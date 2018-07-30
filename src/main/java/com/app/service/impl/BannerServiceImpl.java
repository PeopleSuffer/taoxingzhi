/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.BannerDao;
/*    */ import com.app.entity.Banner;
/*    */ import com.app.service.BannerService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("bannerService")
/*    */ public class BannerServiceImpl
/*    */   implements BannerService
/*    */ {
/*    */   @Resource
/*    */   private BannerDao bannerDao;
/*    */   
/*    */   public List<Banner> getBannerList()
/*    */   {
/* 19 */     return this.bannerDao.getBannerList();
/*    */   }
/*    */   
/*    */   public Banner getBannerById(int id)
/*    */   {
/* 24 */     return this.bannerDao.getBannerById(id);
/*    */   }
/*    */   
/*    */   public void addBanner(Banner banner)
/*    */   {
/* 29 */     this.bannerDao.addBanner(banner);
/*    */   }
/*    */   
/*    */   public void deleteBannerById(int id)
/*    */   {
/* 34 */     this.bannerDao.deleteBannerById(id);
/*    */   }
/*    */   
/*    */   public void updateBanner(Banner banner)
/*    */   {
/* 39 */     this.bannerDao.updateBanner(banner);
/*    */   }
/*    */   
/*    */   public int getBannerNumber()
/*    */   {
/* 44 */     return this.bannerDao.getBannerNumber();
/*    */   }
/*    */   
/*    */   public void updateBannerState(Banner banner)
/*    */   {
/* 49 */     this.bannerDao.updateBannerState(banner);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\BannerServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */