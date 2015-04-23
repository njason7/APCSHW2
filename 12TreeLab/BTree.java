import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
    Random rand = new Random();

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
		add(curr.getRight(),bn);
	    }else{
		add(curr.getLeft(),bn);
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
	 String result ="";
	 if (curr != null && curr.getValue() != null){
	     result += curr.getValue();
	 }
	 result += "\n";
	 if (curr.getRight() != null && curr.getRight().getValue() != null){
	     result += curr.getRight.getValue();
	 }
	 if (curr.getLeft() != null && curr.getLeft().getValue() != null){
	     result += curr.getLeft.getValue();
	 }
}