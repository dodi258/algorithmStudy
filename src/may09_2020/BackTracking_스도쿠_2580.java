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

class Point{
    int x; 
    int y; 
    Point(int inX, int inY) {
        this.x = inX; 
        this.y = inY; 
    }
}
public class BackTracking_스도쿠_2580 {
    public static List<Point> p = new LinkedList<Point>(); 
    public static int[][] sdoku; 
    public static boolean[][] row;
    public static boolean[][] col; 
    public static boolean[][] box; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        sdoku = new int[9][9];
 
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(in.readLine()); 
            for(int j = 0; j < 9; j++) { 
                sdoku[i][j] = Integer.parseInt(st.nextToken());  
                if(sdoku[i][j] == 0)
                    p.add(new Point(i, j)); 
            }
//            System.out.println(Arrays.toString(sdoku[i])); 
        }

        row = new boolean[9+1][9+1];
        col = new boolean[9+1][9+1];
        box = new boolean[9+1][9+1];
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int num = sdoku[i][j];
                row[i][num] = true;
                col[j][num] = true; 
                box[(i/3) *3 + j/3][num] = true;
            }
        }

        placeNumber(0); 
        
    }
    
    public static void placeNumber(int cnt) {
        if(p.size() == cnt) {
            for(int i = 0; i < 9; i++) {
                System.out.println(Arrays.toString(sdoku[i]).replace("[", "").replace("]", "").replace(","," ")); 
            }
            System.out.println(" "); 
            // 답을 찾는 순간 프로그램 종료 
            System.exit(0);
            return; 
        }
        
        
        int r = p.get(cnt).x; 
        int c = p.get(cnt).y; 
        
        // 숫자 체크 
        
            for(int num = 1; num < 10; num ++) {
                if(!row[r][num] && !col[c][num] && !box[(r/3) *3 + c/3][num]) {
                    row[r][num] = true;
                    col[c][num] = true; 
                    box[(r/3) *3 + c/3][num] = true;
                    sdoku[r][c] = num; 
                    
                    placeNumber(cnt + 1); 

                    row[r][num] = false; 
                    col[c][num] = false; 
                    box[(r/3) *3 + c/3][num] = false; 
                    sdoku[r][c] = 0; 
                }
            }
       

    }
}
