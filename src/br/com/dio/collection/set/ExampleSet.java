package br.com.dio.collection.set;

// given 7 grades of a student [7, 8.5, 9.3, 5, 7, 0, 3.6], do:

//      Set grades = new HashSet(); //antes do java 5
//      HashSet<Double> grades = new HashSet<>();
//      Set<Double> grades = new HashSet<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
/*      Set<Double> grades = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        grades.add(1d);
        grades.remove(5d);
        System.out.println(grades);
*/

import java.util.*;

public class ExampleSet {
    public static void main(String[] args) {
        System.out.println("Create a group and add the grades: ");

        Set<Double> grades = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(grades.toString());

        System.out.println("Show grade 5.0 position: ");
        //hashset is a random order, you cant get something by position. cant use Get.

        System.out.println("Add to the list grade 8.0 to the position 4: ");
//hashset is a random order, you cant get something by position

        System.out.println("Replace grade 5 for grade 6.0: ");
//hashset is a random order, you cant get something by position

        System.out.println("Check if grade 5 is in the group: " + grades.contains(5d));

        System.out.println("Show the third added grade: ");
//hashset is a random order, you cant get something by position

        System.out.println("Show the lowest grade: " + Collections.min(grades));

        System.out.println("Show the highest grade: " + Collections.max(grades));

        Iterator<Double> iterator = grades.iterator();
        Double addition = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            addition += next;
        }
        System.out.println("Show the addition of the grades: " + addition);

        System.out.println("Average of the grades: " + (addition / grades.size()));

        System.out.println("Remove grade 0.0: ");
        grades.remove(0d);
        System.out.println(grades);

        Iterator<Double> iterator1 = grades.iterator();
        while(iterator1.hasNext());
        {
            Double Double = iterator1.next();
            if (Double < 7) iterator1.remove();
        }
        System.out.println("Remove grade from position 8: " + grades);
        System.out.println("Remove the grades less than 7 and show a list: ");

        System.out.println("Show the grades in the orded they were added");

        Set<Double> grades2 = new LinkedHashSet<>();
        grades2.add(7d);
        grades2.add(8.5);
        grades2.add(9.3);
        grades2.add(5d);
        grades2.add(0d);
        grades2.add(3.6);

        System.out.println("Show the ascending order of the grades: ");
        Set<Double> grades3 = new TreeSet<>(grades2);
        System.out.println(grades3);

        System.out.println("Delete all group");
        grades.clear();

        System.out.println("Check if the group is empty: " + grades2.isEmpty());
        System.out.println("Check if the group is empty: " + grades.isEmpty());
        System.out.println("Check if the group is empty: " + grades3.isEmpty());



    }
}
