/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.RegulationDao;
/*    */ import com.app.entity.Regulation;
/*    */ import com.app.service.RegulationService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("regulationService")
/*    */ public class RegulationServiceImpl
/*    */   implements RegulationService
/*    */ {
/*    */   @Resource
/*    */   private RegulationDao regulationDao;
/*    */   
/*    */   public List<Regulation> getRegulationList()
/*    */   {
/* 19 */     return this.regulationDao.getRegulationList();
/*    */   }
/*    */   
/*    */   public Regulation getRegulationById(Integer id)
/*    */   {
/* 24 */     return this.regulationDao.getRegulationById(id);
/*    */   }
/*    */   
/*    */   public List<Regulation> getRegulationByState()
/*    */   {
/* 29 */     return this.regulationDao.getRegulationByState();
/*    */   }
/*    */   
/*    */   public int getRegulationNumber()
/*    */   {
/* 34 */     return this.regulationDao.getRegulationNumber();
/*    */   }
/*    */   
/*    */   public void addRegulation(Regulation regulation)
/*    */   {
/* 39 */     this.regulationDao.addRegulation(regulation);
/*    */   }
/*    */   
/*    */   public void updateRegulation(Regulation regulation)
/*    */   {
/* 44 */     this.regulationDao.updateRegulation(regulation);
/*    */   }
/*    */   
/*    */   public void updateRegulationState(Regulation regulation)
/*    */   {
/* 49 */     this.regulationDao.updateRegulationState(regulation);
/*    */   }
/*    */   
/*    */   public void deleteRegulationById(Integer id)
/*    */   {
/* 54 */     this.regulationDao.deleteRegulationById(id);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\RegulationServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */