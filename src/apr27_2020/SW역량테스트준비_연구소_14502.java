/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apr27_2020;

/**
 *
 * @author 주세인1
 * ! Combination 관련 문제 
 *   (n * m) C 3
 */
import java.util.List; 
import java.util.ArrayList; 
import java.util.StringTokenizer; 
import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.IOException; 

public class SW역량테스트준비_연구소_14502 {
    static class Point {
        int r, c; 
        Point(int r, int c) {
            this.r = r; 
            this.c = c; 
        }
    }
    
    static int n, m; 
    static int[][] map; 
    static int[][] map_copy; 
    static List<Point> virus = new ArrayList<Point>(); 
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int max = 0; // 최소가 0임
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        // n: 행
        n = Integer.parseInt(st.nextToken()); 
        // m: 열
        m = Integer.parseInt(st.nextToken()); 
        map = new int[n][m];
        map_copy = new int[n][m];
        
        // 행
       for(int i= 0; i < n; i++) {
           st = new StringTokenizer(br.readLine()); 
           // 열 
           for(int j = 0; j < m; j++) {
               map[i][j] = Integer.parseInt(st.nextToken()); 
               if(map[i][j] == 2) 
                   virus.add(new Point(j, i)); 
           }
       }
       setWall(0,0); 
       System.out.println(max);
    }
    
    static void setWall(int level, int start) {
       if(level == 3) {
           // 맵 복사 //backtracking 이라 맵을 복사해야함.  
           copyMap();
           
           // 바이러스 퍼트리기
           for(Point pos: virus) {
               spreadVirus(pos.r, pos.c); 
           }
           
           max = Math.max(max, getSafeArea()); 
           return; 
           
       }

           for(int i = start; i < n * m; i++) {
               int r = i/m; 
               int c = i%m;
               
               if(map[r][c] == 0) {
                   map[r][c] = 1; 
                   setWall(level + 1, i+ 1); 
                   map[r][c] = 0; 
               }
           }
       
   }
   static void copyMap() {
       for(int i = 0; i < n; i++) {
           for(int j = 0; j < m; j++) {
               map_copy[i][j] = map[i][j]; 
           }
       }
   }
   
   static void spreadVirus(int r, int c) {
       for(int i = 0; i < 4; i++) {
           int nr = r + dr[i]; 
           int nc = c + dc[i]; 
           
           if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
               if(map_copy[nr][nc] == 0) {
                   map_copy[nr][nc] = 2; 
                   spreadVirus(nr, nc); 
               }
           }
          
               
           
       }
   }
   static int getSafeArea() {
       int area = 0; 
       for(int i = 0; i < n; i++) {
           for(int j = 0; j < m; j++) {
               if(map_copy[i][j] == 0) 
                   area ++; 
           }
       }
       
       return area; 
   }
}

