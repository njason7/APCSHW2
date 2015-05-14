import java.util.*;

public class MyHeap{
    private boolean isMax;
    private ArrayList<Integer> numholder = new ArrayList<Integer>();
    private int counter = 0;
    private TreeNode<Integer> root;

    public MyHeap(){
	isMax = true;
    }

    public MyHeap(boolean isMax){
	this.isMax = isMax;
    }
    
    public void add(int n){
	if (root == null){
	    root = new TreeNode<Integer>(n);
	    numholder.add(1);
	    numholder.add(n);
	}else{
	    TreeNode<Integer> curr = root;
	    int orinum = numholder.get(0);
	    while (orinum == numholder.get(0)){
		if (curr.getLeft()==null && curr.getRight()==null){
		    curr.setLeft(new TreeNode<Integer>(n,curr));
		    numholder.set(0,numholder.get(0)+1);
		    numholder.add(n);
		    while (isMax && curr.getLeft().getData() > curr.getData()){
			int count = 1;
			while (numholder.get(count) != curr.getData()){
			    count++;
			}
			numholder.set(count*2,curr.getData());
			numholder.set(count,curr.getLeft().getData());
			int save = curr.getLeft().getData();
			curr.getLeft().setData(curr.getData());
			curr.setData(save);
			curr = curr.getParent();
			if (curr==null){
			    break;
			}
		    }
		    if(curr!=null && curr.getRight() != null){
			while (isMax && curr.getRight().getData() > curr.getData()){
			    int count = 1;
			    while (numholder.get(count) != curr.getData()){
				count++;
			    }
			    numholder.set(count*2+1,curr.getData());
			    numholder.set(count,curr.getRight().getData());
			    int save = curr.getRight().getData();
			    curr.getRight().setData(curr.getData());
			    curr.setData(save);
			    curr = curr.getParent();
			    if (curr==null){
				break;
			    }
			}
		    }
		    while (!isMax && curr.getLeft().getData() < curr.getData()){
			int count = 1;
			while (numholder.get(count) != curr.getData()){
			    count++;
			}
			numholder.set(count*2,curr.getData());
			numholder.set(count,curr.getLeft().getData());
			int save = curr.getLeft().getData();
			curr.getLeft().setData(curr.getData());
			curr.setData(save);
			curr = curr.getParent();
			if (curr==null){
			    break;
			}
		    }
		    if(curr!= null && curr.getRight() != null){
			while (!isMax && curr.getRight().getData() < curr.getData()){
			    int count = 1;
			    while (numholder.get(count) != curr.getData()){
				count++;
			    }
			    numholder.set(count*2+1,curr.getData());
			    numholder.set(count,curr.getRight().getData());
			    int save = curr.getRight().getData();
			    curr.getRight().setData(curr.getData());
			    curr.setData(save);
			    curr = curr.getParent();
			    if (curr==null){
				break;
			    }
			}
		    }
		}else if(curr.getRight()==null){
		    curr.setRight(new TreeNode<Integer>(n,curr));
		    numholder.set(0,numholder.get(0)+1);
		    numholder.add(n);
		    System.out.println(numholder.indexOf(curr.getData()));
		    while (isMax && curr.getRight().getData() > curr.getData()){
			int count = 1;
			while (numholder.get(count) != curr.getData()){
			    count++;
			}
			numholder.set(count*2+1,curr.getData());
			numholder.set(count,curr.getRight().getData());
			int save = curr.getRight().getData();
			curr.getRight().setData(curr.getData());
			curr.setData(save);
			curr = curr.getParent();
			if (curr==null){
			    break;
			}
		    }
		    if(curr!=null && curr.getLeft() != null){
			while (isMax && curr.getLeft().getData() > curr.getData()){
			    int count = 1;
			    while (numholder.get(count) != curr.getData()){
				count++;
			    }
			    numholder.set(count*2,curr.getData());
			    numholder.set(count,curr.getLeft().getData());
			    int save = curr.getLeft().getData();
			    curr.getLeft().setData(curr.getData());
			    curr.setData(save);
			    curr = curr.getParent();
			    if (curr==null){
				break;
			    }
			}
		    }
		    while (!isMax && curr.getRight().getData() < curr.getData()){
			int count = 1;
			while (numholder.get(count) != curr.getData()){
			    count++;
			}
			numholder.set(count*2+1,curr.getData());
			numholder.set(count,curr.getRight().getData());
			int save = curr.getRight().getData();
			curr.getRight().setData(curr.getData());
			curr.setData(save);
			curr = curr.getParent();
			if (curr==null){
			    break;
			}
		    }
		    if(curr !=null && curr.getLeft() != null){
			while (!isMax && curr.getLeft().getData() < curr.getData()){
			    int count = 1;
			    while (numholder.get(count) != curr.getData()){
				count++;
			    }
			    numholder.set(count*2,curr.getData());
			    numholder.set(count,curr.getLeft().getData());
			    int save = curr.getLeft().getData();
			    curr.getLeft().setData(curr.getData());
			    curr.setData(save);
			    curr = curr.getParent();
			    if (curr==null){
				break;
			    }
			}
		    }
		}else{
		    if ((curr.getLeft().getRight()==null) && (curr.getRight().getRight()) == null){
			curr = curr.getLeft();
		    }else{
			curr = curr.getRight();
		    }
		}
	    }
	}
    }
    
