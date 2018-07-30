/*    */ package com.app.entity;
/*    */ 
/*    */ public class Banner
/*    */ {
/*    */   private int id;
/*    */   private String title;
/*    */   private String imagePath;
/*    */   private String bannerDetails;
/*    */   private String bannerTime;
/*    */   private Integer state;
/*    */   
/*    */   public int getId()
/*    */   {
/* 14 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setId(int id)
/*    */   {
/* 20 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTitle()
/*    */   {
/* 26 */     return this.title;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setTitle(String title)
/*    */   {
/* 32 */     this.title = title;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getImagePath()
/*    */   {
/* 38 */     return this.imagePath;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setImagePath(String imagePath)
/*    */   {
/* 44 */     this.imagePath = imagePath;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getBannerDetails()
/*    */   {
/* 50 */     return this.bannerDetails;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setBannerDetails(String bannerDetails)
/*    */   {
/* 56 */     this.bannerDetails = bannerDetails;
/*    */   }
/*    */   
/*    */ 
/*    */   public String getBannerTime()
/*    */   {
/* 62 */     return this.bannerTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setBannerTime(String bannerTime)
/*    */   {
/* 68 */     if (bannerTime.contains(".")) {
/* 69 */       bannerTime = bannerTime.substring(0, bannerTime.lastIndexOf("."));
/*    */     }
/* 71 */     this.bannerTime = bannerTime;
/*    */   }
/*    */   
/*    */ 
/*    */   public Integer getState()
/*    */   {
/* 77 */     return this.state;
/*    */   }
/*    */   
/*    */ 
/*    */   public void setState(Integer state)
/*    */   {
/* 83 */     this.state = state;
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\entity\Banner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */