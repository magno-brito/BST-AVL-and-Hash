import java.util.List;

public class ArvoreBinariaBusca <Valor extends Comparable<Valor>> {
    private No raiz;

    
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
        if (x == null) return new No(valor);
        int cmp = valor.compareTo(x.valor);
        if (cmp > 0) x.direita = insere(x.direita, valor);
        else if (cmp < 0) x.esquerda = insere(x.esquerda, valor);
        else x.valor = valor;
        return x;
    }

   
    public void remove(String valor) {

    }
    public List<String> valoresEmOrdem() {

    }

    public String min(No x) {
        if(x.esquerda == null) return x.valor;
        return min(x.esquerda);
    }

    public String max(No x){
        if(x.direita == null) return x.valor;
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
    
}
