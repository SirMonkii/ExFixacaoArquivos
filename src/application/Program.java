package application;

import utilities.ArchiveManipulation;

import java.io.File;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArchiveManipulation archiveMan = new ArchiveManipulation();

        System.out.println("Please enter the path of the .csv file: ");
        archiveMan.readFile(new File(sc.nextLine()));

        sc.close();
    }

}
