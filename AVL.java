public class AVL {
    public No raiz;
    

    public int tamanho() {
        return tamanho(raiz);
    }

    private int tamanho(No x) {
        if (x == null) {
            return 0;
        }
        return x.tamanho;
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(No x) {
        if (x == null) {
            return -1;
        } return x.altura;
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

    public No min(No x) {
        if(x.esquerda == null) return x;
        return min(x.esquerda);
    }

    private No insere(No x, String valor) {
        if (x == null) return new No(valor, 0, 1);
        int cmp = valor.compareTo(x.valor);
        if (cmp < 0) x.esquerda = insere(x.esquerda, valor);
        else if( cmp > 0) x.direita = insere(x.direita, valor);
        else  x.valor = valor;
        x.tamanho = 1 + tamanho(x.esquerda) + tamanho(x.direita);
        x.altura = 1 + Math.max(altura(x.esquerda), altura((x.direita)));
        return balancea(x);
    }

    private No remove( No x, String valor) {
        int cmp = valor.compareTo(x.valor);
        if(cmp < 0) {
            x.esquerda = remove(x.esquerda, valor);
        } else if (cmp > 0) {
            x.direita = remove(x.direita, valor);
        } else if( x.esquerda == null) {
            return x.direita;
        } else if (x.direita == null) {
            return x.esquerda;
        } else {
            No y = x;
            x = min(y.direita);
            x.direita = removeMin(y.direita);
            x.esquerda = y.esquerda;
        }
        x.tamanho = 1 + tamanho(x.esquerda) + tamanho(x.direita);
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        return balancea(x);
    }

    private No balancea(No x) {
        if (fatorBalanceamento(x) < -1) {
            if (fatorBalanceamento(x.direita) > 0) {
                x.direita = rotacionaDireita(x.direita);
            }
            x = rotacionaEsquerda(x);
        } else if (fatorBalanceamento(x) > 1) {
            if (fatorBalanceamento(x.esquerda) < 0) {
                x.esquerda = rotacionaEsquerda(x.esquerda);
            }
            x = rotacionaDireita(x);
        }
        return x;
    }

    private int fatorBalanceamento(No x) {
        return altura(x.esquerda) - altura(x.direita);
    }
}
