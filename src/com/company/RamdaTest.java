package com.company;

import com.company.ramda.Func;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by icent on 2017. 1. 23..
 */
public class RamdaTest {

    @Test
    public void test01() {

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);


        items.forEach((k,v) ->{
            if(k.equals("A")) {
                System.out.println(v);
            }
        });
    }
}
