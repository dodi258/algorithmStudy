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

import java.util.Stack; 

public class Programmers_괄호변환 {
    public static String solution(String s) {
        
        String answer = ""; 
        
        
        //여기 v 가 0 이면이 있어야함. 
        if (s.length() == 0 || isRightString(s)) 
            return s; 
        
        StringBuilder u = new StringBuilder(); 
        StringBuilder v = new StringBuilder(); 
        for(int i= 0; i < s.length(); i++) {
            v.append(s.charAt(i)); 
        }
        int left = 0; 
        int right = 0; 
        while(true) {
            
            if (v.charAt(0) == ')') {
                left +=1 ; 
            }
            else {
                right +=1; 
            }
            
            u.append(v.charAt(0));
            v.deleteCharAt(0); 
            
            if (left == right) 
                break; 
            
            
        }
                
        StringBuilder str = new StringBuilder(); 
        if (isRightString(u.toString())) {
            str.append(u + solution(v.toString())); 
        }
        
        else {
            str.append("("); 
            str.append(solution(v.toString())); 
            str.append(")"); 
            
            for(int i = 0; i < u.length(); i++) {  
                if (u.charAt(i) == '('){
                    str.append(")");
                }
                else 
                    str.append("("); 
            }
        }
        answer = str.toString(); 
        return answer; 
    }
    
//    public static String makeRightString(String s) {
//        
//        //u와 v 정하기 
//        StringBuilder u = new StringBuilder(); 
//        StringBuilder v = new StringBuilder(s); 
//        
//        int left = 0; 
//        int right = 0; 
//        if (v.charAt(0) == '(') {
//            left ++; 
//        }
//        else {
//            right ++; 
//        }
//        u.append(v.deleteCharAt(0)); 
//        
//        while(true) {
//            if (left == right)
//                break; 
//            if (v.charAt(0) == '(') {
//                left ++; 
//            }
//            else {
//                right ++; 
//            }
//            u.append(v.deleteCharAt(0)); 
//        }
//        
//        StringBuilder str = new StringBuilder(); 
//        if (isRightString(u.toString())) {
//            str.append(u);
//            str.append(makeRightString(v.toString())); 
//        }
//        
//        else {
//            str.append("("); 
//            str.append(makeRightString(v.toString())); 
//            str.append(")"); 
//            
//            for(int i = u.length() - 1; i >= 0; i--) {
//                if (u.charAt(i) == '('){
//                    str.append(')');
//                }
//                else 
//                    str.append('('); 
//            }
//        }
//        
//        return str.toString(); 
//    }
    
    public static boolean isRightString(String s) {
        Stack<Character> stack = new Stack<>(); 
        stack.push(s.charAt(0)); 
        
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i); 
            if (c == ')') {
                if (!stack.empty()) {
                    stack.pop(); 
                }
                
                else {
                    stack.push(c); 
                    break; 
                }
            }
            else {
                stack.push(c); 
            }
        }
        
        if (stack.isEmpty())
            return true; 
        else
            return false; 
    }
    
    public static void main(String[] args) {
        String s1 = "(()())()"; 
        String s2 = ")("; 
        String s3 = "()))((()"; 
//        
        System.out.println(solution(s1)); 
        System.out.println(solution(s2)); 
        System.out.println(solution(s3)); 
    }
}
