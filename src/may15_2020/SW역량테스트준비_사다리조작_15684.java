/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may15_2020;

/**
 *
 * @author 주세인1
 */

import java.util.*; 
import java.io.*; 

public class SW역량테스트준비_사다리조작_15684 {
    static int N, M, H; 
    static int[][] bridge; 
    static boolean found; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        H = Integer.parseInt(st.nextToken()); 
        
        // 다리가 한개도 없다면, 
        if (M == 0) {
            System.out.println(0); 
            return; 
        }

        bridge = new int[H + 1][N + 1];  
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine()); 
            int h = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            
            // 가로선 배치 
            bridge[h][c] = 1; 
        }
        
        // 1개씩 다리 개수를 늘려가며 검사
        for(int i = 0 ;i  <= 3; i++) {
            setBridge(0, 0, i); 
            if (found) {
                System.out.println(i); 
                return; 
            } 
        }
        
        System.out.println(-1); 
    }
    
    public static void setBridge(int level, int start, int max) {
        
        if (max == level) {
            if (playGame()) {
                found = true; 
            }
            return; 
        }
        
        // n C max : 조합 
        for(int i = start; i < (N - 1) * H; i++) {
            int h = i / (N-1) + 1; 
            int c = i % (N-1) + 1; 
            
            if(bridge[h][c] == 1 || bridge[h][c - 1] == 1 || bridge[h][c + 1] == 1) continue; 
            bridge[h][c] = 1; 
            setBridge(level + 1, i + 1, max); 
            bridge[h][c] = 0; 
            
        }
    }
    
    public static boolean playGame() {
        
        // column
        for(int i = 1; i <= N; i++ ) {
            // row 한 칸씩 내려가기
            int c = i; 
            for(int j = 1; j <= H; j++) {
                if (bridge[j][c] == 1) {
                    c += 1; 
                }
                else if (bridge[j][c -1] == 1) {
                    c -= 1; 
                }
            }
            
            if (c != i)
                return false; 
        }
        return true; 
    }
}
