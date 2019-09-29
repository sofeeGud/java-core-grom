
package lesson25;

public class GeneralDAO <T extends IdEntity> {

    private T[] array = (T[]) new Object[10];


  /*  private void print(lesson27.Order order) {
        System.out.println("order is: " + order.toString());

    }

    public <T extends IdEntity> void validate(T t) throws Exception {

        if (t.getId() <= 0)
            throw new Exception("id can't be negative");
    }

    public <K> void validate(K k) {
        if (k.equals(100)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }*/

    public T save(T t) throws Exception{
        if (t == null)
            throw new Exception("null");

        validate(t);
        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }

        throw new Exception("error");
    }

    private T validate(T t) throws Exception{

        if (t == null)
            throw new Exception("null");

        for (T el : array)
            if (el.getId() == t.getId())
                throw new Exception("Id already used: " +el.getId());

        return t;

    }


    T[] getAll(){
    return null;
    }


}
