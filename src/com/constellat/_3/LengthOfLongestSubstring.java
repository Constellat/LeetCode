package com.constellat._3;

import java.io.IOException;
import java.util.HashMap;

public class LengthOfLongestSubstring {

    public int function1(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;
            a:
            for (; j < s.length(); j++) {
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        if (sum < j - i) {
                            sum = j - i;
                        }
                        break a;
                    }
                }
            }
            if (j == s.length()) {
                if (sum < j - i) {
                    sum = j - i;
                }
            }
        }
        return sum;
    }

    public int function2(String s) {
        int max = 0;
        int flag = -1;
        int a[] = new int[s.length() + 1];
        a[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;
            for (; j > flag; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    flag = j;
                    a[i + 1] = i - j;
                    if (max < a[i + 1]) {
                        max = a[i + 1];
                    }
                    j = -1;
                    break;
                }
            }
            if (j == flag) {
                a[i + 1] = a[i] + 1;
                if (max < a[i + 1]) {
                    max = a[i + 1];
                }
            }
        }
        return max;
    }

    public int function3(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int max = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                int location = hashMap.get(s.charAt(i));
                if (location > flag) {
                    flag = location;
                }
            }
            if (max < i - flag) {
                max = i - flag;
            }
            hashMap.put(s.charAt(i), i);
        }
        return max;
    }

    public int function4(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        if (chars.length == 0) {
            return 0;
        } else if (chars.length == 1) {
            return 1;
        }
        //重复的坐标
        int len = 0;
        // 外层for循环  用来计算总长
        int j;
        //内层for循环  用来计算总长
        int k;
        for (j = 0; j < chars.length; j++) {
            for (k = len; k < j; k++) {
                if (chars[j] == chars[k]) {
                    len = k + 1;
                    break;
                }
            }
            if (max < j - len + 1) {
                max = j - len + 1;
            }
        }
        return max;
    }

    public void test() throws IOException {
        long startTime = System.nanoTime();   //获取开始时间
        System.out.println(function1("abcabcbb"));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法一运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(function2("abcabcbb"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法二运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(function3("abcabcbb"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法三运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(function4("abcabcbb"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法四运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间
    }

    /**
     * Runtime r = Runtime.getRuntime();        //
     * long freeMemory = r.freeMemory();        //返回 Java 虚拟机中的空闲内存量
     * long totalMemory = r.totalMemory();      //返回 Java 虚拟机中的内存总量
     * long maxMemory = r.maxMemory();          //返回 Java 虚拟机试图使用的最大内存量
     * int availableProcessors = r.availableProcessors();   //返回到虚拟机的最大可用的处理器数量
     *
     *
     * class Solution {
     *     public int lengthOfLongestSubstring(String s) {
     *         char[] chars = s.toCharArray();
     * 		int max = 0;
     * 		if (chars.length == 0) {
     * 			return 0;
     *                } else if (chars.length == 1) {
     * 			return 1;
     *        }
     * 		//重复的坐标
     * 		int len = 0;
     * 		// 外层for循环  用来计算总长
     * 		int j ;
     * 		//内层for循环  用来计算总长
     * 		int k;
     * 		for (j=0; j <chars.length ; j++) {
     * 			for ( k = len;  k<j ; k++) {
     * 				if (chars[j] == chars[k]) {
     * 					len = k+1 ;
     * 					break;
     *                }
     *            }
     * 			if (max < j - len+1) {
     * 				max = j - len+1;
     *            }
     *        }
     * 		return max;
     *     }
     * }
     *
     */
}
