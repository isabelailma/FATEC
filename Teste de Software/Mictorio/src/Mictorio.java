import java.util.ArrayList;
import java.util.Collections;

/*Um problema enfrentado pelos homens no uso de mictórios em
banheiros públicos é o constrangimento causado por outro homem
urinando no mictório ao lado. Uma situação constrangedora é definida
quando dois "mijões" deveriam ocupar mictórios adjacentes.
Dada uma quantidade de mictórios em um banheiro e a ocupação
inicial deles (informando em qual deles já existe um "mijão"),
determine quantos "mijões" ainda podem usar os mictórios e qual a
posição deles antes para que não ocorra uma situação constrangedora.*/

public class Mictorio {
	
	private int qtde_mictorios;
	private ArrayList<Object> banheiro;
	
	//Construtor
	public Mictorio(){
		
	};
	
	public Mictorio(int qtde_mictorios, ArrayList<Object> banheiro) {
		this.qtde_mictorios = qtde_mictorios;
		this.banheiro = banheiro;
	}

	
	//Getters and Setters
	public int getQtde_mictorios() {
		return qtde_mictorios;
	}

	public void setQtde_mictorios(int qtde_mictorios) {
		this.qtde_mictorios = qtde_mictorios;
	}

	public ArrayList<Object> getBanheiro() {
		return banheiro;
	}

	public void setBanheiro(ArrayList<Object> banheiro) {
		this.banheiro = banheiro;
	}
	
	@Override
	public String toString() {
		return "Quantidade de Mictorios: " + getQtde_mictorios() + "\nOcupação Inicial: " + getBanheiro() + "\n";
	}
	
	
	/*Método que trata a situação constrangedora(causado por outro homem
	urinando no mictório ao lado)*/
	public boolean situacaoConstrangedora(ArrayList<Object> ocupados){
		for(int i = 0; i < ocupados.size(); i++){
			if(ocupados.get(i) == "1" && ((i+1 <= ocupados.size()-1 && ocupados.get(i+1) == "1") || (i-1 >= 0 && ocupados.get(i-1) == "1"))){
				return true;
			}
		}
		return false;
	}
	
	//Método que retorna uma lista com os mictorios ocupados
	public ArrayList<Object> indiceOcupados(ArrayList<Object> ocupacaoInicial){
		ArrayList<Object> ocupados = new ArrayList<Object>();
		for(int i = 0; i < ocupacaoInicial.size(); i++){
			if(ocupacaoInicial.get(i) == "Ocupado"){
				ocupados.add("1");
			}
			else{
				ocupados.add("0");
			}
		}
		return ocupados;
	}
	
	/*Método que determine quantos "mijões" ainda podem usar os mictórios e qual a 
	posição deles antes para que não ocorra uma situação constrangedora*/
	public ArrayList<Object> adjacentes(ArrayList<Object> ocupados){
		if(situacaoConstrangedora(ocupados) == false){
			
			
			for(int i = 0; i < ocupados.size(); i++){
				if(ocupados.get(i) == "1" || ocupados.get(i) == "2"){
					if(i+2 <= ocupados.size()-1 && ocupados.get(i+2) == "0" && ocupados.get(i+1) == "0"){
						if(i+3 <= ocupados.size()-1){
							if(ocupados.get(i+3) == "0"){
								ocupados.set(i+2, "2");
							}
						}
						if(i+3 > ocupados.size()-1){
							ocupados.set(i+2, "2");
						}
					}
					if(i-2 >= 0 && ocupados.get(i-2) == "0" && ocupados.get(i-1) == "0"){
						if(i-3 >= 0){
							if(ocupados.get(i-3) == "0"){
								ocupados.set(i-2, "2");
							}
						}
						if(i-3 < 0){
							ocupados.set(i-2, "2");
						}
					}
				}
			}
			
			for(int i = ocupados.size()-1; i >= 0 ; i--){
				if(ocupados.get(i) == "1" || ocupados.get(i) == "2"){
					if(i+2 <= ocupados.size()-1 && ocupados.get(i+2) == "0" && ocupados.get(i+1) == "0" && ocupados.get(i+3) == "0"){
						if(i+3 <= ocupados.size()-1){
							if(ocupados.get(i+3) == "0"){
								ocupados.set(i+2, "2");
							}
						}
						if(i+3 > ocupados.size()-1){
							ocupados.set(i+2, "2");
						}
					}
					if(i-2 >= 0 && ocupados.get(i-2) == "0" && ocupados.get(i-1) == "0"){
						if(i-3 >= 0){
							if(ocupados.get(i-3) == "0"){
								ocupados.set(i-2, "2");
							}
						}
						if(i-3 < 0){
							ocupados.set(i-2, "2");
						}
						
					}
				}
			}
			return ocupados;
		}
		else{
			System.out.println("Situação Constrangedora!");
			return ocupados;
		}
	}
	
	/*Método que determine quantos "mijões" ainda podem usar os mictórios e qual a
	posição deles antes para que não ocorra uma situação constrangedora*/
	public void posicoes(ArrayList<Object> adjacentes){
		for(int i = 0; i <= adjacentes.size()-1; i++){
			if(adjacentes.get(i) == "2"){
				System.out.println("Posição: Mictório " + (i+1));
			}
		}
		System.out.println("Quantidade de Mijões: " + Collections.frequency(adjacentes, "2"));
	}	
}