package functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP2 {

    public static void main(String[] args) {
        /**
         * Book [title=The Trial, author=Franz Kafka, pages=240, type=NOVEL]
         * Book [title=Ancient Greece, author=Robert F., pages=435, type=HISTORY]
         * Book [title=Ancient Rome, author=Robert F., pages=860, type=HISTORY]
         * Book [title=The Stranger, author=Albert Camus, pages=560, type=NOVEL]
         * */

        List<Book> books = Arrays.asList(
                new Book("The Trial", "Franz Kafka", 240, Book.TYPE.NOVEL),
                new Book("Ancient Greece", "Robert F", 435, Book.TYPE.HISTORY),
                new Book("Ancient Rome", "Robert F.", 860, Book.TYPE.HISTORY),
                new Book("The Stranger", "Albert Camus", 560, Book.TYPE.NOVEL)
        );

        List<Book> output = books.stream().filter(s -> s.getTitle().split(" ").length == 2).collect(Collectors.toList());
        System.out.println(output);

    }
}

class Book {
    enum TYPE {
        NOVEL,
        HISTORY
    }

    private String title;
    private String author;
    private int pages;
    private TYPE type;

    public Book(String title, String author, int pages, TYPE type) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", type=" + type +
                '}';
    }
}
