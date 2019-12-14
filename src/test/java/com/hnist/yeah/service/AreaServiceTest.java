package com.hnist.yeah.service;

import com.hnist.yeah.BaseTest;
import com.hnist.yeah.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private  AreaService areaService;
    @Test
    public void testAreaService() {

        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList);
    }
}
