package Banque;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CORBA.SystemException;

public class client_banque
{ public static void main (String args[])
 {	//....

char ch = lire_choix() ;
while (ch !='0') {
  switch(ch) {
            case '1':
              // Lecture du montant du compte
              	
            case '2':
              // Crediter le compte
            case '3':
              // Debiter le compte
            default:
              // Erreur de saisie
          }
          ch=lire_choix();      
        }
      }
     /* catch(SystemException ex) {
    	  
      }*/

  static char lire_choix() {
      System.out.println( "+------------------+");
      System.out.println( "| Service bancaire |");
      System.out.println( "+------------------+\n");
      System.out.println( "1 : Lecture du montant du compte");
      System.out.println( "2 : Credit du compte" );
      System.out.println( "3 : Debit du compte\n" );
      System.out.println( "0 : Quitter\n");
      System.out.println( "Taper le code de l'operation a effectuer : ");
      return(lire_char());
  }
 
  static char lire_char() {
    String chaine;
    try {
      java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
      BufferedReader in =  new BufferedReader(new InputStreamReader(dataIn));
      chaine = in.readLine();
    }
    catch(java.io.IOException ex)
    {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      return(' ');
    }
    return(chaine.charAt(0));
  }
   static float lire_float() {
    String chaine;
    try {
      java.io.DataInputStream dataIn =  new java.io.DataInputStream(System.in);
      BufferedReader in =  new BufferedReader(new InputStreamReader(dataIn));
      chaine = in.readLine();
    }
    catch(java.io.IOException ex)
    {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      return(0);
    }
    return(Float.parseFloat(chaine));
  }
 }
