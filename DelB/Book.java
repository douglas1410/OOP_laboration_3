package DelB;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Book implements Comparable<Book>, Serializable{
	      private ArrayList<Author> authors;
	private String isbn;
	private	String title;
	private int edition;
	private double price;
	public Book(String isbn ,String title, int edition, int price){
		this.isbn=isbn;
		this.title=title;
		this.edition=edition;
		this.price=price;
		authors = new ArrayList<Author>();



	}
	public Book(){

	}
	public void addAuthor(String author){
		authors.add(new Author(author));
	}

	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}


	public ArrayList<Author> getAuthors(){


		return (ArrayList<Author>) authors.clone();

	}
	@Override
	public int compareTo(Book o) {
		String title= this.title;
		String otherBook = o.title;
		int res = title.compareTo(otherBook);

		return res;
	}

	public boolean equals(Object other){
		if(other instanceof Book){
			Book b= (Book) other;
			if(b.isbn.equals(isbn)){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		String info="";
		String authorsofBook="";
		for (Author a : this.authors) {
				authorsofBook+=a.getAuthor();

		}
		info = " "+ title +" "+ edition +" "+ isbn +" "+ price +" "+authorsofBook+"\n";
		return info;
	}





}
