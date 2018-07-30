package com.app.service;

import com.app.entity.Cooperation;
import java.util.List;

public abstract interface CooperationService
{
  public abstract List<Cooperation> getCooperationList();
  
  public abstract Cooperation getCooperationById(Integer paramInteger);
  
  public abstract int getCooperationNumber();
  
  public abstract void addCooperation(Cooperation paramCooperation);
  
  public abstract void updateCooperationById(Cooperation paramCooperation);
  
  public abstract void deleteCooperationById(Integer paramInteger);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\CooperationService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */