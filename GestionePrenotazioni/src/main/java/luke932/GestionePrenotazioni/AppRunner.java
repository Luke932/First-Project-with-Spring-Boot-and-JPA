package luke932.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import luke932.GestionePrenotazioni.DAO.EdificioDAO.EdificioRepository;
import luke932.GestionePrenotazioni.DAO.PostazioneDAO.PostazioneRepository;
import luke932.GestionePrenotazioni.DAO.PrenotazioneDAO.PrenotazioneRepository;
import luke932.GestionePrenotazioni.DAO.UtenteDAO.UtenteRepository;
import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.Prenotazione;
import luke932.GestionePrenotazioni.entities.TipoPostazione;
import luke932.GestionePrenotazioni.entities.Utente;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {

	@Autowired
	private PostazioneRepository pstR;

	@Autowired
	private EdificioRepository edfR;

	@Autowired
	private UtenteRepository utnR;

	@Autowired
	private PrenotazioneRepository prnR;

	@Autowired
	private AppConfig app;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// ===================SAVE
		edfR.save(app.edificio1());
		log.info("Edificio con nome ->" + " " + app.edificio1().getNome() + " " + "salvato!");
		edfR.save(app.edificio2());
		log.info("Edificio con nome ->" + " " + app.edificio2().getNome() + " " + "salvato!");

		pstR.save(app.postazione1());
		log.info("Postazione con codice ->" + " " + app.postazione1().getCodice() + " " + "salvata");
		pstR.save(app.postazione2());
		log.info("Postazione con codice ->" + " " + app.postazione2().getCodice() + " " + "salvata");

		utnR.save(app.utente1());
		log.info("Utente con nome ->" + " " + app.utente1().getNomeCompleto() + " " + "salvato!");
		utnR.save(app.utente2());
		log.info("Utente con nome ->" + " " + app.utente2().getNomeCompleto() + " " + "salvato!");

		prnR.save(app.prenotazione1());
		log.info("Prenotazione con id ->" + " " + app.prenotazione1().getId() + " " + "salvato!");
		prnR.save(app.prenotazione2());
		log.info("Prenotazione con id ->" + " " + app.prenotazione2().getId() + " " + "salvato!");

		// ================RICERCA UTENTE
		List<Postazione> postazioniByTipoAndCittà = pstR.findByTipoAndEdificioCittà(TipoPostazione.OPENSPACE, "Milano");
		if (!postazioniByTipoAndCittà.isEmpty()) {
			Postazione uno = postazioniByTipoAndCittà.get(0);
			log.info(uno.toString());
		} else {
			log.info("Nessuna postazione Open Space trovata a Roma.");
		}

		Postazione due = pstR.findByCodice("POST-001");
		log.info(due.toString());

		List<Prenotazione> prenotazioniByDataPrenotazione = prnR.findByDataPrenotazione(LocalDate.of(2023, 6, 15));
		if (!prenotazioniByDataPrenotazione.isEmpty()) {
			Prenotazione uno1 = prenotazioniByDataPrenotazione.get(0);
			log.info(uno1.toString());
		} else {
			log.info("Nessuna prenotazione trovata per la data specificata.");
		}

		Utente utente = app.utente1();
		Prenotazione prenotazione = prnR.findFirstByUtente(utente);
		if (prenotazione != null) {
			log.info(prenotazione.toString());
		} else {
			log.info("Nessuna prenotazione trovata per l'utente specificato.");
		}

		Prenotazione due2 = (Prenotazione) prnR.findFirstByPostazioneAndDataPrenotazione(app.postazione1(),
				LocalDate.of(2023, 5, 30));
		log.info(due2.toString());

	}

}
