package arvbin;

public class ArvBin {
	private No raiz;

	public ArvBin(){
		raiz = null;
	}
	
	/** Verifica se a árvore está vazia */
	public boolean vazia (){
		return (raiz == null);
	}

	/** Funcao de busca recursiva.
		Retorna o endereço do elemento se ele for encontrado.
		Caso contrario, retorna null*/
	private No busca(No T, int valor) {          
		// Condicao de parada
		if (T == null) 
			return null;  // Arvore Vazia

		// Condicao de parada
		if(T.getConteudo() == valor) { 
			return T; //Elem. encontrado na raiz
		}
		
		// Caso recursivo
		No aux = busca(T.getEsq(), valor);
		if (aux == null) 
			aux = busca(T.getDir(), valor);
	   
		return aux;
	}
	
	/** Buscar um elemento na árvore
		Retorna o endereço se o elemento for encontrado, 
		Caso contrário retorna NULL*/
	public No busca(int valor) {          
		if (vazia())
			return null;
		
		//No res = busca(raiz, valor);
		//return res;
		return busca(raiz, valor);
	}
	
	
	/** Insere um nó raiz em uma árvore vazia 
	 	Retorna true se a inserção for com sucesso.
		Caso contrário, retorna false */   
	public boolean insereRaiz(int valor) {   
		if (raiz != null) 
			return false;  //Erro: Arvore não está vazia

		No novoNo = new No();
		novoNo.setConteudo(valor);
		novoNo.setEsq(null);
		novoNo.setDir(null);
		
		raiz = novoNo;
		return true;
	}   

	/** Insere um filho à direita de um dado nó.
    		Retorna true se a inserção for com sucesso,
    		Caso contrário false  */
	public boolean insereDir(int vPai, int vFilho ) {
		
		// Verifica se o elemento já existe
		No filho = busca(vFilho);
		if (filho != null)
	        return false;  // Err: dado já existe
	
		// Busca o pai e verifica se possui filho direito
		No pai = busca(vPai);
	  	if (pai == null)
			return false;  // Err: pai não encontrado
		
	  	if (pai.getDir() != null)
			return false;  // Err: filho dir já existe
	
		No novoNo = new No();
		novoNo.setConteudo(vFilho);
		novoNo.setEsq(null);
		novoNo.setDir(null);
		
		pai.setDir(novoNo);
		
		return true;
	}

	/** Insere um filho à esquerda de um dado nó.
		Retorna true se a inserção for com sucesso,
		Caso contrário false  */
	public boolean insereEsq(int vPai, int vFilho ) {
		
		// Verifica se o elemento já existe 
		No filho = busca(vFilho);
		if (filho != null)
	        return false;  // Err: dado já existe
	
		// Busca o pai e verifica se possui filho da esq
		No pai = busca(vPai);
	  	if (pai == null)
			return false; // Err: pai não encontrado
	  	
		if (pai.getEsq() != null)
			return false; // Err: filho esq já existe
	
		No novoNo = new No();
		novoNo.setConteudo(vFilho);
		novoNo.setEsq(null);
		novoNo.setDir(null);
		
		pai.setEsq(novoNo);
		return true;
	}
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private void exibePreOrdem(No T) {
		if (T == null)
			return;
	
		// Imprime a raiz
		System.out.print(" " + T.getConteudo());
		
		// Caminha recursivamente na sub-arv da esq (pre-ordem)
		if (T.getEsq() != null)
			exibePreOrdem(T.getEsq());
	
		// Caminha recursivamente na sub-arv da dir (pre-ordem)
	 	if (T.getDir() != null)
			exibePreOrdem(T.getDir());
	}

	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public void exibePreOrdem() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibePreOrdem(raiz);
	}	
	
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private void exibeInOrdem(No T) {
		if (T == null)
			return ;

		if (T.getEsq() != null)
			exibeInOrdem(T.getEsq());
	
	    System.out.print(" " + T.getConteudo());
	
	 	if (T.getDir() != null)
			exibeInOrdem(T.getDir());
	}

	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public void exibeInOrdem() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibeInOrdem(raiz);
	}	
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	private void exibePosOrdem(No T) {
		if (T == null)
			return ;

		if (T.getEsq() != null)
			exibePosOrdem(T.getEsq());
	
	 	if (T.getDir() != null)
			exibePosOrdem(T.getDir());

	 	System.out.print(" " + T.getConteudo());
	}
	
	/** Exibe o conteúdo de uma árvore em pré-ordem*/
	public void exibePosOrdem() {
		if (raiz == null)
			System.out.println("Arvore vazia");
		else
			exibePosOrdem(raiz);
	}
	
	public No buscaLargura(int valor){
		FilaSeq fila = new FilaSeq();
	
		if (vazia())
			return null; // Err: arv vazia
		
		fila.insere(raiz);
		while(!fila.vazia()) {
			No aux = fila.remove();
			
			System.out.println("[ATUAL] = " + aux.getConteudo());
			if (aux.getConteudo() == valor)
				return aux;
			
			// Adiciona os filhos na fila
			if (aux.getEsq() != null)
				fila.insere(aux.getEsq());
			
			if (aux.getDir() != null)
				fila.insere(aux.getDir());
		}
		
		System.out.println("Nao achei... ");
		return null;
	}
	
}
