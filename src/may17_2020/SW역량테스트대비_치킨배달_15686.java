package may17_2020; 

import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.ArrayList; 

class Point {
    // x: 열, y: 행 
    int x, y; 
    Point(int x, int y) {
        this.x = x; 
        this.y = y; 
    }
}
public class SW역량테스트대비_치킨배달_15686 {
    static int N; 
    static int M; 
    static ArrayList<Point> stores = new ArrayList<Point>(); 
    static ArrayList<Point> houses = new ArrayList<Point>(); 
    static ArrayList<Point> selected = new ArrayList<Point>(); 
    static int minDist = Integer.MAX_VALUE; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(in.readLine()); 
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        
        // 행 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine()); 
            // 열 
            for(int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken()); 
                if(value == 2) {
                    stores.add(new Point(j, i)); 
                }
                else if(value == 1) {
                    houses.add(new Point(j, i)); 
                }
            }
        }
        
        for(int i = 1; i <= M; i++) {
            // i == 가게 개수 
            selectStore(i, 1, 0); 
            selected = new ArrayList<Point>(); 
        }
        
        System.out.println(minDist); 
    }
    
    public static void selectStore(int targetCnt, int storeCnt, int storeIdx) {
        if(storeCnt > targetCnt) {
            int chickenDist = getChickenDist();
            minDist = Math.min(chickenDist, minDist); 
            return; 
        }
        
        for(int i = storeIdx; i < stores.size(); i++) {
            Point next = stores.get(i);
          
                selected.add(next); 
                selectStore(targetCnt, storeCnt + 1, i + 1); 
                selected.remove(next); 
        }
      
    }
    
    public static int getChickenDist() {
        int distSum = 0; 
        for(int i = 0; i < houses.size(); i++) {
            Point house  = houses.get(i); 
            
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < selected.size(); j++) {
                Point store = selected.get(j); 
                int dist = Math.abs(house.x - store.x) + Math.abs(house.y - store.y); 
                min = Math.min(dist, min); 
            }
            distSum += min; 
        }
        
        
        return distSum; 
        
    }
}
