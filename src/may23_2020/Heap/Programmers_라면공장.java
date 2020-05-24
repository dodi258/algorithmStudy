package may23_2020.Heap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 주세인1
 */
import java.util.*; 

class Programmers_라면공장 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0; 
        
        
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder()); 
        //i -> 일 수 
 
        int start = 0; 
        //k 는 곧 버텨야할 days
        //k 전날 까지 버텨야 함. 
        for(int i = 1; i < k; i++) {
            stock --; // 재고를 쓴다. 
            
            //가지고 있는 stock이 그날 떨어진다면, i+1 날 까지 공급을 받아야한다. 
            if(stock == 0) {
                int j = start; 
                while(j < dates.length && dates[j] <= i) {
                    pqueue.offer(supplies[j]); 
                    j ++; 
                }
                
                start = j; 
                answer ++; 
                stock += pqueue.poll(); 
       
            }
            
            }
        return answer;
    }
}
