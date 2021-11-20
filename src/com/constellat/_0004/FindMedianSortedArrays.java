package com.constellat._0004;

import java.util.ArrayList;

public class FindMedianSortedArrays {


    public double function1(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (i < nums1.length || j < nums2.length) {
            if (i == nums1.length) {
                arrayList.add(nums2[j]);
                j++;
            } else if (j == nums2.length) {
                arrayList.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                arrayList.add(nums2[j]);
                j++;
            } else {
                arrayList.add(nums1[i]);
                i++;
            }
        }
        i = arrayList.size() / 2;
        if (2 * i + 1 == arrayList.size()) {
            return arrayList.get(i);
        } else if (i == 0) {
            return 0;
        } else {
            return (double) (arrayList.get(i) + arrayList.get(i - 1)) / 2;
        }
    }

    public double function2(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (arrayList.size() * 2 <= (nums1.length + nums2.length)) {
            if (i == nums1.length) {
                arrayList.add(nums2[j]);
                j++;
            } else if (j == nums2.length) {
                arrayList.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                arrayList.add(nums2[j]);
                j++;
            } else {
                arrayList.add(nums1[i]);
                i++;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return arrayList.get(arrayList.size() - 1);
        } else {
            return (arrayList.get(arrayList.size() - 1) + (double) arrayList.get(arrayList.size() - 2)) / 2;
        }
    }

    public double function3(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int length = 0;
        Double before = 0.0;
        int after = 0;
        while (length * 2 < (nums1.length + nums2.length)) {
            if (i == nums1.length) {
                before = (double)nums2[j];
                j++;
            } else if (j == nums2.length) {
                before = (double)nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                before = (double)nums2[j];
                j++;
            } else {
                before = (double)nums1[i];
                i++;
            }
            length++;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return before;
        } else {
            if (i == nums1.length) {
                after = nums2[j];
            } else if (j == nums2.length) {
                after = nums1[i];
            } else if (nums1[i] > nums2[j]) {
                after = nums2[j];
            } else {
                after = nums1[i];
            }
            return (before + after) / 2;
        }
    }

    public void test() {
        int a[] = {1, 3};
        int b[] = {2};

        long startTime = System.nanoTime();   //获取开始时间
        System.out.println(function1(a, b));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法一运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间


        startTime = System.nanoTime();   //获取开始时间
        System.out.println(function2(a, b));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法二运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(function3(a, b));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法三运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间
    }
}