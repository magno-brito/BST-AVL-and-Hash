public class No {

    public String valor;
    public No esquerda, direita;
    public int tamanho;// numero de filhos do nó
    public int altura; // maior nível dentre as subávores
    
    public No(String valor, int tamanho,int altura){
        this.valor = valor;
        this.tamanho = tamanho;
        this.altura = altura;
    }

    public No(String valor) {
        this.valor = valor;
        this.tamanho = 1;
    }

    

}