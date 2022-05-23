package br.com.dio.collection.list;

import javax.print.attribute.standard.JobName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
given the info about my cats, write a list and order it by
name, age and color

Cat 1 = name: Jon, age: 18, color: black
cat 2 = name: Simba, age: 6, color: tiger
cat 3 = name: Jon, age: 12, color: yellow
 */
public class ExampleOrdinationList {
    public static void main(String[] args) {
        List<Cat> myCats = new ArrayList<>() {{
            add(new Cat("Jon", 18, "black"));
            add(new Cat("Simba", 6, "tiger"));
            add(new Cat("Jon", 12, "yellow"));
        }};
        System.out.println(myCats);

        System.out.println("-- \tRandom order\t---");
        Collections.shuffle(myCats);
        System.out.println(myCats);

        System.out.println("-- \tNatural order (name)\t---");
        Collections.sort(myCats); //to use sort, u need a comparable method first
        System.out.println(myCats);

        System.out.println("-- \tAge order\t---");
        //Collections.sort(myCats, new ComparatorAge());
        myCats.sort(new ComparatorAge());
        System.out.println(myCats);

        System.out.println("-- \tColor order\t---");
        myCats.sort(new ComparatorColor());
        System.out.println(myCats);

        System.out.println("-- \tName, color and Age order\t---");
        myCats.sort(new ComparatorNameColorAge());
        System.out.println(myCats);






    }
}

class Cat implements Comparable<Cat> { //alt enter para implementar os methods
    private String name;
    private Integer age;
    private String color;

    //alt insert create a construtctor


    public Cat(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cat cat) {
        return this.getName().compareToIgnoreCase(cat.getName());
    }
}

class ComparatorAge implements Comparator<Cat> {

    @Override
    public int compare(Cat g1, Cat g2) {
        return Integer.compare(g1.getAge(), g2.getAge());
    }
}

class ComparatorColor implements Comparator<Cat>{
@Override
public int compare (Cat g1, Cat g2) {

    return g1.getColor().compareToIgnoreCase(g2.getColor());

}
}

class ComparatorNameColorAge implements Comparator<Cat>{
    @Override
    public int compare (Cat g1, Cat g2) {
        int name = g1.getName().compareToIgnoreCase(g2.getName());
        if (name != 0) return name;

        int color = g1.getColor().compareToIgnoreCase(g2.getColor());
        if (color != 0) return color;

        return Integer.compare(g1.getAge(), g2.getAge());
    }
}