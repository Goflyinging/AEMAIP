package cn.xidian.aemaip.dao;

import cn.xidian.aemaip.entity.Enclosure;

public interface EnclosureMapper {
    public int insert(Enclosure entity);
    
    public Enclosure selectById(int fileid);
    
    public Enclosure selectByAddress(String adress);
}
