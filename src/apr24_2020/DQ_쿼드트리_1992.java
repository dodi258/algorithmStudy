/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apr24_2020;

/**
 *
 * @author dodi258
 */
import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.Arrays; 

class DQ_쿼드트리_1992 {
    static int N; 
    static String[][] map; 
    static int[] dr = {0, 0, 1, 1}; 
    static int[] dc = {0, 1, 0, 1}; 
    static StringBuilder result; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        
        N = Integer.parseInt(in.readLine()); 
        map = new String[N][N];
        result = new StringBuilder(); 
        
        for(int i = 0; i < N; i++) {
            String row = in.readLine(); 
            map[i] = row.split(""); 
        }
        
        if(checkAll0or1(0,0,N,map[0][0])) {
            result.append(map[0][0]); 
        }
        
        dfs(1, 0, 0); 
        System.out.println(result.toString()); 
        
    }
    
    static void dfs (int level, int row, int col) {
        int size = N / (int) Math.pow(2, level);
        result.append("("); 
        
        // 4분면을 돌면서 배열이 모두 0 혹은 1로 구성되어있는지 확인.
        // 그리고 영상을 압축한다. 
        for(int i = 0 ; i < 4; i++) {
            int startRow = row + dr[i] * size; 
            int startCol = col + dc[i] * size; 
            String num = map[startRow][startCol]; 
            boolean isAll0or1 = checkAll0or1(startRow, startCol, size, num); 
            
            if(isAll0or1) {
                result.append(num); 
            }
            else {
                dfs(level + 1, startRow, startCol); 
               
            }
        }
        
        result.append(")"); 
        
    }
    static boolean checkAll0or1(int startRow, int startCol, int size, String num) {
        
        for(int i = startRow; i < startRow + size; i++) {
            for(int j = startCol; j < startCol + size; j++) {
                
                if(! map[i][j].equals(num)) {
                    return false; 
                }
            }
        }
        
        return true; 
    }
}
