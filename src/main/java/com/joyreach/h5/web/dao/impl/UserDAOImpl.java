package com.joyreach.h5.web.dao.impl;

import com.joyreach.h5.web.dao.IUserDAO;
import com.joyreach.h5.web.entity.UserEntity;
import com.joyreach.h5.web.query.UserInfoQuery;

import edu.hziee.common.dbroute.BaseDAO;

public class UserDAOImpl extends BaseDAO implements IUserDAO {

  @Override
  public UserEntity getUserInfoByQuery(UserInfoQuery query) {
    return (UserEntity) super.queryForObject("USER_INFO.GET_USER_INFO_BY_QUERY", query);
  }

  @Override
  public void insertUserInfo(UserEntity entity) {
    super.insert("USER_INFO.INSERT_USER_INFO", entity);
  }

  @Override
  public void insertUserTokenInfo(UserEntity entity) {
    super.insert("USER_INFO.INSERT_USER_TOKEN_INFO", entity);
  }

  @Override
  public void updateUserTokenInfo(UserEntity entity) {
    super.update("USER_INFO.UPDATE_USER_TOKEN_INFO", entity);
  }

  @Override
  public void improveUserVipLevel(UserEntity user) {
    super.update("USER_INFO.IMPROVE_USER_VIP_LEVEL", user);
  }
}
