/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.Cooperation;
/*     */ import com.app.service.CooperationService;
/*     */ import com.app.util.PagingUtils;
/*     */ import com.app.util.UpdateFile;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"cooperation"})
/*     */ public class CooperationController
/*     */ {
/*     */   @Resource(name="cooperationService")
/*     */   private CooperationService cooperationService;
/*     */   
/*     */   @RequestMapping({"all"})
/*     */   @ResponseBody
/*     */   public List<Cooperation> getCooperationList(Integer pageNumber)
/*     */   {
/*  38 */     List<Cooperation> cooperations = this.cooperationService.getCooperationList();
/*     */     
/*  40 */     Cooperation cooperation = new Cooperation();
/*  41 */     PagingUtils<Cooperation> pagingUtils = new PagingUtils(cooperation);
/*     */     
/*  43 */     if (pageNumber == null) {
/*  44 */       pageNumber = Integer.valueOf(0);
/*     */     }
/*     */     
/*  47 */     List<Cooperation> cooperationList = pagingUtils.pageingDate(pageNumber.intValue(), cooperations);
/*  48 */     return cooperationList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"allfront.do"})
/*     */   @ResponseBody
/*     */   public List<Cooperation> getCooperationListByFront(Integer pageNumber)
/*     */   {
/*  59 */     List<Cooperation> cooperations = this.cooperationService.getCooperationList();
/*     */     
/*  61 */     Cooperation cooperation = new Cooperation();
/*  62 */     PagingUtils<Cooperation> pagingUtils = new PagingUtils(cooperation);
/*     */     
/*  64 */     if (pageNumber == null) {
/*  65 */       pageNumber = Integer.valueOf(0);
/*     */     }
/*     */     
/*  68 */     List<Cooperation> cooperationList = pagingUtils.pageingDate(pageNumber.intValue(), cooperations);
/*  69 */     return cooperationList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById.do"})
/*     */   @ResponseBody
/*     */   public Cooperation getCooperationById(Integer id)
/*     */   {
/*  79 */     if ((id != null) && (id.intValue() > 0)) {
/*  80 */       return this.cooperationService.getCooperationById(id);
/*     */     }
/*  82 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"getNumber.do"})
/*     */   @ResponseBody
/*     */   public int getCooperationNumber()
/*     */   {
/*  92 */     return this.cooperationService.getCooperationNumber();
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
/*     */   @RequestMapping(value={"add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult addCooperation(@RequestParam("file") MultipartFile file, String title, String content, HttpServletRequest request)
/*     */   {
/* 108 */     Cooperation cooperation = new Cooperation();
/*     */     
/* 110 */     BaseResult result = UpdateFile.upload(request, file, "cooperation/");
/*     */     
/* 112 */     if (result.getCode() == 200)
/*     */     {
/* 114 */       String filePath = result.getData().toString();
/*     */       
/*     */ 
/* 117 */       SimpleDateFormat formatter = new SimpleDateFormat(
/* 118 */         "yyyy-MM-dd");
/* 119 */       String date = formatter.format(new Date());
/*     */       
/* 121 */       cooperation.setImagePath(filePath);
/*     */       
/* 123 */       cooperation.setTitle(title);
/*     */       
/* 125 */       cooperation.setContent(content);
/*     */       
/* 127 */       cooperation.setCreateTime(date);
/*     */       
/* 129 */       this.cooperationService.addCooperation(cooperation);
/*     */     }
/* 131 */     return result;
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
/*     */   @RequestMapping(value={"update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult updateCooperationById(@RequestParam("file") MultipartFile file, String path, String title, String content, Integer id, HttpServletRequest request)
/*     */   {
/* 148 */     if ((id == null) || (this.cooperationService.getCooperationById(id) == null)) {
/* 149 */       return BaseResult.build(500, "输入的id错误");
/*     */     }
/* 151 */     BaseResult result = new BaseResult();
/*     */     
/* 153 */     Cooperation cooperation = new Cooperation();
/*     */     
/* 155 */     String fileName = file.getOriginalFilename();
/* 156 */     if ((file.getOriginalFilename() != null) && (fileName.contains(".")))
/*     */     {
/* 158 */       result = UpdateFile.upload(request, file, "cooperation/");
/*     */       
/* 160 */       if (result.getCode() == 200)
/*     */       {
/* 162 */         String filePath = result.getData().toString();
/*     */         
/*     */ 
/* 165 */         cooperation.setImagePath(filePath);
/*     */         
/* 167 */         cooperation.setTitle(title);
/*     */         
/* 169 */         cooperation.setContent(content);
/*     */         
/* 171 */         cooperation.setId(id);
/*     */         
/* 173 */         this.cooperationService.updateCooperationById(cooperation);
/*     */         
/* 175 */         return BaseResult.ok(filePath);
/*     */       }
/* 177 */       return BaseResult.build(500, "操作错误"); }
/* 178 */     if ((path != null) && (!fileName.contains(".")))
/*     */     {
/*     */ 
/* 181 */       cooperation.setImagePath(path);
/*     */       
/* 183 */       cooperation.setTitle(title);
/*     */       
/* 185 */       cooperation.setContent(content);
/*     */       
/* 187 */       cooperation.setId(id);
/*     */       
/* 189 */       this.cooperationService.updateCooperationById(cooperation);
/* 190 */       return BaseResult.ok(path);
/*     */     }
/* 192 */     return BaseResult.build(500, "操作错误");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteById"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteCooperationById(Integer id)
/*     */   {
/* 204 */     if ((id == null) || (this.cooperationService.getCooperationById(id) == null)) {
/* 205 */       return BaseResult.build(500, "操作错误");
/*     */     }
/*     */     
/* 208 */     this.cooperationService.deleteCooperationById(id);
/* 209 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deletes"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteLinks(String ids)
/*     */   {
/* 220 */     if ((ids == null) || (ids.equals("")))
/* 221 */       return BaseResult.build(500, "操作错误");
/* 222 */     if (!ids.contains(","))
/*     */     {
/* 224 */       int id = Integer.parseInt(ids);
/*     */       
/* 226 */       if (this.cooperationService.getCooperationById(Integer.valueOf(id)) == null) {
/* 227 */         return BaseResult.build(500, "操作错误");
/*     */       }
/*     */       
/* 230 */       this.cooperationService.deleteCooperationById(Integer.valueOf(id));
/* 231 */       return BaseResult.ok();
/*     */     }
/*     */     
/* 234 */     String[] postcode = ids.split(",");
/*     */     
/* 236 */     for (int i = 0; i < postcode.length; i++)
/*     */     {
/* 238 */       Integer id = Integer.valueOf(Integer.parseInt(postcode[i]));
/*     */       
/* 240 */       if ((id == null) || (this.cooperationService.getCooperationById(id) == null)) {
/* 241 */         return BaseResult.build(500, "操作错误");
/*     */       }
/*     */     }
/*     */     
/* 245 */     for (int i = 0; i < postcode.length; i++)
/*     */     {
/* 247 */       Integer id = Integer.valueOf(Integer.parseInt(postcode[i]));
/* 248 */       this.cooperationService.deleteCooperationById(id);
/*     */     }
/* 250 */     return BaseResult.ok();
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\CooperationController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */