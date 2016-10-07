import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by NgT on 10/2/2016.
 */
public class GameWindow extends Frame {
    Image backgroundImage = null;
    Image plane3Image = null;
    Image plane4Image = null;
    private int plane3X = 800 / 2 - 25;
    private int plane3Y = 600 - 70;
    private int plane4X = 800 / 2 - 25;
    private int plane4Y = 600 - 140;
    private int preX, preY;
    public GameWindow() {
        this.setVisible(true);
        this.setSize(800, 600);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {
                System.out.println("windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {
                System.out.println("windowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {
                System.out.println("windowDeactivated");
            }
        });
        this.setLocationRelativeTo(null);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        plane3X += 10;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        plane3X -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        plane3Y -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        plane3Y += 10;
                        repaint();
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                System.out.println("keyReleased");
            }
        });
        //MouseListener create new plane control by mouse.

        this.addMouseListener(new MouseListener() {


            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (e.getX() != plane4X && e.getY() != plane4Y ) {
                    System.out.println(e.getX() + " " +e.getY());
                    plane4X = e.getX();
                    plane4Y = e.getY();
                }
                repaint();
            }
        });
        try {
            backgroundImage = ImageIO.read(
                    new File("resources/background.png"));
            plane3Image = ImageIO.read(
                    new File("resources/plane3.png"));
            plane4Image = ImageIO.read(
                    new File("resources/plane4.png"));
            System.out.println("Loaded backgroundImage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
        g.drawImage(plane3Image, plane3X, plane3Y, 70, 51, null);
        g.drawImage(plane4Image, plane4X, plane4Y, 70, 62, null);
    }
}
