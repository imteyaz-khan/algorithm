package com.sample.project.algorithm.misc;

import com.sample.project.datastructure.Stack;

/**
 * Created by imteyaz.khan on 14/07/17.
 */
public class BigNumberProduct {

    public static String productOf(String num1,String num2) {
        Node ip[]=new Node[num1.length()];
        for(int i=num1.length()-1;i>=0;i--) {
            Node node=productOf(num1.length()-1-i,(int)num1.charAt(i)-48,num2);
            ip[i]=node;
        }

        return sumOf(ip);
    }

    public static Node productOf(int numberIndex,int n,String number) {
        Node dummyNode=new Node(1);
        Node current=dummyNode;
        for(int index=0;index<numberIndex;index++) {
            current.next=new Node(1);
            current=current.next;
        }

        int carry=0;
        for(int i=number.length()-1;i>=0;i--) {
            int value=((number.charAt(i)-48)*n)+carry;
            int reminder=value%10;
            carry=value/10;
            current.next=new Node(reminder);
            current=current.next;
        }
        if(carry>0) {
            current.next= new Node(carry);
        }
        return dummyNode.next;
    }

    public static String sumOf(Node[] nodes) {
        Stack<Integer> stack=new Stack<>();
        int carry=0;
        while(hasElements(nodes)) {
            int value=0;
            for(int index=0;index<nodes.length;index++) {
                Node node=nodes[index];
                if(node!=null) {
                    value=value+node.number;
                    node=node.next;
                    nodes[index]=node;
                }
            }
            value=value+carry;
            carry=value/10;
            stack.push(value%10);

        }
        if(carry>0) {
            stack.push(carry);
        }
        removeTrailingZero(stack);
        StringBuilder stringBuilder=new StringBuilder();

        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static boolean hasElements(Node[] nodes) {
        for(Node node:nodes) {
            if(node!=null) {
                return true;
            }
        }
        return false;
    }

    public static void removeTrailingZero(Stack<Integer> stack) {
        while(!stack.isEmpty()) {
            int number=stack.pop();
            if(number==0) {
               continue;
            }
            stack.push(number);
            return;
        }
    }

    static class Node {
         int number;
         Node next;
         public Node(int number) {
             this.number=number;
         }
    }

    public static void main(String args[]) {
        String num1="2129012443739222287697023";
        String num2="232341366388477488";
        System.out.println(productOf(num1,num2));
    }
}
