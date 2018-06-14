package com.joyreach.h5.web.dao;

import com.joyreach.h5.web.entity.UserEntity;
import com.joyreach.h5.web.query.UserInfoQuery;

public interface IUserDAO {

  UserEntity getUserInfoByQuery(UserInfoQuery query);

  void insertUserInfo(UserEntity entity);

  void insertUserTokenInfo(UserEntity entity);

  void updateUserTokenInfo(UserEntity entity);

  void improveUserVipLevel(UserEntity user);
}
