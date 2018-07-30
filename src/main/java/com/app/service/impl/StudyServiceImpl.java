/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.StudyDao;
/*    */ import com.app.entity.Study;
/*    */ import com.app.service.StudyService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service("studyService")
/*    */ public class StudyServiceImpl
/*    */   implements StudyService
/*    */ {
/*    */   @Resource
/*    */   private StudyDao studyDao;
/*    */   
/*    */   public List<Study> getStudyList(int state)
/*    */   {
/* 20 */     return this.studyDao.getStudyList(state);
/*    */   }
/*    */   
/*    */   public Study getStudyById(Integer id)
/*    */   {
/* 25 */     return this.studyDao.getStudyById(id);
/*    */   }
/*    */   
/*    */   public void addStudy(Study study)
/*    */   {
/* 30 */     this.studyDao.addStudy(study);
/*    */   }
/*    */   
/*    */   public void updateStudy(Study study)
/*    */   {
/* 35 */     this.studyDao.updateStudy(study);
/*    */   }
/*    */   
/*    */   public void deleteStudyById(Integer id)
/*    */   {
/* 40 */     this.studyDao.deleteStudyById(id);
/*    */   }
/*    */   
/*    */   public Integer getNumberStudy(Integer state)
/*    */   {
/* 45 */     return this.studyDao.getNumberStudy(state);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\StudyServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */