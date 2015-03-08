import java.util.Arrays;

public class quick{

    public static int partition(int[] ary,int si, int ei){
	int ri = si + (int)(Math.random()*(ei-si+1));
	int pivot = ary[ri];
	int end = ei;
	int pivindex = si;
	int[] copy= new int[ary.length];
	for (int i=0;i<ary.length;i++){
	    if (i<si || i>ei){
		copy[i] = ary[i];
	    }
	}
	for (int i=si;i<=end;i++){
	    if (ary[i] < pivot){
		copy[si] = ary[i];
		si++;
	    }else if (ary[i] > pivot){
		copy[ei] = ary[i];
		ei--;
	    }
	}
	copy[si] = pivot;
	System.arraycopy(copy,0,ary,0,ary.length);
	return si;
    }

    public static int quickselect(int[] ary,int si,int ei,int index){
	int partindex = partition(ary,si,ei);
	if (index == partindex){
	    return ary[index];
	}else if (index > partindex){
	    return quickselect(ary,partindex,ei,index);
	}else if (index < partindex){
	    return quickselect(ary,si,partindex,index);
	}
	return index;
    }

    public static void main (String[]args){
	int[] ary = new int[] {1,4,2,5,7,12,9};
	System.out.println(quickselect(ary,0,ary.length-1,2));
	System.out.println(Arrays.toString(ary));
    }
}
