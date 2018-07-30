/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.Advisory;
/*     */ import com.app.service.AdvisoryService;
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
/*     */ @Controller
/*     */ @RequestMapping({"advisory"})
/*     */ public class AdvisoryController
/*     */ {
/*     */   @Resource(name="advisoryService")
/*     */   private AdvisoryService advisoryService;
/*     */   
/*     */   @RequestMapping({"all"})
/*     */   @ResponseBody
/*     */   public List<Advisory> getAdvisorieList(Integer pageNumber)
/*     */   {
/*  32 */     List<Advisory> advisories = this.advisoryService.getAdvisorieList();
/*  33 */     Advisory advisory = new Advisory();
/*  34 */     PagingUtils<Advisory> pagingUtils = new PagingUtils(advisory);
/*     */     
/*  36 */     if (pageNumber == null) {
/*  37 */       pageNumber = Integer.valueOf(0);
/*     */     }
/*     */     
/*  40 */     List<Advisory> advisorieList = pagingUtils.pageingDate(pageNumber.intValue(), advisories);
/*  41 */     return advisorieList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"forntAll.do"})
/*     */   @ResponseBody
/*     */   public List<Advisory> getAdvisories(Integer pageNumber)
/*     */   {
/*  52 */     List<Advisory> advisories = this.advisoryService.getAdvisorieList();
/*  53 */     Advisory advisory = new Advisory();
/*  54 */     PagingUtils<Advisory> pagingUtils = new PagingUtils(advisory);
/*     */     
/*  56 */     if (pageNumber == null) {
/*  57 */       pageNumber = Integer.valueOf(0);
/*     */     }
/*     */     
/*  60 */     List<Advisory> advisorieList = pagingUtils.pageingDate(pageNumber.intValue(), advisories);
/*  61 */     return advisorieList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findSix.do"})
/*     */   @ResponseBody
/*     */   public List<Advisory> getAdvisorieBeforeSix()
/*     */   {
/*  70 */     return this.advisoryService.getAdvisorieBeforeSix();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"getNumber.do"})
/*     */   @ResponseBody
/*     */   public int getAdvisoriesNumber()
/*     */   {
/*  79 */     return this.advisoryService.getAdvisoryNumber().intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById.do"})
/*     */   @ResponseBody
/*     */   public Advisory getAdvisoryById(int id)
/*     */   {
/*  90 */     if (id < 1) {
/*  91 */       return null;
/*     */     }
/*  93 */     return this.advisoryService.getAdvisoryById(id);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult addAdvisory(String advisoryTitle, String content, HttpServletRequest request)
/*     */   {
/* 110 */     Advisory advisory = new Advisory();
/*     */     
/*     */ 
/*     */ 
/* 114 */     SimpleDateFormat formatter = new SimpleDateFormat(
/* 115 */       "yyyy-MM-dd HH:mm:ss");
/* 116 */     String date = formatter.format(new Date());
/*     */     
/* 118 */     advisory.setAdvisoryTitle(advisoryTitle);
/*     */     
/* 120 */     advisory.setAdvisoryDetails(content);
/*     */     
/* 122 */     advisory.setAdvisoryTime(date);
/*     */     
/* 124 */     this.advisoryService.addAdvisory(advisory);
/* 125 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult updateAdvisory(Integer id, String advisoryTitle, String advisoryDetails)
/*     */   {
/* 138 */     Advisory advisory = new Advisory();
/*     */     
/* 140 */     if ((id == null) || (this.advisoryService.getAdvisoryById(id.intValue()) == null)) {
/* 141 */       return BaseResult.build(500, "操作错误");
/*     */     }
/*     */     
/* 144 */     advisory.setId(id);
/*     */     
/* 146 */     advisory.setAdvisoryTitle(advisoryTitle);
/*     */     
/* 148 */     advisory.setAdvisoryDetails(advisoryDetails);
/*     */     
/* 150 */     this.advisoryService.updateAdvisoryById(advisory);
/* 151 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"delete"})
/*     */   @ResponseBody
/*     */   public String deleteAdvisoryById(int id)
/*     */   {
/* 163 */     if ((id < 1) || (this.advisoryService.getAdvisoryById(id) == null)) {
/* 164 */       return "0";
/*     */     }
/* 166 */     this.advisoryService.deleteAdvisoryById(id);
/* 167 */     return "1";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteIds"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteByIds(String ids)
/*     */   {
/* 177 */     BaseResult result = new BaseResult();
/* 178 */     if ((ids == null) || (ids.equals(""))) {
/* 179 */       result.setCode(500);
/* 180 */       result.setMessage("操作错误");
/* 181 */     } else if (!ids.contains(",")) {
/* 182 */       int id = Integer.parseInt(ids);
/* 183 */       if ((id > 0) && (this.advisoryService.getAdvisoryById(id) != null)) {
/* 184 */         this.advisoryService.deleteAdvisoryById(id);
/* 185 */         result.setCode(200);
/* 186 */         result.setMessage("删除成功");
/*     */       } else {
/* 188 */         result.setCode(500);
/* 189 */         result.setMessage("删除错误");
/*     */       }
/*     */     } else {
/* 192 */       String[] postcode = ids.split(",");
/* 193 */       for (int i = 0; i < postcode.length; i++) {
/* 194 */         int id = Integer.parseInt(postcode[i]);
/* 195 */         if ((id < 1) || (this.advisoryService.getAdvisoryById(id) == null)) {
/* 196 */           result.setCode(500);
/* 197 */           result.setMessage("删除错误");
/*     */         }
/* 199 */         this.advisoryService.deleteAdvisoryById(id);
/*     */       }
/* 201 */       result.setCode(200);
/* 202 */       result.setMessage("删除成功");
/*     */     }
/* 204 */     return result;
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\AdvisoryController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */