public class LNode{
    private LNode next;
    private int data;

    public LNode(){

    }

    public LNode(int data){
	this.data = data;
    }

    public LNode(int data, LNode next){
	this.next = next;
	this.data = data;
    }

    public void setdata(int data){
	this.data = data;
    }

    public void setnext(LNode next){
	this.next = next;
    }

    public int getdata(){
	return data;
    }

    public LNode getnext(){
	return next;
    }

    public String toString(){
	return ""+data;
    }
}
