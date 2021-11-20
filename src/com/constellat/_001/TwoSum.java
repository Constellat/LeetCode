package com.constellat._001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */

    public List<Integer> function1(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]+nums[j] == target){
                    return Arrays.asList(j+1,i+1);
                }
            }
        }
        return null;
    }

    public List<Integer> function2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int result = target - nums[i];
            if(map.containsKey(result)){
                return Arrays.asList(i+1,map.get(result)+1);
            }
        }
        return null;
    }

    public List<Integer> function3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            int result = target - nums[i];
            if(map.containsKey(result)){
                return Arrays.asList(map.get(result),i);
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public int[] function4(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            int result = target - nums[i];
            map.put(result,i);
        }
        return null;
    }

    public void test(){
        int array[] = new int[]{7,8,9,1,5,6,4};

        long startTime=System.nanoTime();   //获取开始时间
        System.out.println(function1(array,5));
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("方法一运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime=System.nanoTime();   //获取开始时间
        System.out.println(function2(array,5));
        endTime=System.nanoTime(); //获取结束时间
        System.out.println("方法二运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime=System.nanoTime();   //获取开始时间
        System.out.println(function3(array,5));
        endTime=System.nanoTime(); //获取结束时间
        System.out.println("方法三运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间
    }
}

