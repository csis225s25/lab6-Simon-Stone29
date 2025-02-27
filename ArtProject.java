import java.awt.*;
import javax.swing.*;
import java.util.Random;

/**
 * Lab 6 starter example
 * 
 * @author Jim Teresco
 * @author Ira Goldstein
 * @author Simon Stone and Jaden Brown
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class GraphicsPanel2 extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        
        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);
        setBackground(Color.PINK);
        // the Graphics object passed to this method has many methods
        // we can use to draw in the area of the panel, one of which
        // allows us to draw a String at a given x,y position
        
        Random rand = new Random();
        
        g.setColor(Color.MAGENTA);
        for(int i = 0; i < 10; i++){
            g.fillOval(rand.nextInt(getWidth()),rand.nextInt(getHeight()),rand.nextInt(getWidth()),rand.nextInt(getHeight()));
        }

        g.setColor(Color.CYAN);
        for(int i = 0; i < 10; i++){
            g.fillRect(rand.nextInt(getWidth()),rand.nextInt(getHeight()),rand.nextInt(getWidth()),rand.nextInt(getHeight()));
        }

        g.setColor(Color.RED);
        for(int i = 0; i < 10; i++){
            g.fillArc(rand.nextInt(getWidth()),rand.nextInt(getHeight()),rand.nextInt(getWidth()),rand.nextInt(getHeight()), rand.nextInt(360), rand.nextInt(360));
        }
        g.setColor(Color.ORANGE);
        for(int i = 0; i < 10; i++){
            g.drawOval(rand.nextInt(getWidth()),rand.nextInt(getHeight()),rand.nextInt(getWidth()),rand.nextInt(getHeight()));
        }

        g.setColor(Color.GREEN);
        for(int i = 0; i < 10; i++){
            g.drawRect(rand.nextInt(getWidth()),rand.nextInt(getHeight()),rand.nextInt(getWidth()),rand.nextInt(getHeight()));
        }
        
        //g.drawPolygon();
    }
}

public class ArtProject implements Runnable {
    /**
     * The run method to set up the graphical user interface
     */
    @Override
    public void run() {
        Random rand = new Random();
        
        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("ArtProject");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new GraphicsPanel2();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}
