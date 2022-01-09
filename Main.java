// Arwa Hazem Mohamed khalil 20190663
//Mariam Khalid Sayed Abd El-Raouf 20190518
package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LZ77 lz77 = new LZ77();
        boolean f = true;
        while(f) {
            System.out.println("enter 1 to compress or 2 to decompress ");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("please enter a string to compress");
                    String str = input.next();
                    lz77.compress(str);
                    f = false;
                }
                case 2 -> {
                    ArrayList<Tag> t = new ArrayList<>();
                    System.out.println("please enter number of tags to decompress");
                    int len = input.nextInt();
                    System.out.println("please enter your tags");
                    for (int i = 0; i < len; i++) {
                        Tag tag = new Tag(input.nextInt(), input.nextInt(), input.next().charAt(0));
                        t.add(tag);
                    }
                    lz77.decompress(t);
                    f = false;
                }
            }
        }

    }
}