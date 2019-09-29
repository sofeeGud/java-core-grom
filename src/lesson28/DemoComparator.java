package lesson28;

import java.util.ArrayList;
import java.util.Date;


public class DemoComparator {

    public static void main(String[] args){

        Capability capability2 = new Capability(1005, "test00", "nnnn", false, new Date());
        Capability capability1 = new Capability(1001, "test00", "nnnn", true, new Date(96584565));
        Capability capability3 = new Capability(900, "test01", "nnnn", true,new Date(652265) );
        Capability capability4 = new Capability(900, "test02", "aaaa", false, new Date());



        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);

        System.out.println(capabilities);
        capabilities.sort(new IsActiveComparator());
        System.out.println(capabilities);
        System.out.println("------------------------------------------------------");


        capabilities.sort(new DateComparator());
        System.out.println(capabilities);
        System.out.println("------------------------------------------------------");

        capabilities.sort(new FullComparator());
        System.out.println(capabilities);



    }
}
