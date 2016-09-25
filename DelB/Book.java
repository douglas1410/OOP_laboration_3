package DelB;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
*
*/
public class Book implements Comparable<Book>, Serializable{
	
	private ArrayList<Author> authors;
	private String isbn;
	private	String title;
	private int edition;
	private double price;
	
	/**
	*Constructor
	*@param isbn ISBN-number of the book.
	*@param title Title of the book.
	*@param edition Edition of the book.
	*@param price Price of the book.
	*/
	public Book(String isbn ,String title, int edition, int price){
		this.isbn=isbn;
		this.title=title;
		this.edition=edition;
		this.price=price;
		authors = new ArrayList<Author>();



	}
	/**
	*Empty constructor.
	*/
	public Book(){

	}
	/**
	* Add author of the book.
	* @param author Name of the author.
	*/
	public void addAuthor(String author){
		authors.add(new Author(author));
	}
	/**
	* Get title of the book.
	* @return Title of the book.
	*/
	public String getTitle() {
		return title;
	}
	/**
	* Get ISBN-number of the book.
	* @return ISBN-number of the book.
	*/
	public String getIsbn() {
		return isbn;
	}

	/**
	*Get list of authors.
	*@return List of authors.
	*/
	public ArrayList<Author> getAuthors(){


		return (ArrayList<Author>) authors.clone();

	}
	/**
	*Compare title of this Book with another.
	@return 0 if titles are the same, -1 if this title is lexicographically less than the arguments title, 1 if this title is lexicographically greater than the arguments title
	*/
	@Override
	public int compareTo(Book o) {
		
		String title= this.title;
		String otherBook = o.title;
		int res = title.compareTo(otherBook);

		return res;
	}
	/**
	*See if books are equal.
	*@return true if books have the same ISBN-number, false if not.
	*/
	@Override
	public boolean equals(Object other){
		if(other instanceof Book){
			Book b= (Book) other;
			if(b.isbn.equals(isbn)){
				return true;
			}
		}
		return false;
	}
	/**
	*
	*/
	@Override
	public String toString(){
		String info="";
		String authorsofBook="";
		for (Author a : this.authors) {
				authorsofBook+=a.getName();

		}
		info = " "+ title +" "+ edition +" "+ isbn +" "+ price +" "+authorsofBook+"\n";
		return info;
	}





}
