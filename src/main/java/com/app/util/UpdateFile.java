/*    */ package com.app.util;
/*    */ 
/*    */ import com.app.common.BaseResult;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.UUID;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UpdateFile
/*    */ {
/* 22 */   private static String SERVICE_URL = Application.serverUrl;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BaseResult upload(HttpServletRequest request, MultipartFile file, String imagePath)
/*    */   {
/*    */     try
/*    */     {
/* 34 */       String fileName = file.getOriginalFilename();
/*    */       
/* 36 */       if (!fileName.contains(".")) {
/* 37 */         return BaseResult.build(500, "文件上传失败", fileName);
/*    */       }
/* 39 */       String fileSuffixName = fileName.substring(fileName
/* 40 */         .lastIndexOf("."));
/*    */       
/* 42 */       if (CheckFileUtils.checkPicture(fileSuffixName))
/*    */       {
/* 44 */         String uuid = UUID.randomUUID().toString();
/*    */         
/* 46 */         String lastFileName = uuid + fileSuffixName;
/*    */         
/* 48 */         String realPath = request.getSession().getServletContext()
/* 49 */           .getRealPath("/images/" + imagePath + lastFileName);
/*    */         
/* 51 */         File newFile = new File(realPath);
/*    */         
/*    */         try
/*    */         {
/* 55 */           if (!newFile.exists()) {
/* 56 */             newFile.mkdirs();
/*    */           }
/*    */         } catch (Exception e) {
/* 59 */           System.out.println("新建文件夹操作出错");
/* 60 */           e.printStackTrace();
/*    */         }
/* 62 */         file.transferTo(new File(realPath));
/*    */         
/*    */ 
/* 65 */         String fileUri = SERVICE_URL + "/" + imagePath + lastFileName;
/* 66 */         return BaseResult.ok(fileUri);
/*    */       }
/*    */     }
/*    */     catch (IOException e) {
/* 70 */       e.printStackTrace();
/* 71 */       return BaseResult.build(400, "文件上传失败");
/*    */     }
/*    */     
/* 74 */     return BaseResult.build(400, "文件上传失败");
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\util\UpdateFile.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */