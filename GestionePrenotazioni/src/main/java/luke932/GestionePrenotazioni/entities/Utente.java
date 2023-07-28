package luke932.GestionePrenotazioni.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Utente {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	private String nomeCompleto;

	private String email;

	@OneToMany(mappedBy = "utente")
	private List<Prenotazione> prenotazioni;

	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", nomeCompleto=" + nomeCompleto + ", email=" + email
				+ "]";
	}
}
