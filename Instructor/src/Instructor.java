public class Instructor
{
    public long id;
    public String name, title, department;
    public book[] books;

    Instructor(long id, String name, String title, String department, book [] books)
    {
        this(id, name, title, department);
        this.books = books;
    }

    Instructor(long id, String name, String title, String department)
    {
        this(id, name, title);
        this.department = department;
    }

    Instructor(long id, String name, String title)
    {
        this(id, name);
        this.title = title;
    }

    Instructor(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getMostRecentBookTitle()
    {
        return books[books.length -1].getTitle();
    }

    public book updateBook(int index, String title)
    {
        book oldBook = new book (books[index].getTitle());
        books[index].setTitle(title);
        return oldBook;
    }

    public book updateBook(int index, book book)
    {
		book oldBook = books[index];
		books[index] = book;
		return oldBook;
    }

    public static void main(String [] args)
    {
        book book1 = new book ("Java for Beginners");
        book book2 = new book ("Scala for Beginners");
        book book3 = new book ("Effective Python");

        Instructor instructor = new Instructor(101, "John", "Assistant Professor",
                            "Computer Science", new book[] {book1, book2, book3});

        System.out.println(instructor.getMostRecentBookTitle());
        System.out.println("old book: " + instructor.updateBook(1, "Effective C#").getTitle());

        book book4 = new book ("Introduction to Data Mining");
        System.out.println("old book: " + instructor.updateBook(1, book4).getTitle());
    }
}