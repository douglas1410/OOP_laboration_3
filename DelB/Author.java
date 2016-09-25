package DelB;

import java.io.Serializable;
/**
*
*/
public class Author implements Serializable {
	
	private String name;
	
	/**
	*Constructor
	*@param name Name of the author.
	*/
	public Author(String name){
		this.name = name;
	}
	
	/**
	*Get name of the author.
	*@return Name of the author.
	*/
	public String getName(){
		return name;

}
