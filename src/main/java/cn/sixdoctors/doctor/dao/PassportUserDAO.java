package cn.sixdoctors.doctor.dao;

import cn.sixdoctors.doctor.model.PassportUser;

/**
 * Created by wangpengcheng on 2018/5/20.
 */
public interface PassportUserDAO {
    void insert(PassportUser passportUser);

    PassportUser findByUserId(int userId);

    PassportUser findByUserName(String userName);

    PassportUser findBymobile(String mobile);

}
