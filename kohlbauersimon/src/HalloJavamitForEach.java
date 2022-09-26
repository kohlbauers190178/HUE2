import java.util.ArrayList;

public class HalloJavamitForEach {

    public static void main(String[] args){

        ArrayList<String> list = new ArrayList<>();

        list.add("string1");
        list.add("string2");
        list.add("string3");
        list.add("string4");

        for (String s : list) {
            System.out.println(s);
        }

        list.forEach((s)->System.out.println(s));

        list.forEach(System.out::println);


    }

}
