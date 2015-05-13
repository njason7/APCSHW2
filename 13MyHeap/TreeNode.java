public class TreeNode<E>{
    private TreeNode<E> left,right,parent;
    private E store;

    public TreeNode(E value){
	store = value;
	right = null;
	left = null;
	parent = null;
    }
    
    public TreeNode(){
	store = null;
	right = null;
	left = null;
	parent = null;
    }

    public TreeNode(E value, TreeNode<E> parent){
	store = value;
	right = null;
	left = null;
	this.parent = parent;
    }

    public void setRight(TreeNode<E> n){
	right = n;
    }
    
    public void setLeft(TreeNode<E> n){
	left = n;
    }

    public void setParent(TreeNode<E> n){
	parent = n;
    }

    public TreeNode<E> getRight(){
	return right;
    }

    public TreeNode<E> getLeft(){
	return left;
    }

    public TreeNode<E> getParent(){
	return parent;
    }    

    public void setData(E value){
	store = value;
    }

    public E getData(){
	return store;
    }

    public String toString(){
	return ""+store;
    }
}
