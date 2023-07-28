package luke932.GestionePrenotazioni.DAO.PostazioneDAO;

import java.util.List;

import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.TipoPostazione;

public interface IPostazioneDAO {
	public void save(Postazione postazione);

	public void findByIdAndUpdate(Long id, Postazione postazione);

	public void findByIdAndDelete(Long id);

	public Postazione findById(Long id);

	public List<Postazione> findAll();

	public long count();

	public List<Postazione> findByTipoandEdificioCittà(TipoPostazione tipo, String città);

	public Postazione findByCodice(String codice);
}
