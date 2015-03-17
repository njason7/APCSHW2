import java.util.*;
import java.io.*;
import java.lang.*;

public class makelake{
    int R, C, E, N, targetR, targetC, targetS, Tallest, Vol;
    int[][] stomps, field;

    public String name(){
    	return "ng.jason"
    }

    public makelake(String filename){
	try{
	    Scanner in = new Scanner(new File(filename));
	    String line = in.nextLine();
	    String[] thethings = line.split(" ");
	    R = Integer.parseInt(thethings[0]);
	    C = Integer.parseInt(thethings[1]);
	    E = Integer.parseInt(thethings[2]);
	    N = Integer.parseInt(thethings[3]);
	    field = new int[R][C];
	    line = "";
	
	    for(int a = 0; a < R;a++){
		line = in.nextLine();
		String[] therow = line.split(" ");
		for (int b = 0; b < C; b++){
		    field[a][b] = Integer.parseInt(therow[b]);
		}
	    }
	    stomps = new int[N][3];
	    for(int a = 0; a < N;a++){
		line = in.nextLine();
		String[] thecommands = line.split(" ");
		for (int b = 0; b < 3; b++){
		    stomps[a][b] = Integer.parseInt(thecommands[b]);
		}
	    }
	}
	catch(Exception e){
	    System.out.println("File not found");
	    e.printStackTrace();
	    System.exit(0);
	}
    }

    public String toString(){
	String printing = "";
	for (int a = 0; a < R; a++){
	    for(int b = 0; b < C; b++){
		printing = printing + field[a][b] + " ";
	    }
	    printing = printing + "\n";
	}
	return printing;
    }
    public String thecommands(){
	String printing = "";
	for (int a = 0; a < N; a++){
	    for(int b = 0; b < 3; b++){
		printing = printing + stomps[a][b] + " ";
	    }
	    printing = printing + "\n";
	}
	return printing;
    }
    public int test(){
	Vol = 0;
	for (int a = 0; a < stomps.length; a++){
	    targetR = stomps[a][0];
	    targetC = stomps[a][1];
	    targetS = stomps[a][2];
	    Tallest = field[targetR][targetC];
	    for (int b = 0; b < 3; b++){
		for (int c = 0; c < 3; c++){
		    if(field[b + targetR - 1][c + targetC - 1] > Tallest){
			Tallest = field[b + targetR - 1][c + targetC - 1];
		    }
		}
	    }
	    Tallest = Tallest - targetS;
	    for (int b = 0; b < 3; b++){
		for (int c = 0; c < 3; c++){
		    if(field[b + targetR - 1][c + targetC - 1] > Tallest){
			field[b + targetR - 1][c + targetC - 1] = Tallest;
		    }
		}
	    }
	}
	for (int b = 0; b < R; b++){
	    for (int c = 0; c < C; c++){
		if(field[b][c] < E){
		    Vol = Vol + (E - field[b][c]);
		}
	    }
	}
	return Vol * 72 * 72;
    }
    public static void main (String[]args){
	if(args.length > 0){
	    makelake test = new makelake(args[0]);
	    System.out.println(test.test());
	}
    }
}
