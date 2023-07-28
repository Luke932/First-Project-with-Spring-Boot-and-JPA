package luke932.GestionePrenotazioni.DAO.UtenteDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import luke932.GestionePrenotazioni.entities.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

}
