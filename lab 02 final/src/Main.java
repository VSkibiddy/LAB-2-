//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String inputFilename = "[sasha copy the path yourself please :)]";
        String outputFilename = "frequency.txt";
        CharacterCounter.test();

        try {
            FileCharacterReader fileReader = new FileCharacterReader(inputFilename);
            int[] frequencies = CharacterCounter.count(fileReader.getReader());
            fileReader.close();
            FileWriter outputWriter = new FileWriter(outputFilename);

            for(int i = 0; i < frequencies.length; ++i) {
                if (frequencies[i] > 0) {
                    char letter = (char)(i + 65);
                    outputWriter.write(letter + " : ");

                    for(int j = 0; j < frequencies[i]; ++j) {
                        outputWriter.write("*");
                    }

                    outputWriter.write("\n");
                }
            }

            outputWriter.close();
            System.out.println("¡Frequencies saved in " + outputFilename + "!");
        } catch (IOException e) {
            System.out.println("There was an error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
