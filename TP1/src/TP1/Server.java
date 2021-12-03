package TP1;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.omg.CORBA.ORB;

public class Server {
public static void main(String ... args) {
	java.util.Properties props= System.getProperties();
	int status=0;
	org.omg.CORBA.ORB orb=null;
	
	try {
		orb=org.omg.CORBA.ORB.init(args, props);
		status= run(orb);
	}catch(Exception ex) {
		ex.printStackTrace();
		status=1;
	}
	if(orb!=null) {
		try {
			orb.destroy();
		}catch(Exception ex) {
			ex.printStackTrace();
			status=1;
		}
	}
	System.exit(status);
}

private static int run(org.omg.CORBA.ORB orb) throws org.omg.CORBA.UserException {
	org.omg.PortableServer.POA rootPOA=
			org.omg.PortableServer.POAHelper.narrow(
					orb.resolve_initial_references("rootPOA"));
	
	org.omg.PortableServer.POAManager manager =
			rootPOA.the_POAManager();
	hellowWorldImpl helloImpl = new hellowWorldImpl();
	helloWorld hello = helloImpl._this(orb);
	try {
		String ref = orb.object_to_string(hello);
		String refFile= "hello.ref";
		PrintWriter out= new PrintWriter(new FileOutputStream(refFile));
	    out.println(ref);
		out.close();
	} catch (Exception e) {
		e.printStackTrace();
		return 1;
		// TODO: handle exception
	}
	manager.activate();
	orb.run();
	
	return 0;
}
}
