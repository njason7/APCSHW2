import java.util.*;

public class HeapSort{

    public static void heapsort(int[] ary){
	int start;
	if (ary.length%2 == 0){
	    start = ary.length/2 -1;
	}else{
	    start = ary.length/2;
	}
	for (int i = start; i >=0;i--){
	    int index = i;
	    while (index*2+1 < ary.length){
		if (index*2+2 < ary.length){
		    if (ary[index*2+2] > ary[index] && ary[index*2+2] > ary[index*2+1]){
			int save = ary[index];
			ary[index] = ary[index*2+2];
			ary[index*2+2] = save;
			index = index*2+2;
		    }else if(ary[index*2+1] > ary[index] && ary[index*2+1] > ary[index*2+2]){
			int save = ary[index];
			ary[index] = ary[index*2+1];
			ary[index*2+1] = save;
			index = index*2+1;
		    }else{
			break;
		    }    
		}else if(index*2+1 < ary.length){
		    if (ary[index*2+1] > ary[index]){
			int save = ary[index];
			ary[index] = ary[index*2+1];
			ary[index*2+1] = save;
			index = index*2+1;
		    }
		}else{
		    break;
		}
	    }
	} 
	int counter = ary.length-1;
	while (counter >= 0){
	    int save = ary[0];
	    ary[0] = ary[counter];
	    ary[counter] = save;
	    int index = 0;
	    while (index*2+2 < counter){
		if (ary[index*2+2] > ary[index] && ary[index*2+2] > ary[index*2+1]){
		    int save1 = ary[index];
		    ary[index] = ary[index*2+2];
		    ary[index*2+2] = save1;
		    index = index*2+2;
		}else if(ary[index*2+1] > ary[index] && ary[index*2+1] > ary[index*2+2]){
		    int save2 = ary[index];
		    ary[index] = ary[index*2+1];
		    ary[index*2+1] = save2;
		    index = index*2+1;
		}else{
		    break;
		}
	    }
	    counter--;
	}  	
    }

    public static void main (String[]args){
	int[] test = new int[]{8,9,3,1,6,4,2,7};
	System.out.println(Arrays.toString(test)+"\n");
	heapsort(test);
	System.out.println(Arrays.toString(test));
    }
}
