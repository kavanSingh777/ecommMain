package com.cardinal.ecomm.controller;

import com.cardinal.ecomm.model.Products;
import com.cardinal.ecomm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JdbcControllerProducts
{

    @Autowired
    JdbcTemplate jdbc;

    //INserting static values into the database
//    @RequestMapping("/insertProd")
//    public String index()
//    {
//        //jdbc.execute("insert into user(name,email)values('kavan','kavan@sjdfksd.com')");
//        return "data inserted Successfully";
//    }
//
//   /* @RequestMapping("/insert/{n}/{e}")
//    public String getFuntion(@PathVariable("n") String name1, @PathVariable("e") String email1)
//    {
//
//        jdbc.execute("insert into user(name,email)values(name1,email1)");
//        return "data inserted Successfully from the url";
//    }*/
//
//
//    //insert name and email from url
//    @RequestMapping("/insert/{n}/{e}")
//    public String saveEmployeeByPreparedStatement(@PathVariable("n") String name1, @PathVariable("e") String email1)
//    {
//        String query = "insert into user(name,email) values(?,?)";
//        return jdbc.execute(query, new PreparedStatementCallback<String>()
//        {
//            @Override
//            public String doInPreparedStatement(PreparedStatement ps)
//                    throws SQLException, DataAccessException {
//
//                //ps.setInt(1,e.getId());
//                ps.setString(1, name1);
//                ps.setString(2, email1);
//                ps.execute();
//                return "Query executed from prepared statement for inserting from URL";
//
//            }
//        });
//    }

    // Inserting products into the database
    @PostMapping("/insertProducts")
    public String insertOneField(@RequestBody Products prodObj)
    {
        String query = "insert into products values (?,?,?,?,?,?,?,?)";

        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {


                ps.setInt(1,prodObj.getProduct_id());
                ps.setString(2, prodObj.getProductSKU());
                ps.setString(3,prodObj.getProduct_name());
                ps.setFloat(4,prodObj.getProduct_price());
                ps.setString(5,prodObj.getShort_desc());
                ps.setString(6,prodObj.getLong_desc());
                ps.setString(7,prodObj.getProduct_image());
                ps.setString(8,prodObj.getProduct_category_id());
                ps.execute();
                return "Query executed for INSERTING a value into PRODUCTS table";

            }
        });
    }
    //Editing product details in the database with the values set from the POST body
    @PostMapping("/editProducts/{id}")
    public String editOneField(@PathVariable("id")  int uid, @RequestBody Products prodObj)
    {

        //for editing certain columns
        //incomplete for now
        List<Products> plist = new ArrayList<>();
        plist.iterator();
        for(Products u : plist)
        {

        }
        String query = "update products set product_id = ?, productSKU = ?, product_name = ?,product_price = ?,short_desc = ?,long_desc= ?,product_image = ?,product_category_id = ? where product_id = ?";

        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,e.getId());


                ps.setInt(1,prodObj.getProduct_id());
                ps.setString(2, prodObj.getProductSKU());
                ps.setString(3,prodObj.getProduct_name());
                ps.setFloat(4,prodObj.getProduct_price());
                ps.setString(5,prodObj.getShort_desc());
                ps.setString(6,prodObj.getLong_desc());
                ps.setString(7,prodObj.getProduct_image());
                ps.setString(8,prodObj.getProduct_category_id());
                ps.setInt(9,prodObj.getProduct_id());

                ps.execute();
                return "Query executed for EDITING a value in the PRODUCTS table";

            }
        });
    }


    //deleting products from database with id only

    @GetMapping("/deleteProducts/{id}")
    public String deleteOneField(@PathVariable("id")  int pid)
    {
        String query = "delete from products where product_id = ?";

        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,e.getId());


                ps.setInt(1, pid);

                ps.execute();
                return "Query executed  for DELETING a product from the database";

            }
        });
    }


    //Get all product details from the table


    @ResponseBody
    @PostMapping(path = "/getAllProducts", produces = "application/json; charset=UTF-8")
    public List<Products> getProductInfo()
    {
        String query = "select * from products";

        return jdbc.execute(query, new PreparedStatementCallback<List>()
        {
            @Override
            public List<Products> doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,userDetails.getId());

                //ps.setInt(1, id);
                System.out.println(ps.execute());
                ps.execute();
                ResultSet rs = ps.executeQuery(query);
//                User users[] = new User[rs.];
                List<Products> plist = new ArrayList<>();
                while(rs.next()) {
                    Products p = new Products(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5),
                            rs.getString(6),rs.getString(7),rs.getString(8));
                    plist.add(p);
                }
                //System.out.println(ps.getResultSetType());

                return plist ;

            }
        });
    }



}
