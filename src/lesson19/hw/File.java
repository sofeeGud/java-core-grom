package lesson19.hw;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size)throws Exception {


            if (name.length() <= 10) {
                this.name = name;
                this.format = format;
                this.size = size;
                this.id = id;
            }
           else {
                throw new Exception("Can not create file. File name is too long, id = " + id);
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
