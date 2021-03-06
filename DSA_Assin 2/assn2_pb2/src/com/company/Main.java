package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        double max = (k*k -1);
        int max_len = 0,p = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[k];
        s = br.readLine().split(" ");
        int[] nos = new int[k];
        int[] res = new int[k];
        int[] bucket = new int[10];
        int digit;
        for (int i = 0; i < k; i++) {
            nos[i] = Integer.parseInt(s[i]);        //put input numbers in nos[]
        }
        for (int i = 0; i < 10; i++) {
            bucket[i] = 0;
        }
        for (int i = 0; i < k; i++) {       //p gives max number
            if(nos[i]>p){
                p = nos[i];
            }
        }
        max_len = (int) Math.log(max);
        max_len++;

                //redix sort from lsb to msb
        for (int i = 1; p/i>0; i = i*10) {
            //count sort to sort individual position
            for (int j = 0; j < k; j++) {
                digit = (nos[j]/i)%10;
                bucket[digit]++;
            }
            for (int j = 1; j < k; j++) {
                bucket[j] = bucket[j]+bucket[j-1];

            }
            for (int j = k-1; j >= 0; j--) {
                digit = (nos[j]/i)%10;
                int l = bucket[digit] ;
                res[l-1] = nos[j];
//              l--;
//                  res[bucket[(nos[j]/i)%10]-1] = nos[j];
//                  bucket[(nos[j]/i)%10]--;

            }
            for (int j = 0; j < k; j++) {
                nos[j] = res[j];
            }

        }
        //nos[k-1]=p;
        for (int i = 0; i < k; i++) {
            System.out.print(nos[i]+" ");
        }
    }

}
