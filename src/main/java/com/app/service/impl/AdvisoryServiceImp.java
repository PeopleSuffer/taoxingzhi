/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.AdvisoryDao;
/*    */ import com.app.entity.Advisory;
/*    */ import com.app.service.AdvisoryService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("advisoryService")
/*    */ public class AdvisoryServiceImp
/*    */   implements AdvisoryService
/*    */ {
/*    */   @Resource
/*    */   private AdvisoryDao advisoryDao;
/*    */   
/*    */   public List<Advisory> getAdvisorieList()
/*    */   {
/* 19 */     return this.advisoryDao.getAdvisorieList();
/*    */   }
/*    */   
/*    */   public Advisory getAdvisoryById(int id)
/*    */   {
/* 24 */     return this.advisoryDao.getAdvisoryById(id);
/*    */   }
/*    */   
/*    */   public void addAdvisory(Advisory advisory)
/*    */   {
/* 29 */     this.advisoryDao.addAdvisory(advisory);
/*    */   }
/*    */   
/*    */   public void deleteAdvisoryById(int id)
/*    */   {
/* 34 */     this.advisoryDao.deleteAdvisoryById(id);
/*    */   }
/*    */   
/*    */   public void addAdvisoryImage(String imagePath)
/*    */   {
/* 39 */     this.advisoryDao.addAdvisoryImage(imagePath);
/*    */   }
/*    */   
/*    */   public List<Advisory> getAdvisorieBeforeSix()
/*    */   {
/* 44 */     return this.advisoryDao.getAdvisorieBeforeSix();
/*    */   }
/*    */   
/*    */   public void updateAdvisoryById(Advisory advisory)
/*    */   {
/* 49 */     this.advisoryDao.updateAdvisoryById(advisory);
/*    */   }
/*    */   
/*    */   public Integer getAdvisoryNumber()
/*    */   {
/* 54 */     return this.advisoryDao.getAdvisoryNumber();
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\AdvisoryServiceImp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */