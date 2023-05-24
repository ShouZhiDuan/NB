package com.gupaoedu.mapper;

import com.gupaoedu.domain.TestTb;
import com.gupaoedu.domain.associate.TestDbAndBlog;
import org.apache.ibatis.annotations.Param;

/**
 * @author shouzhi@duan
 */
public interface TestTbMapper {

    /**
     * 根据ID查询
     * @param id
     * @return
     */
     TestTb selectTestTbById(@Param("id") Integer id,@Param("tbName") String tbName);

     TestDbAndBlog selectTestDbAndBlogRst(@Param("id") Integer id);

}
