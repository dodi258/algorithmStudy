//package may21_2020;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author 주세인1
// */
////DP 로 풀겠음.. 
//public class Programmers_점프와순간이동 {
//    public static void main(String[] args) {
//        int n1 = 5; 
//        int n2 = 6; 
//        int n3 = 5000; 
//        
//        System.out.println(solution(n1));
//        System.out.println(solution(n2));
//        System.out.println(solution(n3));
//    }
//    
//    public static int solution(int n) {
//
//        int[] dp = new int[n + 1]; 
//        dp[0] = 0; 
//        dp[1] = 1; 
//        
//        for(int i = 2; i <= n; i++) {
//            
//                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + (i % 2)); 
//            
//        }
//
//        return dp[n]; 
//    }
//}
