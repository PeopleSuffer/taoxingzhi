/*    */ package com.app.interceptor;
/*    */ 
/*    */ import com.app.entity.Manager;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoginInterceptor
/*    */   implements HandlerInterceptor
/*    */ {
/*    */   public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */   public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/*    */     throws Exception
/*    */   {
/* 31 */     response.setContentType("text/javascript; charset=utf-8");
/*    */     
/* 33 */     Manager manager = (Manager)request.getSession().getAttribute("manager");
/* 34 */     if (manager == null)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 40 */       response.sendRedirect("http://www.yehaikeji.com:8080/taoxingzhi/login.html");
/* 41 */       return false;
/*    */     }
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\interceptor\LoginInterceptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */