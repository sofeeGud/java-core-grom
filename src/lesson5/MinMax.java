package lesson5;

import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        int[] array = {5,6,7,1,2};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));

    }

    static int[] sortAscending(int[] array){
        int temp;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[j] > array[i]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }

    static int[] sortDescending(int[] array){
        int t;
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array.length; j++){
                if(array[j] < array[i]){
                    t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
        }
        return array;

    }
}
