package com.app.dao;

import com.app.entity.Regulation;
import java.util.List;

public abstract interface RegulationDao
{
  public abstract List<Regulation> getRegulationList();
  
  public abstract Regulation getRegulationById(Integer paramInteger);
  
  public abstract List<Regulation> getRegulationByState();
  
  public abstract int getRegulationNumber();
  
  public abstract void addRegulation(Regulation paramRegulation);
  
  public abstract void updateRegulation(Regulation paramRegulation);
  
  public abstract void updateRegulationState(Regulation paramRegulation);
  
  public abstract void deleteRegulationById(Integer paramInteger);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\dao\RegulationDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */