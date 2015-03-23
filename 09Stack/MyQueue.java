public class MyQueue<T>{

    private MyLinkedList<T> list;

    public MyQueue(){
	list = new MyLinkedList<T>();
    }

    public T enqueue(T value){
	list.add(value);
	return value;
    }

    public T dequeue(){
	return list.remove(0);
    }

    public static void main (String[]args){
	MyQueue<Integer> test = new MyQueue<Integer>();
	test.enqueue(3);
	test.enqueue(2);
	System.out.println(test.dequeue());
	System.out.println(test.dequeue());
    }

}
