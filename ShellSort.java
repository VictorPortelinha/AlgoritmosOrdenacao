public class ShellSort {
    private int Swaps;
    private int Iteracoes;
    public void sort(int[] array,int tamanho){
        for(int gap=tamanho/2;gap>0;gap /= 2){
            Iteracoes++;
            for(int i=gap;i<tamanho;i++){
                Iteracoes++;
                int temp = array[i];
                int j;
                for ( j = i; j >= gap && array[j - gap] > temp; j -= gap){
                    Iteracoes++;
                    array[j] = array[j - gap];
                }
                array[j] = temp;
                Swaps++;
            }

        }
    }
    public int getIteracoes(){
        return Iteracoes;
    }
    public int getSwaps(){
        return Swaps;
    }
    public static void printArray(int[] array,int tamanho){
        System.out.print("[");
        for(int i=0;i<tamanho-1;i++){
            System.out.print(array[i]+",");
        }
        System.out.println(array[tamanho-1]+"]");
    }
    public static void main(String[] args) {
        int tamanho = 100000;
        int[] arr = GerarVetorAleatorio.gerarVetorAleatorio(tamanho);

        ShellSort ob = new ShellSort();
        ob.sort(arr,tamanho);
        int tempExec = 0;
        for(int i=0;i<1;i++){
            long start1 = System.nanoTime();
            ob.sort(arr,tamanho);
            long end1 = System.nanoTime();
            tempExec += end1 - start1;
        }
        System.out.println("Temp de exec"+ tempExec);
        System.out.println("N de Swaps"+ ob.getSwaps());
        System.out.println("N de iteraçoes"+ ob.getIteracoes());




    }
}
