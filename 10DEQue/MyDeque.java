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
	System.out.println(Arrays.toString(ary));
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
	System.out.println(Arrays.toString(clone));
	System.out.println(head);
	System.out.println(tail);
	return clone;
    }

    public String toString(){
	return Arrays.toString(ary);
    }	

    public static void main (String[]args){
	MyDeque<Integer> test = new MyDeque<Integer>();
	test.addFirst(1);
	test.addFirst(2);	
	test.addFirst(3);
	test.addFirst(4);
	test.addFirst(5);
	test.addFirst(6);
	test.addFirst(7);
	test.addFirst(8);
	System.out.println(test);
    }
}
