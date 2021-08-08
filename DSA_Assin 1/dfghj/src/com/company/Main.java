package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    ll myll= new ll();
	    nodes head = null;
	    Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        for(int j = 0; j< testcases; j++){
            int lllength = scan.nextInt();
            int repeatsize = scan.nextInt();
            ll mynode = new ll();
            for(int k = 0; k < lllength; k++){
                int p =scan.nextInt();
                head = mynode.createnode(p);
            }
            head = mynode.reverse_ll(repeatsize,head);
            myll.traversell(head);
        }

    }
}
class nodes{
    public int value;
    public nodes reference;

}
class ll {
    nodes head=null;
    public nodes createnode(int data) {
        nodes newnode = new nodes();
        newnode.value = data;
        newnode.reference = null;
        if (head == null) {
            head = newnode;
        } else {
            nodes n = head;
            while (n.reference != null) {
                n = n.reference;
            }
            n.reference = newnode;
        }
    return  head;
    }

        public nodes reverse_ll(int a, nodes head){
            nodes cur = head;
            nodes temp=null,temp2 = cur.reference ;
            //reverse first a elems then next a till end
            while(temp2.reference!=null){
                for (int g = 0 ; g<a;g++){
                    //reverse ll code
                   // temp2 = cur.reference;
                    cur.reference = temp;
                    temp = cur;
                    cur = temp2;
                    temp2 = temp2.reference;

                }

            }
            return cur;
        }
        public void traversell(nodes head){
            nodes n = head;
            while (n.reference!= null){
                System.out.println(n.value);
                n = n.reference;
            }
        }
    }



