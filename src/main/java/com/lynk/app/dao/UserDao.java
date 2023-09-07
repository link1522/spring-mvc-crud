package com.lynk.app.dao;

import java.util.List;

import com.lynk.app.entity.User;

public interface UserDao {
    public List<User> getAll();

    public User getById(Integer id);

    public Integer create(User user);

    public Integer update(User user);

    public Integer deleteById(Integer id);
}
