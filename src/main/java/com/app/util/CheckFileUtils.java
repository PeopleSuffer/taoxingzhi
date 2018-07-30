/*    */ package com.app.util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CheckFileUtils
/*    */ {
/* 10 */   private static final String[] excelSuffixs = { ".xls", ".xlsx" };
/* 11 */   private static final String[] picture = { ".jpg", ".jpeg", ".png", ".bmp", ".tif", ".psd", ".svg", 
/* 12 */     ".PNG", ".JPG", ".JPEG", ".BMP", ".TIF", ".PSD", ".SVG" };
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean checkExcel(String fileSuffixName)
/*    */   {
/*    */     String[] arrayOfString;
/*    */     
/*    */ 
/* 22 */     int j = (arrayOfString = excelSuffixs).length; for (int i = 0; i < j; i++) { String excelSuffix = arrayOfString[i];
/*    */       
/* 24 */       if (excelSuffix.equals(fileSuffixName)) {
/* 25 */         return true;
/*    */       }
/*    */     }
/*    */     
/* 29 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static boolean checkPicture(String fileSuffixName)
/*    */   {
/*    */     String[] arrayOfString;
/*    */     
/* 38 */     int j = (arrayOfString = picture).length; for (int i = 0; i < j; i++) { String excelSuffix = arrayOfString[i];
/*    */       
/* 40 */       if (excelSuffix.equals(fileSuffixName)) {
/* 41 */         return true;
/*    */       }
/*    */     }
/*    */     
/* 45 */     return false;
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\util\CheckFileUtils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */