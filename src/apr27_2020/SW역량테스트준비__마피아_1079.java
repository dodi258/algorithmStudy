/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apr27_2020;

/**
 *
 * @author 주세인1
 */

import java.io.*; 
import java.util.*; 


public class SW역량테스트준비__마피아_1079 {
    static int N; // N: 참가자 수  
    static int[] guiltGrade; // guilt_grade: 유죄 지수
    static int[][] R; 
    static int mafia;
    static Deque<Integer> deque; // 죽일 순서를 정렬하는 것. 
    static int maxPlayCnt = 0; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        
        N = Integer.parseInt(in.readLine()); 
        guiltGrade = new int[N]; 
        R = new int[N][N]; 
        deque = new LinkedList<>(); 
        
        // guiltGrade 입력 
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < N; i++) {
            guiltGrade[i] = Integer.parseInt(st.nextToken()); 
        }
        
        // R 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        mafia = Integer.parseInt(in.readLine()); 
        setOrder(0); 
        System.out.println(maxPlayCnt); 
    }
    
    static int playGame() {
        int citizenCnt = N - 1; 
        int mafiaCnt = 1; 
        Queue<Integer> queue = new LinkedList<>(deque); 
        int[] guiltGrade_copy = Arrays.copyOf(guiltGrade, N);
        
        int playCnt = 0; 
        while(citizenCnt > 0 && mafiaCnt > 0) {
            // 밤: 마피아가 사람 한명을 죽이고, 유죄 지수가 갱신된다. 
            if( (citizenCnt + mafiaCnt) % 2 == 0) {
                 int idx = queue.poll(); 
                 guiltGrade_copy[idx] = -500;
                 Iterator<Integer> iter = queue.iterator(); 
                 
                 while(iter.hasNext()) {
                     int i = iter.next(); 
                     guiltGrade_copy[i] += R[idx][i]; 
                 }
                 
                 // 마피아의 유죄지수 갱신 
                 guiltGrade_copy[mafia] += R[idx][mafia]; 
                 
                 citizenCnt --; 
                 playCnt ++; 
            }
        
            // 낮: 홀수 명 남았을 때는 낮이다. 
            else{
                // 유죄지수가 가장 높은 사람을 뽑아서 죽인다. 
                int maxGuiltGrade = -500; 
                for(int i = 0; i < N; i++) {
                    if(maxGuiltGrade < guiltGrade_copy[i]) {
                        maxGuiltGrade = guiltGrade_copy[i]; 
                    }
                }
                
                for(int i = 0; i < N; i++) {
                    if(guiltGrade_copy[i] == maxGuiltGrade) {
                        if(i == mafia) {
                            mafiaCnt --; 
                            break; 
                        }
                        
                        else {
                            guiltGrade_copy[i] = -500; 
                            citizenCnt --; 
                            queue.remove(new Integer(i));
                            break; 
                        }
                    }
                }
            }
        }
        
        return playCnt; 
    }
    
    //순열로 죽일 시민의 순서를 구한다. 
    static void setOrder(int level) {
        if(level == N - 1) {
            // 시민의 순서가 다 정해지면 playGame()을 호출 
            maxPlayCnt = Math.max(maxPlayCnt, playGame());
            return; 
        }
        
        else {
            for(int i = 0; i < N; i++) {
                if(i == mafia)
                    continue; 
                else if (! deque.contains(i)) {
                    deque.addLast(i);
                    setOrder(level + 1); 
                    deque.removeLast();
                }
            }
            
        }
        
        
    }
     
    
    
}
