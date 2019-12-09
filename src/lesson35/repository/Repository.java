package lesson35.repository;

import java.io.*;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;

public abstract class Repository<T> {
    private String path;

    Repository(String path) {
        this.path = path;
    }
    //read + mapping data

    public Set<T> getAll() throws Exception {

        Set<T> ts = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                ts.add(parse(line));
            }
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + " failed");
        }
        return ts;
    }

    public abstract T parse(String line) throws Exception;

    public T writeToFile(T t) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            if (br.readLine() != null)
                bw.append("\r\n");
            bw.append(t.toString());
        } catch (IOException e) {
            throw new IOException("Writing to file " + path + " failed");
        }
        return t;
    }

    public Long genId() {
        Date date = new Date();

        return date.getTime();
    }
}
