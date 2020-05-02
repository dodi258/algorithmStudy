
package may02_2020;

/**
 *
 * @author 주세인1
 */

/**
 *  입력
 *  5
 *  9 20 28 18 11
 *  30 1 21 17 28
 *  
 *  출력
 *  ["#####", "# # #", "### #", "#  ##", "#####"]
 */

import java.util.*; 
import java.io.*; 

public class 카카오2017_비밀지도_1 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        
        int n = Integer.parseInt(in.readLine()); 
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n]; 
        
        // arr1 입력 받기
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken()); 
        }
        
        // arr2 입력 받기 
        st = new StringTokenizer(in.readLine()); 
        for(int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken()); 
        }
        
        solve(n, arr1, arr2); 
        
        
    }
    
    static void solve(int n, int[] arr1, int[] arr2) {
        StringBuilder string; 
        String[] result = new String[n]; 
        
        for(int i = 0; i < n; i++) {
            int num = arr1[i] | arr2[i]; 
            int cnt = n; 
            string = new StringBuilder("\""); 
            
            // 이진수 만들기 
            while(cnt --> 0) {
                string.insert(1, num % 2 == 1 ? "#" : " "); 
                num = num >> 1; 
            }
            string.append("\""); 
            result[i] = string.toString();
        }
        
        System.out.println(Arrays.toString(result)); 
    }
}
