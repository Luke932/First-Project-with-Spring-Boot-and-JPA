package luke932.GestionePrenotazioni.DAO.EdificioDAO;

import java.util.List;

import luke932.GestionePrenotazioni.entities.Edificio;

public interface IEdificioDAO {

	public void save(Edificio edificio);

	public void findByIdAndUpdate(Long id, Edificio edificio);

	public void findByIdAndDelete(Long id);

	public Edificio findById(Long id);

	public List<Edificio> findAll();

	public long count();

}
