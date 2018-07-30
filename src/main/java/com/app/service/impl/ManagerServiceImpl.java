/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.ManagerDao;
/*    */ import com.app.entity.Manager;
/*    */ import com.app.service.ManagerService;
/*    */ import javax.annotation.Resource;
/*    */ 
/*    */ @org.springframework.stereotype.Service("managerService")
/*    */ public class ManagerServiceImpl implements ManagerService
/*    */ {
/*    */   @Resource
/*    */   private ManagerDao managerDao;
/*    */   
/*    */   public Manager getManagerByName(Manager manager)
/*    */   {
/* 16 */     return this.managerDao.getManagerByName(manager);
/*    */   }
/*    */   
/*    */   public Manager getManagerById(Integer id)
/*    */   {
/* 21 */     return this.managerDao.getManagerById(id);
/*    */   }
/*    */   
/*    */   public void updateManager(Manager manager)
/*    */   {
/* 26 */     this.managerDao.updateManager(manager);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\ManagerServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */