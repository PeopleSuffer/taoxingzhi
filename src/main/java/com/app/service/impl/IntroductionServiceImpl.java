/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.IntroductionDao;
/*    */ import com.app.entity.Introduction;
/*    */ import com.app.service.IntroductionService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("introductionService")
/*    */ public class IntroductionServiceImpl
/*    */   implements IntroductionService
/*    */ {
/*    */   @Resource
/*    */   private IntroductionDao introductionDao;
/*    */   
/*    */   public List<Introduction> getIntroductionList()
/*    */   {
/* 19 */     return this.introductionDao.getIntroductionList();
/*    */   }
/*    */   
/*    */   public Introduction getiIntroductionById(Integer id)
/*    */   {
/* 24 */     return this.introductionDao.getiIntroductionById(id);
/*    */   }
/*    */   
/*    */   public List<Introduction> getIntroductionByState(Integer state)
/*    */   {
/* 29 */     return this.introductionDao.getIntroductionByState(state);
/*    */   }
/*    */   
/*    */   public void addIntroduction(Introduction introduction)
/*    */   {
/* 34 */     this.introductionDao.addIntroduction(introduction);
/*    */   }
/*    */   
/*    */   public void updateIntroduction(Introduction introduction)
/*    */   {
/* 39 */     this.introductionDao.updateIntroduction(introduction);
/*    */   }
/*    */   
/*    */   public void updateIntroductionState(Introduction introduction)
/*    */   {
/* 44 */     this.introductionDao.updateIntroductionState(introduction);
/*    */   }
/*    */   
/*    */   public void deleteIntroductionById(Integer id)
/*    */   {
/* 49 */     this.introductionDao.deleteIntroductionById(id);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\IntroductionServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */