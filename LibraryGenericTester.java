import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * This class contains tests for LibraryGeneric.
 * 
 * @author Sarthak Goyal
 * @version January 16, 2019
 */
public class LibraryGenericTester {
	
	private LibraryGeneric<String> nameLib;  // library that uses names to identify patrons (holders)
	private LibraryGeneric<PhoneNumber> phoneLib;  // library that uses phone numbers to identify patrons
	private LibraryGeneric<String> customLib;
	private LibraryGeneric<String> sortLib;
	private LibraryGeneric<String> dateLib;
	
	
	@BeforeEach
	void setUp() throws Exception {
		nameLib = new LibraryGeneric<String>();
		nameLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		nameLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		nameLib.add(9780446580342L, "David Baldacci", "Simple Genius");
		nameLib.add(9781515383284L, "Charles Darwin", "On the Origin of Species");
		nameLib.add(9781607472209L, "Stephen Hawking", "A Brief History of Time");
		
		sortLib = new LibraryGeneric<String>();
		sortLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		sortLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		sortLib.add(9780446580342L, "David Baldacci", "Simple Genius");
		sortLib.add(9781607472209L, "Stephen Hawking", "A Brief History of Time");
		sortLib.add(9781515383284L, "Charles Darwin", "On the Origin of Species");

		phoneLib = new LibraryGeneric<PhoneNumber>();
		phoneLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		phoneLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		phoneLib.add(9780446580342L, "David Baldacci", "Simple Genius");	
		
		customLib = new LibraryGeneric();
		customLib.addAll("src/assign02/Mushroom_Publishing.txt");
		customLib.add(9781515383284L, "Charles Darwin", "On the Origin of Species");
		customLib.add(9791022301152L, "Plato", "Symposium");
		customLib.add(9781607472209L, "Stephen Hawking", "A Brief History of Time");
		
		dateLib = new LibraryGeneric();
		dateLib.addAll("src/assign02/Mushroom_Publishing.txt");
		dateLib.add(9781515383284L, "Charles Darwin", "On the Origin of Species");
		dateLib.add(9791022301152L, "Plato", "Symposium");
		dateLib.add(9781607472209L, "Stephen Hawking", "A Brief History of Time");
	}
	
	@Test
	public void testNameLibCheckout() {
		String patron = "Jane Doe";
		assertTrue(nameLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(nameLib.checkout(9780374292799L, patron, 1, 1, 2008));
	}

	@Test
	public void testNameLibLookup() {
		String patron = "Jane Doe";
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		ArrayList<LibraryBookGeneric<String>> booksCheckedOut = nameLib.lookup(patron);
		
		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}
	
	@Test
	public void testNameLibCheckin() {
		String patron = "Jane Doe";
		nameLib.checkout(9780330351690L, patron, 1, 1, 2008);
		nameLib.checkout(9780374292799L, patron, 1, 1, 2008);
		assertTrue(nameLib.checkin(patron));
	}

	@Test
	public void testPhoneLibCheckout() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		assertTrue(phoneLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(phoneLib.checkout(9780374292799L, patron, 1, 1, 2008));
	}

	@Test
	public void testPhoneLibLookup() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		phoneLib.checkout(9780330351690L, patron, 1, 1, 2008);
		phoneLib.checkout(9780374292799L, patron, 1, 1, 2008);
		ArrayList<LibraryBookGeneric<PhoneNumber>> booksCheckedOut = phoneLib.lookup(patron);
		
		assertNotNull(booksCheckedOut);
		assertEquals(2, booksCheckedOut.size());
		assertTrue(booksCheckedOut.contains(new Book(9780330351690L, "Jon Krakauer", "Into the Wild")));
		assertTrue(booksCheckedOut.contains(new Book(9780374292799L, "Thomas L. Friedman", "The World is Flat")));
		assertEquals(patron, booksCheckedOut.get(0).getHolder());
		assertEquals(patron, booksCheckedOut.get(1).getHolder());
	}

