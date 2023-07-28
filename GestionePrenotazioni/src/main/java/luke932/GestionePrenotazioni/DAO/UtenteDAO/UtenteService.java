package luke932.GestionePrenotazioni.DAO.UtenteDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import luke932.GestionePrenotazioni.entities.Utente;
import luke932.GestionePrenotazioni.exceptions.ItemNotFoundException;

@Service
@Slf4j
public class UtenteService implements IUtenteDAO {

	@Autowired
	private UtenteRepository utR;

	public void save(Utente utente) {
		utR.save(utente);
		log.info(utente.toString());
	}

	@Override
	public void findByIdAndUpdate(Long id, Utente utente) {
		Utente found = this.findById(id);

		found.setId(id);
		found.setUsername(utente.getUsername());
		found.setNomeCompleto(utente.getNomeCompleto());
		found.setEmail(utente.getEmail());

		utR.save(found);
	}

	@Override
	public void findByIdAndDelete(Long id) throws ItemNotFoundException {
		Utente found = this.findById(id);
		utR.delete(found);
	}

	@Override
	public Utente findById(Long id) throws ItemNotFoundException {
		return utR.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

	@Override
	public List<Utente> findAll() {
		return utR.findAll();
	}

	@Override
	public long count() {
		return utR.count();
	}

	@Override
	public Utente findByUsername(String username) {
		return utR.findByUsername(username);
	}
}
