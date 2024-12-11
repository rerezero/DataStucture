import dataStructures.ArrayLinearList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class MyArrayLinearList extends ArrayLinearList {
 
	public MyArrayLinearList(int initialCapacity) {
	 super(initialCapacity);
 }
 
  public MyArrayLinearList() {
	  super(10);
  }
  
  public MyArrayLinearList Reverse() {
	  MyArrayLinearList temp = new MyArrayLinearList(this.size());
	  int j = 0;
	  for (int i = this.size() - 1; i >= 0; i--)
		  temp.add(j++, this.element[i]);
	  return temp;
  }
  
  public int Max(){
	  int m = (int)this.get(0);
	  for(int i=0;i<this.size();i++)  
		  if(m < (int)this.get(i))
			  m = (int)this.get(i);
	  return m;
  }
  public int Min() {
      int m = (int)this.get(0);
      for (int i = 0; i < this.size(); i++) 
          if (m > (int) this.get(i)) 
              m = (int) this.get(i);
      return m;
  }
  public int Sum() {
      int sum = 0;
      for (int i = 0; i < this.size(); i++) 
          sum += (int) this.get(i);
      return sum;
  }
  public double Average() {
      if (this.size() == 0) return 0;
      return (double) this.Sum() / this.size();
  }
  public void removeOdd() {
      for (int i = 0; i < this.size(); i++) {
          if ((int) this.get(i) % 2 != 0) {
              this.remove(i);
              i--; 
          }
      }
  }
  public void sort() {
      Object[] array = Arrays.copyOf(this.element, this.size());
      Arrays.sort(array);
      for (int i = 0; i < array.length; i++) {
          this.element[i] = array[i];
      }
  }
  public void unique() {
      for (int i = 0; i < this.size(); i++) {
          for (int j = i + 1; j < this.size(); j++) {
              if (this.get(i).equals(this.get(j))) {
                  this.remove(j);
                  j--; 
              }
          }
      }
  }
  public void merge(MyArrayLinearList otherList) {
      for (int i = 0; i < otherList.size(); i++) {
          this.add(this.size(), otherList.get(i));
      }
  }
  public void rand() {
	    List<Object> elementsList = Arrays.asList(Arrays.copyOf(this.element, this.size()));
	    Collections.shuffle(elementsList);
	    for (int i = 0; i < elementsList.size(); i++) {
	        this.element[i] = elementsList.get(i);
	    }
	}
}


