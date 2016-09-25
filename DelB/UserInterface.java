import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Usier interface for CollectionOfBooks.
 * @author Vilhelm och Douglas
 */
public class UserInterface {
	private CollectionOfBooks collectionOfBooks;
	private Scanner scan;
	public UserInterface(){
		scan = new Scanner(System.in);
                
                try {
                    collectionOfBooks= new CollectionOfBooks();
                    deSerializeFromFile("books.ser");
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
	}
	
        /**
         * Print first menu and listen for the users choice.
         */
	public void menu(){
		char choice=' ';
		
		String answer;
		while(choice!='0'){
			printMenu();
			answer=scan.nextLine();
			answer=answer.toUpperCase();
			choice=answer.charAt(0);
			
			switch (choice) {
			case '1': System.out.println("add book");
				addBook();
				break;
			case '2': System.out.println("remvove book");
				removeBook();
				break;
			case '3': searchBookmenu();
				break;
			
                        case '4': System.out.println("List all books.");
                                listAllBooks();
                                
			case '0': System.out.println("Exit !!!");
                                try {
                                    serializeToFile("books.ser");
                                } catch (Exception e) {
                                    System.out.println("Error");
                                }
				break;

			default: System.out.println("Unknown commad");
				
			}
			
		}
		
	}
        /**
         * Print the "Search-book-menu" and listen for the users choice.
         */
	public void searchBookmenu(){
		char searchChoice=' ';
		String answer;
		printBookMenu();
		answer=scan.nextLine();
		searchChoice= answer.charAt(0);
			
		switch (searchChoice) {
			case '1': System.out.println("search with title");
                                searchBooksByTitle();
				break;
			case '2': System.out.println("search with author");
				searchBooksByAuthor();
				break;
			case '3': System.out.println("search with ISBN");
				searchBooksByIsbn();
                                break;
                                
			default: 
				System.out.println("Unknown command");
				
		}

		
	}
	/**
         *  Print the menu.
         */
	public void printMenu(){
		System.out.println("----CollectionsBookMenu----");
		System.out.println("1. Add a new book");
		System.out.println("2. Remove a book" );
		System.out.println("3. Search a book in collection");
                System.out.println("4. List all books in collection.");
		System.out.println("0. Exit");
		System.out.println("---------------------------");
	}
        /**
         * Print the book menu.
         */
	public void printBookMenu(){
		System.out.println("-----SearchBook------");
		System.out.println("1. With Title");
		System.out.println("2. With Author");
		System.out.println("3. With ISBN");
	}
        /**
         * Add book to collectionOfBooks.
         */
	public void addBook(){
		
                Book book;
                String isbn;
                String title;
                int edition;
                int price;
                int noOfAuthors;
                
		System.out.println("Enter ISBN");
		isbn = scan.nextLine();
                System.out.println("Enter title");
                title = scan.nextLine();
                System.out.println("Enter edition");
                edition = Integer.parseInt(scan.nextLine());
                System.out.println("Enter price");
                price = Integer.parseInt(scan.nextLine());
                
                book = new Book(isbn, title, edition, price);
                
                System.out.println("Enter number of authors");
                while (true) {
                    if (scan.hasNextInt()) {
                        noOfAuthors = Integer.parseInt(scan.nextLine());
                        break;
                    } else {
                        System.out.println("Enter number of authors");
                        scan.nextLine();
                    }
                }
                
                for(int i = 0; i < noOfAuthors; i++) {
                    System.out.println("Enter author no. " + (i + 1));
                    book.addAuthor(scan.nextLine());
                }
                
                collectionOfBooks.addBook(book);
                System.out.println("\"" + book.getTitle() + "\" added.");
	}
        
        /**
         * Ask user for book title. Remove books with given title and print result.
         */
        public void removeBook() {
            
            ArrayList<Book> books;
            String title;
            
            System.out.println("Enter title of the book(s) to be removed");
            title = scan.nextLine();
            
            books = collectionOfBooks.getBooksByTitle(title);
            
            for (Book book : books) {
                
                if (collectionOfBooks.removeBook(book)) {
                    System.out.println("\"" + book.getTitle() + "\" removed.");
                } else {
                    System.out.println("Couldn't find \"" + book.getTitle() + "\"");
                }
                
            }
        }
	
	/**
         * Ask user for title, print books with given title.
         */
	public void searchBooksByTitle(){
                
                String title;
                ArrayList<Book> books;
                
                System.out.println("Enter title");
                title = scan.nextLine();
                
                books = collectionOfBooks.getBooksByTitle(title);
                
                if (books.isEmpty()) {
                    System.out.println("No books found.");
                } else {
                    for(Book book : books) {
                        System.out.println(book.toString());
                    }
                }
	}
        /**
         * Ask user for ISBN, print books with given ISBN.
         */
        public void searchBooksByIsbn(){
                
                String isbn;
                ArrayList<Book> books;
                
                System.out.println("Enter ISBN");
                isbn = scan.nextLine();
                
                books = collectionOfBooks.getBooksByIsbn(isbn);
                
                if (books.isEmpty()) {
                    System.out.println("No books found.");
                } else {
                    for(Book book : books) {
                        System.out.println(book.toString());
                    }
                }
	}
        
        /**
         * Ask user for author, print books by given author.
         */
        public void searchBooksByAuthor(){
                
                String author;
                ArrayList<Book> books;
                
                System.out.println("Enter Author");
                author = scan.nextLine();
                
                books = collectionOfBooks.getBooksByAuthor(author);
                
                if (books.isEmpty()) {
                    System.out.println("No books found.");
                } else {
                    for(Book book : books) {
                        System.out.println(book.toString());
                    }
                }
	}
        
        /**
         * Print all books in collection.
         */
        public void listAllBooks() {
            
            ArrayList<Book> books;
            
            if (collectionOfBooks.isEmpty()) {
                System.out.println("No books found.");
            } else {
                
                books = collectionOfBooks.getAllBooks();
                
                for (Book book : books) {
                    System.out.println(book.toString());
                }
            }
        }
	
         /**
	 * Call this method before the application exits, to store the books, 
	 * in serialized form, on file the specified file.
	 */
	public void serializeToFile(String filename) throws IOException {
		
		ObjectOutputStream out = null;
		ArrayList<Book> books = collectionOfBooks.getAllBooks();
                
		try {
			out = new ObjectOutputStream(
			new FileOutputStream(filename));
			out.writeObject(books);
		}
		finally {
			try {
				if(out != null)	out.close();
			} catch(Exception e) {System.out.println(e.toString());}
		}
	}
        
        /**
         * @param filename Name of the file to read.
         * @throws java.io.IOException
         * @throws java.lang.ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public void deSerializeFromFile(String filename) throws IOException, ClassNotFoundException {
		
		ObjectInputStream in = null;
                ArrayList<Book> books;
		
		try {
			in = new ObjectInputStream(
			new FileInputStream(filename));
			// readObject returns a reference of type Object, hence the down-cast
			books = (ArrayList<Book>) in.readObject();
                        
                        for (Book book : books) {
                            collectionOfBooks.addBook(book);
                        }
		}
		finally {
			try {
				if(in != null)	in.close();
			} catch(Exception e) { System.out.println(e.toString());}	
		}
	}
	/**
         * Main method.
         * @param args Not used
         */
	public static void main(String[] args) {
	
		UserInterface u = new UserInterface();
		u.menu();
	}
}
