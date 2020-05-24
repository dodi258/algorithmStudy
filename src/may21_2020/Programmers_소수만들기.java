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
//import java.util.Arrays; 
//import java.util.List; 
//import java.util.ArrayList; 
//public class Programmers_소수만들기 {
//    
//    public static void main(String[] args) {
////        int[] nums1 = {1, 2, 3, 4};
//        int[] nums2 = {1, 2, 7, 6, 4};
////        
////        System.out.println(solution(nums1)); 
//        System.out.println(solution(nums2));
//        
//    }
//    
//    public static int solution(int[] nums) {
//        boolean[] sieve = new boolean[3001];
//        // 소수인것을 걸러내기~ 
//        Arrays.fill(sieve, true);
//        sieve[0] = false; 
//        sieve[1] = false; 
//        
//        int answer = 0; 
//        
//        for(int i = 0; i < sieve.length; i++) {
//            if (! sieve[i]) continue; 
//            for(int j = i + i; j < sieve.length; j+= i) {
//                sieve[j] = false; 
//            }
//        }
//        int length = nums.length; 
//        for(int i = 0; i < length; i++) {
//            int sum = nums[i]; 
//            for(int j = i + 1; j < length; j++) {
//                sum += nums[j];
//                for(int k = j + 1; k < length; k++) {
//                    sum += nums[k]; 
//                    if (sieve[sum]) answer ++; 
//                    sum -= nums[k]; 
//                }
//                sum -= nums[j]; 
//            }
//        }
//        return answer; 
//    }
//    
//    
////    public static void setCombination(int level, int start, List<Integer> selected, int sum) {
////        if (level == 3) {
////            System.out.println(selected.toString()); 
////            if (sieve[sum]) {
////                answer ++;
////                sieve[sum] = false; 
////            } 
////        }
////        
////        for(int i = start; i < nums.length; i++) {
////            selected.add(nums[i]); 
////            setCombination(level + 1, i + 1, selected, sum + nums[i]); 
////            selected.remove(level); 
////        }
////    }
//}
