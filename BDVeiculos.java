package atividade6;

public class BDVeiculos {

	private Passeio p[] = new Passeio[2];
	private Carga c[] = new Carga[2];
	
	/*####################### Veiculo de Passeio ######################*/
	
	//Recebe um objeto Passeio e adiciona-o ao vetor.
	public boolean setVeiculoPasseio(Passeio passeio) {
		
		int pos = getIndiceDisponivelVeiculoPasseio();
		
		if (pos > -1) {
			p[pos] = passeio;
			return true;
		}
		
		return false;
	}
	
	public Passeio retornaPasseioPelaPosicao(int posicao) {
		return p[posicao];
	}
	
	/*Procura uma posicao vazia no vetor,
	  caso encontre uma retornar o indice
	  caso não encontrei retorna -1
	*/
	public int getIndiceDisponivelVeiculoPasseio() {
		
		for(int i = 0; i < p.length; i++) {
			if (p[i] == null) return i;
		}	
		return -1;
	}
	
	//Retorna o indice onde se encontra o veiculo (pela placa)
	public int getIndiceDoVeiculoPasseio(String placa) {
		for(int i = 0; i < p.length; i++) {
			if (p[i] != null) {
				if (p[i].getPlaca().equalsIgnoreCase(placa)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	//Imprime os dados de um veiculo de passeio pela placa
	public void imprimeVeiculoDePasseio(String placa) {
		
		int i = getIndiceDoVeiculoPasseio(placa);
		
		if (i > -1) {
			imprimirVeiculoDePasseio(retornaPasseioPelaPosicao(i));
		} else {
			System.out.println("\nVeiculo não localizado!");
		}
	}
	
	//Imprime os dados de um veiculo de passeio
	public void imprimirVeiculoDePasseio(Passeio p) {		
		System.out.println("\n********** Veiculo de Passeio ***********");
		System.out.println("Marca := " + p.getMarca());
		System.out.println("Modelo := " + p.getModelo());
		System.out.println("Cor := " + p.getCor());
		System.out.println("Placa := " + p.getPlaca());
		System.out.println("Qtd Rodas := " + p.getQtdRodas());
		System.out.println("Velocidade Maxima (km/h) := " + p.getVelocMax());
		System.out.println("Velocidade Maxima (m/h) := " + p.calcVel(p.getVelocMax()));
		System.out.println("Qtd Passageiros := " + p.getQtdPassageiros());
		System.out.println("Potencia do Motor := " + p.getMotor().getPotencia());
		System.out.println("Qtd Pistoes do Motor := " + p.getMotor().getQtdPist());
		System.out.println("Valor Caculado Interface := " + p.calcular());
		System.out.println("\n*******************************************");	

	}
	
	public void imprimeTodosVeiculosDePasseio() {
		boolean achou = false;
		for(int i = 0; i < p.length; i++) {
			if(p[i] !=  null) {
				imprimirVeiculoDePasseio(p[i]);
			}
		}
		
		if (!achou) {
			System.out.println("\nNao ha veiculos para exibir!");
		}
	}
	
	/*####################### Veiculo de Carga ######################*/
	
	//Recebe um objeto Carga e adiciona-a ao vetor.
	public boolean adicionarVeiculoCarga(Carga carga) {
		
		int pos = acharPosicaoVaziaVeculoCarga();
		
		if (pos > -1) {
			c[pos] = carga;
			return true;
		}
		return false;
	}
	
	public Carga retornaCargaPelaPosicao(int posicao) {
		return c[posicao];
	}
	
	/*Procura uma posicao vazia no vetor,
	  caso encontre uma retornar o indice
	  caso não encontrei retorna -1
	*/
	public int acharPosicaoVaziaVeculoCarga() {
		
		for(int i = 0; i < c.length; i++) {
			if (c[i] == null) return i;
		}	
		return -1;
	}
	
	//Retorna o indice onde se encontra o veiculo (pela placa)
	public int posicaoDoVeiculoCarga(String placa) {
		for(int i = 0; i < c.length; i++) {
			if (c[i] != null) {
				if (c[i].getPlaca().equalsIgnoreCase(placa)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	//Imprime os dados de um veiculo de carga pela placa
	public void imprimeVeiculoDeCarga(String placa) {
		
		int i = posicaoDoVeiculoCarga(placa);
		
		if (i > -1) {
			imprimirVeiculoDeCarga(retornaCargaPelaPosicao(i));
		} else {
			System.out.println("\nVeiculo não localizado!");
		}
	}
	
	//Imprime os dados de um veiculo de Carga
	public void imprimirVeiculoDeCarga(Carga c) {		
		System.out.println("\n********** Veiculo de Carga ***********");
		System.out.println("Marca := " + c.getMarca());
		System.out.println("Modelo := " + c.getModelo());
		System.out.println("Cor := " + c.getCor());
		System.out.println("Placa := " + c.getPlaca());
		System.out.println("Qtd Rodas := " + c.getQtdRodas());
		System.out.println("Velocidade Maxima (km/h) := " + c.getVelocMax());
		System.out.println("Velocidade Maxima (cm/h) := " + c.calcVel(c.getVelocMax()));	
		System.out.println("Carga maxima := " + c.getCargaMax());
		System.out.println("Tara := " + c.getTara());
		System.out.println("Potencia do Motor := " + c.getMotor().getPotencia());
		System.out.println("Qtd Pistoes do Motor := " + c.getMotor().getQtdPist());
		System.out.println("Valor Caculado Interface := " + c.calcular());
		System.out.println("\n*******************************************");
	}
	
	public void imprimeTodosVeiculosDeCarga() {
		boolean achou = false;
		for(int i = 0; i < c.length; i++) {
			if(c[i] !=  null) {
				imprimirVeiculoDeCarga(c[i]);
				achou = true;
			}
		}
		if (!achou) {
			System.out.println("\nNao ha veiculos para exibir!");
		}
	}
	
}
