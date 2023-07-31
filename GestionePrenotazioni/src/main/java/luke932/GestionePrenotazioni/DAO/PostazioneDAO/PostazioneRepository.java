package luke932.GestionePrenotazioni.DAO.PostazioneDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	List<Postazione> findByTipoAndEdificioCittà(TipoPostazione tipo, String città);

	Postazione findByCodice(String codice);
}
