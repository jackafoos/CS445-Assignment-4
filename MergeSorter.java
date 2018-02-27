public class MergeSorter implements IntSorter{

  private int[] array = null;
  private int moves = 0;
  private long startTime = 0;
  private long endTime = 0;
  private int[] tempArray = null;

  public void init(int[] a){
    this.array = a;
    moves = 0;
  }

  //Sort the array as called per the testclass
  public void sort(){
    startTime = System.nanoTime();
    tempArray = new int[array.length];
    //System.arraycopy(array, 0, tempArray, 0, array.length);
    mergeSort(0, array.length - 1);
    //System.arraycopy(tempArray, 0, array, 0, array.length);
    endTime = System.nanoTime();
  }

  //main divide the array
  private void mergeSort(int first, int last){
    if (first < last){
      //find the approximate midpoint of the array
      int mid = (first + last)/2;
      //sort the first half
      mergeSort(first, mid);
      //sort the second half
      mergeSort(mid + 1, last);
      //merge the two halves
      merge(first, mid, last);
    }
  }

  private void merge(int first, int mid, int last){

    for (int i = first; i <= last; i++) {
          tempArray[i] = array[i];
      }

    //Merge the temp Arrays
    int i = first;
    int j = mid + 1;
    int index = first;

    /*comparing each item in the arrays, we add the lower one to ary[]
     *because this is recursive, we assume the sub-Arrays are already sorted
     */
    while(i <= mid && j <= last){
      if(tempArray[i] <= tempArray[j]){
        array[index] = tempArray[i];
        i++;
        moves++;
      }else{
        array[index] = tempArray[j];
        j++;
        moves++;
      }
      index++;
    }

    //Copy the remaining items from the first array to the main one.
    while (i <= mid)
    {
      array[index] = tempArray[i];
      i++;
      index++;
      moves++;
    }

    //Copy the remaining items from the other array to the main one.
    while (j < n2)
    {
      array[index] = tempArray[j];
      j++;
      index++;
      moves++;
    }
}

  public int getMoves(){
    return moves;
  }

  public long getSortTime(){
    return endTime - startTime;
  }
}
