import java.util.ArrayList;

public class Teste {
	
	public static void main(String[] args) {
		
		Mictorio mictorio = new Mictorio();
		
		ArrayList<Object> ocupacaoInicial = new ArrayList<Object>();
		ocupacaoInicial.add("Livre");
		ocupacaoInicial.add("Livre");
		ocupacaoInicial.add("Ocupado");
		ocupacaoInicial.add("Livre");
		ocupacaoInicial.add("Livre");
		ocupacaoInicial.add("Livre");
		ocupacaoInicial.add("Livre");
		ocupacaoInicial.add("Ocupado");
		ocupacaoInicial.add("Livre");
		ocupacaoInicial.add("Ocupado");
		
		Mictorio banheiro = new Mictorio(10, ocupacaoInicial); 
		
		System.out.println(banheiro);
		mictorio.posicoes(mictorio.adjacentes(mictorio.indiceOcupados(ocupacaoInicial)));
	}
}