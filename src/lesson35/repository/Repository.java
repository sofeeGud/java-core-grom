package lesson35.repository;

import java.io.*;
import java.util.Date;

public class Repository<T> {
    private String path;

    Repository(String path) {
        this.path = path;
    }
    //read + mapping data


    T writeToFile(T t) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            if (br.readLine() != null)
                bw.append("\r\n");
            bw.append(t.toString());
        } catch (IOException e) {
            throw new Exception("Writing to file " + path + " failed");
        }
        return t;
    }


    public Long genId() {
        Date date = new Date();

        return date.getTime();
    }
}
