package co.edu.unbosque.view.utils;

import java.awt.Color;

/**
 * Esta clase define una paleta de colores estática que se utiliza en toda la
 * aplicación. Los colores están definidos como constantes y se proporcionan
 * métodos estáticos para acceder a ellos.
 */
public class ColorPalette {
	// Definir constantes para los colores con nombres descriptivos
	private static final Color MAIN_RED = new Color(255, 32, 78);
	private static final Color SECONDARY_RED = new Color(160, 21, 62);
	private static final Color MAIN_PURPLE = new Color(93, 14, 65);
	private static final Color MAIN_BLACK = new Color(0, 34, 77);
	private static final Color MAIN_WHITE = new Color(255, 245, 248);
	private static final Color SIMPLE_WHITE = new Color(255, 255, 255);
	private static final Color MAIN_GRAY = new Color(204, 202, 202);
	private static final Color TRANSPARENT = new Color(204, 202, 202, 0);
	private static final Color SECONDARY_BLUE = new Color(0, 207, 204);

	/**
	 * Obtiene el color rojo principal.
	 * 
	 * @return el color rojo principal.
	 */
	public static Color getMainRed() {
		return MAIN_RED;
	}

	/**
	 * Obtiene el color rojo secundario.
	 * 
	 * @return el color rojo secundario.
	 */
	public static Color getSecondaryRed() {
		return SECONDARY_RED;
	}

	/**
	 * Obtiene el color púrpura principal.
	 * 
	 * @return el color púrpura principal.
	 */
	public static Color getMainPurple() {
		return MAIN_PURPLE;
	}

	/**
	 * Obtiene el color negro principal.
	 * 
	 * @return el color negro principal.
	 */
	public static Color getMainBlack() {
		return MAIN_BLACK;
	}

	/**
	 * Obtiene el color blanco principal.
	 * 
	 * @return el color blanco principal.
	 */
	public static Color getMainWhite() {
		return MAIN_WHITE;
	}

	/**
	 * Obtiene el color gris principal.
	 * 
	 * @return el color gris principal.
	 */
	public static Color getMainGray() {
		return MAIN_GRAY;
	}

	/**
	 * Obtiene el color transparente.
	 * 
	 * @return el color transparente.
	 */
	public static Color getTransparent() {
		return TRANSPARENT;
	}

	/**
	 * Obtiene el color azul secundario.
	 * 
	 * @return el color azul secundario.
	 */
	public static Color getSecondaryBlue() {
		return SECONDARY_BLUE;
	}

	/**
	 * Obtiene el color blanco simple.
	 * 
	 * @return el color blanco simple.
	 */
	public static Color getSimpleWhite() {
		return SIMPLE_WHITE;
	}
}
