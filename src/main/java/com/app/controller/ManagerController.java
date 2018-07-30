/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.Manager;
/*     */ import com.app.service.ManagerService;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
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
/*     */ @RequestMapping({"manager"})
/*     */ public class ManagerController
/*     */ {
/*     */   @Resource(name="managerService")
/*     */   private ManagerService managerService;
/*     */   
/*     */   @RequestMapping(value={"login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public Map<String, Object> getManagerByName(String managerName, String possWord, HttpServletRequest request)
/*     */   {
/*  35 */     Manager managerboss = new Manager();
/*  36 */     managerboss.setManagerName(managerName);
/*  37 */     managerboss.setPossWord(possWord);
/*     */     
/*  39 */     Map<String, Object> map = new HashMap();
/*     */     
/*  41 */     Manager manager = this.managerService.getManagerByName(managerboss);
/*     */     
/*  43 */     if (this.managerService.getManagerByName(managerboss) == null) {
/*  44 */       map.put("code", Integer.valueOf(500));
/*  45 */       map.put("message", "账号或密码错误");
/*  46 */       return map;
/*     */     }
/*     */     
/*  49 */     map.put("code", Integer.valueOf(200));
/*  50 */     map.put("message", manager);
/*  51 */     HttpSession session = request.getSession();
/*  52 */     session.setAttribute("manager", manager);
/*  53 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById"})
/*     */   @ResponseBody
/*     */   public Manager getManagerById(Integer id)
/*     */   {
/*  63 */     if ((id != null) && (id.intValue() > 0)) {
/*  64 */       return this.managerService.getManagerById(id);
/*     */     }
/*  66 */     return null;
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
/*     */   public BaseResult updateManager(Integer id, String managerName, String possWord)
/*     */   {
/*  80 */     if ((id == null) || (this.managerService.getManagerById(id) == null)) {
/*  81 */       return BaseResult.build(500, "输入参数错误");
/*     */     }
/*     */     
/*  84 */     if ((managerName != null) && (!managerName.equals("")) && (possWord != null) && (!possWord.equals("")))
/*     */     {
/*  86 */       Manager manager = new Manager();
/*     */       
/*  88 */       manager.setId(id);
/*     */       
/*  90 */       manager.setManagerName(managerName);
/*     */       
/*  92 */       manager.setPossWord(possWord);
/*     */       
/*  94 */       this.managerService.updateManager(manager);
/*  95 */       return BaseResult.ok();
/*     */     }
/*  97 */     return BaseResult.build(500, "操作错误");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"exitManager"})
/*     */   @ResponseBody
/*     */   public String exitManager(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 109 */     request.getSession().invalidate();
/*     */     try {
/* 111 */       System.out.println(1);
/* 112 */       request.getSession().removeAttribute("manager");
/*     */       
/*     */ 
/*     */ 
/* 116 */       return "1";
/*     */     }
/*     */     catch (Exception e) {
/* 119 */       e.printStackTrace();
/*     */     }
/* 121 */     return "0";
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\ManagerController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */