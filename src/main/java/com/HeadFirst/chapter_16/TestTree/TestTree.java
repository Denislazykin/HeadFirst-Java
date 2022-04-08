package main.java.com.HeadFirst.chapter_16.TestTree;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново свое тело");
        Book b3 = new Book("В поисках Эмо");
        BookCompare bookCompare = new BookCompare();
        TreeSet<Book> tree = new TreeSet<>(bookCompare);
        tree.add(new Book("Как устроены кошки"));
        tree.add(new Book("Постройте заново свое тело"));
        tree.add(new Book("В поисках Эмо"));
        System.out.println(tree);

    }

    public static class BookCompare implements Comparator<Book> {
        public int compare(Book one, Book two) {
            return (one.title.compareTo(two.title));
        }
    }

    static class Book implements Comparable<Book> {
        String title;

        public Book(String t) {
            title = t;
        }

        @Override
        public int compareTo(Book o) {
            Book book = (Book) o;
            return (title.compareTo(book.title));
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}