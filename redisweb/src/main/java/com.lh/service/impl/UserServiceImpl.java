package com.lh.service.impl;

import com.lh.bean.User;
import com.lh.common.Pager;
import com.lh.dao.UserDAO;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void save(Object obj) {
        ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();
        User user = (User)obj;
        userDAO.save(obj);
        valueOperations.set("user-"+user.getId(),user);

    }

    @Override
    public void remove(Object obj) {

    }

    @Override
    public void removeById(Long id) {
        redisTemplate.delete("user-"+id);
        userDAO.removeById(id);
    }

    @Override
    public void update(Object obj) {
        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        User user = (User)obj;
        userDAO.update(obj);
        valueOperations.getAndSet("user-"+user.getId(),user);
    }

    @Override
    public Object getById(Long id) {
        ValueOperations<String, User> valueOperations = redisTemplate.opsForValue();
        User user = valueOperations.get("user-"+id);
        if(user != null){
            return user;
        }else{
            Object obj = userDAO.getById(id);
            if(obj!=null){
                valueOperations.set("user-"+id,(User)obj);
            }
            return obj;
        }

    }

    @Override
    public List<Object> listAll() {
        return null;
    }

    @Override
    public Pager listPager(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
        return null;
    }
}
