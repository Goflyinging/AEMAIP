package cn.xidian.aemaip.dao;

import java.util.List;

import cn.xidian.aemaip.entity.Qss;

public interface QssMapper {
    
    public Qss selectQssById(int qssid);
    
    public List<Qss> selectQssByAd(int qssid);
}
