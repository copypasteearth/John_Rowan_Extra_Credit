/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John Rowan
 */
public class Board {
    public int x;
    public int y;
    public Board(int x,int y){
        this.x = x;
        this.y = y;
    }
    public boolean equals(Board other){
        if(other.x == this.x && other.y == this.y)
            return true;
        return false;
    }
    public String toString(){
        return "("+ this.x + "," + this.y + ")";
    }
    
}
