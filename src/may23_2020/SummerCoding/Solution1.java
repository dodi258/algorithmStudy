///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package may23_2020.SummerCoding;
//
///**
// *
// * @author 주세인1
// */
//
//import java.util.Set; 
//import java.util.HashSet; 
////import java.util.Iterator; 
//
//
//public class Solution1 {
//    public static void main(String[] args) {
//        int p1 = 1987; 
//        int p2 = 2015; 
//        System.out.println(solution(p1)); 
//        System.out.println(solution(p2)); 
//    }
//    
//    public static int solution(int p) {
//        p++; 
//        while(! isBeautiful(p)) p++; 
//        
//        return p;
//    }
//    
//    public static boolean isBeautiful(int p) {
//        String str = String.valueOf(p); 
//        Set<Character> set = new HashSet<>(); 
//        
//        for(int i = 0; i < str.length(); i++) {
//            set.add(str.charAt(i));
//        }
////        Iterator<Character> iter = set.iterator(); 
////        while(iter.hasNext()) {
////            System.out.println(iter.next()); 
////        }
//        if (str.length() != set.size())
//            return false; 
//        return true; 
//    }
//}
