///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package may19_2020;
//
///**
// *
// * @author 주세인1
// */
//
//import java.util.Stack; 
//
//public class Programmers_괄호변환 {
//    public static String solution(String s) {
//        
//        String answer = ""; 
//        
//        
//        //문자열이 ""거나 올바른 문자열 이면 
//        if (s.length() == 0 || isRightString(s)) 
//            return s; 
//        
//        //u와 v 가르기 
//        StringBuilder u = new StringBuilder(); 
//        StringBuilder v = new StringBuilder(s); 
//
//        int left = 0; 
//        int right = 0; 
//        while(true) {
//            
//            if (v.charAt(0) == ')') {
//                left +=1 ; 
//            }
//            else {
//                right +=1; 
//            }
//            
//            u.append(v.charAt(0));
//            v.deleteCharAt(0); 
//            
//            if (left == right) 
//                break; 
//            
//        }
//                
//        StringBuilder str = new StringBuilder(); 
//        if (isRightString(u.toString())) {
//            str.append(u + solution(v.toString())).toString(); 
//        }
//        
//        else {
//            str.append("("); 
//            str.append(solution(v.toString())); 
//            str.append(")"); 
//            
//            for(int i = 1; i < u.length() -1; i++) {  
//                if (u.charAt(i) == '('){
//                    str.append(")");
//                }
//                else 
//                    str.append("("); 
//            }
//        }
//        
//        return str.toString(); 
//    }
//
//    public static boolean isRightString(String s) {
//        Stack<Character> stack = new Stack<>(); 
//        stack.push(s.charAt(0)); 
//        
//        for(int i = 1; i < s.length(); i++){
//            char c = s.charAt(i); 
//            if (c == ')') {
//                if (!stack.empty()) {
//                    stack.pop(); 
//                }
//                
//                else {
//                    stack.push(c); 
//                    break; 
//                }
//            }
//            else {
//                stack.push(c); 
//            }
//        }
//        
//        if (stack.isEmpty())
//            return true; 
//        else
//            return false; 
//    }
//    
//    public static boolean isRightString2(String s) {
//        int len = s.length(); 
//        int left = 0; 
//        for(int i = 0; i < len; i++) {
//            if (s.charAt(i) == '(') {
//                left ++; 
//            }
//            else {
//                if (left == 0) return false; 
//                left --;
//            }
//        }
//        return true; 
//    }
//    public static void main(String[] args) {
//        String s1 = "(()())()"; 
//        String s2 = ")("; 
//        String s3 = "()))((()"; 
////        
//        System.out.println(solution(s1)); 
//        System.out.println(solution(s2)); 
//        System.out.println(solution(s3)); 
//    }
//}
