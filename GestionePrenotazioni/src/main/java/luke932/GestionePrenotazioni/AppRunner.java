package luke932.GestionePrenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import luke932.GestionePrenotazioni.DAO.EdificioDAO.EdificioRepository;
import luke932.GestionePrenotazioni.DAO.PostazioneDAO.PostazioneRepository;
import luke932.GestionePrenotazioni.DAO.PrenotazioneDAO.PrenotazioneRepository;
import luke932.GestionePrenotazioni.DAO.UtenteDAO.UtenteRepository;

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
	}

}
