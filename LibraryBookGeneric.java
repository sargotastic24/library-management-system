/**
 * @author Sarthak Goyal
 */

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book {
	private Type Holder;
	private GregorianCalendar DueDate;
	private boolean Checked; //(checked in or out)

	public LibraryBookGeneric(long isbn, String author, String title) {
		
		super(isbn, author, title);
		Holder = null;
		DueDate = null;
		Checked = false;
	}
	
	public Type getHolder() {
		return Holder;
		
	}
	
	public GregorianCalendar getDueDate() {
		return DueDate;
		
	}
	
	public boolean bookChecked() {
		return Checked;
	}
	
	//Assumes the book is prior to checked out and is returned. Also specifies Type parameter.
	public LibraryBookGeneric<Type> setCheckOut () {
		DueDate = null;
		Holder = null;
		Checked = false;
		return this;
	}
	//Checking the book out. Also specifies Type parameter.
	public LibraryBookGeneric<Type> setCheckOut(Type holder, GregorianCalendar dueDate) {
		Checked = true;
		Holder = holder;
		DueDate = dueDate;
		return this;
		
	}
}
