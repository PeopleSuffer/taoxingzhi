/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.Introduction;
/*     */ import com.app.service.IntroductionService;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
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
/*     */ @RequestMapping({"introduction"})
/*     */ public class IntroductionController
/*     */ {
/*     */   @Resource(name="introductionService")
/*     */   private IntroductionService introductionService;
/*     */   
/*     */   @RequestMapping({"all"})
/*     */   @ResponseBody
/*     */   public List<Introduction> getIntroductionList()
/*     */   {
/*  31 */     return this.introductionService.getIntroductionList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById.do"})
/*     */   @ResponseBody
/*     */   public Introduction getiIntroductionById(Integer id)
/*     */   {
/*  42 */     if ((id != null) && (id.intValue() > 0)) {
/*  43 */       return this.introductionService.getiIntroductionById(id);
/*     */     }
/*  45 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findByState.do"})
/*     */   @ResponseBody
/*     */   public Introduction getIntroductionByState()
/*     */   {
/*  57 */     List<Introduction> intrList = this.introductionService.getIntroductionByState(Integer.valueOf(1));
/*     */     
/*  59 */     if ((intrList != null) && (intrList.size() > 0)) {
/*  60 */       return (Introduction)intrList.get(0);
/*     */     }
/*  62 */     return null;
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
/*     */   public BaseResult addIntroduction(String title, String content)
/*     */   {
/*  75 */     Introduction introduction = new Introduction();
/*     */     
/*     */ 
/*  78 */     SimpleDateFormat formatter = new SimpleDateFormat(
/*  79 */       "yyyy-MM-dd HH:mm:ss");
/*  80 */     String date = formatter.format(new Date());
/*     */     
/*  82 */     introduction.setTitle(title);
/*     */     
/*  84 */     introduction.setContent(content);
/*     */     
/*  86 */     introduction.setCreateTime(date);
/*     */     
/*  88 */     introduction.setState(Integer.valueOf(0));
/*     */     
/*  90 */     this.introductionService.addIntroduction(introduction);
/*  91 */     return BaseResult.ok();
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
/*     */   public BaseResult updateIntroduction(Integer id, String title, String content)
/*     */   {
/* 105 */     Introduction introduction = new Introduction();
/*     */     
/* 107 */     if ((id == null) || (this.introductionService.getiIntroductionById(id) == null)) {
/* 108 */       return BaseResult.build(500, "id参数错误");
/*     */     }
/*     */     
/* 111 */     introduction.setId(id);
/*     */     
/* 113 */     introduction.setTitle(title);
/*     */     
/* 115 */     introduction.setContent(content);
/*     */     
/* 117 */     this.introductionService.updateIntroduction(introduction);
/* 118 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"updateByState"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult updateIntroductionState(Integer id, Integer state)
/*     */   {
/* 131 */     Introduction introduction = new Introduction();
/*     */     
/* 133 */     if ((id == null) || (this.introductionService.getiIntroductionById(id) == null)) {
/* 134 */       return BaseResult.build(500, "id参数错误");
/*     */     }
/*     */     
/* 137 */     if ((state.intValue() == 1) || (state.intValue() == 0)) {
/* 138 */       introduction.setId(id);
/* 139 */       introduction.setState(state);
/* 140 */       this.introductionService.updateIntroductionState(introduction);
/* 141 */       return BaseResult.ok();
/*     */     }
/* 143 */     return BaseResult.build(500, "操作有误");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteById"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteIntroductionById(Integer id)
/*     */   {
/* 155 */     if ((id == null) || (this.introductionService.getiIntroductionById(id) == null)) {
/* 156 */       return BaseResult.build(500, "id参数错误");
/*     */     }
/*     */     
/* 159 */     this.introductionService.deleteIntroductionById(id);
/* 160 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deletes"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteByIds(String ids)
/*     */   {
/* 170 */     if ((ids == null) || (ids.equals("")))
/* 171 */       return BaseResult.build(500, "输入的参数有误");
/* 172 */     if (!ids.contains(",")) {
/* 173 */       int id = Integer.parseInt(ids);
/* 174 */       if ((id > 0) && (this.introductionService.getiIntroductionById(Integer.valueOf(id)) != null)) {
/* 175 */         this.introductionService.deleteIntroductionById(Integer.valueOf(id));
/* 176 */         return BaseResult.ok();
/*     */       }
/* 178 */       return BaseResult.build(500, "删除错误");
/*     */     }
/*     */     
/* 181 */     String[] postcode = ids.split(",");
/* 182 */     for (int i = 0; i < postcode.length; i++) {
/* 183 */       int id = Integer.parseInt(postcode[i]);
/* 184 */       if ((id < 1) || (this.introductionService.getiIntroductionById(Integer.valueOf(id)) == null)) {
/* 185 */         return BaseResult.build(500, "删除错误");
/*     */       }
/*     */     }
/* 188 */     for (int i = 0; i < postcode.length; i++) {
/* 189 */       int id = Integer.parseInt(postcode[i]);
/* 190 */       this.introductionService.deleteIntroductionById(Integer.valueOf(id));
/*     */     }
/* 192 */     return BaseResult.ok();
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\IntroductionController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */