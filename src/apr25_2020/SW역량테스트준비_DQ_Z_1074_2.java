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

import java.util.StringTokenizer; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 

public class SW역량테스트준비_DQ_Z_1074_2 {
    static int N; 
    static int targetRow; 
    static int targetCol; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        
        N = Integer.parseInt(st.nextToken()); 
        targetRow = Integer.parseInt(st.nextToken());
        targetCol = Integer.parseInt(st.nextToken());
        
        int count = 0 ; 
        
        // 4분면 시작 점 
        int row = (int) Math.pow(2, N) / 2; 
        int col = (int) Math.pow(2, N) / 2; 
        
        while (N --> 0) {

            int move = (int) Math.pow(2, N) / 2; 
            int skip = (int) Math.pow(4, N); 

            // 1사분면 
            if (targetRow < row && targetCol < col) {
                row -= move; 
                col -= move; 
            }
            
            // 2사분면 
            else if (targetRow < row && targetCol >= col) {
                row -= move; 
                col += move; 
                count += skip; 
            }
            
            // 3 사분면 
            else if (targetRow >= row && targetCol < col) {
                row += move; 
                col -= move; 
                count += skip * 2; 
            }
            
            // 4 사분면 
            else {
                row += move; 
                col += move; 
                count += skip * 3; 
            }
        }
        
        System.out.println(count); 
    }
}
