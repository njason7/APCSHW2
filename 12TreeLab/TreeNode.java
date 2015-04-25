public class TreeNode<E>{
    private TreeNode<E> left,right;
    private E store;

    public TreeNode(E value){
	store = value;
	right = null;
	left = null;
    }
    
    public void setRight(TreeNode<E> n){
	right = n;
    }
    
    public void setLeft(TreeNode<E> n){
	left = n;
    }

    public TreeNode<E> getRight(){
	return right;
    }

    public TreeNode<E> getLeft(){
	return left;
    }
    
    public void setValue(E value){
	store = value;
    }

    public E getValue(){
	return store;
    }

    public String toString(){
	return ""+store;
    }
}
