import java.util.*;

public class MyDeque<T>{
    private int head,tail,size;
    private Object[] ary;
    private int[] priority;

    public MyDeque(){
	ary = new Object[6];
	head = 2;
	tail = 2;
	size = 0;
	priority = new int[6];
    }

    public MyDeque(int init){
	ary = new Object[init];
	head = init/2;
	tail = init/2;
	size = 0;
	priority = new int[init];
    }

    public void addFirst(T value){
	if (head == tail && ary[head] == null){
	    ary[head] = value;
	}else{
	    if (size == ary.length){
		ary = resize(ary);
	    }
	    head--;
	    if (head == -1){
		head = ary.length-1;
	    }
	    ary[head] = value;
	}
	size++;
    }

    public void addLast(T value){
	if (head == tail && ary[tail] == null){
	    ary[tail] = value;
	}else{
	    if (size == ary.length){
		ary = resize(ary);
	    }
	    tail++;
	    if (tail == ary.length){
	    tail = 0;
	    }
	    ary[tail] = value;
	}
	size++;
    }

    public Object[] resize(Object[] ary){
	Object[] clone = new Object[ary.length*2];
	for (int i = 1;i<ary.length-head;i++){
	    clone[ary.length/2+i-1] = ary[head+i];
	}
	for (int i = 0;i<head+1;i++){
	    clone[ary.length/2+ary.length-head+i-1] = ary[i];
	}
	int[] copy = new int[priority.length*2];
	for (int i = 1;i<priority.length-head;i++){
	    copy[priority.length/2+i-1] = priority[head+i];
	}
	for (int i = 0;i<head+1;i++){
	    copy[priority.length/2+priority.length-head+i-1] = priority[i];
	}
	priority = copy;
	head = size/2-1;
	tail = size*3/2;
	return clone;
    }

    public T removeFirst(){
	T save = (T)ary[head];
	ary[head] = null;
	if (head == ary.length -1){
	    head = 0;
	}else{
	    head++;
	}
	size--;
	return save;
    }

    public T removeLast(){
	T save = (T)ary[tail];
	ary[tail] = null;
	if (tail == 0){
	    tail = ary.length-1;
	}else{
	    tail--;
	}
	size--;
	return save;
    }
    
    public int size(){
	return size;
    }

    public void add(T value,int prior){
	addLast(value);
	priority[tail] = prior;
    }

    public T removeSmallest(){
	int smallest, headcount, lowest;
	smallest = priority[head];
	headcount = head;
	lowest = head;
	while (headcount != tail){
      	    if (headcount == priority.length){
		headcount = 0;
	    }
	    if (priority[headcount] < smallest){
		smallest = priority[headcount];
		lowest = headcount;
	    }
	    if (headcount==tail){
		break;
	    }
	    headcount++;
	}
     	if (priority[tail] < smallest){
	    lowest = tail;
	    smallest = priority[tail];
	}
      	T save = (T)ary[lowest];
	ary[lowest] = ary[head];
	ary[head] = null;
	priority[lowest] = priority[head];
	priority[head] = 0;
	head++;
	if (head == ary.length){
	    head = 0;
	}
	return save;
    }

    public String toString(){
	String result = "";
	for (int i = 0;i<ary.length;i++){
	    if (ary[(head+i)%ary.length] != null){
		if (i > 0){
		    result += ", ";
		}
		result += ary[(head+i)%ary.length];
	    }
	}
	//return Arrays.toString(ary);
	return result;
    }	

    public String raw(){
	return Arrays.toString(ary);
    }
    
    public String priority(){
	return Arrays.toString(priority);
    }

    public static void main (String[]args){
	MyDeque<Integer> test = new MyDeque<Integer>();
	/*test.addFirst(1);
	test.addFirst(2);	
	test.addFirst(3);
	test.addFirst(4);
	test.addFirst(5);
	test.addFirst(6);
	test.addFirst(7);
	test.addFirst(8);
	System.out.println(test);
	System.out.println(test.removeLast());
	System.out.println(test.removeLast());
	System.out.println(test.removeLast());
	System.out.println(test.removeLast());	
	System.out.println(test);*/
	test.add(1,1);
	test.add(2,3);
	test.add(3,2);
	//System.out.println(test.priority());
	//System.out.println(test);
	//System.out.println(test.removeSmallest());
	//System.out.println(test.priority());
	//System.out.println(test);
	//System.out.println(test.removeSmallest());
	//System.out.println(test.priority());
	//System.out.println(test);
	//test.removeSmallest();
	test.removeSmallest();
    }
}
