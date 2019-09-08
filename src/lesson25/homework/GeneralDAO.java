package lesson25.homework;

public class GeneralDAO<T> {

    @SuppressWarnings("unchacked")
    private T[] array = (T[]) new Object[10];


    public T save(T t) throws Exception {

        validate(t);

        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }

        throw new Exception("Not found place");
    }

    public T[] getAll() {

        int len = 0;
        for (T el : array) {
            if (el != null)
                len++;
        }


        T[] arGetAll = (T[]) new Object[len];

        if (len == 0)
            return arGetAll;

        int i = 0;
        for (T el : array) {
            if (el != null) {
                arGetAll[i] = el;
                i++;
            }
        }
        return arGetAll;
    }

    private void validate(T t) throws Exception {

        if (t == null)
            throw new Exception(t + " don't save. It's null");

        for (T el : array)
            if (t.equals(el))
                throw new Exception(t + " already used");
    }
}