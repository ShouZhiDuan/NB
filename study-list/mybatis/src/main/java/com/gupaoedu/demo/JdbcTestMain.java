package com.gupaoedu.demo;

import com.gupaoedu.domain.Blog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.sql.*;

/**
 * @author dev
 */
@Slf4j
public class JdbcTestMain {
    private static String url = "jdbc:mysql://192.168.10.120:23306/shouzhi?useSSL=false";
    private static String user = "root";
    private static String pwd = "123456";

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("======");

        stopWatch.start();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = getConnection(url, user, pwd);

            /**
             * simple query
             */
            /*preparedStatement = connection.prepareStatement("select  * from blog");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                log.info(resultSet.getInt("bid") + "");
                log.info(resultSet.getString("name"));
                log.info(resultSet.getString("author_id"));
                log.info("======");
            }*/

            /**
             * batch insert
             */
            preparedStatement = connection.prepareStatement("INSERT INTO `shouzhi`.`blog` (`bid`, `name`, `author_id`) VALUES (?,?, ?)");
            for (int m = 5; m < 1000005; m++) {
                preparedStatement.setInt(1,m);
                preparedStatement.setString(2,"name" + m);
                preparedStatement.setInt(3, m);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

            stopWatch.stop();

            log.info(stopWatch.prettyPrint());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 获取数据库连接
     * @param url
     * @param user
     * @param pwd
     * @return
     */
    private static Connection getConnection(String url, String user, String pwd){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pwd);
            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
