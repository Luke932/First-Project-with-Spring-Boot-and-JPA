package luke932.GestionePrenotazioni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Edificio {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String indirizzo;

	private String città;
}
