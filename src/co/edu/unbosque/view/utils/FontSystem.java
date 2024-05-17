package co.edu.unbosque.view.utils;

import java.awt.Font;

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

    // Getter para obtener la fuente H1
    public static Font getH1() {
        return H1;
    }

    // Getter para obtener la fuente H2
    public static Font getH2() {
        return H2;
    }

    // Getter para obtener la fuente H3
    public static Font getH3() {
        return H3;
    }

    // Getter para obtener la fuente H4
    public static Font getH4() {
        return H4;
    }

    // Getter para obtener la fuente H5
    public static Font getH5() {
        return H5;
    }

    // Getter para obtener la fuente H6
    public static Font getH6() {
        return H6;
    }

    // Getter para obtener la fuente para párrafos
    public static Font getParagraph() {
        return PARAGRAPH;
    }

    // Getter para obtener la fuente para títulos grandes
    public static Font getLargeTitle() {
        return LARGE_TITLE;
    }

    // Getter para obtener la fuente para títulos extra grandes
    public static Font getExtraLargeTitle() {
        return EXTRA_LARGE_TITLE;
    }

	public static Font getLargeParagraph() {
		return LARGE_PARAGRAPH;
	}

	public static Font getExtraLargeParagraph() {
		return EXTRA_LARGE_PARAGRAPH;
	}
	
	
}
