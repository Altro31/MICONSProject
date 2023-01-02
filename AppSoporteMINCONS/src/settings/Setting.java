package settings;

import java.io.Serializable;

public class Setting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1162184581806078116L;

	private Limites limites;
	private static Setting setting;

	private Setting() {

		limites = Limites.getInstance();

	}

	public void updateSettings(Setting setting) {
		Limites.update(setting.getLimites());
	}

	public Limites getLimites() {
		return limites;
	}

	public static Setting getSetting() {
		if (setting == null) {
			setting = new Setting();
		}
		return setting;
	}
}
