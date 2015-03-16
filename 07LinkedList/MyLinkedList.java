public class MyLinkedList{
    LNode start;
    LNode end;
    int size;

    public MyLinkedList(LNode node){
	start = node;
	size = 1;
	end = node;
    }

    public MyLinkedList(){
	size = 0;
    }

    public boolean add(int value){
	if (size==0){
	    start = new LNode(value);
	    end = start;
	    size++;
	    return true;
	}else{
	    LNode current = start;
	    LNode next = new LNode(value);
	    while (current.getNext() != null){
		current = current.getNext();
	    }
	    current.setNext(next);
	}
	size++;
	return true;
    }
    
    public void add(int index, int value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("index out of bounds");
	}
	int indexcount = 0;
	LNode current = start;
	LNode previous = new LNode();
	if (index > 0){
	    while (indexcount < index){
		if (indexcount == index - 1){
		    previous = current;
		}
		current = current.getNext();
		indexcount++;
	    }
	    LNode next = new LNode(value,current);
	    previous.setNext(next);
	}else{
	    LNode next = new LNode(value,current);
	    start = next;
	}
	size++;    
    }
    
    public int get(int index){
	if (index < size){
	    int indexcount = 0;
	    LNode current = start;
	    while (indexcount < index){
		current = current.getNext();
		indexcount++;
	    }
	    return current.getData();
	}
	return 0;
    }

    public int remove(int index){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("index out of bounds");
	}
	int indexcount = 0;
	LNode current = start;
	LNode previous = new LNode();
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

    public int set(int index,int value){
	if (index < 0 || index > size){
	    throw new IndexOutOfBoundsException("index out of bounds");
	}
	int indexcount = 0;
	LNode current = start;
	while (indexcount != index){
	    indexcount++;
	    current = current.getNext();
	}
	int save = current.getData();
	current.setData(value);
	return save;
    }
    
    public int indexOf(int value){
	int index = 0;
	LNode current = start;
	while (index < size){
	    if (current.getData() == value){
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
	LNode current = start;
	String result = "[ ";
	while (current.getNext() != null){
	    result += current.getData()+" ";
	    current = current.getNext();
	}
	result += current.getData() + " ]";
	return result;
    }

    public static void main (String[]args){
	MyLinkedList test = new MyLinkedList();
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
