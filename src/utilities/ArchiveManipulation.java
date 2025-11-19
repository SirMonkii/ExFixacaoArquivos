package utilities;

import java.io.*;
import java.util.ArrayList;

public class ArchiveManipulation {

    ArrayList<String[]> inputItens = new ArrayList<>();
    ArrayList<String[]> outputItens = new ArrayList<>();

    public void readFile(File userPath) {

        try (BufferedReader br = new BufferedReader(new FileReader(userPath))) {
            String line;

            line = br.readLine();

            while (line != null) {
                inputItens.add(line.split(";"));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (String[] item : inputItens){
            String itemName = item[0];
            double itemTotal = Double.parseDouble(item[1]) * Integer.parseInt(item[2]);

            String[] newItem = {item[0], String.valueOf(itemTotal)};

            outputItens.add(newItem);
        }
    }
}
