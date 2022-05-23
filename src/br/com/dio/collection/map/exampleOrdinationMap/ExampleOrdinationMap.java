package br.com.dio.collection.map.exampleOrdinationMap;
/*Dadas as seguintes informações sobre meus livros favoritos e seus autores,
crie um dicionário e ordene este dicionário:
exibindo (Nome Autor - Nome Livro);
Autor = Hawking, Stephen  - Livro = nome: Uma Breve História do Tempo. páginas: 256
Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, paginas: 408
Autor = Harari, Yuval Noah  - Livro = 21 Lições Para o Século 21, páginas: 432
*/

import java.util.*;

public class ExampleOrdinationMap {
    public static void main(String[] args) {
        System.out.println("--\tRandom Order--\t");
        //random order is Hashmap
        Map<String, Book> myBooks = new HashMap<>(){{
            put("Hawking, Stephen", new Book("The story of time", 256));
            put("Duhigg, Charles", new Book("The power of habits", 408));
            put("Harari, Yuval Noah", new Book("21 lessons to the 21century", 432));
        }};
     for (Map.Entry<String, Book> book : myBooks.entrySet())
         System.out.println(book.getKey() + " - " + book.getValue().getName());

        System.out.println("--\tAdded order--\t");
        Map<String, Book> myBooks1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Book("The story of time", 256));
            put("Duhigg, Charles", new Book("The power of habits", 408));
            put("Harari, Yuval Noah", new Book("21 lessons to the 21century", 432));
        }};
        for (Map.Entry<String, Book> book : myBooks1.entrySet())
            System.out.println(book.getKey() + " - " + book.getValue().getName());

        System.out.println("--\tAuthors alphabetic order--\t");
        Map<String, Book> myBooks2 = new TreeMap<>(myBooks1);
        for (Map.Entry<String, Book> book : myBooks2.entrySet())
            System.out.println(book.getKey() + " - " + book.getValue().getName());


        System.out.println("--\tAlphabetic Order of the books--\t");
        Set<Map.Entry<String, Book>> myBooks3 = new TreeSet<>(new ComparatorName ()); //TreeSet to order, but first we need a comparator
        myBooks3.addAll(myBooks.entrySet());
        for (Map.Entry<String, Book> book : myBooks3)
            System.out.println(book.getKey() + " - " + book.getValue().getName());

        System.out.println("--\tBooks page order--\t");


    }
}

class Book {
    private String name;
    private Integer pages;

    public Book(String name, Integer pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public Integer getPages() {
        return pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name) && pages.equals(book.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pages);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
class ComparatorName implements Comparator<Map.Entry<String,Book>>{


    @Override
    public int compare(Map.Entry<String, Book> b1, Map.Entry<String, Book> b2) {

        return b1.getValue().getName().compareToIgnoreCase(b2.getValue().getName());
    }
}