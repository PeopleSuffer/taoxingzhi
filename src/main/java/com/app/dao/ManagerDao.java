package com.app.dao;

import com.app.entity.Manager;

public abstract interface ManagerDao
{
  public abstract Manager getManagerByName(Manager paramManager);
  
  public abstract Manager getManagerById(Integer paramInteger);
  
  public abstract void updateManager(Manager paramManager);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\dao\ManagerDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */