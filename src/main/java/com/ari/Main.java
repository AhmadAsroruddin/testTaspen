package com.ari;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SortingChar sortingChar = new SortingChar();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Berapa kata yang ingin anda masukan ?");
        int wordLong = scanner.nextInt();
        scanner.nextLine();
        String[] word = new String[wordLong];

                System.out.println("Tulis kata di bawah ini");
        for(int i = 0 ; i < wordLong; i++){
            System.out.print("kata ke-" + i +" : ");
            word[i] = scanner.nextLine();
        }

        sortingChar.sortingCharacter(word);
    }

}
