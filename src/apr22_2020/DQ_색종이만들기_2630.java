/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apr22_2020;

/**
 *
 * @author dodi258
 */
import java.util.StringTokenizer; 
import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.IOException; 

public class DQ_색종이만들기_2630 {
    static int N; 
    static int[][] map; 
    static int[] paperCnt; 
    public static void main(String[] args) throws IOException {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
         StringTokenizer st = new StringTokenizer(in.readLine()); 
         
         N = Integer.parseInt(st.nextToken()); 
         map = new int[N][N];
         paperCnt = new int[2];
         
         for(int i = 0; i < N; i++) {
             st = new StringTokenizer(in.readLine()); 
             for(int j = 0; j < N; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken()); 
             }
         }
         
         // 한번도 안자른 색종이를 검사합니다. 
         int color = map[0][0]; 
         if(isColoredPaper(0,0, N, color)) {
             paperCnt[color] += 1; 
         }
         
         // level = 0, startRow = 0, startCol = 0
         dfs(1, 0, 0); 
         
         System.out.println(paperCnt[0] + "\n" + paperCnt[1]); 
    }
    
    public static void dfs(int level, int startRow, int startCol) {
        int size = N / (int) Math.pow(2, level);

        // 4 분면을 돕니다. 
        int color = 0; // 0: white, 1: blue
        boolean isPaper = false; 
        
        // 1 분면
        color = map[startRow][startCol]; 
        isPaper = isColoredPaper(startRow, startCol, size, color); 
        if(isPaper) {
            paperCnt[color] += 1; 
        }
        else {
            dfs(level + 1, startRow, startCol);
        }

        // 2 분면
        color = map[startRow][startCol + size]; 
        isPaper = isColoredPaper(startRow, startCol + size, size, color); 
        if(isPaper) {
            paperCnt[color] += 1; 
        }
        else {
            dfs(level + 1, startRow, startCol + size); 
        }

        // 3 분면
        color = map[startRow + size][startCol]; 
        isPaper = isColoredPaper(startRow + size, startCol, size, color); 
        if(isPaper) {
            paperCnt[color] += 1; 
        }
        else {
            dfs(level + 1, startRow + size, startCol); 
        }


        // 4 분면
        color = map[startRow + size][startCol + size]; 
        isPaper = isColoredPaper(startRow + size, startCol + size, size, color); 
        if(isPaper) {
            paperCnt[color] += 1; 
        }
        else {
            dfs(level + 1, startRow + size, startCol + size); 
        }
    }
    
    public static boolean isColoredPaper(int startRow, int startCol, int size, int color) {
        
        for(int i = startRow; i < startRow + size; i++) {
            for(int j = startCol; j < startCol + size; j++) {
                if(map[i][j] != color) {
                    return false; 
                }
            }
        }
        
        return true; 
    }
}
