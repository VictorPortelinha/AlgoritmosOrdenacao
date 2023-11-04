public class BubbleSort {
    private int swap;
    private int iteracoes;
    public void bubbleSort(int[] arr,int tamanho){
        for(int i=0;i<tamanho;i++){
           iteracoes++;
            for(int j=0;j<tamanho-1;j++){
                iteracoes++;
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;

                }
            }

        }
    }
    public int getSwap(){
        return swap;
    }
    public int getIteracoes(){
        return iteracoes;
    }
    public void printArr(int[] array,int tamanho){
        System.out.print("[");
        for(int i=0;i<tamanho-1;i++){
            System.out.print(array[i]+",");
        }
        System.out.println(array[tamanho-1]+"]");
    }
    public static void main(String[] args) {
        int tamanho = 10000;
        int [] arr = GerarVetorAleatorio.gerarVetorAleatorio(tamanho);
        BubbleSort bubbleSort = new BubbleSort();
        int tempExec = 0;
        for(int i=0;i<3;i++){
            long start1 = System.nanoTime();
            bubbleSort.bubbleSort(arr,tamanho);
            long end1 = System.nanoTime();
            tempExec += end1 - start1;
        }
        System.out.println("tempo de exec"+ tempExec/3);
        System.out.println("n de swaps"+ bubbleSort.getSwap()/3);
        System.out.println("n de iterações"+ bubbleSort.getIteracoes()/3);
    }
}
