package luke932.GestionePrenotazioni.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Prenotazione {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "postazione_id")
	private Postazione postazione;

	@Temporal(TemporalType.DATE)
	private LocalDate dataPrenotazione;

	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", dataPrenotazione=" + dataPrenotazione + "]";
	}
}
