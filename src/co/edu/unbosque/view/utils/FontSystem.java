package co.edu.unbosque.view.utils;

import java.awt.Font;

/**
 *  Esta clase define un sistema de fuentes estáticas que se utilizan en toda la aplicación.
 * Las fuentes están definidas como constantes y se proporcionan métodos estáticos para acceder a ellas.
 */
public class FontSystem {
	// Definir constantes para las fuentes con nombres descriptivos
    private static final Font H1 = new Font(Font.SANS_SERIF, Font.BOLD, 32);
    private static final Font H2 = new Font(Font.SANS_SERIF, Font.BOLD, 24);
    private static final Font H3 = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    private static final Font H4 = new Font(Font.SANS_SERIF, Font.BOLD, 18);
    private static final Font H5 = new Font(Font.SANS_SERIF, Font.BOLD, 16);
    private static final Font H6 = new Font(Font.SANS_SERIF, Font.BOLD, 14);
    private static final Font PARAGRAPH = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
    private static final Font LARGE_PARAGRAPH = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    private static final Font EXTRA_LARGE_PARAGRAPH = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
    private static final Font LARGE_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 48);
    private static final Font EXTRA_LARGE_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 64);

    /**
     * Obtiene la fuente H1.
     * 
     * @return la fuente H1.
     */
    public static Font getH1() {
        return H1;
    }

    /**
     * Obtiene la fuente H2.
     * 
     * @return la fuente H2.
     */
    public static Font getH2() {
        return H2;
    }

    /**
     * Obtiene la fuente H3.
     * 
     * @return la fuente H3.
     */
    public static Font getH3() {
        return H3;
    }
    /**
     * Obtiene la fuente H4.
     * 
     * @return la fuente H4.
     */
    public static Font getH4() {
        return H4;
    }
    /**
     * Obtiene la fuente H5.
     * 
     * @return la fuente H5.
     */
    public static Font getH5() {
        return H5;
    }

    /**
     * Obtiene la fuente H6.
     * 
     * @return la fuente H6.
     */
    public static Font getH6() {
        return H6;
    }

    /**
     * Obtiene la fuente para párrafos.
     * 
     * @return la fuente para párrafos.
     */
    public static Font getParagraph() {
        return PARAGRAPH;
    }

    /**
     * Obtiene la fuente para párrafos grandes.
     * 
     * @return la fuente para párrafos grandes.
     */
    public static Font getLargeTitle() {
        return LARGE_TITLE;
    }

    /**
     * Obtiene la fuente para párrafos extra grandes.
     * 
     * @return la fuente para párrafos extra grandes.
     */
    public static Font getExtraLargeTitle() {
        return EXTRA_LARGE_TITLE;
    }
    /**
     * Obtiene la fuente para títulos grandes.
     * 
     * @return la fuente para títulos grandes.
     */
	public static Font getLargeParagraph() {
		return LARGE_PARAGRAPH;
	}
    /**
     * Obtiene la fuente para títulos extra grandes.
     * 
     * @return la fuente para títulos extra grandes.
     */
	public static Font getExtraLargeParagraph() {
		return EXTRA_LARGE_PARAGRAPH;
	}
	
	
}
