package luke932.GestionePrenotazioni;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import luke932.GestionePrenotazioni.DAO.PostazioneDAO.PostazioneService;
import luke932.GestionePrenotazioni.entities.Edificio;
import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.Prenotazione;
import luke932.GestionePrenotazioni.entities.TipoPostazione;
import luke932.GestionePrenotazioni.entities.Utente;

@Configuration
public class AppConfig {

	@Autowired
	private PostazioneService posS;

	private Postazione createPostazione(String codice, String descrizione, TipoPostazione tipo,
			int numeroMassimoOccupanti, Edificio edificio) {
		Postazione existingPostazione = posS.findByCodice(codice);
		if (existingPostazione != null) {
			System.out.println("Postazione con codice " + codice + " già presente nel database.");
			return existingPostazione;
		} else {
			Postazione postazione = new Postazione();
			postazione.setCodice(codice);
			postazione.setDescrizione(descrizione);
			postazione.setTipo(tipo);
			postazione.setNumeroMassimoOccupanti(numeroMassimoOccupanti);
			postazione.setEdificio(edificio);
			posS.save(postazione);
			return postazione;
		}
	}

	@Bean
	public Postazione postazione1() {
		return createPostazione("POST-001", "Postazione Privata", TipoPostazione.PRIVATO, 1, edificio1());
	}

	@Bean
	public Postazione postazione2() {
		return createPostazione("POST-002", "Postazione Open Space", TipoPostazione.OPENSPACE, 4, edificio2());
	}

	@Bean
	public Edificio edificio1() {
		Edificio edificio = new Edificio();
		edificio.setNome("Edificio A");
		edificio.setIndirizzo("Via delle Imprese, 123");
		edificio.setCittà("Roma");
		return edificio;
	}

	@Bean
	public Edificio edificio2() {
		Edificio edificio = new Edificio();
		edificio.setNome("Edificio B");
		edificio.setIndirizzo("Piazza del Lavoro, 456");
		edificio.setCittà("Milano");
		return edificio;
	}

	@Bean
	public Utente utente1() {
		Utente utente = new Utente();
		utente.setUsername("user001");
		utente.setNomeCompleto("Mario Rossi");
		utente.setEmail("mario.rossi@example.com");
		return utente;
	}

	@Bean
	public Utente utente2() {
		Utente utente = new Utente();
		utente.setUsername("user002");
		utente.setNomeCompleto("Laura Bianchi");
		utente.setEmail("laura.bianchi@example.com");
		return utente;
	}

	@Bean
	public Prenotazione prenotazione1() {
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setUtente(utente1());
		prenotazione.setPostazione(postazione1());
		prenotazione.setDataPrenotazione(LocalDate.of(2023, 5, 30));
		return prenotazione;
	}

	@Bean
	public Prenotazione prenotazione2() {
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setUtente(utente2());
		prenotazione.setPostazione(postazione2());
		prenotazione.setDataPrenotazione(LocalDate.of(2023, 6, 15));
		return prenotazione;
	}
}
