package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	public Medlem() {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = -1;
	}

	public String toString() {
		String resultat = "";
		resultat += "Navn: " + getNavn();
		resultat += "\nHobbyer" + getHobbyer().toString();
		resultat += (statusIndeks == -1) ? "No partner" : ("Partner with " + statusIndeks);
		return resultat;

	}
	
	public boolean passerTil(Medlem medlem2) {
		boolean passer = false;
		MengdeADT<Hobby> m2 = medlem2.getHobbyer();
		if(hobbyer.equals(m2)) {
			passer = true;
		}
		return passer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	

}
