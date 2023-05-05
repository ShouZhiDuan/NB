package com.nb.common.base.page;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据封装类
 * Created by dsz on 2020/05/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonPage<T> {

    @ApiModelProperty(value = "查询第几页")
    private Integer page;
    @ApiModelProperty(value = "每页显示几条")
    private Integer perPage;
    @ApiModelProperty(value = "共几页")
    private Integer pages;
    @ApiModelProperty(value = "总条数")
    private Long total;
    @ApiModelProperty(value = "当前页数据列表")
    private List<T> list;
    @ApiModelProperty(value = "是否最后一页(false：否，true：是)")
    private Boolean end;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setPages(pageInfo.getPages());
        result.setPage(pageInfo.getPageNum());
        result.setPerPage(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        result.setEnd(pageInfo.getPageNum() < pageInfo.getPages() ? false : true);
        return result;
    }


    /**
     * 手动分页
     *
     * @param originList 分页前数据
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 分页后结果
     */
    public static  <T> CommonPage<T> getPageByAllList(List<T> originList, Integer pageNum, Integer pageSize) {
        pageNum  = (pageNum == null  || pageNum  == 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize == 0) ? 10 : pageSize;

        // 分页后的结果
        List<T> resultList = new ArrayList<>();

        // 如果需要进行分页
        if (pageNum > 0 && pageSize > 0) {
            // 获取起点
            int pageStart = (pageNum - 1) * pageSize;
            // 获取终点
            int pageStop = pageStart + pageSize;
            // 开始遍历
            while (pageStart < pageStop) {
                // 考虑到最后一页可能不够pageSize
                if (pageStart == originList.size()) {
                    break;
                }
                resultList.add(originList.get(pageStart++));
            }
        }
        // 如果不进行分页
        else {
            // 显示所有数据
            resultList = originList;
        }
        CommonPage<T> result = new CommonPage<T>();
        result.setPage(pageNum);//设置第几页
        result.setPerPage(pageSize);//设置每页显示几条
        result.setPages((originList.size()%pageSize == 0) ? (originList.size()/pageSize) : (originList.size()/pageSize) + 1);
        result.setTotal(Long.valueOf(originList.size()));
        result.setList(resultList);
        result.setEnd(pageNum < ((originList.size()%pageSize == 0) ? (originList.size()/pageSize) : (originList.size()/pageSize) + 1) ? false : true);
        return result;
    }

}
