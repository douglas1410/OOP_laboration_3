package DelB;

import java.util.ArrayList;
import java.util.Collections;

	
public class CollectionOfBooks {
	private ArrayList<Book> bookCollections;

	public CollectionOfBooks(){
		bookCollections = new ArrayList<Book>();
	}
	public void addBook(Book book){
		bookCollections.add(book);
	}
	public boolean removeBook(Book book){
		if(bookCollections.remove(book)){
			return true;
		}else{
			System.out.println("Book not found");
		}
		return false;
	}
	public ArrayList<Book> getBooksByTitle(String Title){
		ArrayList<Book>CollectionByTitle =new ArrayList<Book>();
		CollectionByTitle.clear();
		for (Book b : bookCollections) {
			
			if(b.getTitle().toUpperCase().contains(Title.toUpperCase())){
				CollectionByTitle.add(b);
			}
			Collections.sort(CollectionByTitle);
			
		}
		return CollectionByTitle;
	}
	public ArrayList<Book> getBookByAuthor(String author){
		ArrayList<Book>CollectionByAuthor = new ArrayList<Book>();
		CollectionByAuthor.clear();

		for (Book book : bookCollections) {
			for (Author a : book.getAuthors()) {
				if (a.getAuthor().toUpperCase().contains(author.toUpperCase())) {
					CollectionByAuthor.add(book);
				}
				
			}
			Collections.sort(CollectionByAuthor);
		}
		return CollectionByAuthor;
	}
	public ArrayList<Book> getBookByIsbn(String isbn){
		ArrayList<Book>CollectionByIsbn = new ArrayList<Book>();
		CollectionByIsbn.clear();
		
			for (Book book : bookCollections) {
				if(book.getIsbn().toUpperCase().contains(isbn.toUpperCase())){
					CollectionByIsbn.add(book);
				}
			}
			Collections.sort(CollectionByIsbn);
		return CollectionByIsbn;

	}
	public String toString(){
		String info = bookCollections.toString();
		return info;
	}
	public static void main(String[] args) {
		CollectionOfBooks c = new CollectionOfBooks();
		Book tmp = null;
		tmp = new Book("1234", "Foretagsekonomi", 1, 200);
		tmp.addAuthor("Douglas");
		tmp.addAuthor("Danny");
		c.addBook(tmp);
		tmp = new Book("1235", "Foretag och Samhallet", 1, 500);
		tmp.addAuthor("Deck");
		tmp.addAuthor("Donal");
		c.addBook(tmp);
		tmp=new Book("2312","Finasering" , 2, 700);
		tmp.addAuthor("Douglas");
		tmp.addAuthor("Martin");
		c.addBook(tmp);
		tmp =new Book("2345", "Animal Planet", 4, 200);
		tmp.addAuthor("Douglas");
		tmp.addAuthor("Fredrik");
		c.addBook(tmp);
		
		System.out.println(c.toString());
		System.out.println(c.getBookByAuthor("Martin"));
		System.out.println(c.getBookByIsbn("1234").toString());
		System.out.println(c.getBooksByTitle("f").toString());
	}

}
