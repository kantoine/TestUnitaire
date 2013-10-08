package fr.renater.idegest.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UtilHtmlTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void testTabVide(){
		UtilHtml uh = new UtilHtml();
		String arg[] = {};
		String expectedHtmlTab = "(vide)";
		assertEquals("toHtmlTab : tableau vide", expectedHtmlTab, uh.toHtmlTab(arg, 10));
	}

	public void testTab1Element(){
		
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A"};
		 String expectedHtmlTab = "<table><tr><td>A</td></tr></table>";
		 assertEquals("toHtmlTab: une ligne", expectedHtmlTab, uh.toHtmlTab(arg, arg.length));	
	}
	public void testTabNElementMoinsUn(){
		UtilHtml uh = new UtilHtml();
		 String arg[] = {"A", "B", "C"};
		 String expectedHtmlTab = "<table><tr><td>A</td></tr><tr><td>B</td></tr><tr><td>...</td></tr></table>";
		 assertEquals("toHtmlTab : cas moins 1", expectedHtmlTab, uh.toHtmlTab(arg, arg.length-1));
	}
	 public void testTabNElementDivDeux(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A", "B", "C"};
		 String expectedHtmlTab = "<table><tr><td>A</td></tr><tr><td>...</td></tr></table>";
		 assertEquals("toHtmlTab : cas médian impair", expectedHtmlTab, uh.toHtmlTab(arg, arg.length/2));
	 }
	 
	 public void testTabZeroElement(){
		 UtilHtml uh = new UtilHtml();
		 String arg[] = {"A", "B", "C"};
		 String expectedHtmlTab =""; // A VOUS !!
		 assertEquals("toHtmlTab : cas maxRows = 0", expectedHtmlTab, uh.toHtmlTab(arg, 0));
	 }
}
