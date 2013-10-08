package fr.renater.idegest.tu;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.Normalizer;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class GestAjoutUsersTest extends TestCase{
	/** l'OUT */
	private GestAjoutUsers gau; // L'objet à tester est déclaré comme attribut de la classe de test
	@Before
	public void setUp() throws Exception {

		try {
			this.gau = new GestAjoutUsers("testusers.xml"); //La création de l'objet à tester est placée dans setUp
		}
		catch (IOException e){
			fail("Création de l'OUT impossible");
		}
	}


	@Test
	public void testminuscule(){
		String uid = this.gau.genUid("Bob", "Martin");
		String minuscule = uid.toLowerCase(); // met la chaine en minuscule
		assertEquals("Les caractères sont minuscules","bmartin",minuscule);
	}
	@Test
	public void testBonNombreDeCaractere(){
		String uid = this.gau.genUid("Bob", "Martin");
		int chaine = uid.length();
		if (chaine>=5 && chaine<9 ){
			assertEquals("La chaine est bonne","bmartin",uid);
		}
		else{
				assertEquals("La chaine nest pas bonne","bmartinaaaaeffzefz",uid);
			}
		}
	@Test
	public void testnormaliser(){
		String uid = this.gau.genUid("Bob", "Martin");
		String normaliser
		= Normalizer.normalize(uid, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		assertEquals("Il ny a pas de caracteres indesirables","bmartin",normaliser);
		
	}
	@Test
	public void testAddUser(){
		User user,user2,user3;
		
		
		user = gau.addUser("Bob", "Martin");
		user2=gau.addUser("Bob", "Martin");
		user3= gau.addUser("Bob", "Martin");
	
		
		assertEquals("L uid obtenu nexiste pas","bmartin",user.getLogin());
		assertEquals("L uid obtenu existe pas","bmartin1",user2.getLogin());
		assertEquals("L uid obtenu existe pas","bmartin2",user3.getLogin());
	}
	
	@Test
	public void testTailleMdp(){
		User uid = gau.addUser("Bob", "Martin");
		assertTrue("Les UIDs sont differents",uid.getPass().length() == 8);
	}
}

