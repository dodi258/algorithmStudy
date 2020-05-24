package may20_2020;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 주세인1
 */
import java.util.Arrays;
import java.util.Set; 
import java.util.HashSet; 
 
public class Programmers_영어끝말잇기 {
    public static void main(String[] args) {
        int n1 = 3; 
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}; 
        int n2 = 5; 
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", 
                           "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int n3 = 2; 
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"}; 
        
        int[] answer = solution(n1, words1); 
        
        System.out.println(Arrays.toString(solution(n1, words1))); 
        System.out.println(Arrays.toString(solution(n2, words2)));
        System.out.println(Arrays.toString(solution(n3, words3)));
        
    }
    
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0}; 
        Set<String> wordSet = new HashSet<>(); 
        String pre = words[0];
        wordSet.add(words[0]); 
        
        for(int i = 1; i < words.length; i ++) {
            String now = words[i]; 
            if (pre.charAt(pre.length()-1) != now.charAt(0) || wordSet.contains(now)) {
                answer[0] = i % n + 1; 
                answer[1] = i / n + 1; 
                break; 
            }
            wordSet.add(now);
            pre = now; 
        }
        return answer; 
    }
    
    
}
