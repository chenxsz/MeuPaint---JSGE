package gui.geom;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

public class Caneta extends Forma {

    private List<Point> pontos;
    protected int espessura;

    public Caneta() {
        this(1);
    }

    public Caneta(int espessura) {
        this.pontos = new ArrayList<>();
        this.espessura = espessura;
    }

    public void adicionarPonto(int x, int y) {
        pontos.add(new Point(x, y));
    }

    public List<Point> getPontos() {
        return pontos;
    }

    public int getEspessura() {
        return espessura;
    }

    public void setEspessura(int espessura) {
        this.espessura = espessura;
    }

    @Override
    public void desenhar(Graphics g) {
        if(pontos.isEmpty()) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        Stroke strokeOriginal = g2d.getStroke();

        g2d.setStroke(new BasicStroke(espessura, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        if(corContorno != null) {
            g2d.setColor(corContorno);
        }

        if(pontos.size() == 1) {
            Point p = pontos.get(0);
            g2d.drawLine(p.x, p.y, p.x, p.y);
        } else {
            for (int i = 0; i < pontos.size() - 1; i++) {
                Point p1 = pontos.get(i);
                Point p2 = pontos.get(i + 1);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        g2d.setStroke(strokeOriginal);
    }
}