package com.joyreach.h5.web.service;

import com.joyreach.h5.web.entity.UserEntity;
import com.joyreach.h5.web.query.UserInfoQuery;

public interface IUserService {

  public UserEntity getUserInfo(UserInfoQuery query);

  public void insertUserInfo(UserEntity entity);

  public void inserUserTokenInfo(UserEntity entity);

  public void updateUserTokenInfo(UserEntity entity);

  public void improveUserVipLevel(String string, Integer type);
}
