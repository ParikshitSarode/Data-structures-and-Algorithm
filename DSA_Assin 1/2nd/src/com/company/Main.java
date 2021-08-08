package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        int max = 0;
        for (int p = 0;p< testcases;p++) {
            String ip[] = scan.nextLine().split(" ");
            int n = Integer.parseInt(String.valueOf(ip[0]));
            int k = Integer.parseInt(String.valueOf(ip[1]));
            String houses[] = scan.nextLine().split(" ");
            int[] houseno = new int[0];
            for (int i = 0; i < n; i++) {
                //houseno[i] = Integer.parseInt(houses[i]);
                houseno[i] = scan.nextInt();
            }
            for (int g = 0; g < n; g++) {
                for (int j = g; j < k + g; j++) {
                    if (houseno[j] > max) {
                        max = houseno[j];

                    }
                    System.out.println(max);
                }
            }
        }

    }
}

