/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may23_2020.DFS;

/**
 *
 * @author 주세인1
 */
class Programmers_타겟넘버 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = addNumbers(numbers, 0, 0, target); 
        return answer;
    }
    
    public int addNumbers(int[] numbers, int result, int index, int target) {
        if (index == numbers.length) {
            if (result == target) return 1; 
            else return 0; 
        }
        
        return addNumbers(numbers, result + numbers[index], index + 1, target) + addNumbers(numbers, result - numbers[index], index + 1, target); 
    }
}
