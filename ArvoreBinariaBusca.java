import java.util.List;

public class ArvoreBinariaBusca  {
    private No raiz;

    // Altura é proporcional ao log N
    
    public boolean busca(No x, String valor) {
        if (x == null) return false;
        int cmp = valor.compareTo(x.valor);
        if (cmp < 0) return busca(x.esquerda, valor);
        else if (cmp > 0) return busca(x.direita, valor);
        else  return true;
    }

    public void insere(String valor){
        raiz = insere(raiz, valor);
    }

    private No insere(No x, String valor) {
        if (x == null) return new No(valor,1);
        int cmp = valor.compareTo(x.valor);
        if (cmp > 0) x.direita = insere(x.direita, valor);
        else if (cmp < 0) x.esquerda = insere(x.esquerda, valor);
        else x.valor = valor;
        x.tamanho = 1 + tamanho(x.esquerda) + tamanho(x.direita);
        return x;
    }

   

    public No min(No x) {
        if(x.esquerda == null) return x;
        return min(x.esquerda);
    }

    public No max(No x){
        if(x.direita == null) return x;
        return max(x.esquerda);
    }

    //piso: maior valor <= a um dado valor chave
    //teto: menor valor >= a um dado valor chave

    public String piso(String valor) {
        No x = piso(raiz, valor);
        if (x == null) return null;
        else return x.valor;
    }

    private No piso(No x, String valor) {
        if (x == null) return null;
        int cmp = valor.compareTo(x.valor);
        if (cmp == 0) return x;
        if (cmp < 0) return piso(x.esquerda, valor);
        No t = piso(x.direita, valor);
        if (t != null) return t;
        else return x;
    }

    //Posto - Quantos valores < k?

    public int tamanho() {
        return tamanho(raiz);
    }

    private int tamanho(No x) {
        if (x == null) return 0;
        return x.tamanho;
    }

    public int posto(String valor) {
        return posto(raiz, valor);
    }

    private int posto(No x, String valor) {
        if (x == null) return 0;
        int cmp = valor.compareTo(x.valor);
        if (cmp < 0) return posto(x.esquerda, valor);
        else if (cmp > 0) return 1 + tamanho(x.esquerda) + posto(x.direita, valor);
        else return tamanho(x.esquerda);
    }

    public void removeMin() {
        raiz = removeMin(raiz);
    }

    private No removeMin(No x) {
        if (x.esquerda == null) return x.direita;
        x.esquerda = removeMin(x.esquerda);
        x.tamanho = 1 + tamanho(x.esquerda) + tamanho(x.direita);
        return x;
    }

    public void remove(String valor) {
        raiz = remove(raiz, valor);
    }

    private No remove( No x, String valor) {
        if (x == null) return null;
        int cmp = valor.compareTo(x.valor);
        if (cmp < 0) x.esquerda = remove(x.esquerda, valor);
        else if (cmp > 0) x.direita = remove(x.direita, valor);
        else {
            if (x.direita == null) return x.esquerda;
            if (x.esquerda == null) return x.direita;

            No t = x;
            x = min(t.direita);
            x.direita = removeMin(t.direita);
            x.esquerda = t.esquerda;
        }

        x.tamanho = tamanho(x.esquerda) + tamanho(x.direita) + 1;
        return x;
    }

    
}
