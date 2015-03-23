public class MyLinkedList<T>{
    private LNode<T> start;
    private LNode<T> end;
    private int size;

    public MyLinkedList(LNode<T> node){
	start = node;
	size = 1;
	end = node;
    }

    public MyLinkedList(){
	size = 0;
    }

    public boolean add(T value){
	if (size==0){
	    start = new LNode<T>(value);
	    end = start;
	    size++;
	    return true;
	}else{
	    LNode<T> newend = new LNode<T>(value);
	    end.setNext(newend);
	    end = newend;
	}
	size++;
	return true;
    }
    
    public void add(int index,T value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("index out of bounds");
	}
	int indexcount = 0;
	LNode<T> current = start;
	LNode<T> previous = new LNode<T>();
	if (index > 0){
	    while (indexcount < index){
		if (indexcount == index - 1){
		    previous = current;
		}
		current = current.getNext();
		indexcount++;
	    }
	    LNode<T> next = new LNode<T>(value,current);
	    previous.setNext(next);
	}else if(index == size){
	    LNode<T> newend = new LNode<T>(value);
	    end.setNext(newend);
	    end = newend;
	}else{
	    LNode<T> next = new LNode<T>(value,current);
	    start = next;
	}
	size++;    
    }
    
    public T get(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("index out of bounds");
	}
	int indexcount = 0;
	LNode<T> current = start;
	while (indexcount < index){
	    current = current.getNext();
	    indexcount++;
	}
	return current.getData();
    }

    public T remove(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("index out of bounds");
	}
	int indexcount = 0;
	LNode<T> current = start;
	LNode<T> previous = new LNode<T>();
	if (index > 0){
	    while (indexcount < index){
		if (indexcount == index - 1){
		    previous = current;
		}
		current = current.getNext();
		indexcount++;
	    }
	    previous.setNext(current.getNext());
	}else{
	    start = start.getNext();
	}
	size--;
	return current.getData();
    }

    public T set(int index,T value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("index out of bounds");
	}
	int indexcount = 0;
	LNode<T> current = start;
	while (indexcount != index){
	    indexcount++;
	    current = current.getNext();
	}
	T save = current.getData();
	current.setData(value);
	return save;
    }
    
    public int indexOf(T value){
	int index = 0;
	LNode<T> current = start;
	while (index < size){
	    if (current.getData().equals(value)){
		break;
	    }
	    if (index == size-1){
		index = -1;
		break;
	    }
	    index++;
	    current = current.getNext();
	}
	return index;
    }

    public int size(){
	return size;
    }

    public String toString(){
	LNode<T> current = start;
	String result = "[ ";
	while (current.getNext() != null){
	    result += current.getData()+" ";
	    current = current.getNext();
	}
	result += current.getData() + " ]";
	return result;
    }

    public static void main (String[]args){
	MyLinkedList<Integer> test = new MyLinkedList<Integer>();
	test.add(5);
	test.add(0,3);
	test.add(7);
	test.add(6);
	test.add(2,4);
	System.out.println(test.get(2));
	System.out.println(test.size());
	System.out.println(test);
	System.out.println(test.remove(0));
	System.out.println(test.size());
	System.out.println(test);
	System.out.println(test.set(0,3));
	System.out.println(test);
	System.out.println(test.indexOf(6));
	System.out.println(test.indexOf(100));
    }
}
