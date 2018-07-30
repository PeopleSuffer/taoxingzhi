/*    */ package com.app.entity;
/*    */ 
/*    */ 
/*    */ public class Advisory
/*    */ {
/*    */   private int id;
/*    */   
/*    */   private String advisoryTitle;
/*    */   
/*    */   private String advisoryDetails;
/*    */   
/*    */   private String advisoryTime;
/*    */   
/*    */ 
/*    */   public int getId()
/*    */   {
/* 17 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setId(Integer id)
/*    */   {
/* 23 */     if (id == null) {
/* 24 */       id = Integer.valueOf(0);
/*    */     }
/* 26 */     this.id = id.intValue();
/*    */   }
/*    */   
/*    */ 
/*    */   public String getAdvisoryTitle()
/*    */   {
/* 32 */     return this.advisoryTitle;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setAdvisoryTitle(String advisoryTitle)
/*    */   {
/* 38 */     this.advisoryTitle = advisoryTitle;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getAdvisoryDetails()
/*    */   {
/* 44 */     return this.advisoryDetails;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setAdvisoryDetails(String advisoryDetails)
/*    */   {
/* 50 */     this.advisoryDetails = advisoryDetails;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getAdvisoryTime()
/*    */   {
/* 56 */     return this.advisoryTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setAdvisoryTime(String advisoryTime)
/*    */   {
/* 62 */     if (advisoryTime.contains(".")) {
/* 63 */       advisoryTime = advisoryTime.substring(0, advisoryTime.lastIndexOf("."));
/*    */     }
/* 65 */     this.advisoryTime = advisoryTime;
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\entity\Advisory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */