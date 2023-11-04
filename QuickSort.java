

public class QuickSort {
    private int Swaps;
    private int Iteracoes;
    public void quickSort(int[]arr,int inferior,int superior){
        Iteracoes += 1;
        if(superior <= inferior){
            return;
        }
        int pivo = particiona(arr,inferior,superior);
        quickSort(arr,inferior,pivo-1);
        quickSort(arr,pivo+1,superior);
    }
    public int particiona(int[]arr,int inferior,int superior){
        int pivo = arr[superior];
        int i = inferior - 1;
        for(int j = inferior;j<=superior-1;j++){
            if(arr[j] < pivo){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                Swaps+=1;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[superior];
        arr[superior] = temp;
        Swaps+=1;
        return i;
    }
    public static void printArr(int[] array,int tamanho){
        System.out.print("[");
        for(int i=0;i<tamanho-1;i++){
            System.out.print(array[i]+",");
        }
        System.out.println(array[tamanho-1]+"]");
    }

    public int getSwaps() {
        return Swaps;
    }

    public int getIteracoes() {
        return Iteracoes;
    }

    public static void main(String[] args) {
        int tamanho =  100000;
        int[] array = GerarVetorAleatorio.gerarVetorAleatorio(tamanho);
        QuickSort qSort = new QuickSort();

        qSort.quickSort(array,0,tamanho-1);
        int tempExec = 0;
        int nSwaps = 0;
        for(int i=0;i<1;i++){
            long start1 = System.nanoTime();
            qSort.quickSort(array,0,tamanho-1);
            long end1 = System.nanoTime();
            tempExec += end1 - start1;
            System.out.println(tempExec);
        }
        System.out.println("Temp Exec" + tempExec);
        System.out.println("N de swaps" + qSort.getSwaps());
        System.out.println("N de iteracoes" + qSort.getIteracoes());



    }
}
