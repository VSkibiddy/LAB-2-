//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;

public class CharacterCounter {
    public CharacterCounter() {
    }

    public static int[] count(Reader reader) throws IOException {
        int[] frequencies = new int[26];
        BufferedReader br = new BufferedReader(reader);

        int data;
        while((data = br.read()) != -1) {
            char ch = (char)data;
            if (Character.isLetter(ch)) {
                ch = Character.toUpperCase(ch);
                if (ch >= 'A' && ch <= 'Z') {
                    ++frequencies[ch - 65];
                }
            }
        }

        return frequencies;
    }

    public static void test() {
        try {
            String test1 = "abcABC";
            int[] result1 = count(new StringReader(test1));
            System.out.println("Test 1 (abcABC): " + Arrays.toString(result1));
            System.out.println("Most frequent: " + getMostFrequentCharacter(result1));
            String test2 = "";
            int[] result2 = count(new StringReader(test2));
            System.out.println("Test 2 (empty string): " + Arrays.toString(result2));
            String test3 = "1234!@#$%^&*()_+";
            int[] result3 = count(new StringReader(test3));
            System.out.println("Test 3 (non-letters): " + Arrays.toString(result3));
            System.out.println("Most frequent: " + getMostFrequentCharacter(result3));
            String test4 = "Hello, World!";
            int[] result4 = count(new StringReader(test4));
            System.out.println("Test 4 (Hello, World!): " + Arrays.toString(result4));
            System.out.println("Most frequent: " + getMostFrequentCharacter(result4));
        } catch (IOException e) {
            System.out.println("Error during testing: " + e.getMessage());
        }

    }

    public static char getMostFrequentCharacter(int[] frequencies) {
        int maxIndex = 0;

        for(int i = 1; i < frequencies.length; ++i) {
            if (frequencies[i] > frequencies[maxIndex]) {
                maxIndex = i;
            }
        }

        return (char)(maxIndex + 65);
    }
}
