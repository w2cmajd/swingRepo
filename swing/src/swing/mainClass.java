package swing;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainClass {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame f = new JFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.add(new LoadImage());
				f.pack();
				f.setVisible(true);
			}
		});
	}

}

class LoadImage extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image;

	public LoadImage() {
		super(new GridLayout());
		try {
			image = ImageIO.read(new URL(
					"http://www.java2s.com/style/download.png"));
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		this.add(new JLabel(new ImageIcon(image.getScaledInstance(w, h,
				Image.SCALE_SMOOTH))));
	}
}
