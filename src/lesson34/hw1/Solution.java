package lesson34.hw1;

import java.io.*;

public class Solution {

    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
        cleanFromFile(fileFromPath);
    }

    private StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }
        return res;
    }

    private void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    private void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permission to written");
        }
        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileFrom + " does not have permission to written");
        }
    }

    private void cleanFromFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.write("");
        } catch (IOException e) {
            System.err.println("Can't clear file by " + path);
        }
    }
}

