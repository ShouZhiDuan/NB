package com.gupaoedu.interceptor;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;
/**
 * @Author: qingshan
 */
//@Intercepts({ @Signature(type = StatementHandler.class, method = "query", args = { Statement.class, ResultHandler.class}) })
@Intercepts({
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})
})
public class SQLInterceptor implements Interceptor {
/*    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        System.out.println("获取到SQL语句："+sql);

        try {
            return invocation.proceed();
        }finally {
            long endTime = System.currentTimeMillis();
            System.out.println("SQL执行耗时：" + (endTime-startTime) +"ms");
        }
    }*/

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Statement statement = (Statement) invocation.getArgs()[0];
        System.out.println("-------------------------------");
        System.out.println("sql:"+statement.toString().substring(statement.toString().indexOf(":")+1));
        Object result =invocation.proceed();
        System.out.println("-------------------------------");
        System.out.println("result:"+ JSON.toJSONString(result));
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String gupao = properties.getProperty("gupao");
        // System.out.println("获取到的参数："+ gupao);
    }
}
