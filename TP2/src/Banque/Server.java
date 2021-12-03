package Banque;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.UserException;

public class Server
{
  public static void main(String args[])
   {
	  Properties props= System.getProperties();
	  int status=0;
	  ORB orb=null;
   

    System.out.println( "+------------------+");
    System.out.println( "| Service bancaire |");
    System.out.println( "+------------------+\n");

    try {
		orb= ORB.init(args, props);
		
		status=run(orb);
	} catch (Exception e) {
		e.printStackTrace();
		status=1;
	}
    if(orb!=null) {
    	System.out.println("error");
    	try {
			orb.destroy();
		} catch (Exception e) {
			e.printStackTrace();
			status=1;
		}}
 
	 
 }
  private static int run(ORB orb) throws UserException {
	  org.omg.PortableServer.POA rootPOA= org.omg
			  								.PortableServer
			  								.POAHelper
 											.narrow(orb.resolve_initial_references("rootPOA")) ;
	 org.omg.PortableServer.POAManager manager=rootPOA.the_POAManager();
	 impl_compte_heritage compteImpt= new impl_compte_heritage(500);
	 Compte unCompte=compteImpt._this(orb);
	  try
	  {
	  String ref = orb.object_to_string(unCompte);
	  String refFile = "Compte.ref";
	  FileOutputStream file = new FileOutputStream(refFile);
	  PrintWriter out = new PrintWriter(file);
	  out.println(ref);
	  out.flush() ;
	  file.close();
	  }catch (IOException e) {
	 	e.printStackTrace();
	 	return 1;
	 }
	  manager.activate();
	  orb.run();
		return 0;
	}
  
}
