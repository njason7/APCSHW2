import java.util.*;
import java.io.*;
public class Maze implements Deque{

    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";    
    private String go(int x,int y){
	return ("\033["+x+";"+y+"H");
    }
    

    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

    private String invert(){
	return  "[37";
    }

    public void clearTerminal(){
	System.out.println(clear());
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += maze[i%maxx][i/maxx];
	}
	return hide()+invert()+go(0,0)+ans+"\n"+show();
    }
    
    /*    public boolean solve(){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty]=' ';
	    return solve(startx,starty);
	}
    }
    
    public boolean solve(int x,int y){
	System.out.println(this);
	wait(20);
	//ASSIGNMENT IS TO COMPLETE THIS PART******************
	if (maze[x][y] == 'E'){
	    return true;
	}
	if (maze[x][y] == ' '){
	    maze[x][y] = '@';
	    if (solve(x+1,y) || solve(x,y+1) || solve(x-1,y)||solve(x,y-1)){
		return true;
	    }
	    maze[x][y] = '.';
	    //mark the floor w/ @
	    //try to move in all directions
	    //when fail, replace @ w/ . 
	}
	//ASSIGNMENT IS TO COMPLETE THE PART ABOVE THIS******************
	return false;//by default the maze didn't get solved
	}*/

    public class Coordinates{

	public int[] coor = new int[2];
	
	public Coordinates(int r, int c){
	    coor[0] = r;
	    coor[1] = c;
	}
	
	public int getr(){
	    return coor[0];
	}
	
	public int getc(){
	    return coor[1];
	}
    }

    private Deque<Coordinates> frontier;

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }
    
    public boolean solveBFS(boolean animate){
	frontier.addFirst(startx,starty);
	while (maze[frontier.peek().getr()][frontier.remove().getc()] != 'E'){

	}
	return true;
    }

    public boolean solveDFS(boolean animate){
	return true;
    }
}