package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[n];
        int count = 0;
        int[] map = new int[n];     //map for array map to find coverage of sorted data
        Data[] data = new Data[n];
        Data[] sorted = new Data[n];
        int[] arr = new int[n];
        s = br.readLine().split(" ");       //input in arr
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < n; i++) {       //all ranges of helper stored in Data class object array
            int srange = i - arr[i];
            int erange = i + arr[i];
            int totalrange = 2*arr[i] +1;
            if(arr[i]==-1){         //if value is -1,set ranges -1 and index as i
                srange=-1;
                erange=-1;
                totalrange=-1;
                data[i] = new Data(srange,erange,totalrange,i);

                continue;
            }else {
                while (srange < 0) {
                    totalrange--;
                    srange++;
                }
                while (erange >= n) {
                    totalrange--;
                    erange--;
                }
                data[i] = new Data(srange, erange, totalrange, i);
                //System.out.println(data[i].index);
            }
        }
        //sort according to ranges max to min
        for (int i = 0; i < n; i++) {
            Data k =new Data(data[i].startrange,data[i].endrange, data[i].range,data[i].index);
             //k = data[i].range;
            int j =i-1;
            while (j>=0&&data[j].range>k.range){
                data[j+1] = data[j];
                j--;
            }
            data[j+1]= k;
        }
        for (int i = 0; i < n; i++) {
            //System.out.println(data[i].index);
        }
        //Sorting in desc
//        for (int i = n-1; i >= 0 ; i--) {
//            //System.out.println(data[i].range);
//            if(data[i].range ==-1){
//                sorted[n-(i+1)] = new Data(-1,-1,-1,i);
//            }else {
//                sorted[n-(i+1)] = new Data(data[i].startrange,data[i].endrange,data[i].range,data[i].index);
//            }
//        }
        for (int i = 0; i < n; i++) {
            //System.out.println(sorted[i].index);
            map[i] = -1;
        }

        for (int i = n-1; i >= 0; i--) {
            if(data[i].range==-1)break;
            for (int j = data[i].startrange; j <= data[i].endrange ; j++) {
                if(map[j]==1)continue;
                else {
                    map[j]=1;
                    count++;
                    data[i].flag=1;
                }

//                if(count==n){
//                    System.out.print(i);
//                    return;
//                }
            }

            }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (data[i].flag==1) count++;
            if(map[i]==-1){
                count = -1;
                break;
            }
        }
        System.out.println(count);
        }

    }



class Data{         //To store info on all rangers on a helper
    public int startrange;
    public int endrange;
    public int range;
    public int index;
    public int flag;

    Data(int srange, int erange ,int trange,int indx){

        flag=0;
        startrange = srange;
        endrange = erange;
        range = trange;
        index=indx;
    }
    Data(){
        startrange=0;
        endrange=0;
        range=0;
        index=0;
        flag=0;
    }

}