    public int remove(){
	int save = root.getData();
	TreeNode<Integer> curr = root;
	while (curr.getRight() != null){
	    curr = curr.getRight();
	}
	if (curr.getLeft() != null){
	    curr = curr.getLeft();
	}
	root.setData(curr.getData());
	curr = curr.getParent();
	if (curr == null){
	    numholder = new ArrayList<Integer>();
	    numholder.add(0);
	    return save;
	}
	if (curr.getRight() != null){
	    curr.setRight(null);
	}else{
	    curr.setLeft(null);
	}
	curr = root;
	while (curr.getLeft() != null){
	    int move = curr.getData();
	    if (curr.getLeft() != null && curr.getRight() != null){
		if (isMax){
		    if (curr.getLeft().getData() > curr.getRight().getData() && curr.getLeft().getData() > curr.getData()){
			curr.setData(curr.getLeft().getData());
			curr.getLeft().setData(move);
			curr = curr.getLeft();
		    }else if(curr.getRight().getData() > curr.getLeft().getData() && curr.getRight().getData() > curr.getData()){
			curr.setData(curr.getRight().getData());
			curr.getRight().setData(move);
			curr = curr.getRight();
		    }else{
			break;
		    }
		}else{
		    if (curr.getLeft().getData() < curr.getRight().getData() && curr.getLeft().getData() < curr.getData()){
			curr.setData(curr.getLeft().getData());
			curr.getLeft().setData(move);
			curr = curr.getLeft();
		    }else if(curr.getRight().getData() < curr.getLeft().getData() && curr.getRight().getData() < curr.getData()){
			curr.setData(curr.getRight().getData());
			curr.getRight().setData(move);
			curr = curr.getRight();
		    }else{
			break;
		    }
		}
	    }else{
		if((isMax && curr.getLeft().getData() > curr.getData())||
		   (!isMax && curr.getLeft().getData() < curr.getData())){
		    curr.setData(curr.getLeft().getData());
		    curr.getLeft().setData(move);
		    curr = curr.getLeft();
		}else{
		    break;
		}
	    }
	}
	numholder.remove(0);
	return save;
    }
    
	public int peek(){
	    return root.getData();
	}

	public int getHeight(){
	    return getHeight(root);
	}

	private int getHeight(TreeNode<Integer> r ){
	    if(r == null){
		return 0;
	    }else{
		return 1 + Math.max(getHeight(r.getLeft()),
				    getHeight(r.getRight()));
	    }
	}

	private int maxLength() {
	    if (root == null)
		return 0;
	    return maxLength(root);
	}

	private int maxLength(TreeNode<Integer> curr) {
	    int max = curr.toString().length();
	    int temp;
	    if (curr.getLeft() != null) {
		temp = maxLength(curr.getLeft());
		if (temp > max)
		    max = temp;
	    }
	    if (curr.getRight() != null) {
		temp = maxLength(curr.getRight());
		if (temp > max)
		    max = temp;
	    }
	    return max;
	}

	private String spaces(double n) {
	    String result = "";
	    for (int i = 0; i < n; i++)
		result += " ";
	    return result;
	}

	private String getLevel(TreeNode<Integer> curr, int currLevel, int targetLevel, int height, int wordLength) {
	    if (currLevel == 1){
		return curr.toString() + 

		    spaces(wordLength - curr.toString().length()) +
		    spaces(wordLength * 

			   Math.pow(2, height - targetLevel + 1) - 

			   wordLength);
	    }
	    String result = "";
	    if (curr.getLeft() != null){
		result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	    }else{
		result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	    }
	    if (curr.getRight() != null){
		result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	    }else{ 
		result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	    }
	    return result;
	}
		
	public String toString() {
	    if (root == null)
		return "";
	    String result = "";
	    int height = getHeight();
	    int wordLength = maxLength();
	    for (int level = 1; level < height; level++){
		result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		    getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		    "\n";
	    }
	    result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
	    result+="\n\n";
	    result += numholder;
	    return result;
	}

	public static void main(String[]args){
	    MyHeap test = new MyHeap(false);
	    test.add(3);
	    //test.add(2);
	    //test.add(1);
	    //test.add(4);
	    //test.add(6);
	    // System.out.println(test);
	    // test.add(14);
	    // System.out.println(test);
	    //test.add(7);
	    System.out.println(test);
	    test.remove();
	    //System.out.println(test);
	    //test.remove();
	    System.out.println(test);
	}
    }
