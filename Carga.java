package atividade6;

public final class Carga extends Veiculo implements Calcular{

	private int cargaMax;
	private int tara;
	
	public Carga() {
		cargaMax = 0;
		tara = 0;
	}
	
	public final int getCargaMax() {
		return cargaMax;
	}
	
	public final int getTara() {
		return tara;
	}
	
	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}
	
	public final void setTara(int tara) {
		this.tara = tara;
	}
	
	public final float calcVel(float velocMax) {
		return velocMax * 100000;
	}
	
	public final int calcular() {
		int somaNumericos = (int)getVelocMax() + getQtdRodas() + getCargaMax() + getTara() 
			+ getMotor().getPotencia() + getMotor().getQtdPist();	
		return somaNumericos;
	}
}
