import java.util.*;

public class LNode<T>{
    private LNode<T> next;
    private T data;

    public String name(){
	return "ng.jason";
    }

    public LNode(){

    }

    public LNode(T data){
	this.data = data;
    }

    public LNode(T data, LNode<T> next){
	this.next = next;
	this.data = data;
    }

    public void setData(T data){
	this.data = data;
    }

    public void setNext(LNode<T> next){
	this.next = next;
    }

    public T getData(){
	return data;
    }

    public LNode<T> getNext(){
	return next;
    }

    public String toString(){
	return ""+data;
    }
}
