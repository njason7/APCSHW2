import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
    Random rand = new Random(123);

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }
    
    public void add(E d){
	TreeNode<E> start = new TreeNode<E>(d);
	add(root,start);
    }
    
    private void add(TreeNode<E> curr, TreeNode<E> bn){
	if (curr == null){
	    curr = bn;
	}else if (curr.getRight() == null && curr.getLeft() == null){
	    int add = rand.nextInt(2);
	    if (add == 0){
		curr.setRight(bn);
	    }else{
		curr.setLeft(bn);
	    }
	}else if (curr.getRight() == null){
	    curr.setRight(bn);
	}else if (curr.getLeft() == null){
	    curr.setLeft(bn);
	}else{
	    int guess = rand.nextInt(2);
	    if (guess == 0){
		add(curr.getRight(),bn);
	    }else{
		add(curr.getLeft(),bn);
	    }
	}
    }

     public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

     public void preOrder(TreeNode<E> curr){
	 if (curr != null && curr.getValue() != null){
	     System.out.print(curr.getValue());
	 }
	 preOrder(curr.getRight());
	 preOrder(curr.getLeft());
     }

     public void inOrder(TreeNode<E> curr){

     }

     public void postOrder(TreeNode<E> curr){

     }

     public static void main (String[]args){
	 BTree<Integer> t = new BTree<Integer>();
	 t.add(1);
	 t.add(2);
	 t.add(3);
	 t.traverse( PRE_ORDER);
     }
}