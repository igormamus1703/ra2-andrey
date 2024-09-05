public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        int[] valores = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17, 9, 5};

        for (int valor : valores) {
            arvore.inserir(valor);
        }

        System.out.println("in-ordem:");
        arvore.inOrdem();
        System.out.println("pré-ordem:");
        arvore.preOrdem();
        System.out.println("pós-ordem:");
        arvore.posOrdem();
        System.out.println("Encerrando...");    
        arvore.removerMaior();
        arvore.removerMenor();
        arvore.remover(9);
    }
}
