import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private char[][]backup;
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
	backup = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    backup[i%maxx][i/maxx] = c;
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
	return  "\033[2J";
    }

    private String hide(){
	return  "\033[?25l";
    }

    private String show(){
	return  "\033[?25h";
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
	return clear()+hide()+go(0,0)+ans+"\n"+show();
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

	public String toString(){
	    return "["+coor[0]+","+coor[1]+"]";
	}
    }

    private MyDeque<ArrayList<Coordinates>> frontier = new MyDeque<ArrayList<Coordinates>>();

    private ArrayList<Coordinates> save;

    public boolean solveBFS(){
	return solveBFS(false);
    }

    /*public boolean solveDFS(){
	return solveDFS(false);
	}*/
    
    public boolean check(int r,int c){
	if (maze[r+1][c] != ' ' && maze[r-1][c] != ' ' && maze[r][c+1] != ' ' && maze[r][c-1] != ' ' && maze[r+1][c] != 'E' && maze[r-1][c] != 'E' && maze[r][c+1] != 'E' && maze[r][c-1] != 'E'){
	    return false;
	}
	return true;
    }

    public boolean solveBFS(boolean animate){
	Coordinates cor = new Coordinates(startx,starty);
	ArrayList add = new ArrayList<Coordinates>();
	add.add(cor);
	frontier.addLast(add);
     	int r = startx;
	int c = starty;
	while (maze[r][c] != 'E' && frontier.size() > 0){
	    if (animate == true){
		wait(25);
		System.out.println(this);
	    }
	    ArrayList<Coordinates> coorlist = frontier.removeFirst();
	    Coordinates coor = coorlist.get(coorlist.size()-1);
	    r = coor.getr();
	    c = coor.getc();
	    if (maze[r][c] != 'S' && maze[r][c] != 'E'){
	    maze[r][c] = '*';
	    }
	    coorlist.add(coor);
	    if (check(r,c)){
		if (maze[r-1][c] == ' '){
		    Coordinates cor1 = new Coordinates(r-1,c);
		    ArrayList<Coordinates> coorlist1 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist1.add(coorlist.get(i));
		    }
		    coorlist1.add(cor1);
		    frontier.addLast(coorlist1);
		}
		if (maze[r+1][c] == ' '){
		    Coordinates cor2 = new Coordinates(r+1,c);
		    ArrayList<Coordinates> coorlist2 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist2.add(coorlist.get(i));
		    }
		    coorlist2.add(cor2);
		    frontier.addLast(coorlist2);

		}
		if (maze[r][c-1] == ' '){
		    Coordinates cor3 = new Coordinates(r,c-1);
		    ArrayList<Coordinates> coorlist3 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist3.add(coorlist.get(i));
		    }
		    coorlist3.add(cor3);
		    frontier.addLast(coorlist3);
		}
		if (maze[r][c+1] == ' '){
		    Coordinates cor4 = new Coordinates(r,c+1);
		    ArrayList<Coordinates> coorlist4 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist4.add(coorlist.get(i));
		    }
		    coorlist4.add(cor4);
		    frontier.addLast(coorlist4);
		}
		if (maze[r-1][c] == 'E' || maze[r+1][c] == 'E' || maze[r][c-1] == 'E' || maze[r][c+1] == 'E'){
		    save = coorlist;
		    maze = backup;
		    for (int i=0;i<save.size();i++){
			maze[save.get(i).getr()][save.get(i).getc()] = '*';
			System.out.println(this);
		    }
		    return true;
		}
	    }
	}
	return false;
    }

    public boolean solveDFS(boolean animate){
	Coordinates cor = new Coordinates(startx,starty);
	ArrayList add = new ArrayList<Coordinates>();
	add.add(cor);
	frontier.addLast(add);
     	int r = startx;
	int c = starty;
	while (maze[r][c] != 'E' && frontier.size() > 0){
	    ArrayList<Coordinates> coorlist = frontier.removeFirst();
	    Coordinates coor = coorlist.get(coorlist.size()-1);
	    r = coor.getr();
	    c = coor.getc();
	    if (maze[r][c] != 'S' && maze[r][c] != 'E'){
		maze[r][c] = '*';
	    }
	    if (animate == true){
		wait(25);
		System.out.println(this);
	    }
	    coorlist.add(coor);
	    if (check(r,c)){
		if (maze[r-1][c] == ' '){
		    Coordinates cor1 = new Coordinates(r-1,c);
		    ArrayList<Coordinates> coorlist1 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist1.add(coorlist.get(i));
		    }
		    coorlist1.add(cor1);
		    frontier.addFirst(coorlist1);
		}
		if (maze[r+1][c] == ' '){
		    Coordinates cor2 = new Coordinates(r+1,c);
		    ArrayList<Coordinates> coorlist2 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist2.add(coorlist.get(i));
		    }
		    coorlist2.add(cor2);
		    frontier.addFirst(coorlist2);
		}
		if (maze[r][c-1] == ' '){
		    Coordinates cor3 = new Coordinates(r,c-1);
		    ArrayList<Coordinates> coorlist3 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist3.add(coorlist.get(i));
		    }
		    coorlist3.add(cor3);
		    frontier.addFirst(coorlist3);
		}
		if (maze[r][c+1] == ' '){
		    Coordinates cor4 = new Coordinates(r,c+1);
		    ArrayList<Coordinates> coorlist4 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist4.add(coorlist.get(i));
		    }
		    coorlist4.add(cor4);
		    frontier.addFirst(coorlist4);
		}
		if (maze[r-1][c] == 'E' || maze[r+1][c] == 'E' || maze[r][c-1] == 'E' || maze[r][c+1] == 'E'){
		    save = coorlist;
		    maze = backup;
		    for (int i=0;i<save.size();i++){
			maze[save.get(i).getr()][save.get(i).getc()] = '*';
			System.out.println(this);
		    }
		    return true;
		}
	    }
	}
	return false;
    }

    public int[] solutionCoordinates(){
	ArrayList<Integer> sol1 = new ArrayList<Integer>();
	for (int i=0;i<save.size();i++){
	    if (i%2 == 0){
		sol1.add(save.get(i).getr());
		sol1.add(save.get(i).getc());
	    }
	}
	int[] solution = new int[sol1.size()];
	for (int i=0;i<sol1.size();i++){
	    solution[i] = sol1.get(i);
	}
	return solution;
    }
    
    public int[] findE(){
	int[] ans = new int[2];
	for (int r=0;r<maze.length;r++){
	    for (int c=0;c<maze[r].length;c++){
		if (maze[r][c] == 'E'){
		    ans[0] = r;
		    ans[1] = c;
		    return ans;
		}
	    }
	}
	return ans;
    }

    public int dist(int cor1x, int cor1y, int cor2x, int cor2y){
	return Math.abs(cor1x-cor2x) + Math.abs(cor1y-cor2y);
    }
    
    public boolean solveBest(){
	return solveBest(true);
    }

    public boolean solveBest(boolean animate){
	Coordinates cor = new Coordinates(startx,starty);
	ArrayList add = new ArrayList<Coordinates>();
	add.add(cor);
	int[2] find = findE();
	int init = dist(startx,starty,find[0],find[1]);
	frontier.add(add,init);
     	int r = startx;
	int c = starty;
	while (maze[r][c] != 'E' && frontier.size() > 0){
	    ArrayList<Coordinates> coorlist = frontier.removeFirst();
	    Coordinates coor = coorlist.get(coorlist.size()-1);
	    r = coor.getr();
	    c = coor.getc();
	    if (maze[r][c] != 'S' && maze[r][c] != 'E'){
		maze[r][c] = '*';
	    }
	    if (animate == true){
		wait(25);
		System.out.println(this);
	    }
	    coorlist.add(coor);
	    if (check(r,c)){
		if (maze[r-1][c] == ' '){
		    Coordinates cor1 = new Coordinates(r-1,c);
		    ArrayList<Coordinates> coorlist1 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist1.add(coorlist.get(i));
		    }
		    coorlist1.add(cor1);
		    frontier.addFirst(coorlist1);
		}
		if (maze[r+1][c] == ' '){
		    Coordinates cor2 = new Coordinates(r+1,c);
		    ArrayList<Coordinates> coorlist2 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist2.add(coorlist.get(i));
		    }
		    coorlist2.add(cor2);
		    frontier.addFirst(coorlist2);
		}
		if (maze[r][c-1] == ' '){
		    Coordinates cor3 = new Coordinates(r,c-1);
		    ArrayList<Coordinates> coorlist3 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist3.add(coorlist.get(i));
		    }
		    coorlist3.add(cor3);
		    frontier.addFirst(coorlist3);
		}
		if (maze[r][c+1] == ' '){
		    Coordinates cor4 = new Coordinates(r,c+1);
		    ArrayList<Coordinates> coorlist4 = new ArrayList<Coordinates>();
		    for (int i=0;i<coorlist.size();i++){
			coorlist4.add(coorlist.get(i));
		    }
		    coorlist4.add(cor4);
		    frontier.addFirst(coorlist4);
		}
		if (maze[r-1][c] == 'E' || maze[r+1][c] == 'E' || maze[r][c-1] == 'E' || maze[r][c+1] == 'E'){
		    save = coorlist;
		    maze = backup;
		    for (int i=0;i<save.size();i++){
			maze[save.get(i).getr()][save.get(i).getc()] = '*';
			System.out.println(this);
		    }
		    return true;
		}
	    }
	}
	return false;
    }

    public static void main (String[]args){
	Maze m = new Maze("data2.dat");
	System.out.println(m.solveBFS(true));
	System.out.println(Arrays.toString(m.solutionCoordinates()));
    }
}
