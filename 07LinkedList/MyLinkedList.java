public class MyLinkedList{
    LNode start;
    int size;

    public MyLinkedList(LNode node){
	start = node;
	size = 1;
    }

    public MyLinkedList(){
	start = new LNode();
	size = 0;
    }

    public void add(int value){
	LNode current = start;
	if (size>0){
	    LNode next = new LNode(value);
	    while (current.getnext() != null){
		current = current.getnext();
	    }
	    current.setnext(next);
	}else{
	    start.setdata(value);
	}
	size++;
	
    }

    public void add(int index, int value){
	int indexcount = 0;
	LNode current = start;
	while (indexcount < index){
	    current = current.getnext();
	    indexcount++;
	}
	LNode next = new LNode(value,current.getnext());
	current.setnext(next);
	size++;
    }

    public String toString(){
	LNode current = start;
	String result = "";
	while (current.getnext() != null){
	    result += current.getdata()+" ";
	    current = current.getnext();
	}
	result += current.getdata();
	return result;
    }

    public static void main (String[]args){
	LNode start = new LNode();
	MyLinkedList test = new MyLinkedList(start);
	test.add(5);
	test.add(0,3);
	System.out.println(test);
    }
}
