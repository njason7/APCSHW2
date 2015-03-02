public class Sorts{
    
    public static void mergesort(int[] arr){
	int[] divide1 = new int[arr.length/2];
	int[] divide2 = new int[arr.length-arr.length/2];
	System.arraycopy(arr,0,divide1,0,arr.length/2);
	System.arraycopy(arr,arr.length/2,divide2,0,arr.length-arr.length/2);
	System.arraycopy(merge(divide1,divide2),0,arr,0,arr.length);
    }

    public static int[] merge(int[] array1,int[] array2){
	if (array1.length > 1){
	    int[] divide1 = new int[array1.length/2];
	    int[] divide2 = new int[array1.length-array1.length/2];
	    System.arraycopy(array1,0,divide1,0,array1.length/2);
	    System.arraycopy(array1,array1.length/2,divide2,0,array1.length-array1.length/2);

	    array1 = merge(divide1,divide2);
	}
	if (array2.length > 1){
	    int[] divide1 = new int[array2.length/2];
	    int[] divide2 = new int[array2.length-array2.length/2];
	    System.arraycopy(array2,0,divide1,0,array2.length/2);
	    System.arraycopy(array2,array2.length/2,divide2,0,array2.length-array2.length/2);
	    
	    array2 = merge(divide1,divide2);
	}
	return sort(array1,array2);
    }
    

    public static int[] sort(int[] array1,int[] array2){
	int track1 = 0;
	int track2 = 0;
	int resultno = 0;
	int[] result = new int[array1.length+array2.length];
	while (track1 < array1.length && track2 < array2.length){
	    if (array1[track1] < array2[track2]){
		result[resultno] = array1[track1];
		track1++;
		resultno++;
	    }else{
		result[resultno] = array2[track2];
		track2++;
		resultno++;
	    }
	}
	if (track1 == array1.length){
	    for (int i = track2;i<array2.length;i++){
		result[resultno] = array2[i];
		resultno++;
	    }
	}else if (track2 == array2.length){
	    for (int i = track1;i<array1.length;i++){
		result[resultno] = array1[i];
		resultno++;
	    }
	}
	return result;
    }
   
    public static void main(String[]args){
	int[] array1 = new int[6];
	for (int i=0;i<array1.length;i++){
	    array1[i] = (int)(Math.random()*5000);
	}
	String result = "";
	for (int i=0;i<array1.length;i++){
	    result+=array1[i]+",";
	}
	System.out.println(result);
	mergesort(array1);
	String result2="";
	for (int i=0;i<array1.length;i++){
	    result2+=array1[i]+",";
	}
	System.out.println(result2);
    }
}
