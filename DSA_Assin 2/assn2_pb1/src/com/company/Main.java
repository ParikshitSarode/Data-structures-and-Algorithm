package com.company;
                                    //Placement sort
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] B = new int[101];
        Data[] data = new Data[n];
        Data[] res = new Data[n];
                                        //Taking input in array of class data
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {

            data[i] = new Data(br.readLine().split(" "));

        }
        int bucketno = scan.nextInt();
        Bucketno[] bucket = new Bucketno[bucketno];
        for (int i = 0; i < bucketno; i++) {
            bucket[i] = new Bucketno();
            bucket[i].bucketvvalue = scan.nextInt();
        }

        //Code for counting sort on data[i].salary
        for (int i = 0; i <= 100; i++) {
            B[i] = 0;                   //bucket to all 0s
        }

        for (int i = 0; i < n; i++) {   //incrementing bucket counts
                B[data[i].sal_in_bucket] = B[data[i].sal_in_bucket]+1;
        }

        for (int i = 1; i <=100; i++) {     //counting previous elements present
            B[i] = B[i] + B[i-1];
        }
        for (int i = n-1; i >= 0; i--) {       //new sorted array

            res[i] = new Data(data[i].rollno,data[i].name, data[i].salary);
            B[data[i].sal_in_bucket]--;
            System.out.println(res[i].rollno+" "+res[i].name+" "+res[i].salary);

        }


        for (int i = 0; i < bucketno; i++) {
            for (int j = 0; j < n; j++) {
                if(bucket[i].bucketvvalue == res[j].salary){
                    bucket[i].count++;
                }
            }

        }
        for (int i = 0; i < bucketno; i++) {
            System.out.println(bucket[i].count);
        }

    }

    public static class Data{       //Class to store data
        public String rollno;
        public String name;
        public int salary;
        public int sal_in_bucket;

        Data(String[] s){       //Constructors
            rollno = s[0];
            name = s[1];
            salary = Integer.parseInt(s[2]);
            sal_in_bucket = salary/100000;
        }


        public Data(String roll, String nm, int sal) {
            rollno = roll;
            name = nm;
            salary = sal;
            sal_in_bucket = salary/100000;
        }
    }
    public static class Bucketno{
        int bucketvvalue;
        int count;
    }
}
