package lesson19.hw;

public class Controller {
    public File put(Storage storage, File file) throws Exception{
        validation(storage, file);
        int i = 0;
        for (File file1 : storage.getFiles()){
            if (file1 == null){
                storage.getFiles()[i] = file;
                break;
            }
            i++;
        }
        return storage.getFiles()[i];
    }

    public void delete(Storage storage, File file) throws Exception{
        boolean flag = false;
        for (File file1 : storage.getFiles()){
            if (file1 != null && file1.equals(file)){
                flag = true;
                break;
            }
        }
        if (!flag)
            throw new Exception("File is not use in storage id= " + storage.getId());
        int i = 0;
        for (File file1 : storage.getFiles()){
            if (file1 != null && file1.equals(file)){
                storage.getFiles()[i] = null;
            }
            i++;
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{
        long sizeFrom = 0;
        for (File fileFrom : storageFrom.getFiles()) {
            findById(storageTo, fileFrom.getId());
            validateFormat(storageTo, fileFrom.getFormat());

            sizeFrom += fileFrom.getSize();
        }

        validatePlaceStorageTo(storageTo, storageFrom.getFiles().length);
        validateStorageSize(storageTo, sizeFrom);

        for (File fileFrom : storageFrom.getFiles()){
            if (fileFrom != null){
                delete(storageFrom, fileFrom);
                put(storageTo, fileFrom);
            }
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        for (File fileFrom : storageFrom.getFiles()){
            if (fileFrom.getId() == id){
                put(storageTo, fileFrom);
                delete(storageFrom, fileFrom);
                return;
            }
        }
    }

    private boolean validation(Storage storage, File file) throws Exception {
        findById(storage, file.getId());
        validateFormat(storage, file.getFormat());
        validatePlaceStorage(storage);
        validateStorageSize(storage, file.getSize());

        return false;
    }

    private void validateStorageSize(Storage storage, long fileSize) throws Exception {
        long sumSize = 0;
        for (File file : storage.getFiles()){
            if (file != null)
                sumSize += file.getSize();
        }
        if (sumSize + fileSize > storage.getStorageSize())
            throw new Exception("Not enough storage, id = "  + storage.getId());
    }

    private void validatePlaceStorage(Storage storage) throws Exception {
        for (File file : storage.getFiles()) {
            if (file == null)
                return;
        }
        throw new Exception("No free place in storage id= " + storage.getId());
    }

    private void validatePlaceStorageTo(Storage storage, int cellToNeed) throws Exception {
        int count = 0;
        for (File file : storage.getFiles()){
            if (file == null)
                count++;
        }
        if (count < cellToNeed)
            throw new Exception("No free place in storage id= " + storage.getId());
    }

    private void validateFormat(Storage storage, String fileFormat) throws Exception {
        for (String format : storage.getFormatsSupported()){
            if (format.equals(fileFormat))
                return;
        }
        throw new Exception(fileFormat + " is not supported in storage id= " + storage.getId());
    }

    private File findById(Storage storage, long id) throws Exception{
        for (File file : storage.getFiles()){
            if (file != null && file.getId() == id)
                throw new Exception("File " + id + "already use in storage id= " + storage.getId());
        }
        return null;
    }
}