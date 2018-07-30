/*    */ package com.app.controller;
/*    */ 
/*    */ import com.app.common.BaseResult;
/*    */ import com.app.util.UpdateFile;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"kindle"})
/*    */ public class KindleController
/*    */ {
/*    */   @RequestMapping(value={"addDetails"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @ResponseBody
/*    */   public Map<String, Object> addStudyContent(@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 37 */     Map<String, Object> obj = new HashMap();
/* 38 */     String message = "上传失败";
/*    */     
/* 40 */     BaseResult result = UpdateFile.upload(request, imgFile, "kindle/");
/*    */     
/* 42 */     if (result.getCode() == 200)
/*    */     {
/* 44 */       String filePath = result.getData().toString();
/*    */       
/* 46 */       String url = filePath;
/*    */       
/* 48 */       message = "上传成功";
/*    */       
/* 50 */       obj.put("error", Integer.valueOf(0));
/* 51 */       obj.put("url", url);
/* 52 */       return obj;
/*    */     }
/*    */     
/* 55 */     obj.put("error", Integer.valueOf(1));
/* 56 */     obj.put("message", message);
/* 57 */     return obj;
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\KindleController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */