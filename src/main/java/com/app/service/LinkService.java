package com.app.service;

import com.app.entity.Link;
import java.util.List;

public abstract interface LinkService
{
  public abstract List<Link> linkList();
  
  public abstract Link getLinkById(int paramInt);
  
  public abstract void updateLink(Link paramLink);
  
  public abstract void addLink(Link paramLink);
  
  public abstract void deleteLinkById(int paramInt);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\service\LinkService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */