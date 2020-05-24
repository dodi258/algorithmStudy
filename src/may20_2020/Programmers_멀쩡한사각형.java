/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may20_2020;

/**
 *
 * @author 주세인1
 */
public class Programmers_멀쩡한사각형 {
    public static void main(String[] args) {
        
    }
    public long solution(int w, int h) {
        long answer = 0;
        // h/ w = 기울기 
        // 가로 기준 . 
        for (int i = 0; i < w; i++) {
            answer += Long.valueOf(h) * i / Long.valueOf(w); 
        }
        
        return answer *2; 
    }
}
