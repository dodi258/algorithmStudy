/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apr25_2020;

/**
 *
 * @author 주세인1
 */
import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 

public class DQ_종이의개수_1780 {
    static int N; 
    static int map[][]; 
    static int paperCnt[];
    static int[] dr = {0, 0, 0, 1, 1, 1, 2, 2, 2}; 
    static int[] dc = {0, 1, 2, 0, 1, 2, 0, 1, 2}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        
        N = Integer.parseInt(in.readLine()); 
        map = new int[N][N];
        paperCnt = new int[3]; 
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + 1; 
            }
        }
        
        splitPaper(N, 0, 0); 
        
        System.out.println(paperCnt[0] + "\n" + paperCnt[1] + "\n" + paperCnt[2]); 
        
    }
    
    static void splitPaper(int size, int row, int col) {
        int num = map[row][col];
        
        if(checkPaper(row, col, size, num)) {
            paperCnt[num]++; 
            return; 
        }
        
        else {
            //9 개의 부분으로 분리합니다. 
            size /= 3; 
            for(int i = 0; i < 9; i++) {
               int startRow = row + dr[i] * size; 
               int startCol = col + dc[i] * size; 
               
               splitPaper(size, startRow, startCol); 
            }
        }
    }
    
    static boolean checkPaper(int startRow, int startCol, int size, int num) {
        for(int i = startRow; i < startRow + size; i++) {
            for(int j = startCol; j < startCol + size; j++) {
                if(map[i][j] != num) 
                    return false; 
            }
        }
        
        return true; 
    }
}
