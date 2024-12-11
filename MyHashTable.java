package dataStructures;
import java.util.*;
public class MyHashTable extends HashTable {	
	Scanner sc = new Scanner(System.in);
    public MyHashTable(int theDivisor) {
		super(theDivisor);
	}
    public void insert() {
    	try {
    	Object key, element;
    	print("Түлхүүрийг оруулна уу");
    	key = sc.next();
    	print("Элементийг оруулна уу");
    	element = sc.next();
    	put(key, element);
    	print("Амжилттай нэмэгдлээ");
    	}catch(Exception e) {
    		print("Утга нэмэхэд алдаа гарлаа =>"+ e.getMessage());
    	}
    	}
    
    
    public void mySearch() {
    	try {
    		Scanner sc = new Scanner(System.in);
    		Object key,element;
    		System.out.print("Түлхүүрийг оруулна уу");
    		key = sc.nextLine();
    		element = this.get(key);
    		if(element !=null)
    			System.out.println(key+ " Түлхүүртэй " +element+ " элемент олдлоо");
    		else 
    			System.out.println(key+ " Элемент олдсонгүй ");
    		}
    	catch(Exception e) {
    		System.out.println(" Элемент хайхад алдаа гарлаа => "+ e.getMessage());
    		
    	}
    }

   
    public Object updateElement (Object theKey, Object theElement) {
    	Object updatedElement=null;
    	int b = this.search(theKey);
    	if(this.table[b]!=null) {
    		updatedElement = this.put(theKey, theElement);
    		if(updatedElement!=null)
    		{
    			System.out.println(theKey+" түлхүүртэй "+updatedElement+" элементийг "+theElement+" элементээр солив");
    		}
    	}
    	else
    		System.out.println(theKey+" Түлхүүртэй элемент олдслнгүй");
    	return updatedElement;
    }
    
    public Object updateKey (Object theKey, Object theNewKey) {
    	Object elem=null;
    	int b = this.search(theKey);
    	int b1 = this.search(theNewKey);
    	if(this.table[b]!=null && this.table[b1]==null) {
    		elem = this.table[b].getElement();
    		this.table[b]=null;
    		this.put(theNewKey,elem);
    		System.out.println(theKey+" Түлхүүртэй "+elem+" элементийг "+theNewKey+" түлхүүртэй болгов");
    	}
    	else
    		System.out.println(theKey+" Түлхүүртэй элемент олдсонгүй. Эсвэл "+theNewKey+" түлхүүртэй элемент үүссэн байна");
    	return elem;
    }
    
    
    public void delete(Object theKey) {
    	Object element = this.get(theKey);
		if(element != null) {
			int b = search(theKey); 
			
			this.table[b] = null;
			this.size--;
			System.out.println(theKey + " Түлхүүртэй " +element+ " элемент устлаа.Элементийн тоо " + this.size());
		}else {
			System.out.println(theKey + " Түлхүүртэй элемент олдсонгүй");
		}

    	
    }
   
    
    public void ElementZasah() {
    	try {
    		Scanner scan = new Scanner(System.in);
        	Object key, element;
        	System.out.println("Засах элементийн түлхүүрийг оруулна уу");
        	key = scan.nextLine();
        	System.out.println("Засах элементийг оруулна уу");
        	element = scan.nextLine();
        	this.updateElement(key,element);
        	}catch(Exception e) {
        		print("Элемент засахад алдаа гарлаа =>"+ e.getMessage());
        	}
    }
    
    
    public void KeyZasah() {
    	try {
    		Scanner scan = new Scanner(System.in);
    		Object key,newkey;
    		System.out.println("Хуучин түлхүүрийг оруулаарай ");
    		key = scan.nextLine();
    		System.out.println("Шинэ түлхүүрийг оруулна уу");
    		newkey = scan.nextLine();
    		this.updateKey(key,newkey);
        	}catch(Exception e) {
        		print("Түлхүүр засахад алдаа гарлаа =>"+ e.getMessage());
        	}
    }
   
    
    public void menu() {
    	print("---Үйлдэл сонгох---");
    	print("1) Нэмэх");
    	print("2) Хайх");
    	print("3) Түлхүүр засах");
    	print("4) Элемент засах");
    	print("5) Устгах");
    	print("6) Хэвлэх");
    }
    
    
    public void print(String text) {
    	System.out.println(text);
    }
    
   
    
    
    
    public static void main(String[] args) {
    	int command, divisor;
    	System.out.println("Хэш хүснэгтийн уртыг оруулна уу");
    	Scanner sc = new Scanner(System.in);
    	divisor = sc.nextInt();
    	MyHashTable myHash = new MyHashTable(divisor);
    	for(;;) {
    		myHash.menu();
    		myHash.print("Комнад оруулна уу");
    		command = sc.nextInt();
    		switch(command) {
    		case 1:
    			myHash.insert();
    		    break;
    		case 2:
    			myHash.mySearch();
        		break;
    		case 3:
    			myHash.KeyZasah();
        		break;
    		case 4:
    			myHash.ElementZasah();
        		break;
    		case 5:
    			try {
    				Scanner scan = new Scanner(System.in);
    				Object key;
    				System.out.print("Устгах элементийн түлхүүрийг оруулна уу");
    				key = scan.nextLine();
    				myHash.delete(key);
    			}catch(Exception e) 
    			{
    				System.out.println("Элемент устгахад алдаа гарлаа");
    			}
    		
        		break;
    		case 6:
    			myHash.output();
        		break;
        	default:
        	    myHash.print("Команд олдсонгүй");
    		
    		
    		}
    		
    	}
    }
}
