/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.Link;
/*     */ import com.app.service.LinkService;
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
/*     */ @RequestMapping({"link"})
/*     */ public class LinkController
/*     */ {
/*     */   @Resource(name="linkService")
/*     */   private LinkService linkService;
/*     */   
/*     */   @RequestMapping({"all.do"})
/*     */   @ResponseBody
/*     */   public List<Link> linkList()
/*     */   {
/*  32 */     return this.linkService.linkList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"allIntercept"})
/*     */   @ResponseBody
/*     */   public List<Link> linksIntercept()
/*     */   {
/*  43 */     return this.linkService.linkList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById.do"})
/*     */   @ResponseBody
/*     */   public Link getLinkById(Integer id)
/*     */   {
/*  54 */     if ((id == null) || (id.intValue() <= 0)) {
/*  55 */       return null;
/*     */     }
/*  57 */     return this.linkService.getLinkById(id.intValue());
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
/*     */   public BaseResult updateLink(Integer id, String linkUrl, String linkName)
/*     */   {
/*  71 */     if ((id == null) || (this.linkService.getLinkById(id.intValue()) == null)) {
/*  72 */       return BaseResult.build(500, "操作错误");
/*     */     }
/*     */     
/*  75 */     Link link = new Link();
/*     */     
/*  77 */     link.setId(id);
/*     */     
/*  79 */     link.setLinkUrl(linkUrl);
/*     */     
/*  81 */     link.setLinkName(linkName);
/*  82 */     this.linkService.updateLink(link);
/*  83 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult addLink(String linkUrl, String linkName)
/*     */   {
/*  95 */     if ((linkUrl == null) || (linkUrl.equals("")) || (linkName == null) || (linkName.equals(""))) {
/*  96 */       return BaseResult.build(500, "操作错误");
/*     */     }
/*     */     
/*  99 */     Link link = new Link();
/*     */     
/* 101 */     SimpleDateFormat formatter = new SimpleDateFormat(
/* 102 */       "yyyy-MM-dd HH:mm:ss");
/* 103 */     String date = formatter.format(new Date());
/*     */     
/*     */ 
/* 106 */     link.setCreateTime(date);
/*     */     
/* 108 */     link.setLinkUrl(linkUrl);
/*     */     
/* 110 */     link.setLinkName(linkName);
/* 111 */     this.linkService.addLink(link);
/* 112 */     return BaseResult.ok();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteById"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteLinkById(Integer id)
/*     */   {
/* 124 */     if ((id == null) || (this.linkService.getLinkById(id.intValue()) == null)) {
/* 125 */       return BaseResult.build(500, "操作错误");
/*     */     }
/* 127 */     this.linkService.deleteLinkById(id.intValue());
/* 128 */     return BaseResult.ok();
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
/* 139 */     if ((ids == null) || (ids.equals("")))
/* 140 */       return BaseResult.build(500, "操作错误");
/* 141 */     if (!ids.contains(","))
/*     */     {
/* 143 */       int id = Integer.parseInt(ids);
/*     */       
/* 145 */       if (this.linkService.getLinkById(id) == null) {
/* 146 */         return BaseResult.build(500, "操作错误");
/*     */       }
/*     */       
/* 149 */       this.linkService.deleteLinkById(id);
/* 150 */       return BaseResult.ok();
/*     */     }
/*     */     
/* 153 */     String[] postcode = ids.split(",");
/*     */     
/* 155 */     for (int i = 0; i < postcode.length; i++)
/*     */     {
/* 157 */       Integer id = Integer.valueOf(Integer.parseInt(postcode[i]));
/*     */       
/* 159 */       if ((id == null) || (this.linkService.getLinkById(id.intValue()) == null)) {
/* 160 */         return BaseResult.build(500, "操作错误");
/*     */       }
/*     */     }
/*     */     
/* 164 */     for (int i = 0; i < postcode.length; i++)
/*     */     {
/* 166 */       Integer id = Integer.valueOf(Integer.parseInt(postcode[i]));
/* 167 */       this.linkService.deleteLinkById(id.intValue());
/*     */     }
/* 169 */     return BaseResult.ok();
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\LinkController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */