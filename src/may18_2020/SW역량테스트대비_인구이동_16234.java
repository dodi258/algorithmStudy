/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may18_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 

class Country{
    int r, c;
    Country(int r, int c) {
        this.r = r; 
        this.c = c; 
    }
}

public class SW역량테스트대비_인구이동_16234 {
    static int N, L, R;  
    static int[][] map; 
    static boolean[][] visited; 
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0}; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int changed = 0; 
        int moveCnt = 0; 
        
        while (true) {
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if (! visited[i][j]) {
                        changed += makeUnion(i, j); 
                    }
                }
            }
            
            if (changed == 0) break; 
            
            // 리셋
            for(int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }
            moveCnt ++; 
            changed = 0; 
        }
        
        System.out.println(moveCnt); 
            
    }
    
    public static int makeUnion(int startR, int startC) {
        
        Queue<Country> queue = new LinkedList<>(); 
        Queue<Country> union = new LinkedList<>(); 
        queue.add(new Country(startR, startC)); 
        visited[startR][startC] = true; 
        int sum = 0; 
        
        while(! queue.isEmpty()) {
//            Iterator<Country> iter = queue.iterator(); 
//            System.out.print("["); 
//            while(iter.hasNext()) {
//                Country cc = iter.next(); 
//               System.out.print(cc.r + "," + cc.c + "//"); 
//            }
//            System.out.println("]");
            
            Country c = queue.poll(); 
            union.add(c); 
            int nr; 
            int nc; 
            for(int i = 0; i < 4; i++) {
                nr = c.r + dr[i]; 
                nc = c.c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                int diff = Math.abs(map[nr][nc] - map[c.r][c.c]); 
                if (diff > R || diff < L) continue; 
                queue.add(new Country(nr, nc)); 
                visited[nr][nc] = true; 
                sum += map[nr][nc]; 
            }
        }
        
        if (sum == 0) return 0; 

        else {
//            sum += map[startR][startC]; 
//            
            int avr = (sum + map[startR][startC])/ union.size(); 
        
            while(! union.isEmpty()) {
                Country c = union.poll(); 
                map[c.r][c.c] = avr; 
            }   
            
//            movePeople(union, sum); 
            return 1; 
        }
        
    }
    
    public static void movePeople(Queue<Country> union, int sum) {
        int avr = sum / union.size(); 
        
        while(! union.isEmpty()) {
            Country c = union.poll(); 
            map[c.r][c.c] = avr; 
        }
    }

}
