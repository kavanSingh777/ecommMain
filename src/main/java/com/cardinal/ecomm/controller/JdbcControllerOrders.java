package com.cardinal.ecomm.controller;


import com.cardinal.ecomm.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JdbcControllerOrders {
    @Autowired
    JdbcTemplate jdbc;

    //insertimg into order
    @PostMapping("/insertOrder")
    public String AddField(@RequestBody Orders ordersObject)
    {
        String query = "insert into orders(order_id,cart_id,ord_date,tot_price) values(?,?,?,?)";
        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1,ordersObject.getOrder_id());
                ps.setString(2,ordersObject.getCart_id());
                ps.setString(3,ordersObject.getOrd_date());
                ps.setFloat(4,ordersObject.getTot_price());
                ps.execute();
                return "Query executed from prepared statement for INSERTING a value";

            }
            String query="insert into cart (status_cart) values(2) where cart_id=? and product_id=?";


        });
    }

    //View all the orders of user
    @ResponseBody
    @PostMapping(path = "/getAllOrders", produces = "application/json; charset=UTF-8")
    public List<Orders> getOrdersInfo()
    {
        String query = "select  * from orders";

        return jdbc.execute(query, new PreparedStatementCallback<List>()
        {
            @Override
            public List<Orders> doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {


                ps.execute();
                ResultSet rs = ps.executeQuery(query);
//                Cart cart[] = new Cart[rs.];
                List<Orders> list = new ArrayList<Orders>();
                while(rs.next()) {
                    Orders orders = new Orders(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
                    list.add(orders);
                }
                //System.out.println(ps.getResultSetType());

                return list ;

            }
        });
    }


}
