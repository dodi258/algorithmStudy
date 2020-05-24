//package may22_2020.Hash;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author 주세인1
// */
//
//import java.util.PriorityQueue; 
//import java.util.HashMap; 
//import java.util.Map; 
//import java.util.Arrays; 
//import java.util.Iterator; 
//import java.util.List; 
//import java.util.ArrayList; 
//
//class Music implements Comparable<Music>{
//    int index;
//    int play; 
//     
//    Music(int index, int play) {
//        this.index = index; 
//        this.play = play; 
//    }
//    
//    @Override
//    public int compareTo(Music target) {
//        if (this.play < target.play) {
//            return 1; 
//        }
//        else if (this.play == target.play) {
//            return this.index < target.index ? -1: 1; 
//        }
//        else {
//            return -1; 
//        }
//    }
//    
//}
//
//class Genre implements Comparable<Genre> {
//    String name; 
//    int totalPlay; 
//    Genre(String name, int totalPlay) {
//        this.name = name; 
//        this.totalPlay = totalPlay; 
//    }
//    
//    @Override
//    public int compareTo(Genre target) {
//        return this.totalPlay < target.totalPlay ? 1: -1; 
//        
//    
//    }
//    
//    public boolean equals(String name) {
//        return this.name == name; 
////        if (target instanceof Genre) {
////            return this.name == ((Genre) target).name; 
////        }
////        return false; 
//    }
//}
//
//public class Programmers_베스트앨범 {
//    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        
//        System.out.println(Arrays.toString(solution(genres, plays))); 
//    }
//    
//    public static int[] solution(String[] genres, int[] plays) { 
//        List<Integer> list = new ArrayList<>(); 
//        Map<String, Integer> genreTotalPlay = new HashMap<>(); 
//        Map<String, PriorityQueue<Music>> genrePlay = new HashMap<>(); 
//        
//        for(int i = 0; i < genres.length; i++) {
//            String key = genres[i]; 
//            genreTotalPlay.put(key, genreTotalPlay.getOrDefault(key, 0) + plays[i]); 
//            PriorityQueue<Music> temp = genrePlay.getOrDefault(key, new PriorityQueue<>());
//            temp.add(new Music(i, plays[i])); 
//            genrePlay.put(key, temp); 
//        }
//        
//        PriorityQueue<Genre> gen = new PriorityQueue<>(); 
//        Iterator<String> iter = genreTotalPlay.keySet().iterator(); 
//        while(iter.hasNext()) {
//            String key = iter.next(); 
//            gen.add(new Genre(key, genreTotalPlay.get(key))); 
//        }
// 
//        while(! gen.isEmpty()) {
//            
//            Genre key = gen.poll(); 
//            PriorityQueue<Music> musics = genrePlay.get(key.name);
//            
//            list.add(musics.poll().index); 
//            
//            if (musics.size() >= 1) {
//                list.add(musics.poll().index); 
//            }
//        }
//        int[] answer = new int[list.size()]; 
//
//        for(int i = 0; i < answer.length; i++) {
//            answer[i] = list.get(i); 
//        }        
//        return answer; 
//    }
//}
