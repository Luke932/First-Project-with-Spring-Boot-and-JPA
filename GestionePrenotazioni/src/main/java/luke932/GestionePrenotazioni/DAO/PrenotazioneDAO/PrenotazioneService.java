package luke932.GestionePrenotazioni.DAO.PrenotazioneDAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.Prenotazione;
import luke932.GestionePrenotazioni.entities.Utente;
import luke932.GestionePrenotazioni.exceptions.DateNotPossibleException;
import luke932.GestionePrenotazioni.exceptions.ItemNotFoundException;

@Service
@Slf4j
public class PrenotazioneService implements IPrenotazioneDAO {

	@Autowired
	private PrenotazioneRepository prnR;

	public void save(Prenotazione prenotazione) {
		LocalDate dataPrenotazione = prenotazione.getDataPrenotazione();
		List<Prenotazione> prenotazioniConStessaData = prnR.findByDataPrenotazione(dataPrenotazione);

		if (!prenotazioniConStessaData.isEmpty()) {
			throw new DateNotPossibleException(dataPrenotazione);
		}

		prnR.save(prenotazione);
		log.info(prenotazione.toString());
	}

	@Override
	public void findByIdAndUpdate(Long id, Prenotazione prenotazione) {
		Prenotazione found = this.findById(id);

		found.setId(id);
		found.setDataPrenotazione(prenotazione.getDataPrenotazione());

		prnR.save(found);
	}

	@Override
	public void findByIdAndDelete(Long id) throws ItemNotFoundException {
		Prenotazione found = this.findById(id);
		prnR.delete(found);
	}

	@Override
	public Prenotazione findById(Long id) throws ItemNotFoundException {
		return prnR.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	@Override
	public List<Prenotazione> findAll() {
		return prnR.findAll();
	}

	@Override
	public long count() {
		return prnR.count();
	}

	@Override
	public List<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione) {
		return prnR.findByDataPrenotazione(dataPrenotazione);
	}

	@Override
	public List<Prenotazione> findByUtente(Utente utente) {
		return prnR.findByUtente(utente);
	}

	@Override
	public List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione) {
		return prnR.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
	}

}
