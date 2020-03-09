package com.cardinal.ecomm.controller;



import com.cardinal.ecomm.model.Cart;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController
{
    @Autowired
    JdbcTemplate jdbc;

    //Inserting static values into the database
//    @RequestMapping("/insert")
//    public String index()
//    {
//        jdbc.execute("insert into user(name,email)values('kavan','kavan@sjdfksd.com')");
//        return "data inserted Successfully";
//    }

   /* @RequestMapping("/insert/{n}/{e}")
    public String getFuntion(@PathVariable("n") String name1, @PathVariable("e") String email1)
    {

        jdbc.execute("insert into user(name,email)values(name1,email1)");
        return "data inserted Successfully from the url";
    }*/


    //insert name and email from url
   /* @RequestMapping("/insert/{n}/{e}")
    public String saveEmployeeByPreparedStatement(@PathVariable("n") String name1, @PathVariable("e") String email1)
    {
        String query = "insert into user(name,email) values(?,?)";
        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,e.getId());
                ps.setString(1, name1);
                ps.setString(2, email1);
                ps.execute();
                return "Query executed from prepared statement for inserting from URL";

            }
        });
    }*/
    // Inserting into the cart from the POST body
    @PostMapping("/insertCart")
    public String deleteOneField(@RequestBody Cart cartObject)
    {
        String query = "insert into cart values(?,?,?,?,?,?,?)";
        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,e.getId());
                //ps.setInt(1, userObject.getId());
                ps.setString(1,cartObject.getCart_id());
                ps.setString(2,cartObject.getUser_id());
                ps.setInt(3,cartObject.getProduct_id());
                ps.setInt(4,cartObject.getQuantity());
                ps.setFloat(5,cartObject.getPrice());
                ps.setInt(6,cartObject.getStatus_cart());
                ps.setInt(7,cartObject.getStatus_wishlist());
                ps.execute();
                return "Query executed from prepared statement for INSERTING a value";

            }
        });
    }
    //Editing cart in the database with the value set from the POST body
    @PostMapping("/editCart/{user_id}/{cart_id}/{product_id}")
    public String editOneField(@PathVariable("user_id") String user_id,@PathVariable("cart_id") String cart_id,@PathVariable("product_id") int product_id, @RequestBody Cart cartObject)
    {
        String query = "update cart set quantity = ?, price = ? where user_id = ? and cart_id = ? and product_id = ? and status_cart=1";

        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException
            {

                //ps.setInt(1,e.getId());
                ps.setInt(1,cartObject.getQuantity());
                ps.setFloat(2,cartObject.getPrice());
                ps.setString(3,user_id);
                ps.setString(4,cart_id);
                ps.setInt(5,product_id);


                ps.execute();
                return "Query executed from prepared statement for EDITING a value";

            }
        });
    }
    //deleting from cart in database with user_id and product_id

    @GetMapping("/deleteCart/{user_id}/{product_id}")
    public String deleteOneField(@PathVariable("user_id")  int user_id,@PathVariable("product_id") int product_id)
    {
        String query = "delete from cart where user_id = ? and product_id = ?";

        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,e.getId());


                ps.setInt(1, user_id);
                ps.setInt(2,product_id);

                ps.execute();
                return "Query executed from prepared statement for DELETING a value";

            }
        });
    }


    //Get all user details from the table


    @ResponseBody
    @PostMapping(path = "/getAllCart", produces = "application/json; charset=UTF-8")
    public List<Cart> getUserInfo()
    {
        String query = "select  * from cart";

        return jdbc.execute(query, new PreparedStatementCallback<List>()
        {
            @Override
            public List<Cart> doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,userDetails.getId());

                //ps.setInt(1, id);
                // System.out.println(ps.execute());
                ps.execute();
                ResultSet rs = ps.executeQuery(query);
//                Cart cart[] = new Cart[rs.];
                List<Cart> list = new ArrayList<Cart>();
                while(rs.next()) {
                    Cart cart = new Cart(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getFloat(5));
                    list.add(cart);
                }
                //System.out.println(ps.getResultSetType());

                return list ;

            }
        });
    }


}
