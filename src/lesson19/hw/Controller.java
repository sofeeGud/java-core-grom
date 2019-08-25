package lesson19.hw;

public class Controller {

    public static File put(Storage storage, File file) throws Exception{

        return storage.put(storage, file);
        }

    public static File delete(Storage storage, File file) throws Exception {

        return storage.delete(storage, file);
    }

    public boolean transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom == null)
            throw new NullPointerException("StorageFrom is null.");

        if (storageTo == null)
            throw new NullPointerException("StorageTo is null.");


        if (storageFrom.getFormatsSupported() != storageTo.getFormatsSupported())
            throw new Exception("Format is not correct");

        if (storageFrom.getStorageSize() >= storageTo.getStorageSize())
            throw new Exception("Not enough storage");

        for (File file : storageFrom.getFiles()){
            put(storageTo, file);
            delete(storageFrom, file);
        }
            return true;
        }

    public boolean transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
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
                } else throw new Exception("File " + id + " is not found in Storage " + storageFrom.getId());

            }
        }
        if (storageTo.getStorageSize() + fileTransfer.getSize() >= storageTo.getStorageSize()) {
            try {
                put(storageTo, fileTransfer);
                delete(storageFrom, fileTransfer);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return false;
        }
        return true;
    }

}
