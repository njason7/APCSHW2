public class MyHeap{
    private boolean isMax;
    private ArrayList<Integer> numholder = new ArrayList<Integer>();
    private int counter = 0;
    private TreeNode<Integer> root = new TreeNode<Integer>();

    public MyHeap(){
	isMax = true;
    }

    public MyHeap(boolean isMax){
	this.isMax = isMax;
    }
    
    public void add(int n){
	if (root = null){
	    root = new TreeNode<Integer>(n);
	    numholder.add(1);
	}else{
	    TreeNode<Integer> curr = root;
	    int orinum = numholder.get(0);
	    while (orinum == numholder.get(0)){
		if (curr.getLeft()==null && curr.getRight()==null){
		    curr.setLeft(new TreeNode<Integer>(n));
		    numholder.set(0,numholder.get(0)+1);
		}else if(curr.getRight()==null){
		    curr.setRight(new TreeNode<Integer>(n));
		    numholder.set(0,numholder.get(0)+1);
		}else{
		    if (curr.getLeft().getRight()==null && curr.getRight().getRuight()){
			curr = curr.getLeft();
		    }else{
			curr = curr.getRight();
		    }
		}
	    }
	}
	numholder.add(n);
    }
    
    public int remove(){
	return 0;
    }

    public int peek(){
	return root.getValue();
    }
}