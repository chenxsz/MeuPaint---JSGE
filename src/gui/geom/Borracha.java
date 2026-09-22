package gui.geom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class Borracha extends Caneta {

    public Borracha(int tamanho) {
        super(tamanho);
        this.corContorno = Color.WHITE;
    }

    @Override
    public void desenhar(Graphics g) {
        if(getPontos().isEmpty()) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        Stroke strokeOriginal = g2d.getStroke();

        g2d.setStroke(new BasicStroke(espessura, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.setColor(Color.WHITE);

        if(getPontos().size() == 1) {
            Point p = getPontos().get(0);
            g2d.drawLine(p.x, p.y, p.x, p.y);
        } else {
            for(int i = 0; i < getPontos().size() - 1; i++) {
                Point p1 = getPontos().get(i);
                Point p2 = getPontos().get(i + 1);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        g2d.setStroke(strokeOriginal);
    }
}