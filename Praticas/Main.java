public class Main{
    public static void main(String[] argv){
		Loja nvLoja = new Loja();
		Cliente Manel= new ClienteVip("Manel");
		Manel.associaLoja(nvLoja);
		Manel.verCatalogo();
		Manel.compraProduto(23.45);
		System.out.println(nvLoja.obterValor());
	}
}