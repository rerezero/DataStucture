import java.util.Arrays;
import java.util.Random;

import dataStructures.ArrayLinearList;
import dataStructures.ArrayStack;

public class MyStack extends ArrayStack {
    public MyStack() {
        super();
    }

    public MyStack(int initialCapacity) {
        super(initialCapacity);
    }

    public MyStack(MyStack ms) {
        super(ms.size());
        MyStack temp = new MyStack();
        while (!ms.empty()) {
            temp.push(ms.pop());
        }
        while (!temp.empty()) {
            Object t = temp.pop();
            this.push(t);
            ms.push(t);
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[this.size()];
        MyStack temp = new MyStack();
        int i = 0;
        while (!this.empty()) {
            Object x = this.pop();
            temp.push(x);
            arr[i++] = x;
        }
        while (!temp.empty()) {
            this.push(temp.pop());
        }
        return arr;
    }

    public MyStack rand() { 
        Object[] arr = this.toArray();  
        MyStack ms = new MyStack();  
        Random r = new Random();  
        ArrayLinearList al = new ArrayLinearList();  
        for (int i = 0; i < arr.length; i++)  
            al.add(i, arr[i]);  
        while (!al.isEmpty()) {  
            int k = r.nextInt(al.size()); 
            ms.push(al.get(k));
            al.remove(k);
        }
        return ms;  
    }
    
    public MyStack Unique() 
    {
    	Object [] arr = this.toArray();
    	Arrays.sort(arr);
    	MyStack temp = new MyStack();
    	for(int i=0;i<arr.length-1;i++) {
    		if(!arr[i].equals(arr[i+1])) {
    			temp.push(arr[i]);
    	}
    }
    	if(arr.length>0) {
    	temp.push(arr[arr.length-1]);
    	}
    	return temp;
    	
    }
    
    public MyStack addRange(Object [] elements)
    {
    	MyStack temp = new MyStack(this);
    	for(int i = 0; i<elements.length;i++)
    		temp.push(elements[i]);
    	return temp;
    }
    
    public boolean exists(Object element)
    {
    	Object [] arr = this.toArray();
    	for(int i=0;i<arr.length;i++)
    		if(arr[i]==element)
    			return true;
    	return false;
    }

    public String toString() {
        Object[] arr = this.toArray(); 
        return Arrays.toString(arr);
    }

}
