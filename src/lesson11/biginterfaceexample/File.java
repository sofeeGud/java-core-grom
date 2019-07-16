package lesson11.biginterfaceexample;

public class File {

    private String name;
    private String path;
    private String extensial;
    private int size;

    public File(String name, String path, String extensial, int size) {
        this.name = name;
        this.path = path;
        this.extensial = extensial;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getExtensial() {
        return extensial;
    }

    public int getSize() {
        return size;
    }
}
