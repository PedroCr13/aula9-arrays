package atividade6;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura{

	public String entDados(String mensagem){

		System.out.println(mensagem);

		InputStreamReader tc = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(tc);
		String s = "";
		try{
			s = buffer.readLine();
		}catch(IOException ioe){
			System.out.println("Erro na entrada");
		}
	return s;	
	}
}