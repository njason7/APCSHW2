import java.util.*;

public class MyStack<T>{
    	
    public String name(){
	return "ng.jason";
    }
    
    MyLinkedList<T> list;

    public MyStack(){
	list = new MyLinkedList<T>();
    }

    public boolean empty(){
	return (list.size() == 0);
    }

    public T push(T value){
	if (empty()){
	    list.add(value);
	}else{
	    list.add(0,value);
	}
	return value;
    }

    public T peek(){
	return list.get(0);
    }

    public T pop(){
	return list.remove(0);
    }
    
    public static void main (String[]args){
	MyStack<Integer> test = new MyStack<Integer>();
	System.out.println(test.push(4));
	System.out.println(test.push(2));
	System.out.println(test.peek());
	System.out.println(test.pop());
    }

}
