package lesson19.hw;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) {

        try {
            if (name.length() <= 10){
                this.name = name;
                this.format = format;
                this.size = size;
                this.id = id;
            } else throw new Exception("File name is too long, id=" + id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
//            System.exit(0);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }
}
