/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may09_2020;

/**
 *
 * @author 주세인1
 */
import java.io.*; 
import java.util.*; 

public class Queue_프린터큐_1966 {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
       int N = Integer.parseInt(reader.readLine()); 
       for(int i = 0; i < N; i++) {
           StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); 
           int n = Integer.parseInt(tokenizer.nextToken());
           int idx = Integer.parseInt(tokenizer.nextToken()); 
           String[] printer = reader.readLine().split(" "); 
           Queue<String> queue = new LinkedList<String>(); 
           for(int j = 0; j < n; j++) {
               queue.add(printer[j]); 
           }
           Arrays.sort(printer, Collections.reverseOrder());
//           System.out.println(Arrays.toString(printer)); 
           int cnt = 0; 
           int j = 0; 
           while(true) {
//               System.out.println("printer " + printer[j]); 
               if(queue.peek().equals(printer[j])) {
                   idx --; 
                   cnt ++; 
                   j ++;
                   queue.poll(); 
//                   System.out.println(idx); 
//                   System.out.println("poll " + queue.poll()); 
               }
               else {
                   String temp = queue.poll(); 
                   queue.add(temp); 
                   if(idx == 0) {
                       idx += queue.size() - 1; 
//                       System.out.println(idx); 
                       
                   }
                   else {
                       idx --; 
//                       System.out.println(idx); 
                   }
               }
               if(idx == -1) break; 
                
           }
           
           System.out.println(cnt); 
           
       }
    }
}

