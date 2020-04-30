
package apr30_2020; 

import java.util.*; 
import java.io.*; 

class Point{
    int x; //열
    int y; //행
    
    Point(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}
public class SW역량테스트준비__뱀_3190 {
    static List<Point> snake; 
    static int[][] map; 
    static int[] dir; 
    static final double PI = Math.PI; 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        int N = Integer.parseInt(in.readLine()); 
        map = new int[N + 2][N + 2];
        int K = Integer.parseInt(in.readLine()); 
        while(K-- > 0) {
            st = new StringTokenizer(in.readLine()); 
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; 
            
        }
        dir = new int[10001]; 
        int L = Integer.parseInt(in.readLine()); 
        while(L-- > 0) {
            st = new StringTokenizer(in.readLine()); 
            int time = Integer.parseInt(st.nextToken()); 
            String d = st.nextToken(); 
            dir[time] = d.equals("D") ? 1: -1; 
        }
        
        //경계 세팅. 
        Arrays.fill(map[0], 2); 
        Arrays.fill(map[N+1], 2);
        for(int i= 1; i <= N; i++) {
            map[i][0] = 2; 
            map[i][N + 1] = 2; 
        }
        
        snake = new LinkedList<Point>();
        snake.add(new Point(1, 1)); // 첫 스타트 
        map[1][1] = 2; 
        int dir_cnt = 0; 
        int length = 0; 
        int time = 0;
        
        // 뱀 돌아다니기 
        while(true) {
            time ++; 
            dir_cnt += dir[time-1]; 
            int nextX = (int) Math.cos(PI/2 * dir_cnt); 
            int nextY = (int) Math.sin(PI/2 * dir_cnt); 
            Point next = new Point(snake.get(length).x + nextX , 
                                   snake.get(length).y + nextY);
            //move 
            int status = map[next.y][next.x]; 
            // 벽이면 || 본인 몸이면
            if(status == 2) break; 
            
            map[next.y][next.x] = 2; 
            snake.add(next);
            //사과를 안먹엇을때는 몸 상태 유지! 
            if(status == 0) {
                map[snake.get(0).y][snake.get(0).x]= 0; 
                snake.remove(0);
                
            }
            // 사과먹으면 몸 늘리기 
            else length ++; 
            
        }
        
        System.out.println(time); 
        
    }
    
    
}
