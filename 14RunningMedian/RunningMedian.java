public class RunningMedian{
    MyHeap minheap;
    MyHeap maxheap;
    int counter;

    public RunningMedian(){
	minheap = new MyHeap(false);
	maxheap = new MyHeap();
	counter = 0;
    }

    public double getMedian(){
	if (counter%2 == 0){
	    return ((minheap.peek() + maxheap.peek())/2);
	}else{
	    return maxheap.peek();
	}
    }

    public void add(int value){
	if (counter%2==0){
	    if (counter == 0){
		maxheap.add(value);
	    }else if (value > maxheap.peek()){
		if (counter == 1){
		    minheap.add(value);
		}else if (value > minheap.peek()){
		    maxheap.add(minheap.remove());
		    minheap.add(value);
		}else{
		    maxheap.add(value);
		}
	    }else{
		maxheap.add(value);
	    }
	}else{
	    if (value > maxheap.peek()){
		minheap.add(value);
	    }else{
		minheap.add(maxheap.remove());
		maxheap.add(value);
	    }
	}
	counter++;
    }
    
    public int getminheap(){
	return minheap.peek();
    }
    
    public int getmaxheap(){
	return maxheap.peek();
    }

    public static void main(String[]args){
	RunningMedian test = new RunningMedian();
	test.add(2);
	System.out.println(test.getMedian());
	test.add(8);
	System.out.println(test.getMedian());
	test.add(12);
	System.out.println(test.getminheap());
	System.out.println(test.getmaxheap());
	System.out.println(test.getMedian());
    }
}