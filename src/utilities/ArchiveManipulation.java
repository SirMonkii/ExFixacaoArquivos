package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArchiveManipulation {

    ArrayList<String[]> inputItens = new ArrayList<>();
    ArrayList<String[]> outputItens = new ArrayList<>();

    public void readFile(File userPath) {

        try (BufferedReader br = new BufferedReader(new FileReader(userPath))) {
            String line;

            line = br.readLine();

            while (line != null) {
                inputItens.add(line.split(","));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (String[] item : inputItens) {
            double itemTotal = Double.parseDouble(item[1]) * Integer.parseInt(item[2]);

            String[] newItem = {item[0], String.valueOf(itemTotal)};

            outputItens.add(newItem);
        }
    }

    public void writeFile(File userPath) {

        File outFolder = new File(userPath.getParent() + "/out");

        if (!outFolder.exists()) {
            boolean unused = outFolder.mkdir();
        }

        File summary = new File(outFolder, "summary.csv");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(summary))) {
            for (String[] item : outputItens) {
                bw.write(item[0] + "," + item[1]);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
