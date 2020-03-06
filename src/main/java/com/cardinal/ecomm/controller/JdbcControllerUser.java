package com.cardinal.ecomm.controller;


import com.cardinal.ecomm.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JdbcControllerUser
{
    @Autowired
    JdbcTemplate jdbc;

    //INserting static values into the database
//    @RequestMapping("/insert")
//    public String index()
//    {
//        jdbc.execute("insert into user(name,email)values('kavan','kavan@sjdfksd.com')");
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
    // Inserting name and email from the POST body
    @PostMapping("/insertUsers")
    public String insertOneField(@RequestBody User userObject)
    {
        String query = "insert into user values (?,?,?,?,?,?,?,?,?,?,?)";

        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,e.getId());
                //ps.setInt(1, userObject.getId());
                ps.setInt(1,userObject.getUser_id());
                ps.setString(2,userObject.getFname());
                ps.setString(3,userObject.getLname());
                ps.setString(4,userObject.getEmail());
                ps.setLong(5,userObject.getPhone());
                ps.setString(6,userObject.getAddress());
                ps.setString(7,userObject.getCity());
                ps.setString(8,userObject.getState());
                ps.setString(9,userObject.getPostal_code());
                ps.setString(10,userObject.getCountry());
                ps.setInt(11,userObject.getLogged_flag());
                ps.execute();
                return "Query executed for INSERTING a value into user table";

            }
        });
    }
    //Editing user details in the database with the values set from the POST body
    @PostMapping("/editUsers/{id}")
    public String editOneField(@PathVariable("id")  int uid, @RequestBody User userObject)
    {

        //for editing certain columns
        //incomplete for now
       List<User> ulist = new ArrayList<>();
       ulist.iterator();
       for(User u : ulist)
       {

       }
        String query = "update user set fname = ?, lname = ?, email = ?,phone = ?,address = ?,city= ?,state = ?,postal_code = ?,country = ?, logged_flag=? where user_id = ?";

        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,e.getId());


                ps.setString(1,userObject.getFname());
                ps.setString(2,userObject.getLname());
                ps.setString(3,userObject.getEmail());
                ps.setLong(4,userObject.getPhone());
                ps.setString(5,userObject.getAddress());
                ps.setString(6,userObject.getCity());
                ps.setString(7,userObject.getState());
                ps.setString(8,userObject.getPostal_code());
                ps.setString(9,userObject.getCountry());
                ps.setInt(10,userObject.getLogged_flag());
                ps.setInt(11,uid);


                ps.execute();
                return "Query executed  for EDITING a value in the user table";

            }
        });
    }


    //deleting user from database with id only

    @GetMapping("/deleteUsers/{id}")
    public String deleteOneField(@PathVariable("id")  int id)
    {
        String query = "delete from user where user_id = ?";

        return jdbc.execute(query, new PreparedStatementCallback<String>()
        {
            @Override
            public String doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,e.getId());


                ps.setInt(1, id);

                ps.execute();
                return "Query executed  for DELETING a user fropm the database";

            }
        });
    }


    //Get all user details from the table


    @ResponseBody
    @PostMapping(path = "/getAllUsers", produces = "application/json; charset=UTF-8")
    public List<User> getUserInfo()
    {
        String query = "select  * from user";

        return jdbc.execute(query, new PreparedStatementCallback<List>()
        {
            @Override
            public List<User> doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                //ps.setInt(1,userDetails.getId());

                //ps.setInt(1, id);
                System.out.println(ps.execute());
                ps.execute();
                ResultSet rs = ps.executeQuery(query);
//                User users[] = new User[rs.];
                List<User> list = new ArrayList<User>();
                while(rs.next()) {
                    User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),
                            rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getInt(11));
                    list.add(u);
                }
                //System.out.println(ps.getResultSetType());

                return list ;

            }
        });
    }


}


