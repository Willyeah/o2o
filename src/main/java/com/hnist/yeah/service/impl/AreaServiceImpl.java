package com.hnist.yeah.service.impl;

import com.hnist.yeah.dao.AreaDao;
import com.hnist.yeah.entity.Area;
import com.hnist.yeah.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return  areaDao.queryArea();
    }
}
