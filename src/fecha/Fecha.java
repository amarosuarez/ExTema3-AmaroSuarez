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
	private int d;
	
	/**
	 * Atributo que obtiene el mes
	 */
	private int m;
	
	/**
	 * Atributo que obtiene el año
	 */
	private int a; 

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
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Método que comprueba si la fecha es correcta
	 * @return Devuelve true o false dependiendo de si la fecha es correcta
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/**
	 * Método privado que comprueba si el año es bisiesto usando fechaCorrecta
	 * @return Devuelve true o false dependiendo de si el año es bisiesto
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/**
	 * Método que suma un día al día actual, comprobando si debe de cambiar de mes y de año
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/**
	 * Método que pasa la fecha a String
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
