package com.lh.dao;

import com.lh.common.Pager;

import java.util.List;

/**
 * @version :1.0
 * CREATE TIME :2018/3/6 16:30
 * @authro :LH
 */
public interface BaseDao {
    void save(Object obj);
    void remove(Object obj);
    void removeById(Long id);
    void update(Object obj);

    Object getById(Long id);
    List<Object> listAll();
    List<Object> listPager(Pager pager);
    Long count();

    List<Object> listPagerCriteria(Pager pager, Object obj);
    Long countCriteria(Object obj);
}
