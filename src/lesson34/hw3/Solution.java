package lesson34.hw3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class Solution {
    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        validate(fileFrom, fileTo);
        Files.copy(fileFrom.toPath(), fileTo.toPath());
    }

    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws IOException {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        FileUtils.copyFile(fileFrom, fileTo);
    }

    private void validate(File fileFrom, File fileTo) throws Exception {

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to read");
        }

        if (fileTo.exists())
            fileTo.delete();
    }
}
