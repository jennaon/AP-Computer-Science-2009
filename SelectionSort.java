public class SelectionSort{
    public static void sort (int [] array){
      int num = array.length;
      for (int i = 0; i <= num-1; i++){
        for(int j = i; j <= num-1; j++){
          int temp = 0;
          if (array[i] > array[j]){
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
          }
        }
      }
    }
}
