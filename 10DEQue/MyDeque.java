import java.util.*;

public class MyDeque<T>{
    int head,tail,size;
    Object[] ary;
    public MyDeque(){
	ary = new Object[5];
	head = 2;
	tail = 3;
	size = 0;
    }

    public void addFirst(T value){
	if (size == ary.length){
	    resize(ary);
	}
	ary[head] = value;
	head--;
	size++;
    }

    public void resize(Object[] ary){
	Object[] clone = new Object[ary.length*2];
	for (int i = 0;i<ary.length;i++){
	    clone[ary.length/2+i] = ary[head+i];
	}
	for (int i = 0;i<head;i++){
	    clone[ary.length/2+ary.length-head+i] = ary[i];
	}
	ary = clone;
	head = ary.length/2 -1;
	tail = 3*ary.length/2 +1;
    }

    public String toString(){
	return Arrays.toString(ary);
    }
	

    public static void main (String[]args){
	MyDeque<Integer> test = new MyDeque<Integer>();
	test.addFirst(4);
	test.addFirst(2);
	System.out.println(test);
    }
}