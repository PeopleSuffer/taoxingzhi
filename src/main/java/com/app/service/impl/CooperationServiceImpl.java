/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.CooperationDao;
/*    */ import com.app.entity.Cooperation;
/*    */ import com.app.service.CooperationService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("cooperationService")
/*    */ public class CooperationServiceImpl
/*    */   implements CooperationService
/*    */ {
/*    */   @Resource
/*    */   private CooperationDao cooperationDao;
/*    */   
/*    */   public List<Cooperation> getCooperationList()
/*    */   {
/* 19 */     return this.cooperationDao.getCooperationList();
/*    */   }
/*    */   
/*    */   public Cooperation getCooperationById(Integer id)
/*    */   {
/* 24 */     return this.cooperationDao.getCooperationById(id);
/*    */   }
/*    */   
/*    */   public int getCooperationNumber()
/*    */   {
/* 29 */     return this.cooperationDao.getCooperationNumber();
/*    */   }
/*    */   
/*    */   public void addCooperation(Cooperation cooperation)
/*    */   {
/* 34 */     this.cooperationDao.addCooperation(cooperation);
/*    */   }
/*    */   
/*    */   public void updateCooperationById(Cooperation cooperation)
/*    */   {
/* 39 */     this.cooperationDao.updateCooperationById(cooperation);
/*    */   }
/*    */   
/*    */   public void deleteCooperationById(Integer id)
/*    */   {
/* 44 */     this.cooperationDao.deleteCooperationById(id);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\CooperationServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */