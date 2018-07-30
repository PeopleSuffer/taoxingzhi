package com.app.service;

import com.app.entity.ClubFile;
import java.util.List;

public abstract interface ClubFileService
{
  public abstract List<ClubFile> getClubFileList();
  
  public abstract ClubFile getClubFileById(Integer paramInteger);
  
  public abstract Integer getClubFileNumber();
  
  public abstract void addClubFile(ClubFile paramClubFile);
  
  public abstract void updateClubFileById(ClubFile paramClubFile);
  
  public abstract void deleteClubFileById(Integer paramInteger);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\ClubFileService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */