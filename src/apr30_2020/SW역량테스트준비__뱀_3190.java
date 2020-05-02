/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apr30_2020;

/**
 *
 * @author 주세인1
 */

// 시뮬레이션

import java.io.*; 
import java.util.*; 

public class SW역량테스트준비__뱀_3190 {
    static class Point {
        int r; 
        int c; 
        Point(int r, int c) {
            this.r  = r; 
            this.c = c; 
        }
    }
    
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
    static int N; 
    static int[][] map; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        
        
        N = Integer.parseInt(in.readLine());
        map = new int[N + 1][N + 1];
        
        int appleCnt = Integer.parseInt(in.readLine()); 
        while(appleCnt --> 0) {
            st = new StringTokenizer(in.readLine()); 
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        
        int dirCnt = Integer.parseInt(in.readLine()); 
        int[] dirInfo = new int[10001]; 
        while(dirCnt --> 0) {
            st = new StringTokenizer(in.readLine()); 
            int idx = Integer.parseInt(st.nextToken()); 
            String d = st.nextToken(); 
            
            if(d.equals("D")) {
                dirInfo[idx] = 1; 
            }
            else {
                dirInfo[idx] = -1; 
            }
        }
        
        System.out.println(playGame(dirInfo, 1, 1)); 
    }
    
    static int playGame(int[] dirInfo, int r, int c) {
        int time = 0; 
        int dirNum = 0; 
        
        
        Queue<Point> snake = new LinkedList<Point>(); 
        
        
        while(true) {
            map[r][c] = 2; 
            snake.add(new Point(r, c)); 

            int d = dirInfo[time]; 
            
            if (d != 0) {
                dirNum = ((dirNum + d) + 4 ) % 4; 
            }
            
            int nextR = r + dir[dirNum][0]; 
            int nextC = c + dir[dirNum][1]; 
            
            // 뱀의 몸이 map을 나갈 때 
            if(! boundaryCheck(nextR, nextC)) {
//                System.out.println("밖을 나감"); 
                break;
            }
                
            
            // 뱀의 본인 몸과 만났을 때 
            else if(map[nextR][nextC] == 2) {
//                System.out.println("몸을 만남 "); 
                break; 
            }
            
            else {
                int status = map[nextR][nextC]; 
               
                // 사과를 안만남
                if(status == 0) {
                    Point tail = snake.poll();
                    map[tail.r][tail.c] = 0; 
                 }
                
                r = nextR; 
                c = nextC; 
            }
            
            // 다음 방향 바꾸기 
            
            time ++; 
        }
        
        // 위에서 밖으로 나가버리거나, 본인의 몸통을 만났을 경우에서 
        // 시간이 더해지지 않았기 때문에 
        return time + 1; 
    }
    
    
    static boolean boundaryCheck(int r, int c) {
        if(r >= 1 && r <= N && c >= 1 && c <= N) 
            return true; 
        
        return false; 
    }
    
}