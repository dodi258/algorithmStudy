/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may08_2020;

/**
 */

import java.util.List; 
import java.util.ArrayList; 
import java.util.StringTokenizer; 
import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class SW역량테스트준비__주사위굴리기_3190 {
    static int N, M, K; 
    static List<Integer> west2east;
    static List<Integer> north2south; 
    static int[][] map;
    static int[] dir; 
    static StringBuilder answer; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][M]; 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        dir = new int[K]; 
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < K; i++) {
            dir[i] = Integer.parseInt(st.nextToken()); 
        }
        answer = new StringBuilder(); 
        
        west2east = new ArrayList<Integer>();
        north2south = new ArrayList<Integer>(); 
        
        west2east.add(0);
        west2east.add(0);
        west2east.add(0);
        west2east.add(0);
        
        north2south.add(0); 
        north2south.add(0);
        north2south.add(0);
        north2south.add(0);
        
        solve(startR, startC); 
        System.out.println(answer.toString());
        
    }
    
    public static void solve(int r, int c) {
        
        for(int i = 0; i < K; i++) {
            int nr = r; 
            int nc = c; 
            // 동
            if (dir[i] == 1) {
                
            }
            // 서
            else if (dir[i] == 2) {
                 nc = c - 1; 
                if(! boundaryCheck(nr, nc)) continue;
                
                if(map[nr][nc] == 0) {
                    map[nr][nc] = west2east.get(0); 
                    
                }
                
                else {
                    west2east.set(0, map[nr][nc]); 
                    map[nr][nc] = 0; 
                }
                west2east.add(west2east.get(0)); 
                west2east.remove(0); 
                north2south.set(3, west2east.get(3));
                north2south.set(1, west2east.get(1));
            }
            // 북
            else if (dir[i] == 3) {
                nr = r - 1; 
                if(! boundaryCheck(nr, nc)) continue;
                
                if(map[nr][nc] == 0) {
                    map[nr][nc] = north2south.get(0); 
                   
                }
                
                else {
                    north2south.set(0, map[nr][nc]); 
                    map[nr][nc] = 0; 
                }
                north2south.add(north2south.get(0)); 
                north2south.remove(0); 
                west2east.set(3, north2south.get(3));
                west2east.set(1, north2south.get(1));
            }
            // 남 dir[i] == 4
            else {
                nr = r + 1; 
                if(! boundaryCheck(nr, nc)) continue;
                
                if(map[nr][nc] == 0) {
                    map[nr][nc] = north2south.get(2); 
                     
                }
                
                else {
                    north2south.set(2, map[nr][nc]); 
                    map[nr][nc] = 0; 
                }
                north2south.add(0, north2south.get(3)); 
                north2south.remove(4); 
                west2east.set(3, north2south.get(3));
                west2east.set(1, north2south.get(1));
            }
            
            answer.append(west2east.get(1) + "\n"); 
            r = nr; 
            c = nc; 
        }
    }
    
    public static boolean boundaryCheck(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < M) {
            return true; 
        }
        return false; 
    }
}
