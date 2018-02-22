public class SelectionSorter implements IntSorter{

  private int[] array = null;
  private int moves = 0;
  private long startTime = 0;
  private long endTime = 0;

  public void init(int[] a){
    this.array = a;
    moves = 0;
  }

  public void sort(){
    startTime = System.nanoTime();
    for (int i = 0; i < array.length - 1; i++){
      int smallestIndex = i;
      for (int k = i + 1; k < array.length; k++){
        if (array[smallestIndex] > array[k]){
          smallestIndex = k;
        }
      }
      swap(array, smallestIndex, i);
    }
    endTime = System.nanoTime();
  }

  private void swap(int[] values, int p1, int p2) {
    int temp = values[p1];
    values[p1] = values[p2];
    values[p2] = temp;
    moves++;
  }

  public int getMoves(){
    return moves;
  }

  public long getSortTime(){
    return endTime - startTime;
  }
}
