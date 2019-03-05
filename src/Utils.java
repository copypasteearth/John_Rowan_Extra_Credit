/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John Rowan
 */
public class Utils {
    
public static long combination(long n, long k){
    return permutation(n) / (permutation(k) * permutation(n - k));
}

public static long permutation(long i)
{
    if (i == 1 || i == 0)
    {
        return 1;
    }
    return i * permutation(i - 1);
}
public static int manhattan(int a,int b,int c, int d){
    return Math.abs(a-c) + Math.abs(b - d);
}
    
}
