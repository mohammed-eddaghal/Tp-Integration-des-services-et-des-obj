package BanqueHeritage;

/**
* BanqueHeritage/CompteEpargneHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Banque.idl
* mercredi 24 novembre 2021 09 h 12 WEST
*/

public final class CompteEpargneHolder implements org.omg.CORBA.portable.Streamable
{
  public BanqueHeritage.CompteEpargne value = null;

  public CompteEpargneHolder ()
  {
  }

  public CompteEpargneHolder (BanqueHeritage.CompteEpargne initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = BanqueHeritage.CompteEpargneHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    BanqueHeritage.CompteEpargneHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return BanqueHeritage.CompteEpargneHelper.type ();
  }

}
