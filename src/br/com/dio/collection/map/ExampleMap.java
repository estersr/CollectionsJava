package br.com.dio.collection.map;
        /*
 Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
 modelo = gol - consumo = 14,4km/l
 modelo = uno - consumo = 15,6 km/l
 modelo = mobi - consumo = 16,1 km/l
 modelo = hb20 - consumo = 14,5 km/l
 modelo = kwid - consumo = 15,6 km/l
 */

//        Map carrosPopulares2020 = new HashMap(); //antes do java 5
//        Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
//        HashMap<String, Double> carrosPopulares = new HashMap<>();
//        Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)

import java.util.*;

import static javax.swing.UIManager.put;

public class ExampleMap {
    public static void main(String[] args) {
        System.out.println("Create a dictionary that connects the car models and consumption: ");
        //Type of key: string, type of value: double
        Map<String, Double> popularCars = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(popularCars.toString());

        System.out.println("Replace the consumption of the gol for 15,2 km/l: ");
        popularCars.put("gol",15.2);
        System.out.println(popularCars);

        System.out.println("Check if the model tucson is on the dictionary: " + popularCars.containsKey("tucson"));

        System.out.println("Show the uno consumption: " + popularCars.get("uno"));

        System.out.println("Show the third added model: "); //not possible.

        System.out.println("Show the models: ");
        Set<String> models = popularCars.keySet();
        System.out.println(models);

        System.out.println("Show the cars consumption: ");
        Collection<Double> consumptions = popularCars.values();
        System.out.println(consumptions);

        System.out.println("Show the model of the most economic car: ");
        Double highestConsumption = Collections.max(popularCars.values());
        System.out.println(highestConsumption);
        //now, to show the model of the car you need entrySet
        Set<Map.Entry<String, Double>> entries = popularCars.entrySet();
        String bestModel = "";
        for (Map.Entry<String, Double> entry: entries) {
            if (entry.getValue().equals(highestConsumption))bestModel = entry.getKey();
            System.out.println("Most efficient car: " + bestModel + " - " + highestConsumption);
        }
        System.out.println("Show the less economic model and its consumption: ");
        Double minorConsumption = Collections.min(popularCars.values());
        String lessEfficientModel = "";
//o entryset me permite manipular chaves e valores separadamente
        for (Map.Entry<String, Double> entry:popularCars.entrySet()) {
        if (entry.getValue().equals(lessEfficientModel))
            lessEfficientModel = entry.getKey();

        }
        System.out.println(lessEfficientModel + " - " + minorConsumption);



        Iterator<Double> iterator = popularCars.values().iterator();
        Double addition = 0d;
        while (iterator.hasNext()){
            addition += iterator.next();
        }
        System.out.println("Show the addition of consumptions: " + addition);


        System.out.println("Show the average of consumptions: " + (addition/popularCars.size()));
        System.out.println("Remove the car with consumption equal 15,1: ");

        Iterator<Double> iterator1 = popularCars.values().iterator();
        while (iterator1.hasNext()){
            if (iterator1.next().equals(15.6)) iterator1.remove();

        }
        System.out.println(popularCars);

        System.out.println("Show the added order of the models: ");
        Map<String, Double> popularCars1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(popularCars1.toString());

        System.out.println("show the dictionary by the models order: ");
        Map<String, Double> popularCars2 = new TreeMap<>(popularCars1);
        System.out.println(popularCars2.toString());

        System.out.println("Delete the car dictionary: ");
        popularCars.clear();

        System.out.println("check if the disctionary is empty: " + popularCars.isEmpty());

    }
}
