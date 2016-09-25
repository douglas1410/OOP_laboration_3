
import java.util.ArrayList;
import java.util.Collections;


public class CollectionOfBooks {
	private ArrayList<Book> bookCollections;
	
	/**
	* Constructor
	*/
	public CollectionOfBooks(){
		bookCollections = new ArrayList<Book>();
	}
	/**
	* Add book to the list
	* @param book The book object to add.
	*/
	public void addBook(Book book){
		bookCollections.add(book);
	}
	/**
	* Remove book from the list.
	* @param book The book to remove.
	* @return <CODE>true</CODE> if book was found and removed, <CODE>false</CODE> if not.
	*/
	public boolean removeBook(Book book){
		if(bookCollections.remove(book)){
			return true;
		}else{
		return false;
                }
	}
	
	/**
	* Get books with the given title.
	* @param title Title of the book(s) to get.
	* @return List of books with the given title.
	*/
	public ArrayList<Book> getBooksByTitle(String title){
		ArrayList<Book>CollectionByTitle =new ArrayList<Book>();
		CollectionByTitle.clear();
		for (Book b : bookCollections) {

			if(b.getTitle().toUpperCase().contains(title.toUpperCase())){
				CollectionByTitle.add(b);
			}
			Collections.sort(CollectionByTitle);

		}
		return CollectionByTitle;
	}
	
	/**
	* Get books with given author.
	* @param author Name of the author.
	* @return List of books with given author.
	*/
	public ArrayList<Book> getBooksByAuthor(String author){
		ArrayList<Book>CollectionByAuthor = new ArrayList<Book>();
		CollectionByAuthor.clear();

		for (Book book : bookCollections) {
			for (Author a : book.getAuthors()) {
				if (a.getName().toUpperCase().contains(author.toUpperCase())) {
					CollectionByAuthor.add(book);
				}

			}
			Collections.sort(CollectionByAuthor);
		}
		return CollectionByAuthor;
	}
	/**
	* Get list of the bookks with the same ISBN-number.
	* @param isbn ISBN-number of the book.
	* @return List of the books with the given ISBN-number.
	*/
	public ArrayList<Book> getBooksByIsbn(String isbn){
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
        /**
         * Get all books in the list.
         * @return Cloned list of all books.
         */
        public ArrayList<Book> getAllBooks() {
            return (ArrayList<Book>)bookCollections.clone();
        }
        
        /**
         * 
         * @return <CODE>true</CODE> if the collection is empty, <CODE>false</CODE> otherwise.
         */
        public boolean isEmpty() {
            return bookCollections.isEmpty();
        }
        
        
	@Override
	public String toString(){
		String info = bookCollections.toString();
		return info;
	}


}
