/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.ClubFile;
/*     */ import com.app.service.ClubFileService;
/*     */ import com.app.util.PagingUtils;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"clubfile"})
/*     */ public class ClubFileController
/*     */ {
/*     */   @Resource(name="clubFileService")
/*     */   private ClubFileService clubFileService;
/*     */   
/*     */   @RequestMapping({"all"})
/*     */   @ResponseBody
/*     */   public List<ClubFile> getClubFileList(Integer pageNumber)
/*     */   {
/*  33 */     List<ClubFile> clubFiles = this.clubFileService.getClubFileList();
/*     */     
/*  35 */     ClubFile clubFile = new ClubFile();
/*  36 */     PagingUtils<ClubFile> pagingUtils = new PagingUtils(clubFile);
/*     */     
/*  38 */     if (pageNumber == null) {
/*  39 */       pageNumber = Integer.valueOf(0);
/*     */     }
/*     */     
/*  42 */     List<ClubFile> clubFileList = pagingUtils.pageingDate(pageNumber.intValue(), clubFiles);
/*  43 */     return clubFileList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"all.do"})
/*     */   @ResponseBody
/*     */   public List<ClubFile> getClubFileListFront(Integer pageNumber)
/*     */   {
/*  54 */     List<ClubFile> clubFiles = this.clubFileService.getClubFileList();
/*     */     
/*  56 */     ClubFile clubFile = new ClubFile();
/*  57 */     PagingUtils<ClubFile> pagingUtils = new PagingUtils(clubFile);
/*     */     
/*  59 */     if (pageNumber == null) {
/*  60 */       pageNumber = Integer.valueOf(0);
/*     */     }
/*     */     
/*  63 */     List<ClubFile> clubFileList = pagingUtils.pageingDate(pageNumber.intValue(), clubFiles);
/*  64 */     return clubFileList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById.do"})
/*     */   @ResponseBody
/*     */   public ClubFile getClubFileById(Integer id)
/*     */   {
/*  75 */     if ((id != null) && (id.intValue() > 0)) {
/*  76 */       return this.clubFileService.getClubFileById(id);
/*     */     }
/*  78 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"getNumber.do"})
/*     */   @ResponseBody
/*     */   public Integer getClubFileNumber()
/*     */   {
/*  87 */     return this.clubFileService.getClubFileNumber();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult addClubFile(String title, String content, HttpServletRequest request)
/*     */   {
/* 100 */     ClubFile clubFile = new ClubFile();
/*     */     
/*     */ 
/* 103 */     SimpleDateFormat formatter = new SimpleDateFormat(
/* 104 */       "yyyy-MM-dd HH:mm:ss");
/* 105 */     String date = formatter.format(new Date());
/*     */     
/* 107 */     clubFile.setTitle(title);
/*     */     
/* 109 */     clubFile.setContent(content);
/*     */     
/* 111 */     clubFile.setCreateTime(date);
/*     */     
/* 113 */     this.clubFileService.addClubFile(clubFile);
/* 114 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult updateClubFileById(String title, String content, Integer id, HttpServletRequest request)
/*     */   {
/* 128 */     ClubFile clubFile = new ClubFile();
/*     */     
/* 130 */     if ((id == null) || (this.clubFileService.getClubFileById(id) == null)) {
/* 131 */       return BaseResult.build(500, "id参数错误");
/*     */     }
/*     */     
/* 134 */     clubFile.setId(id);
/*     */     
/* 136 */     clubFile.setTitle(title);
/*     */     
/* 138 */     clubFile.setContent(content);
/*     */     
/* 140 */     this.clubFileService.updateClubFileById(clubFile);
/* 141 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteById"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteClubFileById(Integer id)
/*     */   {
/* 152 */     if ((id == null) || (this.clubFileService.getClubFileById(id) == null)) {
/* 153 */       return BaseResult.build(500, "id参数错误");
/*     */     }
/*     */     
/* 156 */     this.clubFileService.deleteClubFileById(id);
/* 157 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deletes"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteByIds(String ids)
/*     */   {
/* 167 */     if ((ids == null) || (ids.equals("")))
/* 168 */       return BaseResult.build(500, "输入的参数有误");
/* 169 */     if (!ids.contains(",")) {
/* 170 */       int id = Integer.parseInt(ids);
/* 171 */       if ((id > 0) && (this.clubFileService.getClubFileById(Integer.valueOf(id)) != null)) {
/* 172 */         this.clubFileService.deleteClubFileById(Integer.valueOf(id));
/* 173 */         return BaseResult.ok();
/*     */       }
/* 175 */       return BaseResult.build(500, "删除错误");
/*     */     }
/*     */     
/* 178 */     String[] postcode = ids.split(",");
/* 179 */     for (int i = 0; i < postcode.length; i++) {
/* 180 */       int id = Integer.parseInt(postcode[i]);
/* 181 */       if ((id < 1) || (this.clubFileService.getClubFileById(Integer.valueOf(id)) == null)) {
/* 182 */         return BaseResult.build(500, "删除错误");
/*     */       }
/*     */     }
/* 185 */     for (int i = 0; i < postcode.length; i++) {
/* 186 */       int id = Integer.parseInt(postcode[i]);
/* 187 */       this.clubFileService.deleteClubFileById(Integer.valueOf(id));
/*     */     }
/* 189 */     return BaseResult.ok();
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\ClubFileController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */