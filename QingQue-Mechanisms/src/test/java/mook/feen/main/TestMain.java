package mook.feen.main;


import mooc.feen.action.BasicAction;
import mooc.feen.enemy.Enemy;
import mooc.feen.qingque.QingQue;
import mooc.feen.role.CommonRole;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {



    @Test
    public void test() {
        QingQue qingQue = new QingQue();
        List<Integer> points = new ArrayList<>();
        int count = 1;
        System.out.println("第"+(count)+"次抽牌前，拥有的牌："+Arrays.asList(null,null,null,null));
        List<Integer> skill = qingQue.skill(points);
        System.out.println("第"+(count++)+"次抽牌后，拥有的牌："+skill);
        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.println("第"+(count)+"次抽牌前，拥有的牌："+skill);
            skill = qingQue.skill(skill);
            System.out.println("第"+(count++)+"次抽牌后，拥有的牌："+skill);
            System.out.println();
        }





    }



}
