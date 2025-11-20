package application;

import utilities.ArchiveManipulation;

import java.io.File;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArchiveManipulation archiveMan = new ArchiveManipulation();

        System.out.println("Please enter the path of the .csv file: ");

        File path = new File(sc.nextLine());

        archiveMan.readFile(path);
        archiveMan.writeFile(path);

        sc.close();
    }
}
