import java.util.*;
import java.io.*;
public class Practice {
    public static void main(String args[])throws IOException {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int m=sc.nextInt();
      int maze[][]=new int[n][m];
      for(int roe=0;roe<n;roe++)
      {
        for(int col=0;col<m;col++)
        {
          maze[roe][col]=sc.nextInt();
        }
      }
      int max=Integer.MIN_VALUE;

     for(int roe=0;roe<n;roe++)
      {
        for(int col=0;col<m;col++)
        {
          if(maze[roe][col]==0)
          {
        	  maze[roe][col]=1;
        	  int t[][]=new int[n][m];
        	  
        	printmaze(t,maze,n,m);
        
        	  
        	 int temp=maxpond(t,n,m,roe,col);
        	  maze[roe][col]=0;
        	  
       
        	  max=(max>temp)? max:temp;
        	 
          }
        }
      }
      System.out.print(max);

    }
    static void printmaze(int t[][],int maze[][],int n,int m) {
    	for(int roe=0;roe<n;roe++)
        {
          for(int col=0;col<m;col++)
          {
        	  t[roe][col]=maze[roe][col];
          }
          
          
        }
    }
    static boolean isSafe(int maze[][],int n,int m,int row,int col)
    {
    	if(row>=0 && col>=0)
    	{
    	if(row<n && col<m && maze[row][col]==1)
    		return true;
    	}
    	return false;
    }
    static int ans;
    static int maxpond(int t[][],int n,int m,int row,int col)
    {
    
    	if(isSafe(t,n,m,row,col))
    	{
    		t[row][col]=0;
    	
    	
    	ans=1+maxpond(t,n,m,row,col+1)
    	+maxpond(t,n,m,row+1,col)
    	+maxpond(t,n,m,row,col-1)
    	+maxpond(t,n,m,row-1,col);
    	
    	return ans;
    	}
    	return 0;
    }
}
