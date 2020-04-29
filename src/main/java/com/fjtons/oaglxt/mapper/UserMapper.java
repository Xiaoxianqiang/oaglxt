/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserMapper
 * Author:   abc
 * Date:     2020/2/12 16:09
 * Description: UserMapper
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.fjtons.oaglxt.mapper;

import com.fjtons.oaglxt.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈UserMapper〉
 *
 * @author abc
 * @create 2020/2/12
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {
    /**
     * 利用账号查找用户是否存在
     * @param account
     * @return
     */
    User queryUserByAccount(String account);

    /**
     * 利用电话查找用户是否粗存在
     */
    User queryUserByPhone(String phone);

    /**
     * 获取具有负责的
     * @return
     */
    List<User> queryUserResponsible();


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 批量删除
     * @param array
     * @return
     */
    int deleteArrayUser(String[] array);
    /**
     * 分页查找用户
     * selALlUser
     */
    List<User> selAllUser(User user);
}