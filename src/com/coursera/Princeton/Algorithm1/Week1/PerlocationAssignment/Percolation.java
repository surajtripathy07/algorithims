import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.QuickFindUF;
import java.util.*;
/**
 * 
 * Implementation of Percolation API
 * @author Suraj Tripathi
 */
public class Percolation {

    private int[][] grid;
    private int virtualStart;
    private int virtualEnd;
    private int gridSize;
    private QuickFindUF set;
    private int numOfOpenSites;
    
    // create n-by-n grid, with all sites blocked
    public Percolation(int n){
        if (n <= 0) throw new java.lang.IllegalArgumentException();
        
        this.grid = new int[n][n];
        this.virtualStart = 0;
        this.virtualEnd = getGridNum(n, n, gridSize) + 1;
        this.gridSize = n;
        this.set = new QuickFindUF(virtualEnd + 1);
    }
    
    // open site (row, col) if it is not open already
    public void open(int row, int col){
        if (row < 1 || col < 1 || row > gridSize || col > gridSize) throw new java.lang.IndexOutOfBoundsException();
        
        if (isOpen(row, col)) return;
        row = row - 1;
        col = col - 1;
        
        numOfOpenSites++;
        grid[row][col] = 1;
        int gridNum = getGridNum(row, col, gridSize);
        ArrayList<Integer> neighbours = getSurroundingGrid(row, col, gridSize);
        
        for(Integer neighbour : neighbours){
            set.union(gridNum, neighbour);
        }
    }
    
    // is site (row, col) open?
    public boolean isOpen(int row, int col){
        if (row < 1 || col < 1 || row > gridSize || col > gridSize) throw new java.lang.IndexOutOfBoundsException();
        
        return grid[row - 1][col - 1] == 1;
    }
    
    // is site (row, col) full?
    public boolean isFull(int row, int col){
        if (row < 1 || col < 1 || row > gridSize || col > gridSize) throw new java.lang.IndexOutOfBoundsException();
        
        row = row - 1;
        col = col - 1;
        int gridNum = getGridNum(row, col, gridSize);
        return isOpen(row + 1, col + 1) && set.connected(virtualStart, gridNum) && set.connected(virtualEnd, gridNum);
    }
    
    // number of open sites
    public int numberOfOpenSites(){
        return numOfOpenSites;
    }
    
    // does the system percolate?
    public boolean percolates(){
        return set.connected(virtualStart, virtualEnd);
    }
    
    public static void main(String[] args){
        Percolation p = new Percolation(2);
        p.open(1,1);
        p.open(2,2);
        System.out.println(p.isFull(2,2));
        System.out.println(p.numberOfOpenSites());
        System.out.println(p.percolates());
        p.open(1,2);
        
        System.out.println(p.isFull(2,2));
        System.out.println(p.numberOfOpenSites());
        System.out.println(p.percolates());
    }
    
    private int getGridNum(int row, int col, int size){
        return (row * size) + col + 1;
    }
    
    private ArrayList<Integer> getSurroundingGrid(int row, int col, int gridSize){
        int gridNum = getGridNum(row, col, gridSize);
        ArrayList<Integer> neighbour = new ArrayList<Integer>();
        // If it is first row, add virtualStart as neighbour
        if (gridNum <= gridSize){
            neighbour.add(virtualStart);
        } else {
            if (isOpen(row, col + 1)){
                neighbour.add(gridNum - gridSize);
            }
        }
        
        // if it is last row, add virtualEnd as neighbour
        int lastRow = getGridNum(gridSize - 1, gridSize - 1, gridSize) - gridSize;
        if (lastRow < gridNum){
            neighbour.add(virtualEnd);
        } else {
            if (isOpen(row + 2, col + 1)){
                neighbour.add(gridNum + gridSize);
            }
        }
        
        //check left
        if (col > 0 && isOpen(row + 1, col)){
            neighbour.add(gridNum - 1);
        }
        // check right
        if (col < gridSize - 2 && isOpen(row + 1, col + 2)){
            neighbour.add(gridNum + 1);
        }
       return neighbour;         
    }
}