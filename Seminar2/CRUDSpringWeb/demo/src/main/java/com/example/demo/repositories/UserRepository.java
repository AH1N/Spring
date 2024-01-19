package com.example.demo.repositories;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbc;
    private RowMapper<? extends User> userRowMapper;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    public User getUser(int id) {
        String sql = "SELECT id, firstName, lastName FROM userTable WHERE id=?";
        return jdbc.queryForObject(sql, new Object[]{id},
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastName"));
                    return user;
                });
    }

//    public User getUser(int id) {
//        String sql = "SELECT id, firstName, lastName FROM userTable WHERE id=?";
//        return jdbc.queryForObject(sql, new Object[]{id}, userRowMapper);
//    }

    public User edit(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }

}
//Работа с базой