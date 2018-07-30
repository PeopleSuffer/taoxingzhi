package com.app.dao;

import com.app.entity.Introduction;
import java.util.List;

public abstract interface IntroductionDao
{
  public abstract List<Introduction> getIntroductionList();
  
  public abstract Introduction getiIntroductionById(Integer paramInteger);
  
  public abstract List<Introduction> getIntroductionByState(Integer paramInteger);
  
  public abstract void addIntroduction(Introduction paramIntroduction);
  
  public abstract void updateIntroduction(Introduction paramIntroduction);
  
  public abstract void updateIntroductionState(Introduction paramIntroduction);
  
  public abstract void deleteIntroductionById(Integer paramInteger);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\dao\IntroductionDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */