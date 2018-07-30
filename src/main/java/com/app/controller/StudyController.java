/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.Study;
/*     */ import com.app.service.StudyService;
/*     */ import com.app.util.PagingUtils;
/*     */ import com.app.util.UpdateFile;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
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
/*     */ @Controller
/*     */ @RequestMapping({"study"})
/*     */ public class StudyController
/*     */ {
/*     */   @Resource(name="studyService")
/*     */   private StudyService studyService;
/*     */   
/*     */   @RequestMapping({"all"})
/*     */   @ResponseBody
/*     */   public List<Study> getStudyList(Integer state, Integer pageNumber)
/*     */   {
/*  39 */     if ((state.intValue() == 1) || (state.intValue() == 2) || (state.intValue() == 3))
/*     */     {
/*  41 */       List<Study> studies = this.studyService.getStudyList(state.intValue());
/*     */       
/*  43 */       Study study = new Study();
/*  44 */       PagingUtils<Study> pagingUtils = new PagingUtils(study);
/*     */       
/*  46 */       if (pageNumber == null) {
/*  47 */         pageNumber = Integer.valueOf(0);
/*     */       }
/*     */       
/*  50 */       List<Study> studyList = pagingUtils.pageingDate(pageNumber.intValue(), studies);
/*  51 */       return studyList;
/*     */     }
/*     */     
/*  54 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"allAPP.do"})
/*     */   @ResponseBody
/*     */   public List<Study> getStudyLists(Integer state, Integer pageNumber)
/*     */   {
/*  66 */     if ((state.intValue() == 1) || (state.intValue() == 2) || (state.intValue() == 3))
/*     */     {
/*  68 */       List<Study> studies = this.studyService.getStudyList(state.intValue());
/*     */       
/*  70 */       Study study = new Study();
/*  71 */       PagingUtils<Study> pagingUtils = new PagingUtils(study);
/*     */       
/*  73 */       if (pageNumber == null) {
/*  74 */         pageNumber = Integer.valueOf(0);
/*     */       }
/*     */       
/*  77 */       List<Study> studyList = pagingUtils.pageingDate(pageNumber.intValue(), studies);
/*  78 */       return studyList;
/*     */     }
/*  80 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById.do"})
/*     */   @ResponseBody
/*     */   public Study getStudyById(Integer id)
/*     */   {
/*  90 */     if ((id != null) && (id.intValue() > 0)) {
/*  91 */       return this.studyService.getStudyById(id);
/*     */     }
/*  93 */     return null;
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
/*     */   public BaseResult addStudy(@RequestParam("file") MultipartFile file, String title, String content, Integer state, HttpServletRequest request)
/*     */   {
/* 110 */     if ((state == null) || (state.intValue() < 1) || (state.intValue() > 3)) {
/* 111 */       return BaseResult.build(500, "状态输入错误");
/*     */     }
/*     */     
/* 114 */     Study study = new Study();
/*     */     
/* 116 */     BaseResult result = UpdateFile.upload(request, file, "study/");
/*     */     
/* 118 */     if (result.getCode() == 200)
/*     */     {
/* 120 */       String filePath = result.getData().toString();
/*     */       
/*     */ 
/* 123 */       SimpleDateFormat formatter = new SimpleDateFormat(
/* 124 */         "yyyy-MM-dd");
/* 125 */       String date = formatter.format(new Date());
/*     */       
/* 127 */       study.setImagePath(filePath);
/*     */       
/* 129 */       study.setTitle(title);
/*     */       
/* 131 */       study.setContent(content);
/*     */       
/* 133 */       study.setCreateTime(date);
/*     */       
/* 135 */       study.setState(state);
/*     */       
/* 137 */       this.studyService.addStudy(study);
/*     */     }
/* 139 */     return result;
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
/*     */   @RequestMapping(value={"addDetails"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public Map<String, Object> addStudyContent(@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 156 */     Map<String, Object> obj = new HashMap();
/* 157 */     String message = "上传失败";
/*     */     
/* 159 */     BaseResult result = UpdateFile.upload(request, imgFile, "study/");
/*     */     
/* 161 */     if (result.getCode() == 200)
/*     */     {
/* 163 */       String filePath = result.getData().toString();
/*     */       
/* 165 */       String url = filePath;
/*     */       
/* 167 */       message = "上传成功";
/*     */       
/* 169 */       obj.put("error", Integer.valueOf(0));
/* 170 */       obj.put("url", url);
/* 171 */       return obj;
/*     */     }
/*     */     
/* 174 */     obj.put("error", Integer.valueOf(1));
/* 175 */     obj.put("message", message);
/* 176 */     return obj;
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
/*     */   public BaseResult updateStudy(@RequestParam("file") MultipartFile file, String path, String title, String content, Integer id, HttpServletRequest request)
/*     */   {
/* 193 */     if ((id == null) || (this.studyService.getStudyById(id) == null)) {
/* 194 */       return BaseResult.build(500, "输入的id错误");
/*     */     }
/* 196 */     BaseResult result = new BaseResult();
/*     */     
/* 198 */     Study study = new Study();
/*     */     
/* 200 */     String fileName = file.getOriginalFilename();
/* 201 */     if ((file.getOriginalFilename() != null) && (fileName.contains(".")))
/*     */     {
/* 203 */       result = UpdateFile.upload(request, file, "study/");
/*     */       
/* 205 */       if (result.getCode() == 200)
/*     */       {
/* 207 */         String filePath = result.getData().toString();
/*     */         
/*     */ 
/* 210 */         study.setImagePath(filePath);
/*     */         
/* 212 */         study.setTitle(title);
/*     */         
/* 214 */         study.setContent(content);
/*     */         
/* 216 */         study.setId(id);
/*     */         
/* 218 */         this.studyService.updateStudy(study);
/*     */         
/* 220 */         return BaseResult.ok(filePath);
/*     */       }
/* 222 */       return BaseResult.build(500, "操作错误"); }
/* 223 */     if ((path != null) && (!fileName.contains(".")))
/*     */     {
/*     */ 
/* 226 */       study.setImagePath(path);
/*     */       
/* 228 */       study.setTitle(title);
/*     */       
/* 230 */       study.setContent(content);
/*     */       
/* 232 */       study.setId(id);
/*     */       
/* 234 */       this.studyService.updateStudy(study);
/* 235 */       return BaseResult.ok(path);
/*     */     }
/* 237 */     return BaseResult.build(500, "操作错误");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteById"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteStudyById(Integer id)
/*     */   {
/* 249 */     if ((id == null) || (this.studyService.getStudyById(id) == null)) {
/* 250 */       return BaseResult.build(500, "操作错误");
/*     */     }
/* 252 */     this.studyService.deleteStudyById(id);
/* 253 */     return BaseResult.ok();
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
/* 264 */     if ((ids == null) || (ids.equals("")))
/* 265 */       return BaseResult.build(500, "操作错误");
/* 266 */     if (!ids.contains(","))
/*     */     {
/* 268 */       int id = Integer.parseInt(ids);
/*     */       
/* 270 */       if (this.studyService.getStudyById(Integer.valueOf(id)) == null) {
/* 271 */         return BaseResult.build(500, "操作错误");
/*     */       }
/*     */       
/* 274 */       this.studyService.deleteStudyById(Integer.valueOf(id));
/* 275 */       return BaseResult.ok();
/*     */     }
/*     */     
/* 278 */     String[] postcode = ids.split(",");
/*     */     
/* 280 */     for (int i = 0; i < postcode.length; i++)
/*     */     {
/* 282 */       Integer id = Integer.valueOf(Integer.parseInt(postcode[i]));
/*     */       
/* 284 */       if ((id == null) || (this.studyService.getStudyById(id) == null)) {
/* 285 */         return BaseResult.build(500, "操作错误");
/*     */       }
/*     */     }
/*     */     
/* 289 */     for (int i = 0; i < postcode.length; i++)
/*     */     {
/* 291 */       Integer id = Integer.valueOf(Integer.parseInt(postcode[i]));
/* 292 */       this.studyService.deleteStudyById(id);
/*     */     }
/* 294 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"getNumber.do"})
/*     */   @ResponseBody
/*     */   public BaseResult getNumberStudy(Integer state)
/*     */   {
/* 304 */     if ((state.intValue() == 1) || (state.intValue() == 2) || (state.intValue() == 3)) {
/* 305 */       if (this.studyService.getNumberStudy(state) == null) {
/* 306 */         return BaseResult.ok(Integer.valueOf(1));
/*     */       }
/* 308 */       return BaseResult.ok(this.studyService.getNumberStudy(state));
/*     */     }
/* 310 */     return BaseResult.build(500, "参数传入错误");
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\StudyController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */