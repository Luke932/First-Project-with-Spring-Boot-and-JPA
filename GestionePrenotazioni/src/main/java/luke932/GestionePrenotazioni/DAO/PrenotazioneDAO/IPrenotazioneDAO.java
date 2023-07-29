package luke932.GestionePrenotazioni.DAO.PrenotazioneDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.Prenotazione;
import luke932.GestionePrenotazioni.entities.Utente;

public interface IPrenotazioneDAO {
	public void save(Prenotazione prenotazione);

	public void findByIdAndUpdate(Long id, Prenotazione prenotazione);

	public void findByIdAndDelete(Long id);

	public Prenotazione findById(Long id);

	public List<Prenotazione> findAll();

	public long count();

	public List<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione);

	public Optional<Prenotazione> findByUtente(Utente utente);

	public Optional<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione,
			LocalDate dataPrenotazione);

}
