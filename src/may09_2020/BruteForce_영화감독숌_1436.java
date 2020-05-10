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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce_영화감독숌_1436 {
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
			
		int count = 0;
		int num = 665;
		while(count<N) {
			num++;
                        System.out.println("*****count:  " + count);
                        System.out.println("num: " + num); 
			int temp = num;
			int sixCount = 0;
			
			while(temp > 0)
			{
				if(temp%10 == 6) sixCount++;
				else sixCount = 0;
				if(sixCount >= 3) {
					count++;
					break;
				}
				temp/=10;
			}
		}
		System.out.println(num);
	}
}
