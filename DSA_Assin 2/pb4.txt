package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] p = br.readLine().split(" ");
        String[] s = new String[p.length];

        for (int i = 0; i < p.length; i++) {
            if(p[i].equals("N")||p[i].equals("n")){
                s[i]="-1";
            }
            else {
                s[i]=p[i];
            }
            //System.out.print(s[i]);
        }
        Tree tree = new Tree(s);        //Tree constructed

        int informant = scan.nextInt();
        tree.dodfs(informant);
        //BFS on node informant and tree and count max size of queue-- answer

    }
}

class Node{
    public int data;
    public Node link1;
    public Node link2;
}

class Tree {
    static int max = 0;
    static int count = 0;
    public Node[] nodes;
    Stack<Integer> stack = new Stack<Integer>();

    public Tree(String[] s) {
        nodes = new Node[s.length];
        for (int i = 0; i < s.length; i++) {
            nodes[i] = new Node();
            nodes[i].data = Integer.parseInt(s[i]);
            nodes[i].link1 = null;
            nodes[i].link2 = null;
            for (int j = 0; j < i; j++) {
                if (nodes[j].data == -1 && j == 0) continue;
                else {
                    if (nodes[j].link1 == null && nodes[j].data != -1) {
                        nodes[j].link1 = nodes[i];
                        //System.out.println("Parent of"+nodes[i].data+" is "+nodes[j].data+"-Left child");
                        break;
                    } else {
                        if (nodes[j].link2 == null && nodes[j].data != -1) {
                            nodes[j].link2 = nodes[i];
                            //System.out.println("Parent of"+nodes[i].data+" is "+nodes[j].data+"-right child");
                            break;
                        }
                    }
                }
            }
        }
    }

    public void dodfs(int informant) {


        Boolean[] visited = new Boolean[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].data == informant) {
                //stack[top++] = nodes[i];
                //if(top+1>max)max = top+1;
                dfsperform(i, visited);
            }
        }


    }

    public void dfsperform(int nodeindex, Boolean[] visited) {
        visited[nodeindex] = true;
        count++;
        stack.push(nodeindex);
        if (count > max) max = count;

        while (!stack.isEmpty()) {
            int n = stack.pop();
            if (visited[n] == false) {
                dfsperform(n, visited);
                count++;
            }
        }
        System.out.println(max);
    }

}
