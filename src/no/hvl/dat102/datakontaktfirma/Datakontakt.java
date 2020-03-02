package no.hvl.dat102.datakontaktfirma;

import java.util.Iterator;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {

	private TabellMengde<Medlem> medlemstabell;
	private int antallMedlemmer;

	public Datakontakt() {
		medlemstabell = new TabellMengde<Medlem>();
		this.antallMedlemmer = medlemstabell.antall();
	}

	public Datakontakt(int start) {
		medlemstabell = new TabellMengde<Medlem>(start);
		this.antallMedlemmer = 0;
	}

	public int getAntall() {
		return antallMedlemmer;
	}

	public void leggTilMedlem(Medlem person) {
		medlemstabell.leggTil(person);
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		int funnet = -1;
		Iterator<Medlem> teller = medlemstabell.oppramser();
		int pos = 0;
		while (teller.hasNext() && funnet == -1) {
			Medlem element = teller.next();
			if (medlemsnavn.equals(element.getNavn())) {
				funnet = pos;
			} else {
				pos++;
			}
		}
		return funnet;
	}

	public int finnPartnerFor(String medlemsnavn) {
		int funnet = -1;
		Medlem medlem1 = hentMedlem(medlemsnavn);
		Iterator<Medlem> teller = medlemstabell.oppramser();
		while (teller.hasNext() && funnet == -1) {
			Medlem medlem2 = teller.next();
			if (medlem2.passerTil(medlem1) && medlem2.getStatusIndeks() == -1
					&& !(medlem2.getNavn().equals(medlemsnavn))) {
				funnet = finnMedlemsIndeks(medlem2.getNavn());
				medlem1.setStatusIndeks(funnet);
				medlem2.setStatusIndeks(finnMedlemsIndeks(medlemsnavn));
			}
		}
		return funnet;
	}

	public void tilbakestillStatusIndeks(String medlemsnavn) {
		Medlem medlem = hentMedlem(medlemsnavn);

		int partnerIndeks = medlem.getStatusIndeks();
		Medlem partner = hentMedlemMedIndeks(partnerIndeks);

		if (medlem != null && partner != null) {
			medlem.setStatusIndeks(-1);
			partner.setStatusIndeks(-1);
		}
	}

	public Medlem hentMedlem(String medlemsnavn) {
		Iterator<Medlem> teller = medlemstabell.oppramser();
		Medlem element;

		while (teller.hasNext()) {
			element = teller.next();
			if (element.getNavn().equals(medlemsnavn)) {
				return element;
			}
		}

		return null;
	}

	public Medlem hentMedlemMedIndeks(int medlemsindeks) {
		Iterator<Medlem> teller = medlemstabell.oppramser();
		Medlem element;

		while (teller.hasNext()) {
			element = teller.next();
			if (element.getStatusIndeks() == medlemsindeks) {
				return element;
			}
		}
		return null;
	}

}
