package Banque;

public class impl_compte_heritage extends ComptePOA {

	private float _montant=0;
	
	
	public impl_compte_heritage(float _montant) {
		System.out.println("creation d'un obj Compte\n");
		this._montant = _montant;
	}

	@Override
	public float lire_montant() {
		System.out.println("lecture de l'obj Compte\n");
		return _montant;
	}

	@Override
	public void crediter(float montant) {
		System.out.println("credit de l'obt Compte\n");
		_montant+=montant;
	}

	@Override
	public void debiter(float montant) {
		System.out.println("debit de l'obt Compte\n");
		_montant-=montant;
		
	}

}
