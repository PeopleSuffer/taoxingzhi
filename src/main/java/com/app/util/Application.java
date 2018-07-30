/*    */ package com.app.util;
/*    */ 
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.Properties;
/*    */ 
/*    */ 
/*    */ public class Application
/*    */ {
/*  9 */   public static String mwyRequestPath = get("mwyRequestPath");
/* 10 */   public static String mwyUserId = get("mwyUserId");
/* 11 */   public static String mwyPassword = get("mwyPassword");
/* 12 */   public static String mwyIpAddress1 = get("mwyIpAddress1");
/* 13 */   public static String mwyIpAddress2 = get("mwyIpAddress2");
/* 14 */   public static String mwyIpAddress3 = get("mwyIpAddress3");
/* 15 */   public static String mwyIpAddress4 = get("mwyIpAddress4");
/*    */   
/* 17 */   public static String serverUrl = get("serverUrl");
/*    */   
/* 19 */   public static String wxAPPID = get("wxAPPID");
/* 20 */   public static String wxAPPSECRET = get("wxAPPSECRET");
/* 21 */   public static String wxBackUrl = get("wxBackUrl");
/*    */   private static Properties props;
/*    */   
/*    */   private static String get(String key) {
/* 25 */     if (props == null) {
/*    */       try {
/* 27 */         props = new Properties();
/* 28 */         InputStreamReader inputStream = new InputStreamReader(Application.class.getClassLoader().getResourceAsStream("application.properties"), 
/* 29 */           "UTF-8");
/* 30 */         props.load(inputStream);
/* 31 */         inputStream.close();
/*    */       } catch (Exception e) {
/* 33 */         e.printStackTrace();
/*    */       }
/*    */     }
/* 36 */     return props.getProperty(key);
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\util\Application.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */