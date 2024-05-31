import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * This class contains tests for Library.
 * 
 * @author Sarthak Goyal
 * @version January 16, 2019
 */
public class LibraryTester {

	private Library emptyLib, smallLib, mediumLib;
	
	@BeforeEach
	void setUp() throws Exception {
		
		emptyLib = new Library();
		
		smallLib = new Library();
		smallLib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
		smallLib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
		smallLib.add(9780446580342L, "David Baldacci", "Simple Genius");

		mediumLib = new Library();
		mediumLib.addAll("src/assign02/Mushroom_Publishing.txt");
		mediumLib.add(9780450054785L, "Stephen King", "The Shining");
		mediumLib.add(9782738212795L, "Stephen King", "The Green Mile");
		mediumLib.add(9781101154922L, "Stephen King", "It");
		mediumLib.add(9781977648907L, "Henry David Thoreau", "Walden");
		mediumLib.add(9781515383284L, "Charles Darwin", "On the Origin of Species");
		mediumLib.add(9791022301152L, "Plato", "Symposium");
		mediumLib.add(9781607472209L, "Stephen Hawking", "A Brief History of Time");
		
		
	}

	@Test
	public void testEmptyLookupISBN() {
		assertNull(emptyLib.lookup(978037429279L));
	}
	
	@Test
	public void testEmptyLookupHolder() {
		ArrayList<LibraryBook> booksCheckedOut = emptyLib.lookup("Jane Doe");
		assertNotNull(booksCheckedOut);
		assertEquals(0, booksCheckedOut.size());
	}
	
	@Test
	public void testEmptyCheckout() {
		assertFalse(emptyLib.checkout(978037429279L, "Jane Doe", 1, 1, 2008));
	}

	@Test
	public void testEmptyCheckinISBN() {
		assertFalse(emptyLib.checkin(978037429279L));
	}
	
	@Test
	public void testEmptyCheckinHolder() {
		assertFalse(emptyLib.checkin("Jane Doe"));
	}

	@Test
	public void testSmallLibraryLookupISBN() {
		assertNull(smallLib.lookup(9780330351690L));
	}
	
	@Test
	public void testSmallLibraryLookupHolder() {
		smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		ArrayList<LibraryBook> booksCheckedOut = smallLib.lookup("Jane Doe");
		
		assertNotNull(booksCheckedOut);
		assertEquals(1, booksCheckedOut.size());
		assertEquals(new Book(9780330351690L, "Jon Krakauer", "Into the Wild"), booksCheckedOut.get(0));
		assertEquals("Jane Doe", booksCheckedOut.get(0).getHolder());
	}

	@Test
	public void testSmallLibraryCheckout() {
		assertTrue(smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008));
	}

	@Test
	public void testSmallLibraryCheckinISBN() {
		smallLib.checkout(9780330351690L, "Jane Doe", 1, 1, 2008);
		assertTrue(smallLib.checkin(9780330351690L));
	}

	@Test
	public void testSmallLibraryCheckinHolder() {
		assertFalse(smallLib.checkin("Jane Doe"));
	}
	
	
	
//Additional Test Cases	
	
	
	
	
	@Test
	public void testMediumLibraryLookupISBN() {
		assertNull(mediumLib.lookup(9781515383284L));
		assertNull(mediumLib.lookup(9781607472209L));
	}
	
	@Test
	public void testMediumLibraryLookupHolder() {
		
		mediumLib.checkout(9780450054785L, "Jane Doe", 1, 1, 2008);
		mediumLib.checkout(9782738212795L, "John Doe", 2, 24, 2012);
		mediumLib.checkout(9781607472209L, "Student", 2, 24, 2012);
		
		ArrayList<LibraryBook> booksCheckedOut = mediumLib.lookup("Jane Doe");
		ArrayList<LibraryBook> booksCheckedOut01 = mediumLib.lookup("John Doe");
		ArrayList<LibraryBook> booksCheckedOut02 = mediumLib.lookup("Student");
		
		assertNotNull(booksCheckedOut);
		assertNotNull(booksCheckedOut01);
		assertNotNull(booksCheckedOut02);
		
		assertEquals(1, booksCheckedOut.size());
		assertEquals(1, booksCheckedOut01.size());
		assertEquals(1, booksCheckedOut02.size());
		
		assertEquals(new Book(9780450054785L, "Stephen King", "The Shining"), booksCheckedOut.get(0));
		assertEquals(new Book(9782738212795L, "Stephen King", "The Green Mile"), booksCheckedOut01.get(0));
		assertEquals(new Book(9781607472209L, "Stephen Hawking", "A Brief History of Time"), booksCheckedOut02.get(0));
		
		
		assertEquals("Jane Doe", booksCheckedOut.get(0).getHolder());
		assertEquals("John Doe", booksCheckedOut01.get(0).getHolder());
		assertEquals("Student", booksCheckedOut02.get(0).getHolder());
		
	}
	
	@Test
	public void testMediumLibraryCheckout() {
		assertTrue(mediumLib.checkout(9781515383284L, "John Doe", 2, 4, 2012));
		assertFalse(mediumLib.checkout(9081515283384L, "John Doe", 2, 4, 2012));
		assertTrue(mediumLib.checkout(9781977648907L, "Jane Doe", 1, 21, 2019));
		assertFalse(mediumLib.checkout(908050508030L, "Jane Doe", 1, 21, 2019));
		assertTrue(mediumLib.checkout(9781607472209L, "Student", 6, 19, 2006));
		assertFalse(mediumLib.checkout(908050508030L, "Student", 6, 19, 2006));
		assertFalse(smallLib.checkout(908050508030L, "Student", 6, 19, 2006));
	}
	
	@Test
	public void testMediumLibraryCheckinISBN() {
		mediumLib.checkout(9781101154922L, "Jane Doe", 6, 18, 2016);
		assertFalse(mediumLib.checkin(9791022301152L));
		mediumLib.checkout(9791022301152L, "John Doe", 1, 21, 2019);
		assertTrue(mediumLib.checkin(9791022301152L));
		mediumLib.checkout(908050508030L, "Student", 6, 19, 2006);
		assertFalse(mediumLib.checkin(908050508030L));		
	}
	
	@Test
	public void testMediumLibraryCheckinHolder() {
		assertFalse(mediumLib.checkin("Jane Doe"));
		assertFalse(mediumLib.checkin("John Doe"));
		assertFalse(mediumLib.checkin("Student"));	
	}
	
}