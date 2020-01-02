package lesson35.repository;

import java.io.*;
import java.util.Date;

import java.util.HashSet;
import java.util.Random;
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
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append(t.toString());
            bw.append("\r\n");
        } catch (IOException e) {
            throw new IOException("Writing to file " + path + " failed");
        }
        return t;
    }

    public Long genId() {
        Random rand = new Random();
        return rand.nextLong();
    }


    void cleanFromDb(long id) throws Exception {
        StringBuffer tempData = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!Long.valueOf(line.split(",")[0]).equals(id)) {
                    tempData.append(line);
                    tempData.append("\r\n");
                }
            }
            if (tempData.length() >= 2)
                tempData.replace(tempData.length() - 2, tempData.length(), "");
        } catch (IOException e) {
            throw new Exception("Can't clear file by " + path);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path), false))) {
            bw.append(tempData);
        } catch (IOException e) {
            throw new Exception("Can't clear file by " + path);
        }
    }
}
