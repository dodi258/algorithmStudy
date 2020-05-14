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

import java.io.*; 
import java.util.*; 
class CCTV {
    int x, y; 
    int type; 
    CCTV(int x, int y, int type) {
        this.x = x; 
        this.y = y;
        this.type = type; 
    }
}

public class SW역량테스트준비_감시_15683 {
    static int n, m, cnt, cctv_cnt; 
    static int[][] map; 
    static ArrayList<int[][]> watched; 
    static ArrayList<CCTV> cctv = new ArrayList<>(); 
    static ArrayList<String[]> cctvDir = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1}; 

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        // n: 행
        n = Integer.parseInt(st.nextToken());
        // m: 열
        m = Integer.parseInt(st.nextToken()); 
        // cnt: 사각지대 개수
        cnt = n * m;  
        map = new int[n][m];
        watched = new ArrayList<>(); 
        for(int i = 0; i < 8; i++) {
            watched.add(new int[n][m]); 
        }
        
        // cctv 위치 
        
        // 방향 초기화 
        cctvDir.add(new String[1]); 
        // cctv1
        String[] cctv_dir = new String[4];
        cctvDir.add(cctv_dir); 
        // cctv2
        cctv_dir = new String[2]; 
        cctvDir.add(cctv_dir); 
        // cctv3
        cctv_dir = new String[4]; 
        cctvDir.add(cctv_dir);
        // cctv4
        cctv_dir = new String[4]; 
        cctvDir.add(cctv_dir);
        // cctv5
        cctv_dir = new String[1]; 
        cctvDir.add(cctv_dir);
        
        
        
        //0: 오른쪽, 1: 상, 2: 왼쪽, 3: 하
        // cctv1
       String s = new String("0"); 
       cctvDir.get(1)[0] = s; 
       s = new String("1");
       cctvDir.get(1)[1] = s; 
       s = new String("2");
       cctvDir.get(1)[2] = s; 
       s = new String("3");
       cctvDir.get(1)[3] = s; 
       
       // cctv2
       s = new String("02"); 
       cctvDir.get(2)[0] = s; 
       s = new String("13"); 
       cctvDir.get(2)[1] = s; 
       
       // cctv3
       s = new String("01"); 
       cctvDir.get(3)[0] = s; 
       s = new String("12"); 
       cctvDir.get(3)[1] = s; 
       s = new String("23"); 
       cctvDir.get(3)[2] = s;
       s = new String("30"); 
       cctvDir.get(3)[3] = s;
       
       // cctv4
       s = new String("013"); 
       cctvDir.get(4)[0] = s; 
       s = new String("012"); 
       cctvDir.get(4)[1] = s;
       s = new String("123"); 
       cctvDir.get(4)[2] = s; 
       s = new String("230"); 
       cctvDir.get(4)[3] = s; 
       
       // cctv5
       s = new String("0123"); 
       cctvDir.get(5)[0] = s; 
       
       
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if(map[i][j] != 0) {
                    if(1 <= map[i][j] && map[i][j] <= 5) 
                        cctv.add(new CCTV(j , i, map[i][j]));
                    cnt --; 
                }
            }
        }
        
        
        cctv_cnt = cctv.size(); 
        
        setDir(cnt, 0); 
        System.out.println(cnt); 
        
    }
    
    public static void setDir(int sum, int level) {
        if(level == cctv_cnt) {
            cnt = Math.min(sum, cnt);
            return; 
        } 
        
        CCTV now = cctv.get(level); 
        int dirCnt = cctvDir.get(now.type).length; 
        
        while(dirCnt --> 0) {
            int watchedCnt = watch(now, dirCnt, level); 
            sum -= watchedCnt; 
            setDir(sum, level + 1); 
            
            sum += watchedCnt; 
            dontWatch(now, dirCnt, level); 
            
        }
        
    }
    
    public static int watch(CCTV now, int idx, int level) {
        String dirSeq = cctvDir.get(now.type)[idx]; 
        int x = now.x; 
        int y = now.y;
        int sum = 0; 
        for(int i = 0; i < dirSeq.length(); i++) {
            int dir = dirSeq.charAt(i) - '0'; 
            int nx = x + dx[dir]; 
            int ny = y + dy[dir]; 
            while(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if(map[ny][nx] == 6) break;
                if(map[ny][nx] == 0) {
                    map[ny][nx] = 7;
                    watched.get(level)[ny][nx] = 7; 
                    sum ++; 
                }
                
                nx += dx[dir]; 
                ny += dy[dir]; 
            }
        }

        return sum; 
    }
    public static void dontWatch(CCTV now, int idx, int level) {
        // watched 를 통해 원상복귀 합니다. 
        String dirSeq = cctvDir.get(now.type)[idx]; 
        int x = now.x; 
        int y = now.y;
        
        for(int i = 0; i < dirSeq.length(); i++) {
            int dir = dirSeq.charAt(i) - '0'; 
            int nx = x + dx[dir]; 
            int ny = y + dy[dir]; 
            while(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if(watched.get(level)[ny][nx] == 7) 
                    map[ny][nx] = 0; 
                
                nx += dx[dir]; 
                ny += dy[dir]; 
            }
        }
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(watched.get(level)[i], 0); 
        }
        
        
    }
    
}
