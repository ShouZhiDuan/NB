package com.nb.java.designmode.adapter.demo.passport.adapterv2.adapters;


import com.nb.java.designmode.adapter.demo.passport.ResultMsg;

/**
 * Created by Tom.
 */
public interface ILoginAdapter {
    boolean support(Object object);
    ResultMsg login(String id, Object adapter);
}
