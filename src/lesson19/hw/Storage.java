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

    public boolean put(Storage storage, File file) throws Exception {

        validation(storage, file);

        File[] fileNew = new File[files.length + 1];

        System.arraycopy(files, 0, fileNew, 0, files.length);

        fileNew[fileNew.length - 1] = file;

        files = fileNew;

        return true;
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
                    throw new Exception("Missing object"+ "storage = " + storage.id);
                if (!validateFormat(storage, file) && file.getFormat()==null)
                    throw new Exception("Format is not correct, id = " + file.getId() + " storage = " + storage.id);
                if (!validateId(storage, file))
                    throw new Exception("Id is already in use, id = " + file.getId() + " storage = " + storage.id);
                if (!validateFileName(file) && file.getName() == null)
                    throw new Exception("File name is too long, id = " + file.getId() + " storage = " + storage.id);
                if (!validateStorageSize(storage, file))
                    throw new Exception("Not enough storage, id = " + file.getId() + " storage = " + storage.id);
                return true;

    }

    private static boolean validateFormat(Storage storage, File file) {
        for (String storageFormat : storage.getFormatsSupported()) {
            if (file.getFormat() == storageFormat)
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
