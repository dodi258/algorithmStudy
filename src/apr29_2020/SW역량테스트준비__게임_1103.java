/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apr29_2020;

/**
 *
 * @author 주세인1
 */
/*
 * DP. 
*/

import java.util.*; 
import java.io.*; 

public class SW역량테스트준비__게임_1103 {
    static int N, M; // N: 세로, M: 가로
    static int[][] map; 
    static boolean[][] visited;
    static int[][] dp; 
                   // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        map = new int[N][M]; 
        visited = new boolean[N][M]; 
        dp = new int[N][M];
        
        for(int i = 0 ; i < N; i++) {
            String[] line = in.readLine().split(""); 
            for(int j = 0; j < M ; j++) {
                String input = line[j]; 
                
                if(input.equals("H")) {
                    map[i][j] = Integer.MAX_VALUE;
                }
                // H일 때 
                else 
                     map[i][j] = Integer.parseInt(input); 
                
                dp[i][j] = -1; 
            }
        }
        
        System.out.println(dfs(0,0)); 
    }
    
    static int dfs(int r, int c) {
        System.out.println("r: " + r + " , " +"c: " + c ); 
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i])); 
        }
        
        if (! boundaryCheck(r, c) || map[r][c] == Integer.MAX_VALUE)
            return 0; 
        
        // 무한 루프를 돌 때 
        if (visited[r][c]) {
            System.out.println(-1); 
            System.exit(0);
        }
        
        if (dp[r][c] != -1) {
            return dp[r][c]; 
        }
        
        visited[r][c] = true; 
        
        // 상하좌우로 움직임. 
        for(int i = 0; i < 4; i++) {
            dp[r][c] = Math.max(dp[r][c], dfs(r + map[r][c] * dr[i], c + map[r][c] * dc[i]) + 1); 
        }
        
        // dfs할때 4개 중 아무것도 안될때, 
        System.out.println("악"); 
        
        // 아직 안갔으니깐. 
        visited[r][c] = false; 
        
        System.out.println("r: " + r + " , " +"c: " + c ); 
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i])); 
        }
        return dp[r][c]; 
    }
    
    static boolean boundaryCheck(int r, int c) {
        if(r >= 0 && c >= 0 && r < N && c < M) {
            return true; 
        }
        else 
            return false; 
    }
    
}
