public class NQueens{
    public int counter;
    public char[][] board;

    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    public String name(){
	return "ng.jason";
    }

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	for(int i=0;i<board.length*board.length;i++){
	    if (i%board.length == 0 && i!=0){
		ans+="\n";
	    }
	    ans += board[i%board.length][i/board.length];
	    ans += "\t";
	}
	return clear + hide + go(0,0) + ans + "\n" + show;
    }


    public NQueens(int size){
	board = new char[size][size];
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		board[i][j] = '_';
	    }
	}
	counter = size;
    }

    public boolean solve(){
	return solve(0,0);
    }
    
    public boolean solve(int x,int y){
	return solve(x,y,0);
    }

    public boolean solve(int x,int y,int count){
	if (x < board.length && x >= 0 && y < board.length && y >= 0){
	    if (count == counter && board[y][x] == '_'){
		board[y][x] = 'Q';
		return true;
	    }
	    if (board[y][x] == '_'){
		board[y][x] = 'Q';
		if ((solve(x+2,y+1,count+1) && check(x+2,y+1)) || 
		    (solve(x+2,y-1,count+1) && check(x+2,y-1)) || 
		    (solve(x+1,y+2,count+1) && check(x+1,y+2)) ||
		    (solve(x+1,y-2,count+1) && check(x+1,y-2)) ||
		    (solve(x-2,y+1,count+1) && check(x-2,y+1)) ||
		    (solve(x-2,y-1,count+1) && check(x-2,y-1)) ||
		    (solve(x-1,y+2,count+1) && check(x-1,y+2)) ||
		    (solve(x-1,y-2,count+1) && check(x-1,y-2))){
		    return true;
		}
		board[y][x] = '_';
	    }
	}
	return false;
    }
    
    public boolean check(int x, int y){
	int checkcount = 0;
	for (int i=0;i<board.length;i++){
	    if (checkcount > 1){
		return false;
	    }
	    if (board[y][i] == 'Q'){
		checkcount ++;
	    }
	}
	checkcount = 0;
	for (int j=0;j<board.length;j++){
	    if (checkcount > 1){
		return false;
	    }
	    if (board[j][x] == 'Q'){
		return false;
	    }
	}
	checkcount = 0;
	for (int d1=0;d1<board.length;d1++){
	    if (x+d1 < board.length && y+d1 < board.length){
		if (board[y+d1][x+d1] == 'Q'){
		    checkcount++;
		}
	    }
	    if (checkcount > 1){
		return false;
	    }
	}
	checkcount = 0;
	for (int d1=0;d1<board.length;d1++){
	    if (x-d1 > 0 && y+d1 < board.length){
		if (board[y+d1][x-d1] == 'Q'){
		    checkcount++;
		}
	    }
	    if (checkcount > 1){
		return false;
	    }
	}
	checkcount = 0;
	for (int d1=0;d1<board.length;d1++){
	    if (x+d1 < board.length && y-d1 > 0){
		if (board[y-d1][x+d1] == 'Q'){
		    checkcount++;
		}
	    }
	    if (checkcount > 1){
		return false;
	    }
	}
	checkcount = 0;
	for (int d1=0;d1<board.length;d1++){
	    if (x-d1 > 0 && y-d1 > 0){
		if (board[y-d1][x-d1] == 'Q'){
		    checkcount++;
		}
	    }
	    if (checkcount > 1){
		return false;
	    }
	}   
	return true;
    }

    public static void main (String[]args){
	NQueens test = new NQueens(Integer.parseInt(args[0]));
	System.out.println(test);
	if (test.solve(0,1)){
	    System.out.println(test);
	}else{
	    System.out.println("No solution");
	}
    }
}
