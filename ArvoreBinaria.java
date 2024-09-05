public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    // metodo para inserir um elemento na arvore sem permitir duplicados
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private Node inserirRecursivo(Node raiz, int valor) {
        if (raiz == null) {
            return new Node(valor);
        }

        if (valor < raiz.info) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.info) {
            raiz.direita = inserirRecursivo(raiz.direita, valor);
        }

        return raiz;
    }

    // metodos de travessia 
    public void inOrdem() {
        inOrdemRecursivo(raiz);
        System.out.println();
    }

    private void inOrdemRecursivo(Node raiz) {
        if (raiz != null) {
            inOrdemRecursivo(raiz.esquerda);
            System.out.print(raiz.info + " ");
            inOrdemRecursivo(raiz.direita);
        }
    }

    public void preOrdem() {
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    private void preOrdemRecursivo(Node raiz) {
        if (raiz != null) {
            System.out.print(raiz.info + " ");
            preOrdemRecursivo(raiz.esquerda);
            preOrdemRecursivo(raiz.direita);
        }
    }

    public void posOrdem() {
        posOrdemRecursivo(raiz);
        System.out.println();
    }

    private void posOrdemRecursivo(Node raiz) {
        if (raiz != null) {
            posOrdemRecursivo(raiz.esquerda);
            posOrdemRecursivo(raiz.direita);
            System.out.print(raiz.info + " ");
        }
    }

    // metodo para remover o maior elemento
    public void removerMaior() {
        raiz = removerMaiorRecursivo(raiz);
    }

    private Node removerMaiorRecursivo(Node raiz) {
        if (raiz == null) return null;
        if (raiz.direita == null) return raiz.esquerda;
        raiz.direita = removerMaiorRecursivo(raiz.direita);
        return raiz;
    }

    // metodo para remover o menor elemento
    public void removerMenor() {
        raiz = removerMenorRecursivo(raiz);
    }

    private Node removerMenorRecursivo(Node raiz) {
        if (raiz == null) return null;
        if (raiz.esquerda == null) return raiz.direita;
        raiz.esquerda = removerMenorRecursivo(raiz.esquerda);
        return raiz;
    }

    // metodo para remover um elemento 
    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private Node removerRecursivo(Node raiz, int valor) {
        if (raiz == null) return null;

        if (valor < raiz.info) {
            raiz.esquerda = removerRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.info) {
            raiz.direita = removerRecursivo(raiz.direita, valor);
        } else {
            if (raiz.esquerda == null) return raiz.direita;
            if (raiz.direita == null) return raiz.esquerda;

            raiz.info = encontrarMenor(raiz.direita);
            raiz.direita = removerRecursivo(raiz.direita, raiz.info);
        }

        return raiz;
    }

    private int encontrarMenor(Node raiz) {
        int menor = raiz.info;
        while (raiz.esquerda != null) {
            menor = raiz.esquerda.info;
            raiz = raiz.esquerda;
        }
        return menor;
    }
}
