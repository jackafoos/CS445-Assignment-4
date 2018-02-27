public class MergeSorter implements IntSorter{

  private int[] array = null;
  private int moves = 0;
  private long startTime = 0;
  private long endTime = 0;

  public void init(int[] a){
    this.array = a;
    moves = 0;
  }

  //Sort the array as called per the testclass
  public void sort(int[] ary, int first, int last){
    startTime = System.nanoTime();
    mergeSort(array, 0, array.length - 1);
    endTime = System.nanoTime();
  }

  //main divide the array
  private void mergeSort(int[] ary, int first, int last){
    if (first < last){
      //find the approximate midpoint of the array
      int mid = (first + last)/2;
      //sort the first half
      mergeSort(ary, first, mid);
      //sort the second half
      mergeSort(ary, mid + 1, last);
      //merge the two halves
      merge(ary, first, mid, last);
    }
  }

  private void merge(int[] ary, int first, int mid, int last){
    //find the sizes of the arrays to be merged
    int n1 = mid - first + 1;
    int n2 = last - mid;
    //temp arrays
    int[] firstAry = new int[n1];// L[]
    int[] lastAry = new int[n2];// R[]
    System.arraycopy(ary, 0, firstAry, 0, n1 - 1);
    System.arraycopy(ary, mid + 1, lastAry, 0, n2 - 1);

    //Merge the temp Arrays
    int i = 0, j = 0;
    int index = 0;

    /*comparing each item in the arrays, we add the lower one to ary[]
     *because this is recursive, we assume the sub-Arrays are already sorted
     */
    while(i < n1 && j < n2){
      if(firstAry[i] <= lastAry[j]){
        ary[k] = firstAry[i];
        i++;
        moves++;
      }else{
        ary[k] = lastAry[i];
        j++;
        moves++;
      }
      k++;
    }

    //Copy the remaining items from the first array to the main one.
    while (i < n1)
    {
      arr[k] = firstAry[i];
      i++;
      k++;
    }

    //Copy the remaining items from the other array to the main one.
    while (j < n2)
    {
      arr[k] = R[j];
      j++;
      k++;
    }
}

  public int getMoves(){
    return moves;
  }

  public long getSortTime(){
    return endTime - startTime;
  }
}
