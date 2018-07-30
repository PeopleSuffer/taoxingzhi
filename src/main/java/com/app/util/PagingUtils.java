/*    */ package com.app.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PagingUtils<T>
/*    */ {
/*    */   private T beanT;
/*    */   
/*    */   public PagingUtils(T beanT)
/*    */   {
/* 17 */     this.beanT = beanT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<T> pageingDate(int pageNumber, List<T> list)
/*    */   {
/* 27 */     int userNumber = list.size();
/* 28 */     List<T> beanList = new ArrayList();
/* 29 */     if ((pageNumber == 0) || (pageNumber == 1)) {
/* 30 */       if (list.size() < 10) {
/* 31 */         for (int i = 0; i < list.size(); i++) {
/* 32 */           beanList.add(list.get(i));
/*    */         }
/*    */         
/*    */       } else {
/* 36 */         for (int i = 0; i < 10; i++) {
/* 37 */           beanList.add(list.get(i));
/*    */         }
/*    */       }
/* 40 */       return beanList; }
/* 41 */     if (userNumber > (pageNumber - 1) * 10) {
/* 42 */       if (userNumber > pageNumber * 10) {
/* 43 */         for (int i = (pageNumber - 1) * 10; i < pageNumber * 10; i++) {
/* 44 */           beanList.add(list.get(i));
/*    */         }
/*    */       } else {
/* 47 */         for (int i = (pageNumber - 1) * 10; i < list.size(); i++) {
/* 48 */           beanList.add(list.get(i));
/*    */         }
/*    */       }
/* 51 */       return beanList;
/*    */     }
/* 53 */     return null;
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\util\PagingUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */