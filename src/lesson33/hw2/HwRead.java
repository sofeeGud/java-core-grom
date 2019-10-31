package lesson33.hw2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class HwRead {

    public void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }
        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.err.println("Reading from line " + path + "failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

    public void readFileByConsolePath() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please, enter file path to read:");
        readFile(br.readLine());
        IOUtils.closeQuietly(reader);
        IOUtils.closeQuietly(br);
    }
}
