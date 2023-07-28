package luke932.GestionePrenotazioni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
}
