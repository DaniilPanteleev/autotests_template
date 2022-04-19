package autotests.template.taskOop.three;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private int ticket;
    private String burnDate;
    private String phoneNumber;
    List<String> list = new ArrayList<>();
    private int countBook;

    public Reader(String name, int ticket, String burnDate, String phoneNumber) {
        this.name = name;
        this.ticket = ticket;
        this.burnDate = burnDate;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(){
        countBook++;
        System.out.println(this.name + " Взял кингу");
        System.out.println();
    }

    public void returnBook(){
        countBook--;
        System.out.println(this.name + " Вернул книгу");
        System.out.println();
    }

    public void takeBook(int countBook){
        this.countBook = countBook;
        System.out.println(this.name + " Взял "+ countBook + " Книги");
        System.out.println();
    }

    public void returnBook(int countBook){
        this.countBook = countBook;
        System.out.println(this.name + " Вернул "+ countBook + " Книги");
        System.out.println();
    }
    public void takeBook(String... nameBook){
        for (String book : nameBook) list.add(book);

        System.out.println(this.name + " Взял Книги" + this.list);
        System.out.println();
        list.clear();
    }

    public void returnBook(String... nameBook){
        for (String book : nameBook) list.add(book);

        System.out.println(this.name + " Вернул Книги" +this.list );
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.println(this.name + " взял книги:");
        for (Book book : books) {
            System.out.println(book.getNameBook() + ", автор - " + book.getNameAuthor());
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.println(this.name + " вернул книги:");
        for (Book book : books) {
            System.out.println(book.getNameBook() + ", автор - " + book.getNameAuthor());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Reader reader1 = new Reader("Иванов И.И", 1,  "21.10.2005", "+88005553535");
        Reader reader2 = new Reader("Сидоров В.М", 2,  "11.11.2001", "+89080423542");
        Reader reader3 = new Reader("Смирнов Д.Н", 3,  "05.04.1999", "+87645823493");
        Book book1 = new Book("Ты лох", "Лох");
        Book book2 = new Book("Ты пидр", "Пидр");
        Book book3 = new Book("Ты уебок", "Уебок");
        reader1.takeBook(5);
        reader2.takeBook("Рецепты от бабушки агафьи, Агафья", "Познание, Идущий к реке");
        reader3.takeBook(book1, book2,book3);
        reader1.returnBook(1);
        reader2.returnBook("Рецепты от бабушки агафьи, Агафья");
        reader3.returnBook(book3);
    }
}
