package com.accp.demo.biz;

import com.accp.demo.dao.UserDaoPagingAndSortingRepository;
import com.accp.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @describe
 * @company 晟源科技有限公司
 * @create 2019-03-07 11:19
 */
@Service
public class UserBizPagingAndSortingRepository {
    @Autowired
    private UserDaoPagingAndSortingRepository dao;

    /**
     * findAll(sort)只能查询全部排序
     * @return
     */
    public Iterable<User> findAllSort(){
        //定义排序规则
       /* Sort sort=new Sort(Sort.Direction.DESC,"id");
        return dao.findAll(sort);*/
       //多条件排序
        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC,"id"));
        orders.add(new Sort.Order(Sort.Direction.DESC,"email"));
        return dao.findAll(Sort.by(orders));
    }

    /**
     *  只能查全部分页  加sort排序
     * @param page
     * @param size
     */
    public Page<User> findAllPage(Integer page,Integer size){
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        //0页为开始页
        Pageable pageable=new PageRequest(page-1,size,sort);
        return dao.findAll(pageable);
    }
}
