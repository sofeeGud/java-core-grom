package lesson19.hw;


import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }


    public long getStorageSize() {
        return storageSize;
    }

    public File[] getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "\n id=" + id +
                "\n, files=" + Arrays.toString(files) +
                "\n, formatsSupported=" + Arrays.toString(formatsSupported) +
                "\n, storageCountry='" + storageCountry + '\'' +
                "\n, storageSize=" + storageSize +
                '}';
    }
}