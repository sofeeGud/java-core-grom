package lesson19.hw;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size) {
        this.id = id;
        try {
            if (name.length() > 10)
                throw new Exception("File name is too long, id=" + id);
            else this.name = name;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        this.format = format;
        this.size = size;
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
