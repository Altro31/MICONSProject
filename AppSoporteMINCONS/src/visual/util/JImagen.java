package visual.util;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JImagen extends JPanel{
	
	private String path = "fondo.jpg";
	/**
	 * 
	 */
	private static final long serialVersionUID = -1420999087892141348L;

	public JImagen() {
		super();
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setOpaque(false);
		setLayout(null);
	}
	
	@Override
	public void paint(Graphics g) {
		Dimension dimension = this.getSize();
		ImageIcon image = new ImageIcon(getClass().getResource("/imagenes/"+path));
		g.drawImage( image.getImage(), 0, 0, dimension.width, dimension.height, null);
		this.setOpaque(true);
		super.paintChildren(g);
	}
	
	public void setImagePath(String imagePath) {
		path=imagePath;
	}

}
