package com.joyreach.h5.web.service.impl;

import com.joyreach.h5.web.dao.IUserDAO;
import com.joyreach.h5.web.entity.UserEntity;
import com.joyreach.h5.web.query.UserInfoQuery;
import com.joyreach.h5.web.service.IUserService;
import com.joyreach.h5.web.service.util.DateUtil;

public class UserServiceImpl implements IUserService {

  private IUserDAO userDAO;

  @Override
  public UserEntity getUserInfo(UserInfoQuery query) {
    return userDAO.getUserInfoByQuery(query);
  }

  @Override
  public void insertUserInfo(UserEntity entity) {
    userDAO.insertUserInfo(entity);
    UserInfoQuery query = new UserInfoQuery();
    query.setPhone(entity.getPhone());
    UserEntity newEntity = userDAO.getUserInfoByQuery(query);
    entity.setId(newEntity.getId());
  }

  @Override
  public void inserUserTokenInfo(UserEntity entity) {
    entity.setToken(generateToken(entity.getPhone()));
    userDAO.insertUserTokenInfo(entity);
  }

  @Override
  public void updateUserTokenInfo(UserEntity entity) {
    entity.setToken(generateToken(entity.getPhone()));
    userDAO.updateUserTokenInfo(entity);
  }

  @Override
  public void improveUserVipLevel(String userId, Integer type) {
    UserEntity user = new UserEntity();
    user.setVipLevel(type);
    user.setId(Integer.valueOf(userId));
    userDAO.improveUserVipLevel(user);
  }

  private static String generateToken(String phone) {
    String token = DateUtil.formatDate(DateUtil.getCurrentDate(), DateUtil.FULL_PATTERN) + phone + Double.toString(Math.random()).subSequence(2, 5)
        + GenerateIdUtils.getAutoIncrementNum();
    return token;
  }

  public IUserDAO getUserDAO() {
    return userDAO;
  }

  public void setUserDAO(IUserDAO userDAO) {
    this.userDAO = userDAO;
  }

}
