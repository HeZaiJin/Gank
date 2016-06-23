package com.example;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 100个猴子围成一个圈，从某一个猴子开始编号，它们的编号是1到100，从1号开始1,2,3,4,5,1,2,3,4,5循环报数，报到5的猴子就出列，直到所有猴子出列为止，请编程打印出猴子出列的编号顺序。
 */
public class MyClass {

    public static void main(String[] args) {
        ArrayList<Integer> mMonkeys = new ArrayList<>();
        System.out.println("Test");
        // init
        for (int i = 1; i <= 100; i++) {
            mMonkeys.add(i);
        }
        //
        int offset = 0;
        ArrayList<Integer> mValues = new ArrayList<>();
        while (mValues.size() < 100) {
            Iterator<Integer> iterator = mMonkeys.iterator();
            ArrayList<Integer> tmp = new ArrayList<>();
            int j = offset;
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                j++;
                if (j == 5) {
                    j = 0;
                    tmp.add(next);
                    mValues.add(next);
                }
                offset = j;
            }
            mMonkeys.removeAll(tmp);
        }
        // print values
        for (int i = 0; i < mValues.size(); i++) {
            System.out.print(mValues.get(i) + ",");
        }

    }
}