	@Test
	public void testPhoneLibCheckin() {
		PhoneNumber patron = new PhoneNumber("801.555.1234");
		phoneLib.checkout(9780330351690L, patron, 1, 1, 2008);
		phoneLib.checkout(9780374292799L, patron, 1, 1, 2008);
		assertTrue(phoneLib.checkin(patron));
	}
	@Test
	public void testCaseNameLibCheckout() {
		String patron = "Student";
		assertTrue(nameLib.checkout(9780330351690L, patron, 1, 1, 2008));
		assertTrue(nameLib.checkout(9781607472209L, patron, 1, 1, 2008));
	}
	@Test
	public void testGetInventoryList() {
		ArrayList<LibraryBookGeneric<String>> result = nameLib.getInventoryList();
		ArrayList<LibraryBookGeneric<String>> result02 = new ArrayList<LibraryBookGeneric<String>>();

		result02.add(new LibraryBookGeneric<String>(9780330351690L, "Jon Krakauer", "Into the Wild"));
		result02.add(new LibraryBookGeneric<String>(9780374292799L, "Thomas L. Friedman", "The World is Flat"));
		result02.add(new LibraryBookGeneric<String>(9780446580342L, "David Baldacci", "Simple Genius"));
		result02.add(new LibraryBookGeneric<String>(9781515383284L, "Charles Darwin", "On the Origin of Species"));
		result02.add(new LibraryBookGeneric<String>(9781607472209L, "Stephen Hawking", "A Brief History of Time"));
		
		Boolean flag = true;
		for(int i=0; i<result.size(); i++) {
			
			if (!(result.get(i).equals(result02.get(i)))) {
				flag = false;
			}
		}
		assertTrue(flag);
	}
	
	@Test
	public void testGetOverDueList() {
		nameLib.checkout(9780330351690L, "Student", 1,1,2017);
		ArrayList<LibraryBookGeneric<String>> result = nameLib.getOverdueList(1, 1, 2018);

		
		LibraryBookGeneric<String> book1 = new LibraryBookGeneric<>(9780330351690L, "Jon Krakauer", "Into the Wild");
		assertTrue(book1.equals(result.get(0)));

	}
	
	@Test
	public void testGetOverDueList01() {
		nameLib.checkout(9781515383284L, "Student01", 6,19,2006);
		ArrayList<LibraryBookGeneric<String>> result = nameLib.getOverdueList(8, 1, 2005);

		
		LibraryBookGeneric<String> book1 = new LibraryBookGeneric<>(9781515383284L, "Charles Darwin", "On the Origin of Species");
		assertTrue(book1.equals(result.get(0)));

	}
	
	@Test
	public void testGetOverDueList02() {		
		nameLib.checkout(9781607472209L, "Student02", 2,24,1776);
		ArrayList<LibraryBookGeneric<String>> result = nameLib.getOverdueList(3, 26, 1880);

		
		LibraryBookGeneric<String> book1 = new LibraryBookGeneric<>(9781607472209L, "Stephen Hawking", "A Brief History of Time");
		assertTrue(book1.equals(result.get(0)));

	}
	
	@Test
	public void testGetOrderedByTitle() {
		ArrayList<LibraryBookGeneric<String>> result = nameLib.getOrderedByTitle();
		ArrayList<LibraryBookGeneric<String>> result02 = new ArrayList<LibraryBookGeneric<String>>();
		
		result02.add(new LibraryBookGeneric<String>(9781607472209L, "Stephen Hawking", "A Brief History of Time"));
		result02.add(new LibraryBookGeneric<String>(9780330351690L, "Jon Krakauer", "Into the Wild"));
		result02.add(new LibraryBookGeneric<String>(9781515383284L, "Charles Darwin", "On the Origin of Species"));
		result02.add(new LibraryBookGeneric<String>(9780446580342L, "David Baldacci", "Simple Genius"));
		result02.add(new LibraryBookGeneric<String>(9780374292799L, "Thomas L. Friedman", "The World is Flat"));
		
		
		Boolean flag = true;
		for(int i=0; i<result.size(); i++) {
			
			if (!(result.get(i).equals(result02.get(i)))) {
				flag = false;
			}
		}
		assertTrue(flag);
	}
	
}
