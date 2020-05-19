///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package may19_2020;
//
///**
// *
// * 1. 현재의 알파벳을 조작한다. 
// * 2. 현재에서 가장 가까운 조작해야하는 인덱스를 찾는다. 
// * -> 문제: 가장 가까운게 2개 이면? 
// * -> 1. 왼쪽부터 간다. 
// * -> 2. 오른쪽부터 간다. 
// * -> 3. 그때마다.. 다르다. . ㅜ 
// */
//
//import java.util.Arrays;
//import java.util.Queue; 
//import java.util.LinkedList; 
//import java.util.Map; 
//import java.util.HashMap; 
//
//public class Programmers_조이스틱 {
//    
//    static Map<Character, Integer> alphabet; 
//    static boolean[] isChecked; 
//    public static int solution(String name) {
//        // 알파벳에 따른 이동 순서 정리 
//        alphabet = new HashMap<>(); 
//        alphabet.put('A', 0); alphabet.put('B', 1); alphabet.put('C', 2); alphabet.put('D', 3); alphabet.put('E', 4); alphabet.put('F', 5); alphabet.put('G', 6); 
//        alphabet.put('H', 7); alphabet.put('I', 8); alphabet.put('J', 9); alphabet.put('K', 10); alphabet.put('L', 11); alphabet.put('M', 12); alphabet.put('N', 13); 
//        alphabet.put('O', 12); alphabet.put('P', 11); alphabet.put('Q', 10); alphabet.put('R', 9); alphabet.put('S', 8); alphabet.put('T', 7); alphabet.put('U', 6); 
//        alphabet.put('V', 5); alphabet.put('W', 4); alphabet.put('X', 3); alphabet.put('Y', 2); alphabet.put('Z', 1); 
//        isChecked = new boolean[name.length()]; 
//        
//        // A는 그냥 다 체크 했다고 처리 
//        for(int i = 0; i < name.length(); i ++) {
//            if (name.charAt(i) == 'A')
//                isChecked[i] = true; 
//        }
//        
//        
//        //왼쪽 먼저 
//        int answer1 = 0; 
//        int index = 0; 
//        int[] ret;
//        while(! isAllChecked()) {
//            ret = findClosestLeftIndex(index, name); 
//            index = ret[0]; 
//            System.out.println(index); 
//            isChecked[index] = true; 
//            answer1 += alphabet.get(name.charAt(index)) + ret[1]; 
//        }
//        
//        // 오른쪽 먼저
//        int answer2 = 0; 
//        index = 0; 
//        Arrays.fill(isChecked, false);
//        
//        while (! isAllChecked()) {
//            ret = findClosestRightIndex(index, name); 
//            index = ret[0]; 
//            System.out.println(index); 
//            isChecked[index] = true; 
//            answer2 += alphabet.get(name.charAt(index)) + ret[1]; 
//        }
//        return answer1 <= answer2 ? answer1 : answer2; 
//    }
//    
//    public static int[] findClosestLeftIndex(int now, String s) {
//        int len = s.length(); 
//        Queue<Integer> queue = new LinkedList<>(); 
//        queue.add(now); 
//        int cnt = 0; 
//        while(queue.isEmpty()) {
//            now = queue.poll(); 
//            System.out.println(now); 
//            if (! isChecked[now]) {
//                break; 
//            }
//            // 왼쪽
//            queue.add((now - 1 + len) % len); 
//            // 오른쪽
//            queue.add((now + 1) % len); 
//            cnt ++; 
//        }
//        
//        return new int[]{now, cnt}; 
//    }
//    
//    
//    public static int[] findClosestRightIndex(int startIdx, String s) {
//        int len = s.length(); 
//        Queue<Integer> queue = new LinkedList<>(); 
//        queue.add(startIdx); 
//        int now = startIdx;
//        int cnt = 0; 
//        while(queue.isEmpty()) {
//            now = queue.poll(); 
//            if (! isChecked[now]) {
//                break; 
//            }
//            // 오른쪽
//            queue.add((now + 1) % len); 
//            // 왼쪽
//            queue.add((now - 1 + len) % len); 
//            
//            cnt ++;
//        }
//        
//        return new int[]{now, cnt}; 
//    }
//    public static boolean isAllChecked() {
//        for(int i = 0; i < isChecked.length; i++) {
//            if (! isChecked[i]) 
//                return false; 
//        }
//        
//        return true; 
//    }
//    
//
//    
//    public static void main(String[] args) {
//        String name1 = "JEROEN"; 
//        String name2 = "JAN"; 
//        // 왼쪽 먼저? 오른쪽 먼저..? ^_^ .. 
//        String name3 = "JANEAAAAAAAAAAAAAAAAAAAAAAAAAAARE"; 
//        String name4 = "JEAAAAAAAAAAAAAAAAAAAAAAAWERWRWER"; 
//        
//        System.out.println("answer: " + solution(name1)); 
//        System.out.println("answer: " + solution(name2));
//        System.out.println("answer: " + solution(name3));
//        System.out.println("answer: " + solution(name4));
//    }
//}
