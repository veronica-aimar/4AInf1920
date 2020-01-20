package it.itis.cuneo;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.util.concurrent.TimeoutException;

/**
 * Created by inf.aimarv1906 on 16/12/2019.
 */
/*
classe per la gestione sequenziale di un file di testo
* */
public class TextFile {
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;

    public TextFile(String filename, char mode) throws IOException {
        this.mode = 'R';
        if(mode == 'W' || mode == 'w') {
            this.mode = 'W';
            writer = new BufferedWriter(new FileWriter(filename));
        }
        else {
            reader = new BufferedReader(new FileReader(filename));
        }
    }

    public void toFile (String line) throws FilerException, IOException {
        if(this.mode == 'R') throw new FilerException("Read-only" + "file!");
        writer.write(line);
        writer.newLine();
    }

    public String fromFile() throws FilerException,IOException {
        String tmp;
        if(this.mode == 'W') throw new FilerException("Write-only" + "file!");
        tmp = reader.readLine();
        if(tmp == null) throw new FilerException("End of File!");
        return tmp;
    }

    public void closeFile() throws IOException {
        if(this.mode == 'W') {
            writer.close();
        }
        else {
            reader.close();
        }
    }
}
