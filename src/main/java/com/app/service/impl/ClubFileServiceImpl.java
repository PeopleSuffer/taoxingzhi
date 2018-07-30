/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.ClubFileDao;
/*    */ import com.app.entity.ClubFile;
/*    */ import com.app.service.ClubFileService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("clubFileService")
/*    */ public class ClubFileServiceImpl implements ClubFileService
/*    */ {
/*    */   @Resource
/*    */   private ClubFileDao clubFileDao;
/*    */   
/*    */   public List<ClubFile> getClubFileList()
/*    */   {
/* 18 */     return this.clubFileDao.getClubFileList();
/*    */   }
/*    */   
/*    */   public ClubFile getClubFileById(Integer id)
/*    */   {
/* 23 */     return this.clubFileDao.getClubFileById(id);
/*    */   }
/*    */   
/*    */   public Integer getClubFileNumber()
/*    */   {
/* 28 */     return this.clubFileDao.getClubFileNumber();
/*    */   }
/*    */   
/*    */   public void addClubFile(ClubFile clubFile)
/*    */   {
/* 33 */     this.clubFileDao.addClubFile(clubFile);
/*    */   }
/*    */   
/*    */   public void updateClubFileById(ClubFile clubFile)
/*    */   {
/* 38 */     this.clubFileDao.updateClubFileById(clubFile);
/*    */   }
/*    */   
/*    */   public void deleteClubFileById(Integer id)
/*    */   {
/* 43 */     this.clubFileDao.deleteClubFileById(id);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\ClubFileServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */