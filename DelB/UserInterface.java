package DelB;
import java.util.Scanner;
public class UserInterface {
	private CollectionOfBooks collectionOfBooks;
	private Scanner scan;
	public UserInterface(){
		scan = new Scanner(System.in);
		collectionOfBooks= new CollectionOfBooks();
	}
	
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
				
				break;
			case '2': System.out.println("remvove book");
				
				break;
			case '3': searchBookmenu();
				break;
				
			case '0': System.out.println("Exit !!!");
				break;

			default: System.out.println("Unknown commad");
				
			}
			
		}
		
	}
	public void searchBookmenu(){
		char searchChoice=' ';
		String answer;
		printBookMenu();
		answer=scan.nextLine();
		searchChoice= answer.charAt(0);
			
		switch (searchChoice) {
			case '1': System.out.println("search with title");
						
				break;
			case '2': System.out.println("search with author");
				
				break;
			case '3': System.out.println("search with ISBN");
				break;

			default: 
				System.out.println("Unknow commad");
				
		}

		
	}
	
	public void printMenu(){
		System.out.println("----CollectionsBookMenu----");
		System.out.println("1. Add a new book");
		System.out.println("2. Remove a book" );
		System.out.println("3. Search a book in Collection");
		System.out.println("0. Exit");
		System.out.println("---------------------------");
	}
	public void printBookMenu(){
		System.out.println("-----SearchBook------");
		System.out.println("1. With Title");
		System.out.println("2. With Author");
		System.out.println("3. With ISBN");
	}
	public void addBook(){
		Book temp=null;
		String input;
		String inputSplit[];
		
		System.out.println("Enter ");
		input=scan.nextLine();

		//temp = new Book(inputSplit[0], inputSplit[1],inputSplit[2],inputSplit[]);
		collectionOfBooks.addBook(temp);
		
	}
	
	
	public void getBookByTitle(String title){
		collectionOfBooks.getBooksByTitle(title);
	}
	
	
	public static void main(String[] args) {
	
		UserInterface u = new UserInterface();
		u.menu();
	}
}
