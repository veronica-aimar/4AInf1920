package it.itis.cuneo;

import javax.annotation.processing.FilerException;
import java.io.File;

/**
 * Created by inf.aimarv1906 on 16/12/2019.
 */
public class FileException extends Exception {
    private String matter = "";

    public FileException(String matter) {
        this.matter = matter;
    }

    public String getMatter() {
        return this.matter;
    }
}
