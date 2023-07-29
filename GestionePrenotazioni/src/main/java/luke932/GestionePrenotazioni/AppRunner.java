package luke932.GestionePrenotazioni;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import luke932.GestionePrenotazioni.DAO.EdificioDAO.EdificioService;
import luke932.GestionePrenotazioni.DAO.PostazioneDAO.PostazioneService;
import luke932.GestionePrenotazioni.DAO.PrenotazioneDAO.PrenotazioneService;
import luke932.GestionePrenotazioni.DAO.UtenteDAO.UtenteService;
import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.Prenotazione;
import luke932.GestionePrenotazioni.entities.TipoPostazione;
import luke932.GestionePrenotazioni.entities.Utente;
import luke932.GestionePrenotazioni.exceptions.ItemNotFoundException;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {

	@Autowired
	private PostazioneService pstR;

	@Autowired
	private EdificioService edfR;

	@Autowired
	private UtenteService utnR;

	@Autowired
	private PrenotazioneService prnR;

	@Autowired
	private AppConfig app;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		try {
			edfR.save(app.edificio1());
			edfR.save(app.edificio2());

			pstR.save(app.postazione1());
			pstR.save(app.postazione2());

			utnR.save(app.utente1());
			utnR.save(app.utente2());

			prnR.save(app.prenotazione1());
			prnR.save(app.prenotazione2());
		} catch (DataIntegrityViolationException e) {
			handleDataIntegrityViolationException(e);
		} catch (ItemNotFoundException e) {
			handleItemNotFoundException(e);
		}

		List<Postazione> postazioniByTipoAndCittà = pstR.findByTipoandEdificioCittà(TipoPostazione.OPENSPACE, "Milano");
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

		try {
			Utente utente = utnR.findById(1L);
			Optional<Prenotazione> prenotazione = prnR.findByUtente(utente);
			if (prenotazione.isPresent()) {
				log.info(prenotazione.get().toString());
			} else {
				log.info("Nessuna prenotazione trovata per l'utente specificato.");
			}

			Postazione post = pstR.findById(1202L);
			Optional<Prenotazione> due2 = prnR.findByPostazioneAndDataPrenotazione(post, LocalDate.of(2023, 5, 30));
			if (due2.isPresent()) {
				log.info(due2.get().toString());
			} else {
				log.info("Nessuna prenotazione trovata per la postazione e data specificate.");
			}
		} catch (ItemNotFoundException e) {
			handleItemNotFoundException(e);
		}
	}

	private void handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		log.error("Errore di chiave duplicata: " + e.getMessage());
	}

	private void handleItemNotFoundException(ItemNotFoundException e) {
		log.error("Errore: " + e.getMessage());
	}
}
