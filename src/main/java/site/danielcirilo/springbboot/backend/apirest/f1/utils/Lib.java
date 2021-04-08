package site.danielcirilo.springbboot.backend.apirest.f1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase implementada para la reutilizacion de codigo.
 * @author dcirilol
 *
 */
public class Lib {
	
	/**
	 * Hacemos el metodo static para poder acceder a el metodo desde otra clase sin tener que hacer una instacia
	 * de esta clase
	 * @param time recibe el string para pasarlo a date
	 * @return nos retonar la fecha ya parseada en el formato que le indicamos
	 */
	public static Date timeParse(String time) {
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss.SS");
		Date timeFormat = null;
		try {
			timeFormat = formato.parse(time);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return timeFormat;
	}
}
