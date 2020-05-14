package may14_2020; 

import java.io.*; 
import java.util.*; 

public class SW역량테스트준비__경사로_14890 {
    static int n, l, cnt; 
    static int[][] map; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        
        n = Integer.parseInt(st.nextToken()); 
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n]; 
        
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        for(int i = 0; i < n; i++) {
            // 가로 
            if(solve(map[i])) cnt ++; 
            int[] temp = new int[n]; 
            for(int j= 0; j < n; j++) {
                // 세로 
                temp[j] = map[j][i]; 
            }
            if(solve(temp)) cnt++; 
        }
        
        System.out.println(cnt); 
    }
    
    public static boolean solve(int[] map) {
        int idx = 0; 
        boolean[] visited = new boolean[n];
        
        while(true) {
            //끝까지 도달. 
            if(idx == n - 1) break; 
            
            //내려가는 경사로의 경우 
            if(map[idx + 1] == map[idx] -1) {
                // 경사로 길이만큼 뻗는 것이 가능한가요? 
                if(idx + l >= n) return false; // 안됨 
                
                for(int i = idx + 1; i <= idx + l; i++) {
                    visited[i] = true; 
                    if(map[i] != map[idx] - 1)
                        return false; 
                }
                idx += l; 
            }
            
            //올라가는 경사로 
            else if(map[idx + 1] == map[idx] + 1) {
                // 경사로 길이만큼 뻗는 것이 가능?
                if(idx - (l - 1) <  0 ) return false; 
                
                for(int i = idx - (l-1); i <= idx; i ++) {
                    // 이미 내려가는 경사로로 채택이 된 경우 visited[i]
                    if(visited[i] || map[i] != map[idx]) 
                        return false; 
                } 
                idx ++; 
            }
            
            // 평지인 경우 
            else if(map[idx] == map[idx + 1]) idx++; 
            
            // 높이 차이가 2 이상인 경우, 못지나감. 
            else return false; 
            
            
            
        }
        return true;
    }
}
