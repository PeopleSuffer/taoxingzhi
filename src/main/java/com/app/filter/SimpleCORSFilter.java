/*    */ package com.app.filter;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class SimpleCORSFilter
/*    */   implements Filter
/*    */ {
/*    */   public void init(FilterConfig filterConfig)
/*    */     throws ServletException
/*    */   {}
/*    */   
/*    */   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
/*    */     throws IOException, ServletException
/*    */   {
/* 24 */     HttpServletResponse response = (HttpServletResponse)servletResponse;
/* 25 */     String origin = servletRequest.getRemoteHost() + ":" + servletRequest.getRemotePort();
/* 26 */     response.setHeader("Access-Control-Allow-Origin", "*");
/* 27 */     response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
/* 28 */     response.setHeader("Access-Control-Max-Age", "3600");
/* 29 */     response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
/* 30 */     response.setHeader("Access-Control-Allow-Credentials", "true");
/* 31 */     filterChain.doFilter(servletRequest, servletResponse);
/*    */   }
/*    */   
/*    */   public void destroy() {}
/*    */ }


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\filter\SimpleCORSFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */