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

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    @Override
    public String toString() {
        return "Storage{\n" +
                " id=" + id +
                ",\n files=" + Arrays.toString(files) +
                ",\n formatsSupported=" + Arrays.toString(formatsSupported) +
                ",\n storageCountry='" + storageCountry + '\'' +
                ",\n storageSize=" + storageSize +
                '}';
    }

    public static File put(Storage storage, File file) throws Exception {
        if (file == null) {
            throw new Exception("File is null");
        }
        if (storage == null) {
            throw new Exception("Storage is null");
        }

        validation (storage, file);

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                break;
            }
        }
        return file;
    }
    public boolean delete(Storage storage, File file) throws NullPointerException{
        if (file != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].getId() == file.getId() && files[i].getName() == file.getName()) {
                    files[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean validation(Storage storage, File file)throws Exception{
                if (file == null)
                    throw new Exception("Missing object"+ " storage = " + storage.getId());
                if (!validateFormat(storage, file))
                    throw new Exception("Format is not correct, id = " + file.getId() + " storage = " + storage.getId());
                if (!validateId(storage, file))
                    throw new Exception("Id is already in use, id = " + file.getId() + " storage = " + storage.getId());
                if (!validateFileName(file))
                    throw new Exception("File name is too long, id = " + file.getId() + " storage = " + storage.getId());
                if (!validateStorageSize(storage, file))
                    throw new Exception("Not enough storage, id = " + file.getId() + " storage = " + storage.getId());
                return true;

    }

    private static boolean validateFormat(Storage storage, File file) {
        for (String storageFormat : storage.getFormatsSupported()) {
            if (storageFormat.equals(file.getFormat()))
                return true;
        }
        return false;
    }

    private static boolean validateId(Storage storage, File file) {
        for (File fileFind : storage.getFiles()) {
            if (file.getId() == fileFind.getId())
                return false;
        }
        return true;
    }

    private static boolean validateFileName(File file) {

        return file.getName().length() <= 10;
    }

    private static boolean validateStorageSize(Storage storage, File file) {
        long sumSize = 0;
        for (File fileSize : storage.getFiles()) {
            sumSize += fileSize.getSize();
        }
        return (sumSize + file.getSize() <= storage.getStorageSize());
    }

}
