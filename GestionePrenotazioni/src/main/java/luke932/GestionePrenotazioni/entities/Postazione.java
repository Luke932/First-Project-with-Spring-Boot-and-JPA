package luke932.GestionePrenotazioni.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Postazione {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String codice;

	private String descrizione;

	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;

	private int numeroMassimoOccupanti;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "edificio_id")
	private Edificio edificio;

	@Override
	public String toString() {
		return "Postazione [codice=" + codice + ", descrizione=" + descrizione + ", tipo=" + tipo
				+ ", numeroMassimoOccupanti=" + numeroMassimoOccupanti + "]";
	}

}
