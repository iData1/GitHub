/*
 *@author Mattia Ghirlanda
 *Data termine progetto 1.05.2015
 */

import java.io.*;
public class Hangman2{
	public static void main(String[] args) {
		String masked = "";
		String newMasked = "";
		String secret = "cavallo";
		String tempLetter = "";
		char letter = 'o';
		char mask = 'a';

		BufferedReader t = new BufferedReader(new InputStreamReader(System.in));
		InputStreamReader input = new InputStreamReader(System.in);

		int errori = 10;
		
		/*while(true){
			if(errori==0){
				System.out.println("Hai perso");
				return;
			}
			errori--;
		}*/
		
		
		while (true) {
			// Crea stringa mascherata della lunghezza di "cavallo"/(secret)
			for (int i = 0; i < secret.length(); i++) {
				masked += '_';
			}

			try {
				System.out.print("Inserire lettera : ");
				tempLetter = t.readLine();
				letter = tempLetter.charAt(0);
			} catch (Exception e) {}

			newMasked = "";
			for (int i = 0; i < secret.length(); i++) {
				if (letter == secret.charAt(i)) {
					newMasked += letter; 
				} else {
					newMasked += masked.substring(i, i+1);
				}
			}
			masked = newMasked;
			System.out.println(newMasked);
		}
	}
}
