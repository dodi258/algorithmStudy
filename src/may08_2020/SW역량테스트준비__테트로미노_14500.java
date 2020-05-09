/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may08_2020;

/**
 *
 * @author 주세인1
 */

import java.util.*; 
import java.io.*; 

public class SW역량테스트준비__테트로미노_14500 {
    static int N, M; 
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    static int answer; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; 
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                solve(0, 0, i, j); 
            }
        }
        solve2(); 
        System.out.println(answer); 
    }
    
    // 뻐큐모양 제외
    public static void solve(int length, int sum, int r, int c) {
        
        if(visited[r][c]) return ; 
        if (length >= 4) {
            answer = Math.max(answer, sum); 
            return; 
        }
        
        visited[r][c] = true; 
        sum += map[r][c]; 
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i]; 
            int nc = c + dc[i]; 
            if(boundaryCheck(nr, nc)) {
                solve(length + 1, sum, nr, nc); 
            }
        }
        
        visited[r][c] = false;
        sum -= map[r][c]; 
        
        
    }
    
    //뻐큐모양 만 
    public static void solve2() {
        int[] ddr = {-1, 1, -1}; 
        int[] ddc = {-1, -1, 1};
        //가로 
        for(int i = 0; i < N; i++) {
            int temp = map[i][0] + map[i][1];
            
            for(int j = 0; j < M - 2; j++) {
                temp += map[i][j + 2]; 
                if(i + ddr[0] > 0) {
                    answer = Math.max(answer, temp + map[i + ddr[0]][j + 2 + ddc[0]]); 
                }
                
                if(i + ddr[1] < N) {
                    answer = Math.max(answer, temp + map[i + ddr[1]][j + 2 + ddc[1]]); 
                }
                
                temp -= map[i][j]; 
            }
        }
        
        //세로 
        for (int j = 0; j < M; j++) {
            int temp = map[0][j] + map[1][j]; 
            for(int i = 0; i < N - 2; i++) {
                temp += map[i + 2][j]; 
                
                if(j + ddc[0] > 0) {
                    answer = Math.max(answer, temp + map[i + 2 + ddr[0]][j + ddc[0]]);
                }
                
                if(j + ddc[2] < M) {
                    answer = Math.max(answer, temp + map[i + 2 + ddr[2]][j + ddc[2]]); 
                }
                
                temp -= map[i][j]; 
            }
        }
    }
    
    public static boolean boundaryCheck(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < M) {
            return true; 
        }
        return false; 
    }
}
