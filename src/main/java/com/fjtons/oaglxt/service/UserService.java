package com.fjtons.oaglxt.service;

import com.fjtons.oaglxt.pojo.BasicProject;
import com.fjtons.oaglxt.pojo.PageRequest;
import com.fjtons.oaglxt.pojo.PageResult;
import com.fjtons.oaglxt.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    User queryUserByAccount(String account);

    /**
     * 分页查修接口
     * @return
     */
    PageResult selectPage(PageRequest pageRequest, User user);
    /**
     * 利用旧密码和新密码修改账号
     */
    int replacePassword(String oldpass, String pass);
    /**
     * 获取具有审核权限的人
     */
    List<User> queryUserResponsible();

    /**
     * 利用电话查找用户是否粗存在
     */
    User queryUserByPhone(String phone);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);
    /**
     * 批量删除
     * @param array
     * @return
     */
    int deleteArrayUser(String[] array);
}
