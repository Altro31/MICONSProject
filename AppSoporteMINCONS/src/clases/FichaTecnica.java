package clases;

public class FichaTecnica {

	private Vivienda vivienda;
	private Afectacion afect;
	private float cubicacion;
	
	public FichaTecnica(float cub) {
		this.cubicacion=cub;
	}
	
	private static FichaTecnica ficha;

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		if (vivienda == null)
			throw new IllegalArgumentException(" La vivenda no puede tomar valor null");

		this.vivienda = vivienda;
	}

	public Afectacion getAfect() {
		return afect;
	}

	public void setAfect(Afectacion afect) {
		if (afect == null)
			throw new IllegalArgumentException(" La afectacion no puede tomar valor null");

		this.afect = afect;
	}

	public float getCubicacion() {
		return cubicacion;
	}

	public void setCubicacion(float cubicacion) {
		if (cubicacion < 0)
			throw new IllegalArgumentException("La cubicacion no puede ser menor que cero");

		this.cubicacion = cubicacion;
	}
	
	public static FichaTecnica getInstance(boolean nuevaInstancia) {
		if (ficha==null || nuevaInstancia) {
			ficha=new FichaTecnica(0F);
		}
		return ficha;
	}

}
