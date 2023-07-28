package luke932.GestionePrenotazioni.DAO.PrenotazioneDAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.Prenotazione;
import luke932.GestionePrenotazioni.entities.Utente;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	List<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione);

	List<Prenotazione> findByUtente(Utente utente);

	List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
}
