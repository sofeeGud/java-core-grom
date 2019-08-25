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

    public boolean put(File file) throws Exception {
        boolean flag = false;
        if (file !=null){
            if (files !=null && validation(file)) {

                for (int i = 0; i < files.length; i++)
                    if (files[i] == null) {
                        files[i] = file;
                        flag = true;
                        break;
                    }
            }
        }
        return flag;
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

    private boolean validation(File file)throws Exception{
                if (file == null)
                    throw new Exception("Missing object"+ " storage = " + id);
                if (!validateFormat(file))
                    throw new Exception("Format is not correct, id = " + file.getId() + " storage = " + id);
                if (!validateId(file))
                    throw new Exception("Id is already in use, id = " + file.getId() + " storage = " + id);
                if (!validateFileName(file))
                    throw new Exception("File name is too long, id = " + file.getId() + " storage = " + id);
                if (!validateStorageSize(file))
                    throw new Exception("Not enough storage, id = " + file.getId() + " storage = " + id);
                return true;

    }

    private boolean validateFormat(File file) {
        for (String storageFormat : getFormatsSupported()) {
            if (file.getFormat().equals(storageFormat))
                return true;
        }
        return false;
    }

    private boolean validateId(File file) {
        for (File fileFind : getFiles()) {
            if (file.getId() == fileFind.getId())
                return false;
        }
        return true;
    }

    private static boolean validateFileName(File file) {

        return file.getName().length() <= 10;
    }

    private boolean validateStorageSize(File file) {
        long sumSize = 0;
        for (File fileSize : getFiles()) {
            sumSize += fileSize.getSize();
        }
        return (sumSize + file.getSize() <= getStorageSize());
    }

}
