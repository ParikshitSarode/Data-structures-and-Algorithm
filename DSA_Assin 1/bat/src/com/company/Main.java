package com.company;
import java.util.Scanner;
public class Main {

    public static int main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int p =scan.nextInt();
	    int sum = 0;

	    int mat[][] = new int[p][p];

	    for(int i = 0;i<p; i++){
	        for (int j = 0;j<p ;j++){
	            mat[i][j] = scan.nextInt();
            }
        }
        for(int i = 0;i<p; i++){
            for (int j = 0;j<p ;j++) {
                sum += mat[i][j];
                if (sum > 6) {
                    return 0;
                } else if (mat[i][i] == 1) {
                    return 0;
                } else {
                    return Math.abs(i-j);
                }
            }
        }return -1;
    }
}
