//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileReader;
import java.io.IOException;

public class FileCharacterReader {
    final FileReader reader;

    public FileReader getReader() {
        return this.reader;
    }

    public FileCharacterReader(String filePath) throws IOException {
        this.reader = new FileReader(filePath);
    }

    public Character getNextCharacter() throws IOException {
        while(true) {
            int data;
            if ((data = this.reader.read()) != -1) {
                char ch = (char)data;
                if (ch == '\r') {
                    continue;
                }

                return ch;
            }

            return null;
        }
    }

    public void close() throws IOException {
        this.reader.close();
    }
}
