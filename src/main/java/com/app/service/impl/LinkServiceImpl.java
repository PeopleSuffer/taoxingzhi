/*    */ package com.app.service.impl;
/*    */ 
/*    */ import com.app.dao.LinkDao;
/*    */ import com.app.entity.Link;
/*    */ import com.app.service.LinkService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("linkService")
/*    */ public class LinkServiceImpl
/*    */   implements LinkService
/*    */ {
/*    */   @Resource
/*    */   private LinkDao linkDao;
/*    */   
/*    */   public List<Link> linkList()
/*    */   {
/* 19 */     return this.linkDao.linkList();
/*    */   }
/*    */   
/*    */   public Link getLinkById(int id)
/*    */   {
/* 24 */     return this.linkDao.getLinkById(id);
/*    */   }
/*    */   
/*    */   public void updateLink(Link link)
/*    */   {
/* 29 */     this.linkDao.updateLink(link);
/*    */   }
/*    */   
/*    */   public void addLink(Link link)
/*    */   {
/* 34 */     this.linkDao.addLink(link);
/*    */   }
/*    */   
/*    */   public void deleteLinkById(int id)
/*    */   {
/* 39 */     this.linkDao.deleteLinkById(id);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\impl\LinkServiceImpl.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */