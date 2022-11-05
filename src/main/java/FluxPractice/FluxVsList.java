package FluxPractice;

import FluxPractice.Helper.NameGenerator;
import MonoPractice.util.Util;

import java.util.List;

//FLUX VS LIST
public class FluxVsList {
    public static void main(String[] args) {

        List<String> names = NameGenerator.getNamesList(5); //gives 5 names after 10 sec
        System.out.println(names +  "\n");
        System.out.println("===========\n");

       NameGenerator.getNamesFlux(5) //gives data one by one every 2 sec
                .subscribe(
                        Util.onNext()
                );
    }

}
