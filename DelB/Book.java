package DelB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	
	
	
	public static void main(String[] args) throws IOException {
		Book b = new Book("12345","Java",1,200);
		b.addAuthor("Douglas");
		b.addAuthor("Danny");
		FileOutputStream bookFileOut= null;
		try {
			 bookFileOut = new FileOutputStream("/tmp/Book.ser");
			ObjectOutputStream out = new ObjectOutputStream(bookFileOut);
			out.writeObject(b);
			
			out.close();
		} catch (Exception e) {
			e.printStackTrace();;
		} finally {
			bookFileOut.close();
		}
			
		
		Book Ob = null;
		FileInputStream bookFileIn = null;
		try {
			 bookFileIn = new FileInputStream("/tmp/Book.ser");
			ObjectInputStream in = new ObjectInputStream(bookFileIn);
			Ob= (Book) in.readObject();
			in.close();
			
		} catch (Exception i) {
			System.out.println("Book not found");
			
		}finally {
				bookFileIn.close();

		}
		
		System.out.println(Ob.toString());
		
	}
}
