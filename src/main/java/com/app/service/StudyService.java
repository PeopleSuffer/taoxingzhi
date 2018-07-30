package com.app.service;

import com.app.entity.Study;
import java.util.List;

public abstract interface StudyService
{
  public abstract List<Study> getStudyList(int paramInt);
  
  public abstract Study getStudyById(Integer paramInteger);
  
  public abstract Integer getNumberStudy(Integer paramInteger);
  
  public abstract void addStudy(Study paramStudy);
  
  public abstract void updateStudy(Study paramStudy);
  
  public abstract void deleteStudyById(Integer paramInteger);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\StudyService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */