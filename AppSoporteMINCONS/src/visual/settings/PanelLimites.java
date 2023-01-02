package visual.settings;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import settings.Limites;

public class PanelLimites extends JPanel {

	private static final long serialVersionUID = -1082122820359338116L;
	private JLabel lblEvento;
	private JSeparator separatorEvento1;
	private JSeparator separatorEvento2;
	private JLabel lblNombreEvento;
	private JSpinner spinnerNombreEvento;
	private JSeparator separatorVivienda1;
	private JLabel lblVivienda;
	private JSeparator separatorVivienda2;
	private JLabel lblDireccion;
	private JSpinner spinnerDireccion;
	private JLabel lblDimensiones;
	private JSpinner spinnerDimensiones;
	private JLabel lblPersonas;
	private JSpinner spinnerPersonas;
	private JLabel lblAncianos;
	private JSpinner spinnerAncianos;
	private JLabel lblInfantes;
	private JSpinner spinnerInfantes;
	private JLabel lblEmbarazadas;
	private JSpinner spinnerEmbarazadas;
	private Limites limites;
	private JSeparator separatorMaterial1;
	private JLabel lblMaterial;
	private JSeparator separatorMaterial2;
	private JLabel lblNombreMaterial;
	private JSpinner spinnerNombreMaterial;

	public PanelLimites() {
		limites = (Limites) Limites.getInstance().clone();
		setSize(new Dimension(671, 445));
		setPreferredSize(new Dimension(639, 600));
		initComponents();
	}

