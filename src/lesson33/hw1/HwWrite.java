package lesson33.hw1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class HwWrite {

    public void writeToFileFromConsole(String path) {
        System.out.println("Enter file content to write the file:");
        foundPath(path);
        InputStreamReader reader = new InputStreamReader(System.in);

        try (BufferedReader br = new BufferedReader(reader)) {
            String input;
            while ((input = br.readLine()) != null) {
                if (input.equals("wr"))
                    return;
                writing(path, input);
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        } finally {
            IOUtils.closeQuietly(reader);
        }
    }

    private static void writing(String path, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append("\n");
            bw.append(line);
        } catch (IOException e) {
            System.err.println("Can`t write to file with path " + path);
        }
    }

    private static void foundPath(String path) {
        File file = new File(path);
        if (!file.exists())
            System.err.println("File with path " + path + " not found");
    }

}
