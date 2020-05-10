/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may09_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*;

public class BackTracking_연산자끼워넣기_14888 {
    public static int n;
    public static int[] numbers;
    public static int[] operators;
    public static int max = Integer.MIN_VALUE; 
    public static int min = Integer.MAX_VALUE; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 
        StringTokenizer st;
        
        n = Integer.parseInt(in.readLine());
        numbers = new int[n];
        operators = new int[4]; 
        
        // 숫자 배열 초기화 
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken()); 
        }
        
        // 연산자 배열 초기화 
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken()); 
        }
        
        int result = numbers[0]; 
        placeOperator(1, result); 
        
        out.write(max + "\n"); 
        out.write(min + "\n"); 
        
        out.flush(); 
        out.close();
    }
    
    // level 1 부터 시작. 
    public static void placeOperator(int level, int result) {
        if(level == n) {
            max = Math.max(max, result); 
            min = Math.min(min, result); 
        }
        
        else {
            for(int i = 0; i < 4; i++) {
                if(operators[i] > 0) {
                    operators[i] --; 
                    
                    // 더하기 
                    //temp를 하지않고 result 를 해버리면 
                    //다음번에 적용할 때 계속 변한 result를 가지고 해야한다.
                    int temp = result; 
                    if(i == 0) 
                        temp = temp + numbers[level]; 
                    
                    
                    // 빼기
                    else if(i == 1) 
                        temp = temp - numbers[level]; 
                    
                    
                    //곱하기
                    else if(i == 2) 
                        temp = temp * numbers[level]; 
                    
                    
                    else if(i == 3)
                        temp = temp / numbers[level]; 
                    
                    placeOperator(level + 1, temp); 
                    
                    //원상복귀
                    operators[i] ++; 
                    
                }
            }
        }
    }
}
