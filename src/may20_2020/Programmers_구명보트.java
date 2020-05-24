package may20_2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 주세인1
 */
import java.util.Arrays; 
public class Programmers_구명보트 {
    public static void main(String[] args) {
        int[] people1 = {70, 50, 80, 50};
        int limit1 = 100; 
        int[] people2 = {70, 80, 50};
        int limit2 = 100; 
        
        System.out.println(solution(people1, limit1)); 
        System.out.println(solution(people2, limit2)); 
    }
    
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int min = 0; 
        int max = people.length - 1; 
        
        while(min < max) {
            if (people[min] + people[max--] <= limit) {
                min ++; 
            }
        }
        
        return people.length - min; 
    }
}
