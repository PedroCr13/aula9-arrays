package atividade6;

public class Teste{

	public static void main(String args[]){
		
		BDVeiculos bd = new BDVeiculos();
		
		Leitura l = new Leitura();
		int opcao = 0;
		
		do {
			exibeMenu();
			
			try {
				opcao = Integer.parseInt(l.entDados("\nDigite uma opcao:"));
			}catch(NumberFormatException nfe) {
				System.out.println("Deve ser um valor inteiro - <Press Enter>");
				l.entDados("");
				
				continue; //retorna no laço mais proximo, no caso o Do{ } while()
			}		
			
			switch (opcao){
				case 1: 
					boolean continuarCadastrando = true;  
										
					do {
						System.out.println("\n **** CADASTRO DE VEICULO DE PASSEIO ****");
							
						if (bd.getIndiceDisponivelVeiculoPasseio() == -1){
							l.entDados("\nMemoria cheia! Pressine enter para voltar ao menu");	
							continuarCadastrando = false;
						} else {
							System.out.println("\nInsira os valores solicitados abaixo: ");				
							
							String placaPasseio = l.entDados("\nDigite a placa:");
							
							if (bd.getIndiceDoVeiculoPasseio(placaPasseio) > -1) {
								System.out.println("\nVeiculo ja esta cadastrado!");
							} else {
								Passeio passeio = new Passeio();
								passeio = SolicitaDadosVeiculoPasseio(placaPasseio);
									
								if (bd.setVeiculoPasseio(passeio)) {
									System.out.println("\nVeiculo cadastrado!");
								} else {
									System.out.println("\nNao foi possivel cadastrar!");
								} 
							}
						}
						if (bd.() != -1) {
							String resp = l.entDados("\nDeseja adicionar outro veiculo? S/N ");
							
							if (resp.equalsIgnoreCase("n")) 
								continuarCadastrando = false;
						} 
										
					} while(continuarCadastrando);
					
				break;
				
				case 2: 
					continuarCadastrando = true; 
				
					do {
						System.out.println("\n **** CADASTRO DE VEICULO DE CARGA ****");
						
						if (bd.acharPosicaoVaziaVeculoCarga() == -1){
							l.entDados("\nMemoria cheia! Pressine enter para voltar ao menu");	
							continuarCadastrando = false;
						} else {
							System.out.println("\nInsira os valores solicitados abaixo: ");
							
							String placaCarga = l.entDados("\nDigite a placa:");
							
							if (bd.posicaoDoVeiculoCarga(placaCarga) > -1) {
								System.out.println("\nVeiculo ja esta cadastrado!");
							} else {
								Carga carga = new Carga();
								carga = SolicitaDadosVeiculoCarga(placaCarga);
									
								if (bd.adicionarVeiculoCarga(carga)) {
									System.out.println("\nVeiculo cadastrado!");
								} else {
									System.out.println("\nNao foi possivel cadastrar!");
								} 
							}
						}
						if (bd.acharPosicaoVaziaVeculoCarga() != -1) {
							String resp = l.entDados("\nDeseja adicionar outro veiculo? S/N ");
							
							if (resp.equalsIgnoreCase("n")) 
								continuarCadastrando = false;
						} 
									
					} while(continuarCadastrando);
					
				break;
				
				case 3:
					System.out.println("\n **** IMPRIMIR TODOS OS VEICULOS DE PASSEIO **** ");
					
					bd.imprimeTodosVeiculosDePasseio();
					
					l.entDados("\nPressione enter para voltar ao menu");
					
				break;
				
				case 4:
					System.out.println("\n **** IMPRIMIR TODOS OS VEICULOS DE CARGA **** ");
					
					bd.imprimeTodosVeiculosDeCarga();
					
					l.entDados("\nPressione enter para voltar ao menu");
				break;
				
				case 5:
					System.out.println("\n *** IMPRIMIR VEICULO DE PASSEIO PELA PLACA ***");
					
					String placa = l.entDados("\nDigite a placa que deseja pesquisar: ");
					
					bd.imprimeVeiculoDePasseio(placa);
					
					l.entDados("\nPressione enter para voltar ao menu");					
				break;
				
				case 6:
					System.out.println("\n *** IMPRIMIR VEICULO DE CARGA PELA PLACA ***");
					
					placa = l.entDados("\nDigite a placa que deseja pesquisar: ");
					
					bd.imprimeVeiculoDeCarga(placa);
					
					l.entDados("\nPressione enter para voltar ao menu");
				break;
				
				case 7:
					opcao = 7;
				break;
				
				default:
					l.entDados("O valor deve ser entre 1 e 7. Pressione Enter");
				break;
			}
		}while(opcao != 7);
	}
	
	public static void exibeMenu() {
		System.out.println("\n Sistema de Gestão de Veículos - Menu Inicial");
		System.out.println("\n 1 - Cadastrar Veiculo de Passeio");
		System.out.println("\n 2 - Cadastrar Veiculo de Carga");
		System.out.println("\n 3 - Imprimir Todos os Veiculos de Passeio");
		System.out.println("\n 4 - Imprimir Todos os Veiculos de Carga");
		System.out.println("\n 5 - Imprimir Veiculo de Passeio pela Placa");
		System.out.println("\n 6 - Imprimir Veiculo de Carga pela Placa");
		System.out.println("\n 7 - Sair do Sistema");
	}
	
	public static Passeio SolicitaDadosVeiculoPasseio(String placa) {
		Passeio p = new Passeio();
		Leitura l = new Leitura();
		p.setPlaca(placa);
		p.setMarca(l.entDados("Digite a marca"));							
		p.setModelo(l.entDados("Digite o modelo"));
		p.setCor(l.entDados("Digite a cor"));
		p.setQtdRodas(Integer.parseInt(l.entDados("Digite a quantidade de rodas")));
		p.setQtdPassageiros(Integer.parseInt(l.entDados("Digite a quantidade de passageiros")));
		p.setVelocMax(Float.parseFloat(l.entDados("Digite a velocidade maxima")));
		p.getMotor().setPotencia(Integer.parseInt(l.entDados("Digite a potencia do motor")));
		p.getMotor().setQtdPist(Integer.parseInt(l.entDados("Digite a quantidade de pistoes")));
		return p;
	}
	
	public static Carga SolicitaDadosVeiculoCarga(String placa) {
		Carga c = new Carga();
		Leitura l = new Leitura();
		c.setPlaca(placa);
		c.setMarca(l.entDados("Digite a marca"));
		c.setModelo(l.entDados("Digite o modelo"));
		c.setCor(l.entDados("Digite a cor"));
		c.setQtdRodas(Integer.parseInt(l.entDados("Digite a quantidade de rodas")));
		c.setCargaMax(Integer.parseInt(l.entDados("Digite a carga maxima")));
		c.setTara(Integer.parseInt(l.entDados("Digite a tara")));
		c.setVelocMax(Float.parseFloat(l.entDados("Digite a velocidade maxima")));
		c.getMotor().setPotencia(Integer.parseInt(l.entDados("Digite a potencia do motor")));
		c.getMotor().setQtdPist(Integer.parseInt(l.entDados("Digite a quantidade de pistoes"))); 
		
		return c;
	}
}