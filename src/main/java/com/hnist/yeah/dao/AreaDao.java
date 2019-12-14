package com.hnist.yeah.dao;

import com.hnist.yeah.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 查询区域
     * @return areaList
     */
    List<Area> queryArea();
}
