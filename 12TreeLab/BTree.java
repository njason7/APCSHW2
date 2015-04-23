import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    
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
	    Random rand = new Random();
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
	    Random rand = new Random();
	    int guess = rand.nextInt(2);
	    if (guess == 0){
		add(curr.getRight(),bn);
	    }else{
		add(curr.getLeft(),bn);
	    }
	}
    }
}