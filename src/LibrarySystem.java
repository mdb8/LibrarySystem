import java.util.ArrayList;

public class LibrarySystem {

	static ArrayList<Book> library = new ArrayList<Book>();
	static ArrayList<Student> studentDatabase = new ArrayList<Student>();

	public static void setupLibrary() {
		library.add(new Book("Dune", "Herbert", "0001"));
		library.add(new Book("Hobbit", "Tolkien", "0002"));
		library.add(new Book("1984", "Orwell", "0003"));
		library.add(new Book("Brave New World", "Huxley", "0004"));
		library.add(new Book("Foundation", "Asimov", "0005"));
		library.add(new Book("Neuromancer", "Gibson", "0006"));
		library.add(new Book("Snow Crash", "Stephenson", "0007"));
		library.add(new Book("The Moon is a Harsh Mistress", "Heinlein", "0008"));
		library.add(new Book("The Left Hand of Darkness", "Le Guin", "0009"));

		
		studentDatabase.add(new Student("Mason", 1));
		studentDatabase.add(new Student("Steve", 2));
		studentDatabase.add(new Student("Bob", 3));
		studentDatabase.add(new Student("Joe", 4));
		studentDatabase.add(new Student("Jane", 5));
		studentDatabase.add(new Student("Larry", 6));

		System.out.println("Library System History:");
		System.out.println();

		borrowBook(searchStudent("Steve", 3), searchBook("author", "Asimov"));
		borrowBook(searchStudent("Jane", 4), searchBook("title", "1984"));
		borrowBook(searchStudent("Bob", 1), searchBook("title", "Dune"));
		borrowBook(searchStudent("Mason", 2), searchBook("author", "Tolkien"));
		borrowBook(searchStudent("Larry", 5), searchBook("title", "Neuromancer"));

	}

	public static boolean borrowBook(Student student, Book book) {
		if (!book.isAvailable) {
			System.out.println(book.bookname + " is not available.");
			return false;
		}

		student.borrowedBooks.add(book);
		book.isAvailable = false;

		System.out.println(student.name + " borrowed " + book.bookname + ".");

		return true;
	}

	public static Book searchBook(String By, String searchTerm) {

		if (!By.equals("title") && !By.equals("author")) {
			System.out.println("Invalid search type. Please enter 'title' or 'author'.");
			return null;
		}

		Book book = null;

		for (Book bk : library) {
			if (searchTerm.equals(By.equals("title") ? bk.bookname : bk.bookauthor)) {
				book = bk;
			}
		}

		if (book == null) {
			System.out.println("Book not found. Please try again.");
			return null;
		}

		System.out.println("Book found: " + book.bookname + " by " + book.bookauthor + " ISBN: " + book.isbn);
		return book;
	}

	public static Student searchStudent(String Name, int Id) {

		Student student = null;

		for (Student std : studentDatabase) {

			if (std.studentID == Id && std.name.equals(Name)) {
				student = std;
			} else if (std.studentID == Id && !std.name.equals(Name)) {
				System.out.println("Entered Name does not match valid entered ID.");
				System.out.println("Please enter the correct Name for the entered ID,");
				System.out.println("or choose a different ID for the entered Name.");
				return null;
			} else if (std.name.equals(Name) && std.studentID != Id) {
				System.out.println("Entered ID does not match valid entered Name.");
				System.out.println("Please enter the correct ID for the entered Name,");
				System.out.println("or choose a different Name for the entered ID.");
				return null;
			}
		}

		if (student == null) {
			studentDatabase.add(new Student(Name, Id));
			System.out.println("Student not found. New student added.");
			return searchStudent(Name, Id);
		}

		return student;
	}

}