/*     */ package com.app.controller;
/*     */ 
/*     */ import com.app.common.BaseResult;
/*     */ import com.app.entity.Banner;
/*     */ import com.app.service.BannerService;
/*     */ import com.app.util.UpdateFile;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
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
/*     */ @Controller
/*     */ @RequestMapping({"banner"})
/*     */ public class BannerController
/*     */ {
/*     */   @Resource(name="bannerService")
/*     */   private BannerService bannerService;
/*     */   
/*     */   @RequestMapping({"all"})
/*     */   @ResponseBody
/*     */   public List<Banner> getBannerList()
/*     */   {
/*  39 */     return this.bannerService.getBannerList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"allApp.do"})
/*     */   @ResponseBody
/*     */   public List<Banner> getBannerListApp()
/*     */   {
/*  49 */     List<Banner> bannerList = new ArrayList();
/*     */     
/*  51 */     List<Banner> banners = this.bannerService.getBannerList();
/*  52 */     for (int i = 0; i < banners.size(); i++)
/*     */     {
/*  54 */       if (((Banner)banners.get(i)).getState().intValue() == 1) {
/*  55 */         bannerList.add((Banner)banners.get(i));
/*     */       }
/*     */     }
/*  58 */     return bannerList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"findById.do"})
/*     */   @ResponseBody
/*     */   public Banner getBannerById(int id)
/*     */   {
/*  68 */     System.out.println(id);
/*  69 */     return this.bannerService.getBannerById(id);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult addBanner(@RequestParam("file") MultipartFile file, String title, String content, HttpServletRequest request)
/*     */   {
/*  89 */     Banner banner = new Banner();
/*     */     
/*  91 */     BaseResult result = UpdateFile.upload(request, file, "banner/");
/*     */     
/*  93 */     if (result.getCode() == 200)
/*     */     {
/*  95 */       String filePath = result.getData().toString();
/*     */       
/*     */ 
/*  98 */       SimpleDateFormat formatter = new SimpleDateFormat(
/*  99 */         "yyyy-MM-dd HH:mm:ss");
/* 100 */       String date = formatter.format(new Date());
/*     */       
/* 102 */       banner.setImagePath(filePath);
/*     */       
/* 104 */       banner.setTitle(title);
/*     */       
/* 106 */       banner.setBannerDetails(content);
/*     */       
/* 108 */       banner.setBannerTime(date);
/*     */       
/* 110 */       banner.setState(Integer.valueOf(0));
/*     */       
/* 112 */       this.bannerService.addBanner(banner);
/*     */     }
/* 114 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteById"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteBannerById(Integer id)
/*     */   {
/* 124 */     BaseResult result = new BaseResult();
/* 125 */     if ((id == null) || (this.bannerService.getBannerById(id.intValue()) == null)) {
/* 126 */       result.setCode(500);
/* 127 */       result.setMessage("操作错误");
/*     */     } else {
/* 129 */       this.bannerService.deleteBannerById(id.intValue());
/* 130 */       result.setCode(200);
/* 131 */       result.setMessage("删除成功");
/*     */     }
/* 133 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"deleteIds"})
/*     */   @ResponseBody
/*     */   public BaseResult deleteBanners(String ids)
/*     */   {
/* 143 */     BaseResult result = new BaseResult();
/* 144 */     if ((ids == null) || (ids.equals(""))) {
/* 145 */       result.setCode(500);
/* 146 */       result.setMessage("操作错误");
/* 147 */     } else if (!ids.contains(",")) {
/* 148 */       int id = Integer.parseInt(ids);
/* 149 */       if ((id > 0) && (this.bannerService.getBannerById(id) != null)) {
/* 150 */         this.bannerService.deleteBannerById(id);
/* 151 */         result.setCode(200);
/* 152 */         result.setMessage("删除成功");
/*     */       } else {
/* 154 */         result.setCode(500);
/* 155 */         result.setMessage("删除错误");
/*     */       }
/*     */     } else {
/* 158 */       String[] postcode = ids.split(",");
/* 159 */       for (int i = 0; i < postcode.length; i++) {
/* 160 */         int id = Integer.parseInt(postcode[i]);
/* 161 */         if ((id < 1) || (this.bannerService.getBannerById(id) == null)) {
/* 162 */           result.setCode(500);
/* 163 */           result.setMessage("删除错误");
/*     */         }
/* 165 */         this.bannerService.deleteBannerById(id);
/*     */       }
/* 167 */       result.setCode(200);
/* 168 */       result.setMessage("删除成功");
/*     */     }
/* 170 */     return result;
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
/*     */   public BaseResult updateBanner(@RequestParam("file") MultipartFile file, String path, String title, String content, Integer id, HttpServletRequest request)
/*     */   {
/* 184 */     if ((id == null) || (id.intValue() < 1)) {
/* 185 */       return BaseResult.build(500, "操作失败");
/*     */     }
/* 187 */     BaseResult result = new BaseResult();
/*     */     
/* 189 */     Banner banner = new Banner();
/*     */     
/* 191 */     String fileName = file.getOriginalFilename();
/* 192 */     if ((file.getOriginalFilename() != null) && (fileName.contains(".")))
/*     */     {
/* 194 */       result = UpdateFile.upload(request, file, "banner/");
/*     */       
/* 196 */       if (result.getCode() == 200)
/*     */       {
/* 198 */         String filePath = result.getData().toString();
/*     */         
/*     */ 
/* 201 */         banner.setImagePath(filePath);
/*     */         
/* 203 */         banner.setTitle(title);
/*     */         
/* 205 */         banner.setBannerDetails(content);
/*     */         
/* 207 */         banner.setId(id.intValue());
/*     */         
/* 209 */         this.bannerService.updateBanner(banner);
/*     */         
/* 211 */         return BaseResult.ok(filePath);
/*     */       }
/* 213 */       return BaseResult.build(500, "操作错误"); }
/* 214 */     if ((path != null) && (!fileName.contains(".")))
/*     */     {
/*     */ 
/* 217 */       banner.setImagePath(path);
/*     */       
/* 219 */       banner.setTitle(title);
/*     */       
/* 221 */       banner.setBannerDetails(content);
/*     */       
/* 223 */       banner.setId(id.intValue());
/*     */       
/* 225 */       this.bannerService.updateBanner(banner);
/* 226 */       return BaseResult.ok(path);
/*     */     }
/* 228 */     return BaseResult.build(500, "操作错误");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"updateStateById"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult updateBannerStateById(Integer id, Integer state)
/*     */   {
/* 240 */     if ((id == null) || (this.bannerService.getBannerById(id.intValue()) == null)) {
/* 241 */       return BaseResult.build(500, "更新失败");
/*     */     }
/*     */     
/* 244 */     if (this.bannerService.getBannerNumber() + 1 > 6) {
/* 245 */       return BaseResult.build(500, "你的前台轮播图已经超出了");
/*     */     }
/*     */     
/* 248 */     if ((state.intValue() == 1) || (state.intValue() == 0)) {
/* 249 */       Banner banner = new Banner();
/* 250 */       banner.setId(id.intValue());
/* 251 */       banner.setState(state);
/* 252 */       this.bannerService.updateBannerState(banner);
/* 253 */       return BaseResult.ok();
/*     */     }
/* 255 */     return BaseResult.build(500, "更新失败");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"updateStates"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public BaseResult updateBannerState(String ids, Integer state)
/*     */   {
/* 267 */     Banner banner = new Banner();
/*     */     
/* 269 */     if ((ids == null) || (ids.equals("")) || (state == null)) {
/* 270 */       return BaseResult.build(500, "更新失败");
/*     */     }
/* 272 */     if ((state.intValue() > 1) || (state.intValue() < 0)) {
/* 273 */       return BaseResult.build(500, "更新失败");
/*     */     }
/*     */     
/* 276 */     if (!ids.contains(","))
/*     */     {
/* 278 */       if (this.bannerService.getBannerNumber() + 1 > 6) {
/* 279 */         return BaseResult.build(500, "你的前台轮播图已经超出了");
/*     */       }
/*     */       
/* 282 */       if (this.bannerService.getBannerById(Integer.parseInt(ids)) == null) {
/* 283 */         return BaseResult.build(500, "操作错误");
/*     */       }
/* 285 */       banner.setId(Integer.parseInt(ids));
/* 286 */       banner.setState(state);
/* 287 */       this.bannerService.updateBannerState(banner);
/* 288 */       return BaseResult.ok();
/*     */     }
/* 290 */     String[] postcode = ids.split(",");
/*     */     
/* 292 */     if (this.bannerService.getBannerNumber() + postcode.length >= 6) {
/* 293 */       return BaseResult.build(500, "你的前台轮播图已经超出了");
/*     */     }
/*     */     
/* 296 */     for (int i = 0; i < postcode.length; i++) {
/* 297 */       int id = Integer.parseInt(postcode[i]);
/*     */       
/* 299 */       if (this.bannerService.getBannerById(id) == null) {
/* 300 */         return BaseResult.build(500, "操作错误");
/*     */       }
/*     */     }
/* 303 */     for (int i = 0; i < postcode.length; i++) {
/* 304 */       int id = Integer.parseInt(postcode[i]);
/* 305 */       banner.setId(id);
/* 306 */       banner.setState(state);
/* 307 */       this.bannerService.updateBannerState(banner);
/*     */     }
/* 309 */     return BaseResult.ok();
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
/*     */ 
/*     */   @RequestMapping(value={"addDetails"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public Map<String, Object> addBannerDetails(@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 327 */     Map<String, Object> obj = new HashMap();
/* 328 */     String message = "上传失败";
/*     */     
/* 330 */     BaseResult result = UpdateFile.upload(request, imgFile, "banner/");
/*     */     
/* 332 */     if (result.getCode() == 200)
/*     */     {
/* 334 */       String filePath = result.getData().toString();
/* 335 */       System.out.println(filePath);
/*     */       
/* 337 */       String url = filePath;
/*     */       
/* 339 */       message = "上传成功";
/*     */       
/* 341 */       obj.put("error", Integer.valueOf(0));
/* 342 */       obj.put("url", url);
/* 343 */       return obj;
/*     */     }
/*     */     
/* 346 */     obj.put("error", Integer.valueOf(1));
/* 347 */     obj.put("message", message);
/* 348 */     return obj;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"getNumber"})
/*     */   @ResponseBody
/*     */   public int getBannerNumber()
/*     */   {
/* 358 */     return this.bannerService.getBannerNumber();
/*     */   }
/*     */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\controller\BannerController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */