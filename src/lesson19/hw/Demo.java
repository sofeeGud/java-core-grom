package lesson19.hw;

public class Demo {
    public static void main(String[] args) {

        try{
            File file_1 = new File(1, "name_1", "doc", 1);
            File file_2 = new File(2, "name_2", "doc", 1);
            File file_3 = new File(3, "name_3", "rtf", 1);
            File file_4 = new File(4, "name_4", "rtf", 1);
            File file_5 = new File(5, "name_5", "doc", 1);

            File file_6 = new File(6, "name_6", "doc", 1);
            File file_7 = new File(7, "name_7", "doc", 1);
            File file_8 = new File(8, "name_8", "exe", 1);



            File[] files = new File[]{
                    file_1,
                    file_2,
                    file_3,
                    file_4,
            };

            String[] formats = new String[]{"doc", "rtf"};

            Storage storage_1 = new Storage(1, files, formats, "Ukraine", 55);

            Controller controller = new Controller();

            controller.put(storage_1, file_6);
            //controller.put(storage_1, file_7);

            System.out.println(storage_1.toString());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
