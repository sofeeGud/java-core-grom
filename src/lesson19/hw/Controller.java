package lesson19.hw;

public class Controller {

    public static File[] put(Storage storage, File file){

        return storage.put(file);
    }

    public static boolean delete(Storage storage, File file){
        return storage.delete(file);
    }
    public static File transferAll(Storage storageFrom, Storage storageTo){
        return null;
    }
    public static File transferFile(Storage storageFrom, Storage storageTo, long id){
        return null;
    }

}
