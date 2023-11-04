
public class InsertionSort {
    private int iteracoes;
    private int swaps;
    private int[] inputArr;
    private int tamanho;
    public InsertionSort(int[] inputArr, int tamanho){
        this.inputArr = inputArr;
        this.tamanho = tamanho;
    }
    public int[] sort(){
        for(int i=0;i<tamanho-1;i++){
            iteracoes+=1;
            int nAtual = inputArr[i+1]; // começa pelo index 1 do array
            if(inputArr[i]>inputArr[i+1]){ // compara a iteração atual com o próximo item, caso ele seja maior começa o processo de inserção
                for(int j=i+1;j>0;j--){ // insere o elemento em sua posição correta no subarray
                    if(nAtual < inputArr[j-1]){
                        iteracoes+=1;
                        int temp = inputArr[j];
                        inputArr[j] = inputArr[j-1];
                        inputArr[j-1] = temp;
                        swaps+=1;
                    }
                }
            }
        }
        return inputArr;
    }

    public int getIteracoes() {
        return iteracoes;
    }
    public int getSwaps(){
        return swaps;
    }
    public void printArr(int[] arr){
        for(int i=0;i<tamanho;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int tamanho = 10000;
        int[] array = GerarVetorAleatorio.gerarVetorAleatorio(tamanho);


        InsertionSort insertSort = new InsertionSort(array,tamanho);
        int tempExec = 0;
        int nSwaps = 0;
        for(int i=0;i<3;i++){
            long start1 = System.nanoTime();
            int[] arrayOrdenado = insertSort.sort();
            long end1 = System.nanoTime();
            tempExec += end1 - start1;
        }
        System.out.println("Tempo de ordenação "+(tempExec/3));
        System.out.println("Numero de swaps"+(insertSort.getSwaps()/3));
        System.out.println("Numero de iteracoes"+(insertSort.getIteracoes()/3));


    }
}
