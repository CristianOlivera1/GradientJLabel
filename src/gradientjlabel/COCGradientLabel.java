
package gradientjlabel;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
/*
 @autor Cristian Olivera Chávez COC
*/
public class COCGradientLabel extends JLabel {
    private Color color1 = Color.RED; // Valor predeterminado
    private Color color2 = Color.YELLOW; // Valor predeterminado

    // Constructor principal
    public COCGradientLabel(String text, Color color1, Color color2) {
        super(text);
        this.color1 = color1;
        this.color2 = color2;
        setOpaque(false);
      setFont(getFont().deriveFont(16f)); // Tamaño de fuente predeterminado
    }

    // Constructor sin parámetros
    public COCGradientLabel() {
        this("", Color.RED, Color.YELLOW); // Valores predeterminados
    }

    // Getters y Setters para los colores
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
        repaint(); // Redibuja el componente cuando cambie el color
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
        repaint(); // Redibuja el componente cuando cambie el color
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Obtener el texto y su tamaño
        FontMetrics fm = g2d.getFontMetrics();
        String text = getText();
        Rectangle2D textBounds = fm.getStringBounds(text, g2d);
        int textWidth = (int) textBounds.getWidth();
        int textHeight = (int) textBounds.getHeight();

        // Crear un gradiente que cubra el texto
        GradientPaint gradient = new GradientPaint(
            0, 0, color1, 
            textWidth, textHeight, color2
        );

        // Aplicar el gradiente al texto
        g2d.setPaint(gradient);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawString(text, 0, fm.getAscent());

        g2d.dispose();
    }
}
