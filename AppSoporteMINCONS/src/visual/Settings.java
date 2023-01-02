package visual;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import classes.Material;
import classes.Sistema;
import settings.Limites;
import settings.Manager;
import visual.settings.PanelAcercaDe;
import visual.settings.PanelLimites;
import visual.settings.PanelMateriales;
import visual.util.PrincipalPanel;

public class Settings extends PrincipalPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 905221128391092005L;

	private static final String LIMITES = "Límites";
	private static final String MATERIALES = "Materiales";
	private static final String ACERCA_DE = "Acerca De";

	private JPanel panelList;
	private JPanel contentPane;
	private JToggleButton btnMateriales;
	private JToggleButton btnLimites;

	private JScrollPane scrollPaneLimites;
	private PanelLimites panelLimites;
	private JPanel panelButton;
	private JToggleButton btnAplicar;
	private JToggleButton btnRestaurar;
	private JScrollPane scrollPaneMateriales;
	private PanelMateriales panelMateriales;
	private CardLayout layout;

	private JToggleButton btnAcercaDe;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JScrollPane scrollPaneAcercaDe;
	private PanelAcercaDe panelAcercaDe;

	/**
	 * Create the panel.
	 */
	public Settings() {
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame.anteriorPrincipal(1);
				Frame.setContentPanes((Principal) Frame.getPosicionActual()[0]);
			}
		});

		add(getPanelButton());
		add(getPanelList());
		add(getContentPane());
		aplicarEventos(this);

	}

	public void activarBotones() {

		btnAplicar.setEnabled(true);
		btnRestaurar.setEnabled(true);

	}

	public void aplicarEventos(Container panel) {
		for (Component component : panel.getComponents()) {
			if (component instanceof JSpinner) {
				((JSpinner) component).addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						activarBotones();
					}
				});
			} else {
				if (component instanceof JPanel) {
					aplicarEventos((Container) component);
				} else if (component instanceof JScrollPane) {
					aplicarEventos(((JScrollPane) component).getViewport());
				} else if (component instanceof JTable) {
					((JTable) component).getModel().addTableModelListener(new TableModelListener() {
						@Override
						public void tableChanged(TableModelEvent e) {
							activarBotones();
						}
					});
				}
			}
		}
	}

	private void changeSelectionCard(JToggleButton newSelected) {

		layout.show(contentPane, newSelected.getText());

		panelButton.setVisible(true);
	}

	private void oscurecer(final JToggleButton button) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(button.getBackground().darker());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(button.getBackground().brighter());
			}
		});
	}

	private JPanel getPanelList() {
		if (panelList == null) {
			panelList = new JPanel();
			panelList.setBorder(null);
			panelList.setBackground(new Color(255, 255, 255));
			panelList.setBounds(10, 35, 199, 445);
			panelList.setLayout(new GridLayout(12, 1, 0, 0));
			panelList.add(getBtnLimites());
			panelList.add(getBtnMateriales());
			panelList.add(getBtnAcercaDe());

		}
		return panelList;
	}

	private JPanel getContentPane() {
		if (contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBorder(null);
			contentPane.setBounds(210, 35, 671, 416);
			layout = new CardLayout(0, 0);
			contentPane.setLayout(layout);
			contentPane.add(getScrollPaneLimites(), LIMITES);
			contentPane.add(getScrollPaneMateriales(), MATERIALES);
			contentPane.add(getScrollPaneAcercaDe(), ACERCA_DE);
		}
		return contentPane;
	}

	private JToggleButton getBtnMateriales() {
		if (btnMateriales == null) {
			btnMateriales = new JToggleButton(MATERIALES);
			btnMateriales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeSelectionCard(btnMateriales);
				}
			});
			btnMateriales.setFocusable(false);
			btnMateriales.setFocusCycleRoot(true);
			btnMateriales.setFocusTraversalPolicyProvider(true);
			btnMateriales.setFocusTraversalKeysEnabled(true);
			buttonGroup.add(btnMateriales);
			btnMateriales.setBorder(null);
			btnMateriales.setBackground(Color.WHITE);
			btnMateriales.setOpaque(true);
			btnMateriales.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnMateriales.setHorizontalAlignment(SwingConstants.CENTER);
			oscurecer(btnMateriales);
		}
		return btnMateriales;
	}

	private JToggleButton getBtnLimites() {
		if (btnLimites == null) {
			btnLimites = new JToggleButton(LIMITES);
			btnLimites.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeSelectionCard(btnLimites);
				}
			});
			btnLimites.setFocusable(false);
			btnLimites.setFocusCycleRoot(true);
			btnLimites.setFocusTraversalPolicyProvider(true);
			btnLimites.setFocusTraversalKeysEnabled(true);
			buttonGroup.add(btnLimites);
			btnLimites.setBorder(null);
			btnLimites.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnLimites.setOpaque(true);
			btnLimites.setHorizontalAlignment(SwingConstants.CENTER);
			btnLimites.setSelected(true);
			btnLimites.setBackground(new Color(255, 255, 255));
			oscurecer(btnLimites);
		}
		return btnLimites;
	}

	private JScrollPane getScrollPaneLimites() {
		if (scrollPaneLimites == null) {
			scrollPaneLimites = new JScrollPane();
			scrollPaneLimites.setBorder(null);
			scrollPaneLimites.setViewportView(getPanelLimites());
		}
		return scrollPaneLimites;
	}

	private JPanel getPanelLimites() {
		if (panelLimites == null) {
			panelLimites = new PanelLimites();
			panelLimites.setSize(652, 445);
		}
		return panelLimites;
	}

	private JPanel getPanelButton() {
		if (panelButton == null) {
			panelButton = new JPanel();
			panelButton.setBounds(210, 451, 671, 29);
			GroupLayout glPanelButton = new GroupLayout(panelButton);
			glPanelButton.setHorizontalGroup(
					glPanelButton.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
							glPanelButton.createSequentialGroup().addContainerGap(466, Short.MAX_VALUE)
									.addComponent(getBtnAplicar()).addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getBtnRestaurar()).addGap(37)));
			glPanelButton.setVerticalGroup(glPanelButton.createParallelGroup(Alignment.LEADING)
					.addGroup(glPanelButton.createSequentialGroup().addGap(5)
							.addGroup(glPanelButton.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(getBtnRestaurar(), Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(getBtnAplicar(), Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 19,
											GroupLayout.PREFERRED_SIZE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			glPanelButton.linkSize(SwingConstants.VERTICAL, getBtnAplicar(), getBtnRestaurar());
			glPanelButton.linkSize(SwingConstants.HORIZONTAL, getBtnAplicar(), getBtnRestaurar());
			panelButton.setLayout(glPanelButton);
		}
		return panelButton;
	}

	private JToggleButton getBtnAplicar() {
		if (btnAplicar == null) {
			btnAplicar = new JToggleButton("Aplicar");
			btnAplicar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Limites.update(panelLimites.getLimites());

					Sistema.getInstance().getListaMateriales().clear();

					for (Material material : panelMateriales.getListaMateriales()) {
						Sistema.getInstance().getListaMateriales().add(material);
					}

					Manager.guardarDatos();
					btnAplicar.setEnabled(false);
				}
			});
			btnAplicar.setFocusable(false);
			btnAplicar.setEnabled(false);
		}
		return btnAplicar;
	}

	private JToggleButton getBtnRestaurar() {
		if (btnRestaurar == null) {
			btnRestaurar = new JToggleButton("Restaurar");
			btnRestaurar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Limites.restoreDefaultValues();
					btnRestaurar.setEnabled(false);
					scrollPaneLimites.setViewportView(new PanelLimites());
					updateUI();
					aplicarEventos(scrollPaneLimites.getViewport());

				}
			});
			btnRestaurar.setFocusable(false);
			btnRestaurar.setEnabled(false);
		}
		return btnRestaurar;
	}

	private JScrollPane getScrollPaneMateriales() {
		if (scrollPaneMateriales == null) {
			scrollPaneMateriales = new JScrollPane();
			scrollPaneMateriales.setBorder(null);
			scrollPaneMateriales.setViewportView(getPanelMateriales());
		}
		return scrollPaneMateriales;
	}

	private PanelMateriales getPanelMateriales() {
		if (panelMateriales == null) {
			panelMateriales = new PanelMateriales();
		}
		return panelMateriales;
	}

	private JToggleButton getBtnAcercaDe() {
		if (btnAcercaDe == null) {
			btnAcercaDe = new JToggleButton(ACERCA_DE);
			btnAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeSelectionCard(btnAcercaDe);
				}
			});
			btnAcercaDe.setFocusable(false);
			btnAcercaDe.setFocusCycleRoot(true);
			btnAcercaDe.setFocusTraversalPolicyProvider(true);
			btnAcercaDe.setFocusTraversalKeysEnabled(true);
			buttonGroup.add(btnAcercaDe);
			btnAcercaDe.setBorder(null);
			btnAcercaDe.setBackground(new Color(255, 255, 255));
			btnAcercaDe.setOpaque(true);
			btnAcercaDe.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnAcercaDe.setHorizontalAlignment(SwingConstants.CENTER);
			oscurecer(btnAcercaDe);
		}
		return btnAcercaDe;
	}

	private JScrollPane getScrollPaneAcercaDe() {
		if (scrollPaneAcercaDe == null) {
			scrollPaneAcercaDe = new JScrollPane();
			scrollPaneAcercaDe.setFocusable(false);
			scrollPaneAcercaDe.setViewportView(getPanelAcercaDe());
		}
		return scrollPaneAcercaDe;
	}

	private PanelAcercaDe getPanelAcercaDe() {
		if (panelAcercaDe == null) {
			panelAcercaDe = new PanelAcercaDe();
			panelAcercaDe.setPreferredSize(new Dimension(10, 550));
		}
		return panelAcercaDe;
	}
}
