import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;

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

    private String go(int x,int y){
	return ("["+x+";"+y+"H");
    }
    
    private String clear(){
	return  "[2J";
    }

    private String hide(){
	return  "[?25l";
    }

    private String show(){
	return  "[?25h";
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

    private Deque<Coordinates> frontier = new LinkedList<Coordinates>();

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }
    
    public boolean check(int r,int c){
	if (maze[r+1][c] != ' ' && maze[r-1][c] != ' ' && maze[r][c+1] != ' ' && maze[r][c-1] != ' ' && maze[r+1][c] != 'E' && maze[r-1][c] != 'E' && maze[r][c+1] != 'E' && maze[r][c-1] != 'E'){
	    return false;
	}
	return true;
    }

    public boolean solveBFS(boolean animate){
	Coordinates cor = new Coordinates(startx,starty);
	frontier.addFirst(cor);
	int count = 0;
	while (maze[r][c] != 'E'){
	    int r = frontier.peek().getr();
	    int c = frontier.remove().getc();
	    if (animate == true){
		System.out.println(this);
	    }
	    if (check(r,c)){
		if (maze[r-1][c] == ' '){
		    Coordinates cor1 = new Coordinates(r-1,c);
		    frontier.addLast(cor1);
		    maze[r-1][c] = (char)(count+1);
		}
		if (maze[r+1][c] == ' '){
		    Coordinates cor2 = new Coordinates(r+1,c);
		    frontier.addLast(cor2);
		    maze[r+1][c] = (char)(count+1);
		}
		if (maze[r][c-1] == ' '){
		    Coordinates cor3 = new Coordinates(r,c-1);
		    frontier.addLast(cor3);
		    maze[r][c-1] = (char)(count+1);
		}
		if (maze[r][c+1] == ' '){
		    Coordinates cor4 = new Coordinates(r,c+1);
		    frontier.addLast(cor4);
		    maze[r][c+1] = (char)(count+1);
		}
		count++;
	    }
	    frontier.removeFirst();
	}
	return true;
    }

    public boolean solveDFS(boolean animate){
	return true;
    }

    public static void main (String[]args){
	Maze m = new Maze("data1.dat");
	m.solveBFS(true);
    }
}