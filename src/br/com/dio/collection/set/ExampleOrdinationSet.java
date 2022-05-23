package br.com.dio.collection.set;

/*Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de episódio);
Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
Série 3 = nome: that '70s show, genero: comédia, tempoEpisodio: 25
*/

import java.util.*;

public class ExampleOrdinationSet {
    public static void main(String[] args) {



        System.out.println("--\tRandom Order\t--");
        Set<Show> myShows = new HashSet<>(){{
            add(new Show("got", "fantasy",60));
            add(new Show("dark", "drama",60));
            add(new Show("that 70s show", "comedy",25));
        }};
        for (Show show: myShows) System.out.println(show.getName()+ " - " + show.getGenre() + " - " + show.getEpisodeTime());

        System.out.println("--\tAdded Order\t--");
        Set<Show> myShows1 = new LinkedHashSet<>(){{
            add(new Show("got", "fantasy",60));
            add(new Show("dark", "drama",60));
            add(new Show("that 70s show", "comedy",25));
        }};
        for (Show show: myShows1) System.out.println(show.getName()+ " - " + show.getGenre() + " - " + show.getEpisodeTime());

        System.out.println("--\tNatural Order (episode time)\t--");
        //i need a Comparable on the class Show to use TreeSet
        Set<Show> myShows2 = new TreeSet<>(myShows1);
        System.out.println(myShows2);

        System.out.println("--\tOrder by name, genre and time\t--");
        Set<Show> myShows3 = new TreeSet<>(new ComparatorNameGenreEpisodeTime()){{
            add(new Show("got", "fantasy",60));
            add(new Show("dark", "drama",60));
            add(new Show("that 70s show", "comedy",25));
        }};
        for (Show show: myShows3) System.out.println(show.getName()+ " - " + show.getGenre() + " - " + show.getEpisodeTime());



    }

}

class Show implements Comparable<Show> {
    private String name;
    private String genre;
    private static Integer episodeTime;

    //add a constructor alt insert to add the parameters


    public Show(String name, String genre, Integer episodeTime) {
        this.name = name;
        this.genre = genre;
        this.episodeTime = episodeTime;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public static Integer getEpisodeTime() {
        return episodeTime;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", episodeTime=" + episodeTime +
                '}';
    }
//a comparaçao vai do hashcode por nome, genero e episodio, e o equals verifica se tem um hashcode no objeto pesquisado
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return name.equals(show.name) && genre.equals(show.genre) && episodeTime.equals(show.episodeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, episodeTime);
    }

    @Override
    public int compareTo(Show show) {

        //when the time is equal, criterio de desempate:
        int episodeTime = Integer.compare(this.getEpisodeTime(), show.getEpisodeTime());
       if (episodeTime != 0) return episodeTime;
       return this.getGenre().compareTo(show.getGenre());
    }
}

class ComparatorNameGenreEpisodeTime implements Comparator<Show>{

    @Override
    public int compare(Show s1, Show s2) {
        int name = s1.getName().compareTo(s2.getName());
        if (name!= 0) return name;

        int genre = s1.getGenre().compareTo(s2.getGenre());
        if (genre!= 0) return genre;

        return Integer.compare(s1.getEpisodeTime(), s2.getEpisodeTime());

    }
}