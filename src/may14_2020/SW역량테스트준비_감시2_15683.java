/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may14_2020;

/**
 *
 * @author 주세인1
 */
import java.util.*; 
import java.io.*; 

class cctv{
    int r, c; 
    int type; 
    
    cctv(int r, int c, int type) {
        this.r = r; 
        this.c = c; 
        this.type = type; 
    }
}
public class SW역량테스트준비_감시2_15683 {
    static int N, M; 
    static List<cctv> cctvs; 
    static int[][] map; 
    static int minArea = Integer.MAX_VALUE; 
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        cctvs = new ArrayList<>(); 
        List<cctv> allDircctv = new ArrayList<>(); 
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if(map[i][j] >= 1 && map[i][j] <= 4) {
                    cctvs.add(new cctv(i, j, map[i][j])); 
                }
                else if (map[i][j] == 5) {
                    allDircctv.add(new cctv(i, j, 5)); 
                }
            }
        }
        
        // type 5번 cctv 색칠
        for(int i = 0; i < allDircctv.size(); i++) {
            cctv c = allDircctv.get(i);
            moniterArea(100, c.r, c.c, dir, 0); 
        }
        
        moniter(0, 7); 
        System.out.println(minArea); 
    }
    
    public static void moniter(int idx, int cnt) {
        
        if (idx == cctvs.size()) {
            int area = getArea();
            minArea = Math.min(area, minArea);
            return; 
        }
        
        cctv now = cctvs.get(idx);  
        
        int type = now.type; 
        if(type == 1) {
            
            //동
            moniterArea(cnt,now.r, now.c, new int[][]{dir[0]}, 0);
            moniter(idx + 1, cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[0]}, cnt); 
            
            // 서
            moniterArea(cnt, now.r, now.c, new int[][]{dir[1]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[1]}, cnt); 
            
            //남
            moniterArea(cnt, now.r, now.c, new int[][]{dir[2]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[2]}, cnt); 
            
            //북
            moniterArea(cnt, now.r, now.c, new int[][]{dir[3]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[3]}, cnt); 
            
        }
        
        else if (type == 2) {
            moniterArea(cnt, now.r, now.c, new int[][] {dir[0], dir[1]}, 0);
            moniter(idx + 1,  cnt + 1); 
             
              // unmonitered
            moniterArea(0, now.r, now.c, new int[][] {dir[0], dir[1]}, cnt); 

            
            moniterArea(cnt, now.r, now.c, new int[][] {dir[2], dir[3]}, 0);
            moniter(idx + 1,  cnt + 1); 
             
              // unmonitered
            moniterArea(0, now.r, now.c, new int[][] {dir[2], dir[3]}, cnt); 
        }
        
        else if (type == 3) {
             //동
            moniterArea(cnt, now.r, now.c, new int[][]{dir[3], dir[0]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[3], dir[0]}, cnt); 
            
            // 서
            moniterArea(cnt, now.r, now.c, new int[][]{dir[0], dir[2]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[0], dir[2]}, cnt); 
            
            //남
            moniterArea(cnt, now.r, now.c, new int[][]{dir[2], dir[1]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[2], dir[1]}, cnt); 
            
            //북
            moniterArea(cnt, now.r, now.c, new int[][]{dir[1], dir[3]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[1], dir[3]}, cnt); 
        }
        else if (type == 4) {
            //동
            moniterArea(cnt,now.r, now.c, new int[][]{dir[1], dir[3], dir[0]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[1], dir[3], dir[0]}, cnt); 
            
            // 서
            moniterArea(cnt, now.r, now.c, new int[][]{dir[3], dir[0], dir[2]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[3], dir[0], dir[2]}, cnt); 
            
            //남
            moniterArea(cnt, now.r, now.c, new int[][]{dir[0], dir[2], dir[1]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[0], dir[2], dir[1]}, cnt); 
            
            //북
            moniterArea(cnt, now.r, now.c, new int[][]{dir[2], dir[1], dir[3]}, 0);
            moniter(idx + 1,  cnt + 1); 
            
            // unmonitered
            moniterArea(0, now.r, now.c, new int[][]{dir[2], dir[1], dir[3]}, cnt); 
        }
        
    }
    public static int getArea() {
        int area = 0; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    area ++; 
                }
            }
        }
        return area; 
    }
    
    public static void moniterArea(int num, int r, int c, int[][] d, int type) {
        for(int i = 0; i < d.length; i++) {
           int nr = r + d[i][0]; 
           int nc = c + d[i][1]; 
           
           while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
               if (map[nr][nc] == type) {
                   map[nr][nc] = num; 
               }
               // 벽을 만나면 
               else if (map[nr][nc] == 6) {
                   break; 
               }
               nr += d[i][0]; 
               nc += d[i][1]; 
           }
        }
    }
}
