package Proyectogame;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FiltroNombre extends DocumentFilter {

    final int limite = 30;

    public void replace(DocumentFilter.FilterBypass fb, int offs, int length,
            String str, AttributeSet a) throws BadLocationException {

        String text = fb.getDocument().getText(0,
                fb.getDocument().getLength());
        text += str;
        if ((fb.getDocument().getLength() + str.length() - length) <= limite
                && text.matches("^[a-zA-Z]*$")) {
            super.replace(fb, offs, length, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void insertString(DocumentFilter.FilterBypass fb, int offs, String str,
            AttributeSet a) throws BadLocationException {

        String text = fb.getDocument().getText(0,
                fb.getDocument().getLength());
        text += str;
        if ((fb.getDocument().getLength() + str.length()) <= limite
                && text.matches("^[a-zA-Z]*$")) {
            super.insertString(fb, offs, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
