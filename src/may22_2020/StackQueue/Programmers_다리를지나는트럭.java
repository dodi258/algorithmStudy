package may22_2020.StackQueue;

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
class Programmers_다리를지나는트럭 {
     public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
        Queue<Integer> trucks = new LinkedList<Integer>(); 
        Queue<Integer> bridge = new LinkedList<Integer>(); 
        int tot_weight = 0; 
        
        for(int i = 0; i < truck_weights.length; i++) {
            trucks.add(truck_weights[i]); 
        }
        
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0); 
        }
        
        do {
            //먼저 트럭을 적재한다. 
            tot_weight -=  bridge.poll(); 
            if (tot_weight + trucks.peek() <= weight) {
                tot_weight += trucks.peek(); 
                bridge.add(trucks.poll()); 
            }
            else {
                bridge.add(0); 
            }
            answer ++; 
        }while(!bridge.isEmpty() && !trucks.isEmpty()); 
        
        //trucks.isEmpty()일 경우 
        //남아있는 트럭을 건너게 한다. 
        while(!bridge.isEmpty()) {
            bridge.poll(); 
            answer++; 
        }
        
        //다리 길이만큼 0을 주면 된다. 
        
        return answer; 

    }
}
