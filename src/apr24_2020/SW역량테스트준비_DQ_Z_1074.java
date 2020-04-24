/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apr24_2020;

/**
 *
 * @author 주세인1
 */
import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Arrays;
import java.util.StringTokenizer; 

public class SW역량테스트준비_DQ_Z_1074 {
    static int N; 
    static int targetRow; 
    static int targetCol; 
    static long cnt; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        targetRow = Integer.parseInt(st.nextToken()); 
        targetCol = Integer.parseInt(st.nextToken()); 
        int size = (int) Math.pow(2, N); 
        iterateMap(size, 0, 0); 
//        
//        for(int i = 0; i < size; i ++) {
//            System.out.println(Arrays.toString(sequence[i])); 
//        }
    }
    
    static void iterateMap(int size, int row, int col) {
        
        if(size == 2) {
//            sequence[row][col] = cnt;
            if(row == targetRow && col == targetCol) {
                System.out.println(cnt); 
                return; 
            }
            cnt ++; 
            
//            sequence[row][col + 1] = cnt; 
            if(row == targetRow && col + 1 == targetCol) {
                System.out.println(cnt); 
                return; 
            }
            cnt ++; 
            
//            sequence[row + 1][col] = cnt; 
            if(row + 1 == targetRow  && col == targetCol) {
                System.out.println(cnt);
                return; 
            }
            cnt ++; 
            
//            sequence[row + 1][col + 1] = cnt; 
            if(row  + 1 == targetRow  && col + 1 == targetCol) {
                System.out.println(cnt);
                return; 
            }
            cnt ++; 
            return; 
        }
        
        
        // 조각을 1/4로 쪼갭니다. 
        // 1사분면
        iterateMap(size / 2, row, col); 
        // 2사분면
        iterateMap(size / 2, row, col + size / 2); 
        // 3사분면
        iterateMap(size / 2, row + size / 2, col); 
        // 4사분면
        iterateMap(size / 2, row + size / 2, col + size / 2); 
        
    }
}
