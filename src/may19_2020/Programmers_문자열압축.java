/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may19_2020;
/**
 *
 * @author 주세인1
 */

import java.util.*; 
import java.io.*;

public class Programmers_문자열압축 {
    
    public static void main(String[] args) {
        String s1 = "aabbaccc"; 
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede"; 
        String s4 = "abcabcabcabcdededededede"; 
        String s5 = "xababcdcdababcdcd"; 
        int cnt = 2; 
        
        System.out.println("answer: " + solution(s1));
        System.out.println("answer: " + solution(s2));
        System.out.println("answer: " + solution(s3));
        System.out.println("answer: " + solution(s4));
        System.out.println("answer: " + solution(s5));
    }
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE; 
        int len = s.length(); 
        
        if (len == 1 || len == 2) {
            return len; 
        }
        
        //문자열 길이가 2보다 길 때 
        for(int i = 1; i <= s.length() /2; i++) {
            answer = Math.min(answer, shortenString(i, s)); 
        }
        
        return answer; 
    }
    public static int shortenString(int len, String s) {
        int length = len; 
        int cnt = 0; 
        StringBuilder pre = new StringBuilder(); 
        pre.append(s.substring(0, len)); 
        StringBuilder curr = new StringBuilder();
        
        int i=0; 
        
        for(i = len; i < s.length(); i += len) {
//           System.out.println("pre: " + pre.toString()); 
           if (i + len <= s.length()) 
                curr.append(s.substring(i, i+len)); 
           else 
               break; 
//           System.out.println("curr: " +curr.toString()); 
           if (pre.toString().equals(curr.toString())) {
//               System.out.println(cnt);
               cnt ++; 
               if (cnt == 1) {
                   length += 1; 
               } 
           }
           
           else {
               length += len; 
               pre = curr; 
               cnt = 0;
           }
           
           curr = new StringBuilder(); 
        }
        
        
        // 마지막을 붙여줌
        if(s.length() % len != 0) {
            curr.append(s.substring(i, s.length()));  
            if (! pre.toString().equals(curr.toString()))
            length += curr.length(); 
//            System.out.println(curr.toString()); 
        }
        
        
        
//        System.out.println(length);
        
        return length; 
    }
}
