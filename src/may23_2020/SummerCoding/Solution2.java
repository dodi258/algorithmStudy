/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may23_2020.SummerCoding;

/**
 *
 * @author 주세인1
 */

import java.util.List; 
import java.util.ArrayList; 
public class Solution2 {
    public static void main(String[] args) {
        long n1 = 4; 
        long n2 = 11; 
        
        System.out.println(solution(n1)); 
        System.out.println(solution(n2));
    }
    
    public static long solution(long n) {
        int exp = 0; 
        List<Long> seq = new ArrayList<>(); 
        seq.add((long)0); 
        
        while(true) {
            long now = (long) Math.pow(3, exp); 
            long size = seq.size(); 
            for(int i = 0; i < size; i++) {
                seq.add(seq.get(i) + now); 
                
                if (seq.size() == n + 1) {
                    return seq.get(seq.size() - 1); 
                }
            }
            exp ++; 
            
        }

    }
}
