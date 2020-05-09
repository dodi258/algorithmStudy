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

import java.io.*; 
import java.util.*; 

public class SW역량테스트준비__로봇청소기_14503 {
    static int[][] map; 
    static int N, M; 
    static int answer = 0; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        st = new StringTokenizer(in.readLine()); 
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); //0: 북, 1: 동, 2: 서, 3: 남
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solve(d, r, c);
        System.out.println(answer); 
    }
    
    public static void solve(int d, int r, int c) {
        if(map[r][c] == 0) {
            map[r][c] = 2; // 청소함
            answer ++; 
        }
        
        //네 군데를 검사함. 
        boolean isAvailable = false; 
        for(int i = 0; i < 4; i++) {
            if(d == 0) {
                d = 3; 
                if(map[r][c - 1] == 0) {
                    solve(d, r, c - 1); 
                    return; 
                }
            }
            else if (d == 3) {
                d = 2; 
                if(map[r + 1][c] == 0) {
                    solve(d, r + 1, c); 
                    return;  
                }
            } 
            else if (d == 2) {
                d = 1; 
                if(map[r][c + 1] == 0) {
                    solve(d, r, c + 1); 
                    return;
                }
            }
            else {
                d = 0; 
                if(map[r - 1][c] == 0) {
                    solve(d, r - 1, c);
                    return;  
                }
            }
        }
            // 후진 가능한지 검사 
            if (d == 0) {
                if(map[r + 1][c] != 1) {
                    solve(d, r +1, c); 
                }
            }
            else if(d == 3) {
                if(map[r][c + 1] != 1) {
                    solve(d, r, c + 1); 
                }
            }
            else if(d == 2) {
                if(map[r - 1][c] != 1) {
                    solve(d, r - 1, c); 
                }
            }
            else {
                if(map[r][c - 1] != 1) {
                    solve(d, r, c - 1); 
                }
            }
        }
    }
    

