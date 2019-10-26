
public class ClienteVip extends Cliente{
	private int _pontos;

	public ClienteVip(String nome){
		super(nome);
		_pontos = 0;
	}

	public int obterPontos(){
		return _pontos;
	}

	public void compraProduto(double valor){
		super.compraProduto(valor);
		valor -= valor * 0.10; 
		//Nao faz sentido indicar neste caso, porque nao vamos fazer mais nada com isto
		_pontos += 5; //ou 10
	}

	public void verCatalogo(){
		super.verCatalogo();
		System.out.println("Descontos");
	}

	public void reclama(){
		super.reclama();
	}
}