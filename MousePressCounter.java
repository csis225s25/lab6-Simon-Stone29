import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Lab 5 demo of mouse events.
 * 
 * 
 * @author Jaden Brown, Simon Stone
 * @version Spring 2025
 */
public class MousePressCounter extends MouseAdapter implements Runnable, ActionListener {

    private int clickCount = 0;
	private String toDisplay = "Mouse Press Count: 0";

    private JPanel panel = new JPanel();
    private JPanel resetPanel = new JPanel();
    private JButton reset = new JButton("Reset");

	/**
	 * The run method to set up the graphical user interface
	 */
	@Override
	public void run() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("MouseDemo");
		frame.setPreferredSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct an anonymous class that extends JPanel,
		// for which we override the paintComponent method
		 panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);

				FontMetrics fm = g.getFontMetrics();

				int stringWidth = fm.stringWidth(toDisplay);
				int stringAscent = fm.getAscent();

				int xStart = getWidth() / 2 - stringWidth / 2;
				int yStart = getHeight() / 2 + stringAscent / 2;

				g.drawString(toDisplay, xStart, yStart);
			}
		};

        frame.setLayout(new BorderLayout());

        //Creation of the panel that holds the reset button
        resetPanel.add(reset);
        reset.addActionListener(this);

        //Creation of the full window
        frame.add(resetPanel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);

		// display the window we've created
		frame.pack();
		frame.setVisible(true);
	}

    //actionPerformed method runs whenever the reset button is pressed. Method just resets clickCount.
    @Override
    public void actionPerformed(ActionEvent e) {
        clickCount = 0;
        toDisplay = "Mouse Press Count: " + clickCount;
        panel.repaint();
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked: " + e);
        clickCount++;
        toDisplay = "Mouse Press Count: " + clickCount;

        panel.repaint();
	}

	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
	}
}
