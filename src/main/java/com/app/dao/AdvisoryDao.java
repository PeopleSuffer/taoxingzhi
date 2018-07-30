package com.app.dao;

import com.app.entity.Advisory;
import java.util.List;

public abstract interface AdvisoryDao
{
  public abstract List<Advisory> getAdvisorieList();
  
  public abstract Advisory getAdvisoryById(int paramInt);
  
  public abstract List<Advisory> getAdvisorieBeforeSix();
  
  public abstract Integer getAdvisoryNumber();
  
  public abstract void addAdvisory(Advisory paramAdvisory);
  
  public abstract void deleteAdvisoryById(int paramInt);
  
  public abstract void updateAdvisoryById(Advisory paramAdvisory);
  
  public abstract void addAdvisoryImage(String paramString);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\dao\AdvisoryDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */