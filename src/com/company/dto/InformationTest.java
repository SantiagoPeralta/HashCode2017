package com.company.dto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class InformationTest {
    @Test
    public void getResult() throws Exception {
        Information info = new Information();
        Integer[] values = new Integer[] {20, 11, 50, 26, 5, 3, 6, 32, 40, 22, 4, 20, 50, 27, 49, 44, 1, 37, 35, 27, 14, 33, 6, 22, 23, 48, 44, 14, 26, 9, 46, 44, 15, 32, 31, 8, 39, 27, 39, 27, 1, 17, 1, 47, 44, 42, 16, 3, 44, 48, 5, 25, 4, 39, 39, 7, 24, 28, 14, 44, 22, 11, 27, 37, 11, 16, 50, 33, 22, 26, 7, 12, 17, 30, 12, 12, 4, 32, 12, 46, 43, 4, 12, 34, 11, 7, 47, 29, 24, 40, 41, 10, 5, 22, 22, 24, 37, 34, 50, 5};
        ArrayList<Integer> videoSizes = new ArrayList<Integer>(Arrays.asList(values));
        info.setInfrastructureInformation(100,10, 100, 10, 100);
        info.setVideosSizes(videoSizes);
        System.out.println(info.getResult());

    }

}