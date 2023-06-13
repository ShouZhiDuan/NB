package com.nb.java.springbean.repository;

import java.util.List;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName NvRepository
 * @author: duanshouzhi
 * @create: 2023-06-13 11:06
 * @description:
 **/
public interface NvRepository<T> {

    /**
     * 列表查询
     * @param object
     * @return
     */
    List<T> findAll(Object object);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T findById(Integer id);

    /**
     * 更新操作
     * @param t
     * @return
     */
    int update(T t);


    /**
     * 插入操作
     * @param t
     * @return
     */
    T insert(T t);

}
