package com.constellat._2;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 递归
    private ListNode function2(ListNode l1, ListNode l2,int carry) {
        if(l1==null && l2==null && carry==0){
            return null;
        }
        int a=0;
        int b=0;
        if(l1!=null){
            a = l1.val;
        }
        if(l2!=null){
            b = l2.val;
        }

        ListNode result = new ListNode((a+b+carry)%10);
        carry = (a+b+carry)/10;

        if(l1!=null){
            l1 = l1.next;
        }
        if(l2!=null){
            l2 = l2.next;
        }
        result.next = function2(l1,l2,carry);
        return result;
    }

    // 递归
    private ListNode function1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry!=0) {
            int a=0;
            int b=0;
            if(l1!=null){
                a = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                b = l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode((a + b + carry) % 10 );
            carry = (a + b + carry) / 10;

            pre.next = node;
            pre = node;
        }
        return result.next;
    }

    /**
     * 方法三会受到int的大小范围限制
     * @param l1
     * @param l2
     * @return
     */
    public ListNode function3(ListNode l1,ListNode l2){
        long a = listNodeToInt(l1);
        long b = listNodeToInt(l2);
        long sum = a+b;
        return intToListNode(sum);
    }
    private long listNodeToInt(ListNode l){
        long result = 0;
        long temp = 1;
        while(l!=null){
            result = l.val * temp + result;
            temp = temp * 10;
            l = l.next;
        }
        return result;
    }
    private ListNode intToListNode(long i){
        ListNode result = new ListNode((int) (i%10));
        ListNode pre = result;
        i = i/10;
        while(i!=0){
            ListNode node = new ListNode((int) (i % 10));
            i = i / 10;
            pre.next = node;
            pre = node;
        }
        return result;
    }

    public void test() {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));

        long startTime=System.nanoTime();   //获取开始时间
        System.out.println(function1(l1,l2).toString());
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("方法一运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        startTime=System.nanoTime();   //获取开始时间
        System.out.println(function2(l1,l2,0).toString());
        endTime=System.nanoTime(); //获取结束时间
        System.out.println("方法二运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

        //[9]
        //[1,9,9,9,9,9,9,9,9,9]
        l1 = new ListNode(9);
        l2 = new ListNode(1,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))))));
        startTime=System.nanoTime();   //获取开始时间
        System.out.println(function3(l1,l2).toString());
        endTime=System.nanoTime(); //获取结束时间
        System.out.println("方法三运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间
    }
}
