public class InsertionSorter implements IntSorter{

  private int[] array = null;
  private int moves = 0;
  private long startTime = 0;
  private long endTime = 0;

  public void init(int[] a){
    this.array = a;
    moves = 0;
  }

  public void sort(){
    return endTime - startTime;
  }

  public int getMoves(){
    return moves;
  }

  public long getSortTime(){

  }
}
