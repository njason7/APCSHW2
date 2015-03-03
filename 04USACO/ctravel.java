import java.util.*;
import java.io.*;
public class ctravel{
    
    private char[][]field;
    private int r,c,startr,startc,endr,endc,steps,counter;

    public ctravel(String filename){
	try{
	    Scanner in = new Scanner(new File(filename));
	    String line = in.nextLine();
	    String[] vars = line.split(" ");
	    r = Integer.parseInt(vars[0]);
	    c = Integer.parseInt(vars[1]);
	    steps = Integer.parseInt(vars[2]);
	    field = new char[r][c];
	    line = " ";
	    for(int a = 0;a<r;a++){
		line = in.nextLine();
		for (int b=0;b<c;b++){
		    field[a][b] = line.charAt(b);
		}
	    }
	    line = in.nextLine();
	    String[] loc = line.split(" ");
	    startr = Integer.parseInt(loc[0])-1;
	    startc = Integer.parseInt(loc[1])-1;
	    endr = Integer.parseInt(loc[2])-1;
	    endc = Integer.parseInt(loc[3])-1;
	}
	catch(Exception e){
	    System.out.println("File not found");
	    e.printStackTrace();
	    System.exit(0);
	}
    }

    public int solve(){
        this.solve(startr,startc,0);
	return counter;
    }
	
    
    public void solve(int r,int c,int stepc){
	if (r<field.length && r >=0 && c<field[0].length && c>=0 && stepc <= steps){
	    if (stepc == steps && r == endr && c == endc){
		counter++;
	    }
	    if (field[r][c] == '.'){
		this.solve(r+1,c,stepc+1);
		this.solve(r,c+1,stepc+1);
		this.solve(r-1,c,stepc+1);
		this.solve(r,c-1,stepc+1);
	    }
	}
    }


    public static void main (String[]args){
	if(args.length > 0){
	    ctravel test = new ctravel(args[0]);
	    System.out.println(test.solve());
	}
    }
}
