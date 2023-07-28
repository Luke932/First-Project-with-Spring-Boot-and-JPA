package luke932.GestionePrenotazioni.DAO.UtenteDAO;

import java.util.List;

import luke932.GestionePrenotazioni.entities.Utente;

public interface IUtenteDAO {

	public void save(Utente utente);

	public void findByIdAndUpdate(Long id, Utente utente);

	public void findByIdAndDelete(Long id);

	public Utente findById(Long id);

	public List<Utente> findAll();

	public long count();

	public Utente findByUsername(String username);
}
