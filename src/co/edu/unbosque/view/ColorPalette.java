package co.edu.unbosque.view;

import java.awt.Color;

public class ColorPalette {
    // Definir constantes para los colores con nombres descriptivos
    private static final Color MAIN_RED = new Color(255, 32, 78);
    private static final Color SECONDARY_RED = new Color(160, 21, 62);
    private static final Color MAIN_PURPLE = new Color(93, 14, 65);
    private static final Color MAIN_BLACK = new Color(0, 34, 77);
    private static final Color MAIN_WHITE = new Color(255, 245, 248);
    private static final Color MAIN_GRAY = new Color(204, 202, 202);
    private static final Color TRANSPARENT = new Color(204, 202, 202, 0);
    private static final Color SECONDARY_BLUE = new Color(0, 207, 204);

	public static Color getMainRed() {
		return MAIN_RED;
	}

	public static Color getSecondaryRed() {
		return SECONDARY_RED;
	}

	public static Color getMainPurple() {
		return MAIN_PURPLE;
	}

	public static Color getMainBlack() {
		return MAIN_BLACK;
	}

	public static Color getMainWhite() {
		return MAIN_WHITE;
	}

	public static Color getMainGray() {
		return MAIN_GRAY;
	}

	public static Color getTransparent() {
		return TRANSPARENT;
	}

	public static Color getSecondaryBlue() {
		return SECONDARY_BLUE;
	}
}
