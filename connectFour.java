package connectFour;

import java.util.Scanner;

public class connectFour {
	private static boolean isGameOver(int [][] board) {
		int p1 = 0;
		int p2 = 0;
		
		//horizantals/verticals
		for (int a=0;a<7;a++) {
			for (int b=0;b<7;b++) {
				if (board[a][b] == 1) {
					p1 ++;
					p2 = 0;
					if (p1 >= 4 || p2 >= 4) {
						printBoard(board);
						System.out.println("GAME OVER! CONNECT FOUR!");
						return true;
					}
				}
				else if(board[a][b] == 2) {
					p2 ++;
					p1 = 0;
					if (p1 >= 4 || p2 >= 4) {
						printBoard(board);
						System.out.println("GAME OVER! CONNECT FOUR!");
						return true;
					}
				}
				
				else {
					p1 = 0;
					p2 = 0;
				}
			}
			p1 = 0;
			p2 = 0;
			for (int b=0;b<7;b++) {
				if (board[b][a] == 1) {
					p1 ++;
					p2 = 0;
					if (p1 >= 4 || p2 >= 4) {
						printBoard(board);
						System.out.println("GAME OVER! CONNECT FOUR!");
						return true;
					}
				}
				else if(board[b][a] == 2) {
					p2 ++;
					p1 = 0;
					if (p1 >= 4 || p2 >= 4) {
						printBoard(board);
						System.out.println("GAME OVER! CONNECT FOUR!");
						return true;
					}
				}
				else {
					p1 = 0;
					p2 = 0;
				}
			}
			
		}
		for(int y=0; y<7;y++) {
			int x = 0;
			p1 = 0;
			p2 = 0;
			while (x < 7 && (y+x) < 7) {
				if (board[y+x][x]==2) {
					p1=0;
					p2++;
					if (p1 >= 4 || p2 >= 4) {
						printBoard(board);
						System.out.println("GAME OVER! CONNECT FOUR!");
						return true;
					}
				}
				else if(board[y+x][x] == 1) {
					p1 ++;
					p2=0;
					if (p1 >= 4 || p2 >= 4) {
						printBoard(board);
						System.out.println("GAME OVER! CONNECT FOUR!");
						return true;
					}
				}
				else {
					p1 = 0;
					p2 = 0;
					}				
				x++;
			}
		}
		
		for(int y=0; y<7;y++) {
			int x = 0;
			p1 = 0;
			p2 = 0;
			while (x < 7 && (y-x) >= 0) {
				if (board[y-x][x]==2) {
					p1=0;
					p2++;
					if (p1 >= 4 || p2 >= 4) {
						printBoard(board);
						System.out.println("GAME OVER! CONNECT FOUR!");
						return true;
					}
				}
				else if(board[y-x][x] == 1) {
					p1 ++;
					p2=0;
					if (p1 >= 4 || p2 >= 4) {
						printBoard(board);
						System.out.println("GAME OVER! CONNECT FOUR!");
						return true;
					}
				}
				else {
					p1 = 0;
					p2 = 0;
				}				
				x++;
			}
		}
		return false;
}
	
	private static void printBoard(int[][] board) {
		for (int y=0;y<7;y++) {
			String lineBuffer = "";
			for(int x=0; x<7; x++) {
				lineBuffer += "[ ";
				if (board[y][x] == 0) {
					lineBuffer += " ";
				}
				else if(board[y][x] == 1) {
					lineBuffer += "X";
				}
				else if (board[y][x] == 2) {
					lineBuffer += "O";
				}
				lineBuffer += " ]";
			}
			System.out.println(lineBuffer);
		}
	}
	public static void main(String[] args) {
		int currentPlayer = 1;
		int[][] board = new int[7][7];
		Scanner object = new Scanner(System.in);
		while (!isGameOver(board)) {
			printBoard(board);
			System.out.println("Player " + currentPlayer + "'s Turn: ");
		    int userInput = object.nextInt();
		    if (currentPlayer == 1) {
		    	for (int i = 6; i>=0; i--) {
		    		if (board[i][userInput] == 0) {
		    			board[i][userInput] = 1;
		    			isGameOver(board);
		    			currentPlayer = 2;
		    			break;
		    		}
		    	}
		    }
		    else if (currentPlayer == 2) {
		    	for (int j = 6; j>=0; j--) {
		    		if (board[j][userInput] == 0) {
		    			board[j][userInput] = 2;
		    			isGameOver(board);
		    			currentPlayer = 1;
		    			break;
		    }
		}
	}
}
}
}

