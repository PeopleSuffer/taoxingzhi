/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.Regulation;
/*     */ import com.app.service.RegulationService;
/*     */ import com.app.util.PagingUtils;
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
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"regul"})
/*     */ public class RegulationController
/*     */ {
/*     */   @Resource(name="regulationService")
/*     */   private RegulationService regulationService;
/*     */   
/*     */   @RequestMapping({"all"})
/*     */   @ResponseBody
/*     */   public List<Regulation> getRegulationList(Integer pageNumber)
/*     */   {
/*  33 */     List<Regulation> regulations = this.regulationService.getRegulationList();
/*  34 */     Regulation regulation = new Regulation();
/*  35 */     PagingUtils<Regulation> pagingUtils = new PagingUtils(regulation);
/*     */     
/*  37 */     if (pageNumber == null) {
/*  38 */       pageNumber = Integer.valueOf(0);
/*     */     }
/*     */     
/*  41 */     List<Regulation> regulationList = pagingUtils.pageingDate(pageNumber.intValue(), regulations);
/*  42 */     return regulationList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById.do"})
/*     */   @ResponseBody
/*     */   public Regulation getRegulationById(Integer id)
/*     */   {
/*  52 */     if ((id != null) && (id.intValue() > 0)) {
/*  53 */       return this.regulationService.getRegulationById(id);
/*     */     }
/*  55 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findByState.do"})
/*     */   @ResponseBody
/*     */   public Regulation getRegulationByState()
/*     */   {
/*  65 */     List<Regulation> regulations = this.regulationService.getRegulationByState();
/*     */     
/*  67 */     if ((regulations != null) && (regulations.size() > 0)) {
/*  68 */       return (Regulation)regulations.get(0);
/*     */     }
/*  70 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"getNumber"})
/*     */   @ResponseBody
/*     */   public int getRegulationNumber()
/*     */   {
/*  79 */     return this.regulationService.getRegulationNumber();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult addRegulation(String title, String content)
/*     */   {
/*  91 */     Regulation regulation = new Regulation();
/*     */     
/*     */ 
/*  94 */     SimpleDateFormat formatter = new SimpleDateFormat(
/*  95 */       "yyyy-MM-dd HH:mm:ss");
/*  96 */     String date = formatter.format(new Date());
/*     */     
/*  98 */     regulation.setTitle(title);
/*     */     
/* 100 */     regulation.setContent(content);
/*     */     
/* 102 */     regulation.setCreateTime(date);
/*     */     
/* 104 */     regulation.setState(Integer.valueOf(0));
/*     */     
/* 106 */     this.regulationService.addRegulation(regulation);
/* 107 */     return BaseResult.ok();
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
/*     */   public BaseResult updateRegulation(Integer id, String title, String content)
/*     */   {
/* 120 */     Regulation regulation = new Regulation();
/*     */     
/* 122 */     if ((id == null) || (this.regulationService.getRegulationById(id) == null)) {
/* 123 */       return BaseResult.build(500, "id参数错误");
/*     */     }
/*     */     
/* 126 */     regulation.setId(id);
/*     */     
/* 128 */     regulation.setTitle(title);
/*     */     
/* 130 */     regulation.setContent(content);
/*     */     
/* 132 */     this.regulationService.updateRegulation(regulation);
/* 133 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"updateByState"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult updateRegulationState(Integer id, Integer state)
/*     */   {
/* 145 */     Regulation regulation = new Regulation();
/*     */     
/* 147 */     if ((id == null) || (this.regulationService.getRegulationById(id) == null)) {
/* 148 */       return BaseResult.build(500, "id参数错误");
/*     */     }
/*     */     
/* 151 */     if ((state.intValue() == 1) || (state.intValue() == 0)) {
/* 152 */       regulation.setId(id);
/* 153 */       regulation.setState(state);
/* 154 */       this.regulationService.updateRegulationState(regulation);
/* 155 */       return BaseResult.ok();
/*     */     }
/* 157 */     return BaseResult.build(500, "操作有误");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteById"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteRegulationById(Integer id)
/*     */   {
/* 168 */     if ((id == null) || (this.regulationService.getRegulationById(id) == null)) {
/* 169 */       return BaseResult.build(500, "id参数错误");
/*     */     }
/*     */     
/* 172 */     this.regulationService.deleteRegulationById(id);
/* 173 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */   @RequestMapping({"deletes"})
/*     */   @ResponseBody
/* 178 */   public BaseResult deleteByIds(String ids) { if ((ids == null) || (ids.equals("")))
/* 179 */       return BaseResult.build(500, "输入的参数有误");
/* 180 */     if (!ids.contains(",")) {
/* 181 */       int id = Integer.parseInt(ids);
/* 182 */       if ((id > 0) && (this.regulationService.getRegulationById(Integer.valueOf(id)) != null)) {
/* 183 */         this.regulationService.deleteRegulationById(Integer.valueOf(id));
/* 184 */         return BaseResult.ok();
/*     */       }
/* 186 */       return BaseResult.build(500, "删除错误");
/*     */     }
/*     */     
/* 189 */     String[] postcode = ids.split(",");
/* 190 */     for (int i = 0; i < postcode.length; i++) {
/* 191 */       int id = Integer.parseInt(postcode[i]);
/* 192 */       if ((id < 1) || (this.regulationService.getRegulationById(Integer.valueOf(id)) == null)) {
/* 193 */         return BaseResult.build(500, "删除错误");
/*     */       }
/*     */     }
/* 196 */     for (int i = 0; i < postcode.length; i++) {
/* 197 */       int id = Integer.parseInt(postcode[i]);
/* 198 */       this.regulationService.deleteRegulationById(Integer.valueOf(id));
/*     */     }
/* 200 */     return BaseResult.ok();
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\RegulationController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */