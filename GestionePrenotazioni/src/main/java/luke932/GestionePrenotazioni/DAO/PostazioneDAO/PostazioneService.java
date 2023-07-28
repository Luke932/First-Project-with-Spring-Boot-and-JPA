package luke932.GestionePrenotazioni.DAO.PostazioneDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import luke932.GestionePrenotazioni.entities.Postazione;
import luke932.GestionePrenotazioni.entities.TipoPostazione;
import luke932.GestionePrenotazioni.exceptions.ItemNotFoundException;

@Service
@Slf4j
public class PostazioneService implements IPostazioneDAO {

	@Autowired
	private PostazioneRepository pstR;

	public void save(Postazione postazione) {
		pstR.save(postazione);
		log.info(postazione.toString());
	}

	@Override
	public void findByIdAndUpdate(Long id, Postazione postazione) {
		Postazione found = this.findById(id);

		found.setId(id);
		found.setCodice(postazione.getCodice());
		found.setDescrizione(postazione.getDescrizione());
		found.setTipo(postazione.getTipo());
		found.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());

		pstR.save(found);
	}

	@Override
	public void findByIdAndDelete(Long id) throws ItemNotFoundException {
		Postazione found = this.findById(id);
		pstR.delete(found);
	}

	@Override
	public Postazione findById(Long id) throws ItemNotFoundException {
		return pstR.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	@Override
	public List<Postazione> findAll() {
		return pstR.findAll();
	}

	@Override
	public long count() {
		return pstR.count();
	}

	@Override
	public List<Postazione> findByTipoandEdificioCittà(TipoPostazione tipo, String città) {
		return pstR.findByTipoAndEdificioCittà(tipo, città);
	}

	@Override
	public Postazione findByCodice(String codice) {
		return pstR.findByCodice(codice);
	}

}
