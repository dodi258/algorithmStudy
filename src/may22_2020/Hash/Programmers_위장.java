package may22_2020.Hash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 주세인1
 */
import java.util.Map; 
import java.util.HashMap; 
import java.util.Iterator; 

public class Programmers_위장 {
    public int solution(String[][] clothes) {
        int answer = 1; 
        Map<String, Integer> map = new HashMap<>(); 
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1]; 
            map.put(key, map.getOrDefault(key, 0) + 1); 
        }
        
        Iterator<Integer> values = map.values().iterator(); 
        while(values.hasNext()) {
            answer *= values.next() + 1; 
        }
        
        return answer - 1; 
    }
}
