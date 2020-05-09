//
//package may02_2020;
//
///**
// *
// * @author 주세인1
// */
//
///**
// * 입력
// * handshake
// * shake hands
// * 
// * 출력
// * 65536
// * 
// */
//
//// 입력 관련 
//import java.io.BufferedReader; 
//import java.io.InputStreamReader; 
//import java.io.IOException; 
//
//// 구현 관련
//import java.util.Map; 
//import java.util.HashMap; 
//import java.util.Set; 
//import java.util.HashSet; 
//import java.util.Iterator; 
//
//public class 카카오2017_뉴스클러스터링_5 {
//    
//    static Map<String, Integer> set1 = new HashMap<>();
//    static Map<String, Integer> set2 = new HashMap<>(); 
//    // 전체 원소를 받는 (한개씩만) set
//    static Set<String> strSet = new HashSet<>(); 
//    
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
//        
//        String str1 = in.readLine();
//        String str2 = in.readLine(); 
//        
//        str1 = str1.toLowerCase(); 
//        str2 = str2.toLowerCase(); 
//        
//        setStringMap(str1, set1); 
//        setStringMap(str2, set2); 
//        
//        System.out.println((int)(solve() * 65536)); 
//        
//        
//    }
//    
//    static void setStringMap(String str, Map<String, Integer> map) {
//        
//        for(int i = 0; i < str.length() - 1; i++) {
//            char c1 = str.charAt(i); 
//            char c2 = str.charAt(i + 1); 
//            
//            if(c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
//                String pair = String.valueOf(c1) + String.valueOf(c2); 
//                if(! map.containsKey(pair)) {
//                    map.put(pair, 1); 
//                }
//               
//                else {
//                    map.replace(pair, map.get(pair) + 1);
//                }
//                
//                strSet.add(pair);
//            }
//        }
//    }
//    
//    // get similarity between str1, str2
//    static float solve() {
//        float similarity; 
//        float interCnt = 0; 
//        float unionCnt = 0; 
//        
//        Iterator<String> iter = strSet.iterator(); 
//        while(iter.hasNext()) {
//            String str = iter.next(); 
//            
//            int strCnt1 = set1.getOrDefault(str, 0);
//            int strCnt2 = set2.getOrDefault(str, 0); 
//            
//            unionCnt += Math.max(strCnt1, strCnt2); 
//            interCnt += Math.min(strCnt1, strCnt2); 
//            
//        }
//       
//        similarity = unionCnt == 0 ? 1: interCnt/unionCnt; 
//        
//        return similarity; 
//    }
//    
//    
//}
