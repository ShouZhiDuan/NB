package com.nb.java.springbean.repository;

import com.nb.java.springbean.repository.annotation.NeedProxy;

/**
 * @Company 锘崴科技
 * @Version 1.0
 * @program: NB
 * @ClassName UserRepository
 * @author: duanshouzhi
 * @create: 2023-06-13 11:37
 * @description:
 **/
@NeedProxy
public interface UserRepository<User> extends NvRepository<User>{

}