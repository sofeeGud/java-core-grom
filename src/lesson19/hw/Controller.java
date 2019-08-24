package lesson19.hw;

public class Controller {

    public static File put(Storage storage, File file) {

        return storage.put(storage, file);
    }

    public static boolean delete(Storage storage, File file) {
        return storage.delete(storage, file);
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom == null)
            throw new NullPointerException("StorageFrom is null.");

        if (storageTo == null)
            throw new NullPointerException("StorageTo is null.");
        if (storageFrom.getStorageSize() >= storageTo.getStorageSize())
            throw new Exception("Not enough storage");

        if (storageFrom.getFormatsSupported() != storageTo.getFormatsSupported())
            throw new Exception("Format is not correct");

        int lenStorageToNew = storageFrom.getFiles().length + storageTo.getFiles().length;
        Storage[] storageNewTo = new Storage[lenStorageToNew];
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            delete(storageFrom, storageFrom.getFiles()[i]);
            storageNewTo[i].getFiles()[i] = storageTo.getFiles()[i];
            put(storageTo, storageFrom.getFiles()[i]);
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (storageFrom == null)
            throw new NullPointerException("StorageFrom is null.");

        if (storageTo == null)
            throw new NullPointerException("StorageTo is null.");

        if (storageFrom.getFormatsSupported() != storageTo.getFormatsSupported())
            throw new Exception("Format is not correct");

        File fileTransfer = null;
        for (File findFile : storageFrom.getFiles()) {
            if (findFile != null) {
                if (findFile.getId() == id) {
                    fileTransfer = findFile;
                } else throw new Exception("File '" + id + "' is not found in Storage '" + storageFrom.getId() + "'.");

            }
        }

        try {
            put(storageTo, fileTransfer);
            delete(storageFrom, fileTransfer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
