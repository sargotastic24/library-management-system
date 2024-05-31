/**
 * @author Sarthak Goyal
 */

import java.util.GregorianCalendar;

public class LibraryBook extends Book {
	private String Holder;
	private GregorianCalendar DueDate;
	private boolean Checked; //(checked in or out)
	
	//Required Methods: LibraryBook constructor, getHolder(), and getDueDate().
	
	//Constructor assumes there isn't a holder, duedate, and is checked in/out.
	public LibraryBook(long isbn, String author, String title) {
		
		super(isbn, author, title);
		Holder = null;
		DueDate = null;
		Checked = false;
	}
	//Gets person that has obtained the book
	public String getHolder() {
		return Holder;
		
	}
	// gets the books due date
	public GregorianCalendar getDueDate() {
		return DueDate;
		
	}
	//if the book is checked 
	public boolean bookChecked() {
		return Checked;
	}
	
	//Assumes the book is prior to checked out and is returned.
	public LibraryBook setCheckOut () {
		DueDate = null;
		Holder = null;
		Checked = false;
		return this;
	}
	//Checking the book out.
	public void setCheckOut(String holder, GregorianCalendar dueDate) {
		Checked = true;
		Holder = holder;
		DueDate = dueDate;
		
	}
}
