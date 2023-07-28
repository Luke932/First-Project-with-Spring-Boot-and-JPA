package luke932.GestionePrenotazioni;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import luke932.GestionePrenotazioni.entities.Edificio;
import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.Prenotazione;
import luke932.GestionePrenotazioni.entities.TipoPostazione;
import luke932.GestionePrenotazioni.entities.Utente;

@Configuration
public class AppConfig {

	@Bean
	public Postazione postazione1() {
		Postazione postazione = new Postazione();
		postazione.setCodice("POST-001");
		postazione.setDescrizione("Postazione Privata");
		postazione.setTipo(TipoPostazione.PRIVATO);
		postazione.setNumeroMassimoOccupanti(1);
		postazione.setEdificio(edificio1());
		return postazione;
	}

	@Bean
	public Postazione postazione2() {
		Postazione postazione = new Postazione();
		postazione.setCodice("POST-002");
		postazione.setDescrizione("Postazione Open Space");
		postazione.setTipo(TipoPostazione.OPENSPACE);
		postazione.setNumeroMassimoOccupanti(4);
		postazione.setEdificio(edificio2());
		return postazione;
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
