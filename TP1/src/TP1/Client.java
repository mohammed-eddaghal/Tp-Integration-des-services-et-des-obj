//Java  Client.java
package TP1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Client
 {
 public static void main(String args[])
 {
 
 java.util.Properties props = System.getProperties();

 int status = 0;
 org.omg.CORBA.ORB orb = null;

 try
 {
 orb = org.omg.CORBA.ORB.init(args, props);
 status = run(orb);
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
 status = 1;
 }

 if(orb != null)
 {
 try
 {
 orb.destroy();
 }
 catch(Exception ex)
 {
 ex.printStackTrace();
 status = 1;
 }
 }

 System.exit(status);
 }

  static int run(org.omg.CORBA.ORB orb)
 {
 org.omg.CORBA.Object obj = null;
 try {
	 String reffile = "hello.ref";
	 BufferedReader in = new BufferedReader(new FileReader(reffile));
	 String  ref = in.readLine();
	 obj= orb.string_to_object(ref);
 }catch (Exception e) {
	// TODO: handle exception
	 e.printStackTrace();
}
 helloWorld hello = helloWorldHelper.narrow(obj);
 System.out.print(hello.sayHelloWorld());

 return 0;

}
}