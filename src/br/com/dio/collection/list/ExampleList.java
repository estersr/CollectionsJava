package br.com.dio.collection.list;

// Given a 7 grades list of a student [7, 8.5, 9.3, 5, 7, 0, 3.6], do:

//      List grades = new ArrayList(); //before java 5
//      ArrayList<Double> grades = new ArrayList<>();
//      List<Double> grades = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        /*List<Double> grades = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        grades.add(10d);
        System.out.println(grades);*/
        /*List<Double> grades = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        grades.add(1d);
        grades.remove(5d);
        System.out.println(grades);*/


import java.util.*;

public class ExampleList {
    public static void main(String[] args) {
        List<Double> grades = new ArrayList<Double>();
        grades.add(7.0);
        grades.add(8.5);
        grades.add(9.3);
        grades.add(5.0);
        grades.add(7.0);
        grades.add(0.0);
        grades.add(3.6);
        System.out.println(grades.toString());

        System.out.println("Show the position of the 5.0 grade: " + grades.indexOf(5d));

        System.out.println("Add on the list the grade 8.0 on the 4th position: ");
        grades.add(4, 8d);
        System.out.println(grades);

        System.out.println("Replace grade 5.0 for 6.0: ");
        grades.set(grades.indexOf(5d), 6.0);
        System.out.println(grades);

        System.out.println("Check if grade 5.0 is on the list: " + grades.contains(5d));

        System.out.println("Show all grades with the presented order: ");
        for (Double grade: grades) System.out.println(grade);

        System.out.println("Show the third grade: " + grades.get(2));
        System.out.println(grades.toString());

        System.out.println("Show the lowest grade: " + Collections.min(grades));

        System.out.println("Show the highest grade: " + Collections.max(grades));

        Iterator<Double> iterator = grades.iterator();//ctrl alt v create a variable automatic
        Double addition = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            addition += next;
        }
        System.out.println("Show the addition of the grades: " + addition);

        System.out.println("Show the grade avarage: " + (addition/ grades.size()));

        System.out.println("Remove grade 0.0: ");
        grades.remove(0d);
        System.out.println(grades);

        System.out.println("Remove the grade from position 0: ");
        grades.remove(0);
        System.out.println(grades);

        System.out.println("Remove grades that are less than 7.0 and show a list: ");
        Iterator<Double> iterator1 = grades.iterator();
        while(iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(grades);

        System.out.println("Delete all the list: ");
        grades.clear();
        System.out.println(grades);

        System.out.println("Check if the list is empty: " + grades.isEmpty());
        


    }

}
