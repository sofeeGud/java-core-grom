package lesson19.hw;

public class Demo {
    public static void main(String[] args) {

        try {
            File file_1 = new File(1, "name_1", "doc", 1);
            File file_2 = new File(2, "name_2", "doc", 1);
            // File file_2 = new File(2, "null", "doc", 1);
            //File file_2 = null;
            File file_3 = new File(3, "name_3", "rtf", 1);
            File file_4 = new File(4, "name_4", "rtf", 1);
            //File file_4 = new File(4, "name_4", "exe", 15);
            //File file_4 = new File(2, "name_4", "win", 1);
            File file_5 = new File(5, "name_5", "doc", 1);

            File file_6 = new File(6, "name_6", "doc", 1);
            File file_7 = new File(7, "name_7", "doc", 1);
            File file_8 = new File(8, "name_8", "exe", 1);
            File file_9 = new File(9, "name_9", "exe", 1);
            File file_10 = new File(10, "name_10", "exe", 1);
            File file_11 = new File(11, "name_11", "exe", 1);
            File file_12 = new File(12, "name_12", "exe", 1);
            File file_13 = new File(13, "name_13", "exe", 1);
            File file_14 = new File(14, "name_14", "exe", 1);


            File[] files = new File[4];
            File[] files_2 = new File[6];
            File[] files_3 = new File[3];
            File[] files_4 = new File[3];

            String[] formats = new String[]{"doc", "rtf", "exe"};

            Storage storage_1 = new Storage(1, files, formats, "Ukraine", 5);
            Storage storage_2 = new Storage(2, files_2, formats, "Russia", 15);
            Storage storage_3 = new Storage(3, files_3, formats, "Greece", 15);
            Storage storage_4 = new Storage(4, files_4, formats, "US", 15);

            Controller controller = new Controller();

            controller.put(storage_1, file_1);
            controller.put(storage_1, file_2);
            //controller.delete(storage_1, file_1);
            controller.put(storage_1, file_3);
            controller.put(storage_1, file_4);

            controller.put(storage_2, file_5);
            controller.put(storage_2, file_6);

            controller.put(storage_3, file_7);
            controller.put(storage_3, file_8);
            controller.put(storage_3, file_9);
            //controller.delete(storage_3, file_7);
            //controller.delete(storage_3, file_8);


            /*Sys.out.println(storage_1.toString());
            Sys.out.println(storage_2.toString());
            Sys.out.println(storage_3.toString());
            Sys.out.println(storage_4.toString());*/

            controller.transferAll(storage_1, storage_2);
            //controller.transferAll(storage_2, storage_3);
            controller.transferAll(storage_3, storage_4);
            System.out.println(storage_1.toString());
            System.out.println(storage_2.toString());
            System.out.println(storage_3.toString());
            System.out.println(storage_4.toString());

            /*controller.transferFile(storage_1, storage_2, 1);
            controller.transferFile(storage_3, storage_4, 9);
            Sys.out.println(storage_1.toString());
            Sys.out.println(storage_2.toString());
            Sys.out.println(storage_3.toString());
            Sys.out.println(storage_4.toString());*/

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }


}
