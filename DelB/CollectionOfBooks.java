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


}
