/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package may23_2020.SummerCoding;

/**
 *
 * @author 주세인1
 */
import java.util.List; 
import java.util.LinkedList; 
import java.util.Arrays; 




public class Solution4 {
    static class Node {
    List<Integer> upper; 
    int sp; 
    int num; 
    Node(int num, int sp) {
        this.num = num; 
        this.sp = sp; 
        this.upper = new LinkedList<>(); 
    }
    
    void setSp(int sp) {
        this.sp = sp; 
    }
    
    void addUpper(int num) {
        this.upper.add(num); 
    }
//    
//    boolean equals(int num) {
//        return this.num == num; 
//    }
    
    int getSp() {
        return this.sp; 
    }
}
    public static void main(String[] args) {
        int[][] skills = {{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
        int total_sp = 121; 
        System.out.println(Arrays.toString(solution(121, skills))); 
    }
    
    public static int[] solution(int total_sp, int[][] skills) {
        int[] answer = new int[skills.length + 1]; 
        List<Node> tree = new LinkedList<>(); 
        
        for(int i = 0; i <= skills.length; i++) {
            tree.add(new Node(i, 0)); 
        }
        
        for(int i = 0; i < skills.length; i++) {
            tree.get(skills[i][0]-1).upper.add(skills[i][1] - 1);
        }
        
        
        
        for(int i = 0; i <= skills.length; i++) {
            if (tree.get(i).upper.isEmpty()) {
                tree.get(i).setSp(11);
            }
        }
        
        for(int i = 0; i <= skills.length; i++) {
            System.out.println(tree.get(i).sp); 
            System.out.println(tree.get(i).upper.toString()); 
        }
        
        for(int i = 0; i <= skills.length; i++) {
            List<Integer> list = tree.get(i).upper; 
            int sum = 0; 
            for(int idx: list) {
                sum += tree.get(idx).getSp(); 
            }
            tree.get(i).setSp(sum);
        }
        
        for(int i = 0; i <= skills.length; i++) {
            answer[i] = tree.get(i).sp; 
        }
        
        return answer; 
    }
}
