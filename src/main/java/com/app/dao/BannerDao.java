package com.app.dao;

import com.app.entity.Banner;
import java.util.List;

public abstract interface BannerDao
{
  public abstract List<Banner> getBannerList();
  
  public abstract Banner getBannerById(int paramInt);
  
  public abstract void addBanner(Banner paramBanner);
  
  public abstract void deleteBannerById(int paramInt);
  
  public abstract void updateBanner(Banner paramBanner);
  
  public abstract void updateBannerState(Banner paramBanner);
  
  public abstract int getBannerNumber();
}


/* Location:              F:\Linux项目备份\taoxingzhi\WEB-INF\classes\!\com\app\dao\BannerDao.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */