package luke932.GestionePrenotazioni.DAO.EdificioDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import luke932.GestionePrenotazioni.entities.Edificio;
import luke932.GestionePrenotazioni.exceptions.ItemNotFoundException;

@Service
@Slf4j
public class EdificioService implements IEdificioDAO {

	@Autowired
	private EdificioRepository ediR;

	@Override
	public void save(Edificio edificio) {
		ediR.save(edificio);
		log.info(edificio.toString());
	}

	@Override
	public void findByIdAndUpdate(Long id, Edificio edificio) {
		Edificio found = this.findById(id);

		found.setId(id);
		found.setNome(edificio.getNome());
		found.setIndirizzo(edificio.getIndirizzo());
		found.setCittà(edificio.getCittà());

		ediR.save(found);

	}

	@Override
	public void findByIdAndDelete(Long id) {
		Edificio found = this.findById(id);
		ediR.delete(found);
	}

	@Override
	public Edificio findById(Long id) throws ItemNotFoundException {
		return ediR.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	@Override
	public List<Edificio> findAll() {
		return ediR.findAll();
	}

	@Override
	public long count() {
		return ediR.count();
	}

}
