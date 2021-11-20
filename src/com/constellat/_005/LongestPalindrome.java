package com.constellat._005;

public class LongestPalindrome {
    // 方法超时
    public static String function1(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i + result.length(); j--) {
                int left = i;
                int right = j;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }
                    left++;
                    right--;
                }
                if (left >= right) {
                    if (result.length() < j - i + 1) {
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;

        //        String result = "";
//        for(int i=0;i<s.length();i++){
//            int j=s.length()-1;
//            for(;j>=i+result.length();j--){
//                if(s.charAt(i)==s.charAt(j)){
//                    int k=1;
//                    for(;2*k<(j-i);k++){
//                        if(s.charAt(i+k)!=s.charAt(j-k)){
//                            break ;
//                        }
//                    }
//                    if(2*k>=j-i){
//                        if(result.length()<j-i+1){
//                            result = s.substring(i,j+1);
//                            if(i+result.length()==s.length()){
//                                return result;
//                            }
//                            break ;
//                        }
//                    }
//                }
//            }
//        }
//        return result;
    }

    public static String function2(String s) {
        String result = "";
        for (int n = 0; n + result.length() < 2 * s.length() - 1; n++) {
            if (n % 2 == 0) {
                int i = n / 2;
                int j = 1;
                for (; i - j >= 0 && i + j < s.length(); j++) {
                    if (s.charAt(i - j) != s.charAt(i + j)) {
                        break;
                    }
                }
                if (2 * j - 1 > result.length()) {
                    result = s.substring(i - j + 1, i + j);
                }
            } else {
                int i = n / 2;
                int j = 1;
                for (; i - j + 1 >= 0 && i + j < s.length(); j++) {
                    if (s.charAt(i - j + 1) != s.charAt(i + j)) {
                        break;
                    }
                }
                if (2 * j - 2 > result.length()) {
                    result = s.substring(i - j + 2, i + j);
                }
            }
        }
        return result;
    }

    // Manacher 算法
    public static String function3(String s) {
        char[] cStr = s.toCharArray();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("#");
        for (int i = 0; i < cStr.length; i++) {
            sBuffer.append(cStr[i]);
            sBuffer.append("#");
        }
        int id = 0;
        int max = 0;
        int p[] = new int[sBuffer.length()];
        for (int i = 1; i < sBuffer.length(); i++) {

            if (i < max) {
                p[i] = Math.min(p[2 * id - i], max - i);
            } else {
                p[i] = 1;
            }
            while (i - p[i] >= 0 && i + p[i] < sBuffer.length() && sBuffer.charAt(i - p[i]) == sBuffer.charAt(i + p[i])) {
                p[i]++;
            }
            if (i + p[i] > max) {
                max = i + p[i];
                id = i;
            }
        }
        int maxl = 0;
        int maxid = 0;
        for (int i = 0; i < p.length; i++) {
            if (maxl < p[i]) {
                maxl = p[i];
                maxid = i;
            }

        }
        //半径包括id本身。id到第一个元素，id-r+1
        int r = maxl - 1;
        int start = maxid - r + 1;
        int end = maxid + maxl - 1;
        StringBuffer out = new StringBuffer();
        for (int i = start; i < end; i++) {
            if (sBuffer.charAt(i) != '#') {
                out.append(sBuffer.charAt(i));
            }
        }
        return out.toString();
    }

    /**
     * 动态规划
     * 1. 字符串中从a位置到b位置是否是回文串P[a,b]，则依赖于P[a+1,b-1] && string[a]==string[b]的值
     * 2. 使用二维数组存储P的值，就能得到回文串，记录最长的下标差就可以表示
     * 3. 边界条件，P[a,a]一定是true，回文串的长度从1开始，一直到string.length
     */
    public static String function4(String s) {
        String resultString = "";
        int stringLength = s.length();
        boolean[][] result = new boolean[stringLength][stringLength];
        for (int i = 0; i < stringLength; i++) {
            result[i][i] = true;
        }
        // 回文串的长度
        for (int length = 2; length <= stringLength; length++) {
            for (int index = 0; index < stringLength; index++) {
                int index2 = length + index - 1;
                if (index2 >= stringLength) {
                    break;
                }
                if (length == 2) {
                    result[index][index2] = s.charAt(index) == s.charAt(index2);
                } else {
                    result[index][index2] = result[index + 1][index2 - 1] && (s.charAt(index) == s.charAt(index2));
                }
                if (result[index][index2]) {
                    if (resultString.length() < length) {
                        resultString = s.substring(index, index2 + 1);
                    }
                }
            }
        }
        if (resultString.length() == 0 && stringLength > 0) {
            resultString = s.substring(0, 1);
        }
        return resultString;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        System.out.println(function1("abcbaddd"));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法一运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间


        startTime = System.nanoTime();   //获取开始时间
        System.out.println(function2("abcbaddd"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法二运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(function3("abcbaddd"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法三运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime = System.nanoTime();   //获取开始时间
        System.out.println(function4("bb"));
        endTime = System.nanoTime(); //获取结束时间
        System.out.println("方法三运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间
    }
}
