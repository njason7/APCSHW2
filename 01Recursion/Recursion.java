public class Recursion{

    public Recursion(){

    }

    public String name(){
	return "Ng,Jason";
    }

    public int fact(int n){
	if (n > 0){
	    return n*(fact(n-1));
	}
	return 1;
    }

    public int fib(int n){
	if (n == 1){
	    return 0;
	}else if (n==2){
	    return 1;
	}else{
	    return fib(n-2)+fib(n-1);
	}
    }

    public double sqrt(double n){
	return sqrthelp(n,1);
    }

    public double sqrthelp(double n,double guess){
	if (Math.abs(((n/guess + guess)/2)-guess) < .00001){
	    return guess;
	}
	return sqrthelp(n,((n/guess + guess)/2));
    }

    public static void main(String[]args){
	/*Recursion test = new Recursion();
	System.out.println(test.fact(10));
	System.out.println(test.fib(10));
	System.out.println(test.sqrt(100));*/
    }
}
