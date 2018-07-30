package com.app.dao;

import com.app.entity.Link;
import java.util.List;

public abstract interface LinkDao
{
  public abstract List<Link> linkList();
  
  public abstract Link getLinkById(int paramInt);
  
  public abstract void updateLink(Link paramLink);
  
  public abstract void addLink(Link paramLink);
  
  public abstract void deleteLinkById(int paramInt);
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\dao\LinkDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */