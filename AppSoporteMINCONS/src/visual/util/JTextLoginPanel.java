package visual.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class JTextLoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8423273051832415600L;
	private JLabel lblLabel;
	private JPasswordField txtText;
	boolean isPassword;
	private JButton btnEye;
	private final ImageIcon EYE_CLOSED = new ImageIcon(getClass().getResource("/images/EyeClosed.png"));
	private final ImageIcon EYE_OPEN = new ImageIcon(getClass().getResource("/images/EyeOpen.png"));
	private boolean isHiddenPassword;
	private char echoChar;

	/**
	 * Create the panel.
	 */
	public JTextLoginPanel(boolean isPassword) {
		super();
		this.isPassword = isPassword;
		initComponents();
	}

	public void initComponents() {
		setToolTipText("");
		setBounds(130, 211, 349, 40);
		setBackground(new Color(78, 77, 106));
		setLayout(null);
		add(getLblLabel());
		add(getTxtText());
		setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		if (isPassword) {
			add(getBtnEye());
		}
		super.setName("A");
	}

	private JLabel getLblLabel() {
		if (lblLabel == null) {
			lblLabel = new JLabel("Text");
			lblLabel.setForeground(new Color(139, 145, 171));
			lblLabel.setBounds(8, 7, 66, 14);
		}
		return lblLabel;
	}

	private JTextField getTxtText() {
		if (txtText == null) {
			txtText = new JPasswordField();
			txtText.setToolTipText("");
			txtText.setForeground(new Color(206, 209, 219));
			txtText.setAlignmentX(Component.RIGHT_ALIGNMENT);
			txtText.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					setBorder(new LineBorder(new Color(9, 113, 217), 3, true));
					lblLabel.setForeground(new Color(9, 113, 217));
					setBackground(new Color(82, 81, 111));
				}

				@Override
				public void focusLost(FocusEvent e) {
					setBorder(null);
					lblLabel.setForeground(new Color(139, 145, 171));
					setBackground(new Color(78, 77, 106));
				}
			});
			txtText.setBorder(null);
			txtText.setOpaque(false);
			txtText.setBounds(8, 9, 304, 40);
			txtText.setColumns(10);
			txtText.setCaretColor(Color.WHITE);
			echoChar = txtText.getEchoChar();
			if (!isPassword) {
				txtText.setEchoChar((char) 0);
			}

		}
		return txtText;
	}

	public void setText(String text) {
		lblLabel.setText(text);
	}

	public String getText() {
		return new String(txtText.getPassword());
	}

	public JPasswordField getTextField() {
		return txtText;
	}

	@Override
	public void requestFocus() {
		txtText.requestFocus();
	}

	private JButton getBtnEye() {
		if (btnEye == null) {
			btnEye = new JButton("");
			btnEye.setAlignmentY(Component.TOP_ALIGNMENT);
			btnEye.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (isHiddenPassword) {
						btnEye.setIcon(EYE_OPEN);
						isHiddenPassword = false;
						txtText.setEchoChar((char) 0);
					} else {
						btnEye.setIcon(EYE_CLOSED);
						isHiddenPassword = true;
						txtText.setEchoChar(echoChar);
					}

				}
			});
			btnEye.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			btnEye.setFocusable(false);
			btnEye.setContentAreaFilled(false);
			btnEye.setBorder(null);
			btnEye.setIcon(new ImageIcon(JTextLoginPanel.class.getResource("/images/EyeClosed.png")));
			btnEye.setBounds(313, 10, 31, 22);
			isHiddenPassword = true;
		}
		return btnEye;
	}

	public void moveEyeLocation(int x, int y) {
		btnEye.setLocation(new Point(btnEye.getLocation().x + x, btnEye.getLocation().y + y));
	}

	public void moveTextLocation(int x, int y) {
		txtText.setLocation(new Point(txtText.getLocation().x + x, txtText.getLocation().y + y));
	}
}
