import java.util.Scanner;

public class Main {
	public static String name;
	public static int id;

	public static String by;
	public static String term;

	public static Student student = null;
	public static Book book = null;
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		LibrarySystem.setupLibrary();

		getperson();
		getbook();

		while (!LibrarySystem.borrowBook(student, book)) {
			System.out.println("Book not borrowed.");
			System.out.println();
			getbook();
		}

		scan.close();
	}

	public static void getperson() {
		System.out.println();

		System.out.print("Enter student name: ");
		name = scan.nextLine();

		System.out.print("Enter student id: ");
		id = scan.nextInt();
		scan.nextLine();

		student = LibrarySystem.searchStudent(name, id);
		if (student == null) {
			getperson();
			return;
		}

		System.out.println("Borrowing books for " + student.name + " with ID: " + student.studentID);
		System.out.println();
	}

	public static void getbook() {
		System.out.print("Enter how you want to search (author, title): ");
		by = scan.nextLine();

		System.out.print("Enter search term: ");
		term = scan.nextLine();

		System.out.println();

		book = LibrarySystem.searchBook(by, term);
		if (book == null) {
			getbook();
			return;
		}
	}

}
