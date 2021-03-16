package arvbin;

public class Main {

	public static void main(String args[]){
		System.out.println("Arvores Binarias!");

		ArvBin arv = new ArvBin();
		arv.insereRaiz(2);

		arv.insereEsq(2, 4); // insere 4 a esq do 2
		arv.insereDir(2, 6);

		arv.insereEsq(4, 8);
		arv.insereDir( 4, 10);

		arv.insereEsq(6, 12);
		arv.insereEsq(10, 14);
		arv.insereDir(10, 16);

		arv.insereEsq(14, 18);
		arv.insereDir(14, 20);

		arv.insereDir(12, 19);

		No no = arv.busca(19);
		if (no != null){
			System.out.println("No existe, conteudo = " + no.getConteudo());
			if (no.getEsq() != null)
				System.out.println("[ESQ] = " + no.getEsq().getConteudo());
			if (no.getDir() != null)
				System.out.println("[DIR] = " + no.getDir().getConteudo());	
		}

		no = arv.busca(14);
		if (no != null){
			System.out.println("No existe, conteudo = " + no.getConteudo());
			if (no.getEsq() != null)
				System.out.println("[ESQ] = " + no.getEsq().getConteudo());
			if (no.getDir() != null)
				System.out.println("[DIR] = " + no.getDir().getConteudo());	
		}
		
		no = arv.busca(20);
		if (no != null){
			System.out.println("No existe, conteudo = " + no.getConteudo());
			if (no.getEsq() != null)
				System.out.println("[ESQ] = " + no.getEsq().getConteudo());
			if (no.getDir() != null)
				System.out.println("[DIR] = " + no.getDir().getConteudo());	
		}

		
		System.out.println("Pre-ordem");
		arv.exibePreOrdem();

		System.out.println("\nIn-ordem");
		arv.exibeInOrdem();

		System.out.println("\nPos-ordem");
		arv.exibePosOrdem();

		//System.out.println("\n\nBusca em Largura 16");
		//arv.buscaLargura(16);
		
		//System.out.println("\n\nBusca em Largura 18");
		//arv.buscaLargura(18);
		
		//System.out.println("\n\nBusca em Largura 20");
		//arv.buscaLargura(20);

		//System.out.println("\n\nBusca em Largura 32");
		//arv.buscaLargura(32);

		return;
	}
}
