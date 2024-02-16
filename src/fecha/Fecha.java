package fecha;

/**
 * Clase que contiene métodos para comprobar fechas
 * @author asuarez
 * @version 1.0
 */
public class Fecha {
	/**
	 * Atributo que obtiene el día
	 */
	private int dia;
	
	/**
	 * Atributo que obtiene el mes
	 */
	private int mes;
	
	/**
	 * Atributo que obtiene el año
	 */
	private int anio; 

	/**
	 * Constructor vacío
	 */
	public Fecha() {

	}

	/**
	 * Constructor con parámetros dia, mes y anio
	 * @param dia Obtiene el número del día
	 * @param mes Obtiene el número del mes
	 * @param anio Obtiene el número del año
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	
	/**
	 * Método que comprueba si la fecha es correcta
	 * @return Devuelve true o false dependiendo de si la fecha es correcta
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto; 
		boolean anioCorrecto;
		
		anioCorrecto = anio > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		
		final boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Método privado que comprueba si el año es bisiesto usando fechaCorrecta
	 * @return Devuelve true o false dependiendo de si el año es bisiesto
	 */
	private boolean esBisiesto() {
		return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
	}

	/**
	 * Método que suma un día al día actual, comprobando si debe de cambiar de mes y de año
	 */
	public void nextDay() {
		dia++;
		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				anio++;
			}
		}
	}

	/**
	 * Método que pasa la fecha a String
	 */
	public String toString() {
		String fecha = "";
		if (dia < 10 && mes < 10) {
			fecha = "0" + dia + "-0" + mes + "-" + anio;
		} else if (dia < 10 && mes >= 10) {
			fecha = "0" + dia + "-" + mes + "-" + anio;
		} else if (dia >= 10 && mes < 10) {
			fecha = dia + "-0" + mes + "-" + anio;
		} else {
			fecha = dia + "-" + mes + "-" + anio;
		}
		
		return fecha;
	}

}
