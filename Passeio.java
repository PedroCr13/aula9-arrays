package atividade6;

public final class Passeio extends Veiculo implements Calcular{
	
	private int qtdPassageiros;
	
	public Passeio() {
		qtdPassageiros = 0;
	}
	
	public final int getQtdPassageiros() {
		return qtdPassageiros;
	}
	
	public final void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	public final float calcVel(float velocMax) {		
		return velocMax * 1000;
	}
	
	public final int calcular() {
		String caracteres = getCor() + getMarca() + getModelo() + getPlaca();	
		return caracteres.length();
	}
}
