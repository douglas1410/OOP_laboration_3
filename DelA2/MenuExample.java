/** För inläsning vid val av meny-alternativ använder jag
 *	genomgående scan.nextLine(). När jag vill se ett 
 *	enskilt tecken använder jag charAt(int index) från 
 *	String-klassen.
 */

import java.util.Scanner;

public class MenuExample {

	private Scanner scan;

    public MenuExample() {
    	scan = new Scanner(System.in);
    }
    
    // Huvudloopen för menyn
    public void run() {
    	char choice = ' ';
    	String answer;
    	
    	do {
    		printMenu();
    		answer = scan.nextLine();
    		answer = answer.toUpperCase();
    		choice = answer.charAt(0); // Första tecknet i svaret
    		
    		switch(choice) {
    			case 'A':	doThis(); break;
    			case 'B':	doThat(); break;
    			case 'X':	System.out.println("Bye, bye!"); break;
    			default: 	System.out.println("Unknown command");
    		}
    		
    	} while(choice != 'X');
    }
    
    // Definierar ett "uppdrag"
    public void doThis() {
    	System.out.println("Doing this...");
    }
    
    // Definierar ett annat "uppdrag"
    public void doThat() {
    	System.out.println("Doing that...");
    }
    
    public void printMenu() {
    	System.out.println("---Menu---");
    	System.out.println("A Do This");
    	System.out.println("B Do That");
    	System.out.println("X Exit");
    	System.out.println("----------");
    }
    
    public static void main(String[] args) {
    	MenuExample menu = new MenuExample();
    	menu.run();
    }
}