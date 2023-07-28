package luke932.GestionePrenotazioni.exceptions;

import java.time.LocalDate;

public class DateNotPossibleException extends RuntimeException {
	public DateNotPossibleException(LocalDate dataPrenotazione) {
		super("Prenotazione in questa data ->" + dataPrenotazione + "già effettuata!");
	}
}
