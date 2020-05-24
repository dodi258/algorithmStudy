/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may23_2020.Sort;

/**
 *
 * @author 주세인1
 */
import java.util.*; 

class Programmers_가장큰수 {
    public String solution(int[] numbers) {
        String answer = ""; 
        String[] num = new String[numbers.length]; 
        
        for(int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(numbers[i]); 
        }
        
        //새로운 정렬 기준을 만든 후에, 정렬해줌. 
        Arrays.sort(num, new 
                    MyComp());
        
        if(num[0].equals("0")) answer += "0"; 
        else {
            for (int i = 0; i < num.length; i++) {
                answer += num[i]; 
            }
        }
        
        return answer; 
    }
}

class MyComp implements Comparator<String> {
    public int compare(String o1, String o2) {
        return (o2 + o1).compareTo(o1 + o2); 
    }
}
