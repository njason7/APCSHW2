import java.util.*;

public class MyDeque<T>{
    int head,tail,size;
    Object[] ary;
    public MyDeque(){
	ary = new Object[6];
	head = 2;
	tail = 3;
	size = 0;
    }

    public void addFirst(T value){
	if (size == ary.length){
	    ary = resize(ary);
	}
	ary[head] = value;
	head--;
	size++;
	if (head == -1){
	    head = ary.length-1;
	}
    }

    public void addLast(T value){
	if (size == ary.length){
	    ary = resize(ary);
	}
	ary[tail] = value;
	tail++;
	size++;
	if (tail == ary.length){
	    tail = 0;
	}
    }

    public Object[] resize(Object[] ary){
	Object[] clone = new Object[ary.length*2];
	for (int i = 1;i<ary.length-head;i++){
	    clone[ary.length/2+i-1] = ary[head+i];
	}
	for (int i = 0;i<head+1;i++){
	    clone[ary.length/2+ary.length-head+i-1] = ary[i];
	}
	head = size/2-1;
	tail = size*3/2;
	return clone;
    }

    public T removeFirst(){
	if (head == ary.length -1){
	    head = 0;
	}else{
	    head++;
	}
	T save = (T)ary[head];
	ary[head] = null;
	return save;
    }

    public T removeLast(){
	if (tail == 0){
	    tail = ary.length-1;
	}else{
	    tail--;
	}
	T save = (T)ary[tail];
	ary[tail] = null;
	return save;
    }
    
    public String toString(){
	String result = "";
	for (int i = 1;i<ary.length;i++){
	    if (ary[(head+i)%ary.length] != null){
		if (i > 1){
		    result += ", ";
		}
		result += ary[(head+i)%ary.length];
	    }
	}
	//return Arrays.toString(ary);
	return result;
    }	

    public static void main (String[]args){
	MyDeque<Integer> test = new MyDeque<Integer>();
	test.addLast(1);
	test.addLast(2);	
	test.addLast(3);
	test.addLast(4);
	test.addLast(5);
	test.addLast(6);
	test.addLast(7);
	test.addLast(8);
	System.out.println(test);
	System.out.println(test.removeLast());
	System.out.println(test.removeLast());
	System.out.println(test.removeLast());
	System.out.println(test.removeLast());	
	System.out.println(test);
    }
}
