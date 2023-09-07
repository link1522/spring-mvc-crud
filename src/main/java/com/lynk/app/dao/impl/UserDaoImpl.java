package com.lynk.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.lynk.app.dao.UserDao;
import com.lynk.app.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

    public List<User> getAll() {
        String sql = "select id, name, password, address, phone from user";
        List<User> userList = jdbcTemplate.query(sql, rowMapper);

        return userList;
    }

    public User getById(Integer id) {
        try {
            String sql = "select id, name, password, address, phone from user where id = ?";

            User user = jdbcTemplate.queryForObject(sql, rowMapper, id);

            return user;
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find user with id = " + id);
        }
    }

    public Integer create(User user) {
        String sql = "insert into user (name, password, address, phone) values (?,?,?,?)";

        int affectedRows = jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getAddress(),
                user.getPhone());

        return affectedRows;
    }

    @Override
    public Integer update(User user) {
        String sql = "update user set name = ?, password = ?, address = ?, phone = ? where id = ?";

        int affectedRows = jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getAddress(),
                user.getPhone(), user.getId());

        return affectedRows;
    }

    @Override
    public Integer deleteById(Integer id) {
        String sql = "delete from user where id = ?";

        int affectedRows = jdbcTemplate.update(sql, id);

        return affectedRows;
    }
}
