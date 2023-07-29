package luke932.GestionePrenotazioni.DAO.PrenotazioneDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.Prenotazione;
import luke932.GestionePrenotazioni.entities.Utente;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	List<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione);

	Optional<Prenotazione> findFirstByUtente(Utente utente);

	Optional<Prenotazione> findFirstByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

	Optional<Prenotazione> findFirstByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

}
