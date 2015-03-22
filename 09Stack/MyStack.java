import java.util.*;

public class MyStack<E>{
    	
    public String name(){
	return "ng.jason";
    }
    
    LinkedList<E> list;

    public MyStack(){
	list = new LinkedList<E>();
    }

    public boolean empty(){
	return (list.size() == 0);
    }

    public E push(E value){
	if (empty()){
	    list.add(value);
	}else{
	    list.addFirst(value);
	}
	return value;
    }

    public E peek(){
	return list.get(0);
    }

    public E pop(){
	E save = list.peek();
	return list.removeFirst();
    }
    
    public static void main (String[]args){
	MyStack<Integer> test = new MyStack<Integer>();
	System.out.println(test.push(4));
	System.out.println(test.push(2));
	System.out.println(test.peek());
	System.out.println(test.pop());
    }

}
