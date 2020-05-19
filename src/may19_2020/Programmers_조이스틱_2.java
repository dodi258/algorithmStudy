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

import java.util.Arrays;
import java.util.Queue; 
import java.util.LinkedList; 
import java.util.Map; 
import java.util.HashMap; 

public class Programmers_조이스틱_2 {
        
    static Map<Character, Integer> alphabet; 
    static boolean[] isChecked; 
    
    public static int solution(String name) {
        int answer = 0; 
        alphabet = new HashMap<>(); 
        alphabet.put('A', 0); alphabet.put('B', 1); alphabet.put('C', 2); alphabet.put('D', 3); alphabet.put('E', 4); alphabet.put('F', 5); alphabet.put('G', 6); 
        alphabet.put('H', 7); alphabet.put('I', 8); alphabet.put('J', 9); alphabet.put('K', 10); alphabet.put('L', 11); alphabet.put('M', 12); alphabet.put('N', 13); 
        alphabet.put('O', 12); alphabet.put('P', 11); alphabet.put('Q', 10); alphabet.put('R', 9); alphabet.put('S', 8); alphabet.put('T', 7); alphabet.put('U', 6); 
        alphabet.put('V', 5); alphabet.put('W', 4); alphabet.put('X', 3); alphabet.put('Y', 2); alphabet.put('Z', 1);
        
        StringBuilder name_sb = new StringBuilder(name); 
        StringBuilder str_sb = new StringBuilder(); 
        for(int i = 0; i < name.length(); i++) {
            str_sb.append("A"); 
        }
        
        int len = name.length(); 
        int idx = 0; 
        int right = 0; 
        int left = 0; 
        while(true) {
            right = 1; 
            left = 1; 
            
            if (name_sb.charAt(idx) != 'A') {
                answer += alphabet.get(name.charAt(idx)); 
                name_sb.replace(idx, idx + 1, "A"); 
            }
            if (str_sb.toString().equals(name_sb.toString())) {
                break; 
            }
            
            else {
                for(int i = 1; i < name.length(); i++) {
                    if (name_sb.charAt((idx + i) % len) == 'A')
                        right += 1; 
                    else 
                        break; 
                    
                    if (name_sb.charAt((idx - i + len) % len) == 'A') {
                        left += 1; 
                    }
                    else 
                        break; 
                }
                
                if (right >= left) {
                    answer += left; 
                    idx -= left;
                    idx += len; 
                    idx %= len; 
                }
                else {
                    answer += right; 
                    idx += right; 
                    idx %= len; 
                }
            }
        }
        return answer; 
    }
    
    public static void main(String[] args) {
        String name1 = "JEROEN"; 
        String name2 = "JAN"; 
        // 왼쪽 먼저? 오른쪽 먼저..? ^_^ .. 
        String name3 = "JANEAAAAAAAAAAAAAAAAAAAAAAAAAAARE"; 
        String name4 = "JEAAAAAAAAAAAAAAAAAAAAAAAWERWRWER"; 
        
        System.out.println("answer: " + solution(name1)); 
        System.out.println("answer: " + solution(name2));
        System.out.println("answer: " + solution(name3));
        System.out.println("answer: " + solution(name4));
    }
}
