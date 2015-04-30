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
	if (root == null){
	    root = bn;
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
	 if (curr.getLeft() != null && curr.getLeft().getValue() != null){
	     preOrder(curr.getLeft());
	 }
	 if (curr.getRight() != null && curr.getRight().getValue() != null){
	     preOrder(curr.getRight());
	 }
     }

     public void inOrder(TreeNode<E> curr){
	 if (curr.getLeft() != null && curr.getLeft().getValue() != null){
	     preOrder(curr.getLeft());
	 }
	 if (curr != null && curr.getValue() != null){
	     System.out.print(curr.getValue());
	 }
	 if (curr.getRight() != null && curr.getRight().getValue() != null){
	     preOrder(curr.getRight());
	 }
     }
     
     public void postOrder(TreeNode<E> curr){
	 if (curr.getLeft() != null && curr.getLeft().getValue() != null){
	     preOrder(curr.getLeft());
	 }
	 if (curr.getRight() != null && curr.getRight().getValue() != null){
	     preOrder(curr.getRight());
	 }
	 if (curr != null && curr.getValue() != null){
	     System.out.print(curr.getValue());
	 }
     }
     
     public int getHeight(){
	 return getHeight(root);
     }

     private int getHeight(TreeNode<E> curr){
	 int right0 = 1;
	 int left0 = 1;
	 if (curr.getRight() != null){
	     right0 = 1+getHeight(curr.getRight());
	 }
	 if (curr.getLeft() != null){
	     left0 = 1+getHeight(curr.getLeft());
	 }
	 if(right0>left0){
	     return right0;
	 }
	 return left0;
     }

     private String getLevel(TreeNode<E> curr,int level){
	 String result = "";
	 if (level == 0){
	     result += curr.getValue()+" ";
	 }
	 if (curr.getLeft() != null){
	     result += getLevel(curr.getLeft(),level-1);
	 }
	 if (curr.getRight() != null){
	     result += getLevel(curr.getRight(),level-1);
	 }
	 return result;
     }

     public String getLevel(int level){
	 return getLevel(root,level);
     }

     public String toString(){
	 String result = "";
	 int height = getHeight();
	 for (int i = 0;i<height;i++){
	     result += getLevel(i) + "\n";
	 }
	 return result;
     }

     public static void main (String[]args){
	 BTree<Integer> t = new BTree<Integer>();
	 for ( int i=0; i < 8; i++ ) 
	     t.add( i );
	 t.traverse( PRE_ORDER);
	 t.traverse( IN_ORDER);
	 t.traverse( POST_ORDER);
	 System.out.println(t.getHeight());
	 System.out.println(t.getLevel(1));
	 System.out.println(t);
     }
}