	private void initComponents() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(getSeparatorVivienda1(), GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getSeparatorEvento1(), GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(getLblEvento(), GroupLayout.PREFERRED_SIZE, 65,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getLblVivienda(), GroupLayout.PREFERRED_SIZE, 91,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(24)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getSeparatorMaterial1(), GroupLayout.PREFERRED_SIZE, 66,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(getLblMaterial(),
												GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(getSeparatorEvento2(), GroupLayout.PREFERRED_SIZE, 389,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getSeparatorVivienda2(), GroupLayout.PREFERRED_SIZE, 405,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(getSeparatorMaterial2(), GroupLayout.PREFERRED_SIZE, 429,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(getLblNombreMaterial(),
								GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(getLblDireccion(),
								GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(getLblDimensiones(),
								GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(getLblPersonas(),
								GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(getLblAncianos(),
								GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(getLblInfantes(),
								GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(getLblEmbarazadas(),
								GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(getLblNombreEvento(),
								GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addGap(45)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(getSpinnerNombreMaterial(), GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getSpinnerEmbarazadas(), GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getSpinnerInfantes(), GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getSpinnerAncianos(), GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getSpinnerPersonas(), GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getSpinnerDimensiones(), GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getSpinnerDireccion(), GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(getSpinnerNombreEvento(), GroupLayout.PREFERRED_SIZE, 67,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(getLblEvento())
												.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(
														getSeparatorEvento1(), GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(
										groupLayout.createSequentialGroup().addGap(20).addComponent(
												getSeparatorEvento2(), GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(18).addComponent(getLblNombreEvento())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getSpinnerNombreEvento(), GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(
														getSeparatorVivienda1(), GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(getLblVivienda(), GroupLayout.PREFERRED_SIZE, 20,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(75).addComponent(
										getSeparatorVivienda2(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getLblDireccion()).addGap(6)
						.addComponent(getSpinnerDireccion(), GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(getLblDimensiones()).addGap(6)
						.addComponent(getSpinnerDimensiones(), GroupLayout.PREFERRED_SIZE, 24,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(getLblPersonas()).addGap(6)
						.addComponent(getSpinnerPersonas(), GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getLblAncianos()).addGap(6)
						.addComponent(getSpinnerAncianos(), GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGap(6).addComponent(getLblInfantes()).addGap(6)
						.addComponent(getSpinnerInfantes(), GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGap(6).addComponent(getLblEmbarazadas())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(6)
										.addComponent(getSpinnerEmbarazadas(), GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(32).addComponent(
														getLblMaterial(), GroupLayout.PREFERRED_SIZE, 20,
														GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addGap(42).addComponent(
														getSeparatorMaterial1(), GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup().addGap(71).addComponent(
										getSeparatorMaterial2(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(18).addComponent(getLblNombreMaterial()).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getSpinnerNombreMaterial(), GroupLayout.PREFERRED_SIZE, 24,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));
		groupLayout.linkSize(SwingConstants.VERTICAL, getSpinnerEmbarazadas(), getSpinnerInfantes(),
				getSpinnerAncianos(), getSpinnerPersonas(), getSpinnerDimensiones(), getSpinnerDireccion());
		groupLayout.linkSize(SwingConstants.VERTICAL, getLblEmbarazadas(), getLblInfantes(), getLblAncianos(),
				getLblPersonas(), getLblDimensiones(), getLblDireccion());
		groupLayout.linkSize(SwingConstants.HORIZONTAL, getSeparatorEvento2(), getSeparatorVivienda2(),
				getSeparatorMaterial2());
		groupLayout.linkSize(SwingConstants.HORIZONTAL, getLblEvento(), getLblVivienda());
		groupLayout.linkSize(SwingConstants.HORIZONTAL, getLblNombreEvento(), getLblEmbarazadas(), getLblInfantes(),
				getLblAncianos(), getLblPersonas(), getLblDimensiones(), getLblDireccion(), getLblNombreMaterial());
		setLayout(groupLayout);
	}

	private JLabel getLblEvento() {
		if (lblEvento == null) {
			lblEvento = new JLabel("Evento");
			lblEvento.setHorizontalAlignment(SwingConstants.CENTER);
			lblEvento.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblEvento;
	}

	private JSeparator getSeparatorEvento1() {
		if (separatorEvento1 == null) {
			separatorEvento1 = new JSeparator();
		}
		return separatorEvento1;
	}

	private JSeparator getSeparatorEvento2() {
		if (separatorEvento2 == null) {
			separatorEvento2 = new JSeparator();
		}
		return separatorEvento2;
	}

	private JLabel getLblNombreEvento() {
		if (lblNombreEvento == null) {
			lblNombreEvento = new JLabel(
					"• Cantidad máxima de caracteres en el nombre de un evento (0 = No hay límite):");
		}
		return lblNombreEvento;
	}

	private JSpinner getSpinnerNombreEvento() {
		if (spinnerNombreEvento == null) {
			spinnerNombreEvento = new JSpinner();
			spinnerNombreEvento.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int val = (Integer) spinnerNombreEvento.getValue();
					limites.setNombreEvento(val == 0 ? null : val);
				}
			});

			spinnerNombreEvento.setModel(
					new SpinnerNumberModel(Limites.nombreEvento(), Integer.valueOf(0), null, Integer.valueOf(1)));

		}

		return spinnerNombreEvento;
	}

	private JSeparator getSeparatorVivienda1() {
		if (separatorVivienda1 == null) {
			separatorVivienda1 = new JSeparator();
		}
		return separatorVivienda1;
	}

	private JLabel getLblVivienda() {
		if (lblVivienda == null) {
			lblVivienda = new JLabel("Vivienda");
			lblVivienda.setHorizontalAlignment(SwingConstants.CENTER);
			lblVivienda.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblVivienda;
	}

	private JSeparator getSeparatorVivienda2() {
		if (separatorVivienda2 == null) {
			separatorVivienda2 = new JSeparator();
		}
		return separatorVivienda2;
	}

	private JLabel getLblDireccion() {
		if (lblDireccion == null) {
			lblDireccion = new JLabel(
					"• Cantidad máxima de caracteres en la dirección de una vivienda (0 = No hay Límite):");
		}
		return lblDireccion;
	}

	private JSpinner getSpinnerDireccion() {
		if (spinnerDireccion == null) {
			spinnerDireccion = new JSpinner();
			spinnerDireccion.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int val = (Integer) spinnerDireccion.getValue();
					limites.setDireccion(val == 0 ? null : val);
				}
			});
			spinnerDireccion.setModel(
					new SpinnerNumberModel(Limites.direccion(), Integer.valueOf(0), null, Integer.valueOf(1)));

		}
		return spinnerDireccion;
	}

	private JLabel getLblDimensiones() {
		if (lblDimensiones == null) {
			lblDimensiones = new JLabel(
					"• Medida mínima de Largo y Ancho que debe tener una vivienda (0 = No hay Límite):");
		}
		return lblDimensiones;
	}

	private JSpinner getSpinnerDimensiones() {
		if (spinnerDimensiones == null) {
			spinnerDimensiones = new JSpinner();
			spinnerDimensiones.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					float val = (Float) spinnerDimensiones.getValue();
					limites.setDimensiones(val == 0 ? null : val);
				}
			});
			spinnerDimensiones
					.setModel(new SpinnerNumberModel(Limites.dimensions(), Float.valueOf(0), null, Float.valueOf(1)));

		}
		return spinnerDimensiones;
	}

	private JLabel getLblPersonas() {
		if (lblPersonas == null) {
			lblPersonas = new JLabel("• Cantidad máxima de personas en una vivienda (0 = No hay Límite):");
		}
		return lblPersonas;
	}

	private JSpinner getSpinnerPersonas() {
		if (spinnerPersonas == null) {
			spinnerPersonas = new JSpinner();
			spinnerPersonas.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int val = (Integer) spinnerPersonas.getValue();
					limites.setTotalPersonas(val == 0 ? null : val);
				}
			});
			spinnerPersonas
					.setModel(new SpinnerNumberModel(Limites.totalPersonal() == null ? 0 : Limites.totalPersonal(),
							Integer.valueOf(0), null, Integer.valueOf(1)));

		}
		return spinnerPersonas;
	}

	private JLabel getLblAncianos() {
		if (lblAncianos == null) {
			lblAncianos = new JLabel("• Cantidad máxima de ancianos en una vivienda (0 = No hay Límite):");
		}
		return lblAncianos;
	}

	private JSpinner getSpinnerAncianos() {
		if (spinnerAncianos == null) {
			spinnerAncianos = new JSpinner(new SpinnerNumberModel(Limites.ancianos() == null ? 0 : Limites.ancianos(),
					Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerAncianos.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int val = (Integer) spinnerAncianos.getValue();
					limites.setAncianos(val == 0 ? null : val);
				}
			});
		}
		return spinnerAncianos;
	}

	private JLabel getLblInfantes() {
		if (lblInfantes == null) {
			lblInfantes = new JLabel("• Cantidad máxima de niños en una vivienda (0 = No hay Límite):");
		}
		return lblInfantes;
	}

	private JSpinner getSpinnerInfantes() {
		if (spinnerInfantes == null) {
			spinnerInfantes = new JSpinner(new SpinnerNumberModel(Limites.infantes() == null ? 0 : Limites.infantes(),
					Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerInfantes.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int val = (Integer) spinnerInfantes.getValue();
					limites.setInfantes(val == 0 ? null : val);
				}
			});
		}
		return spinnerInfantes;
	}

	private JLabel getLblEmbarazadas() {
		if (lblEmbarazadas == null) {
			lblEmbarazadas = new JLabel("• Cantidad máxima de embarazadas en una vivienda (0 = No hay Límite):");
		}
		return lblEmbarazadas;
	}

	private JSpinner getSpinnerEmbarazadas() {
		if (spinnerEmbarazadas == null) {
			spinnerEmbarazadas = new JSpinner(
					new SpinnerNumberModel(Limites.embarazadas() == null ? 0 : Limites.embarazadas(),
							Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerEmbarazadas.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int val = (Integer) spinnerEmbarazadas.getValue();
					limites.setEmbarazadas(val == 0 ? null : val);
				}
			});
		}
		return spinnerEmbarazadas;
	}

	public Limites getLimites() {
		return limites;
	}

	private JSeparator getSeparatorMaterial1() {
		if (separatorMaterial1 == null) {
			separatorMaterial1 = new JSeparator();
		}
		return separatorMaterial1;
	}

	private JLabel getLblMaterial() {
		if (lblMaterial == null) {
			lblMaterial = new JLabel("Material");
			lblMaterial.setHorizontalAlignment(SwingConstants.CENTER);
			lblMaterial.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblMaterial;
	}

	private JSeparator getSeparatorMaterial2() {
		if (separatorMaterial2 == null) {
			separatorMaterial2 = new JSeparator();
		}
		return separatorMaterial2;
	}

	private JLabel getLblNombreMaterial() {
		if (lblNombreMaterial == null) {
			lblNombreMaterial = new JLabel(
					"• Cantidad máxima de caracteres en el nombre de un material (0 = No hay Límite):");
		}
		return lblNombreMaterial;
	}

	private JSpinner getSpinnerNombreMaterial() {
		if (spinnerNombreMaterial == null) {
			spinnerNombreMaterial = new JSpinner(
					new SpinnerNumberModel(Limites.nombreMaterial() == null ? 0 : Limites.nombreMaterial(),
							Integer.valueOf(0), null, Integer.valueOf(1)));
			spinnerNombreMaterial.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int val = (Integer) spinnerNombreMaterial.getValue();
					limites.setNombreMaterial(val == 0 ? null : val);
				}
			});
		}
		return spinnerNombreMaterial;
	}
}
