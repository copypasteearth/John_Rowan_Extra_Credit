
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John Rowan
 */
public class John_Rowan_Extra_Credit {
    
    public static void main(String[] args){
        Board[][] board = new Board[8][8];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                board[i][j] = new Board(i,j);
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter row for king 0-7 : ");
        int kingx = scan.nextInt();
        System.out.print("Enter column for king 0-7 : ");
        int kingy = scan.nextInt();
        System.out.print("Enter row for other peice 0-7 : ");
        int otherx = scan.nextInt();
        System.out.print("Enter column for other peice 0-7 : ");
        int othery = scan.nextInt();
        Board king = new Board(kingx,kingy);
        Board other = new Board(otherx,othery);
        System.out.println(king +","+ other);
        board = subArray(king,other,board);
        System.out.println("length: " + board.length +", "+ board[0].length);
        long numOfPaths = Utils.combination(board.length + board[0].length -2, board[0].length-1);
        System.out.println("number of paths : " + numOfPaths);
        int manhattanDistance = Utils.manhattan(king.x, king.y, other.x, other.y);
        System.out.println("distance: " + manhattanDistance);
        ArrayList<ArrayList<Board>> list = new ArrayList<ArrayList<Board>>();
        allPaths(list,king,other,board,numOfPaths,manhattanDistance);
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("list size: " + list.size() + ", numPaths: " + numOfPaths);
        
    }
    /*method to get all the shortest paths and put
    them into an arraylist
    */
    public static void allPaths(ArrayList list,Board king,Board other,Board[][] board,long numPaths,int distance){
        int kingx=0,kingy=0,otherx=0,othery=0;
        boolean up = false,left= false,noside= false,noup= false;
            for(int i = 0;i<board.length;i++){
                for(int j = 0;j < board[i].length;j++){
                    if(board[i][j].equals(king)){
                        kingx = i;
                        kingy = j;
                    }
                    if(board[i][j].equals(other)){
                        otherx = i;
                        othery = j;
                    }
                }
            }
            if(otherx < kingx){
                
                up = true;
            }else if(otherx > kingx){
                 up = false;
            }else{
                noup = true;
            }
            if(othery < kingy){
                left = true;
            }else if(othery > kingy){
                left = false;
               
            }else{
                noside = true;
                
            }
        while(list.size() != numPaths){
            
            ArrayList<Board> listi = new ArrayList<Board>();
            if(noup && noside){
                listi.add(king);
                list.add(listi);
                return;
            }else if(noup){
                
                int move = 1;
                while(listi.size() != distance){
                    System.out.println("while : " +listi.size());
                if(left){
                    
                    listi.add(board[kingx][kingy -move]);
                }else{
                    listi.add(board[kingx][kingy +move]);
                }
                move++;
                }
                
                list.add(listi);
                return;
            }else if(noside){
                int move = 1;
                while(listi.size() != distance){
                    System.out.println("while : " +listi.size());
                if(up){
                    
                    listi.add(board[kingx -move][kingy]);
                }else{
                    listi.add(board[kingx+move][kingy ]);
                }
                move++;
                }
                
                list.add(listi);
                return;
            }else{
                Random rand = new Random();
                int moveU = kingx;
                    int moveL = kingy;
                while(listi.size() != distance){
                    
                    if(rand.nextBoolean()){
                         
                        if(up){
                            moveU--;
                            if(moveU >= otherx)
                            listi.add(board[moveU][moveL]);
                            else
                                moveU++;
                         }else{
                            moveU++;
                            if(kingx + moveU <= otherx)
                            listi.add(board[moveU][moveL]);
                            else
                                moveU--;
                        }
                       
                    }else{
                         
                        if(left){
                            moveL--;
                            
                               if(moveL >= othery)
                             listi.add(board[moveU][moveL]);
                               else
                                   moveL++;
                        }else{
                            moveL++;
                            if(moveL <= othery)
                            listi.add(board[moveU][moveL]);
                            else
                                moveL--;
                          }
                       
                    }
                    if(listi.size() == distance && !listi.get(listi.size()-1).equals(other)){
                        //System.out.println("detected garbage" + listi);
                        listi = new ArrayList<Board>();
                        moveU = kingx;
                        moveL = kingy;
                    }else{
                        
                    }
                }
                //System.out.println("list sized up");
                if(!list.contains(listi))
                list.add(listi);
            }
        }
    }
    /*
    method to get a sub array of the original array with
    king and other chess piece at opposite corners
    used for calculating the number of paths
    */
    public static Board[][] subArray(Board king,Board other,Board[][] board){
        Board[][] a = new Board[Math.abs(king.x - other.x)+ 1][];
        int x;
        int counter = 0;
        if(king.x < other.x){
            x = king.x;
        }else{
            x = other.x;
        }
    for (int i = 0 + x; i < Math.abs(king.x - other.x)+1 + x; i++) {
        if(king.y < other.y)
        a[counter] = Arrays.copyOfRange(board[i], king.y, other.y + 1);
        else
          a[counter] = Arrays.copyOfRange(board[i], other.y, king.y + 1); 
        counter++;
    }
    System.out.println(Arrays.deepToString(a));
    return a;
    }
    
}
