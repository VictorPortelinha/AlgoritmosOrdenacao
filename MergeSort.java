
public class MergeSort {
    private int Swaps;
    private int Iteracoes;
    public void merge(int[] array, int tamanho){
        // quando não tem como mais diminuir um array em 2, a recursão é parada
        if(tamanho<=1){
            return;
        }
        Iteracoes++;
        int meio = tamanho/2;
        // cria o array da direita sendo a metade do array inicial seu começo
        int[] arrayEsquerda = new int[meio];
        int[] arrayDireita= new int[tamanho-meio];

        // for loop para copiar os elementos na divisão dos array, valores menores que o meio irão  a esquerda posiçao i, o contrario á direita
        // posição j
        int j = 0;
        for(int i=0;i<tamanho;i++){
            Iteracoes++;
            if(i < meio){
                arrayEsquerda[i] = array[i];
            }else{
                arrayDireita[j] = array[i];
                j++;
            }
        }
        // chama as recursões para divisões a esquerda, direita e ao final da recursão faz o
        // merge nos arrays
        merge(arrayEsquerda,meio);
        merge(arrayDireita,tamanho-meio);
        sort(arrayEsquerda,arrayDireita,array,tamanho);


    }
    public  void sort(int[] arrayEsquerda,int[] arrayDireita,int []array,int tamanho){
        Iteracoes++;
        int tamanhoArrEsq = tamanho / 2;
        int tamanhoArrDir = tamanho - tamanhoArrEsq ;
        int k=0; // variavel para o array que vai ser copiado a ordenação
        int i=0; // variavel para o array da esquerda
        int j=0; // variavel para o array da direita

        while(i<tamanhoArrEsq && j<tamanhoArrDir){
            Iteracoes++;
            if(arrayEsquerda[i] < arrayDireita[j]){
                array[k] = arrayEsquerda[i];
                k++;
                i++;
                Swaps++;
            }else{
                array[k] = arrayDireita[j];
                k++;
                j++;
                Swaps++;
            }
        }
        while(i<tamanhoArrEsq){
            Iteracoes++;
            array[k] = arrayEsquerda[i];
            k++;
            i++;
            Swaps++;
        }
        while(j<tamanhoArrDir){
            Iteracoes++;
            array[k] = arrayDireita[j];
            k++;
            j++;
            Swaps++;
        }

    }
    public void printArr(int[] array,int tamanho){
        System.out.print("[");
        for(int i=0;i<tamanho-1;i++){
            System.out.print(array[i]+",");
        }
        System.out.println(array[tamanho-1]+"]");
    }

    public int getSwaps(){
        return Swaps;
    }
    public int getIteracoes(){
        return Iteracoes;
    }

    public static void main(String[] args) {
        int tamanho = 10000;
        int[] array = GerarVetorAleatorio.gerarVetorAleatorio(tamanho);

        MergeSort arrSort = new MergeSort();
        arrSort.merge(array,tamanho);
        int tempExec = 0;
        for(int i=0;i<5;i++){
            long start1 = System.nanoTime();
            arrSort.merge(array,tamanho);
            long end1 = System.nanoTime();
            tempExec += end1 - start1;
        }
        System.out.println("Temp de exec"+ tempExec/5);
        System.out.println("N de Swaps"+ arrSort.getSwaps()/5);
        System.out.println("N de iteraçoes"+ arrSort.getIteracoes()/5);



    }

}



