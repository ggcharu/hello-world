import java.io.*;
import java.util.*;

public class TreeMAp { 

	public static void main(String ars[])throws IOException {
		
		HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

			map.putIfAbsent(1, new ArrayList<Integer>());
			ArrayList<Integer> t=map.get(1);
			t.add(2);
			t.add(3);
			t.add(4);
			
			map.put(2,new ArrayList<Integer>());
			t=map.get(2);
			t.add(1);
			t.add(3);
			t.add(4);
			t.add(5);
			
			map.put(3,new ArrayList<Integer>());
			t=map.get(3);
			t.add(1);
			t.add(2);
			t.add(4);
			
			map.put(4,new ArrayList<Integer>());
			t=map.get(4);
			t.add(1);
			t.add(2);
			t.add(3);
			t.add(5);
			
			map.put(5,new ArrayList<Integer>());
			t=map.get(5);
			t.add(2);
			t.add(4);
			int colorassigned[]= {1,0,0,0,0};
			boolean t1=color(map,5,2,colorassigned);
	
			
	
	}
		static boolean isSafe(HashMap<Integer,ArrayList<Integer>> map,int color,int element,int[] colorassigned)
		{
    //get all the connections to the given element 
			ArrayList<Integer> t=map.get(element);
			for(Integer i:t)
			{
      //check if the assigned color is not already assigned to nearst neighbour
				if(colorassigned[(int)i-1]==color)
				return false;
			}
			return true;
		}
		public static boolean color(HashMap<Integer,ArrayList<Integer>> map,int n,int element,int colorassigned[])
		{
      //Print the color array when all elements have been assigned their colors
			if(element>n)
			{
				for(int i:colorassigned)
					System.out.print(i+" ");
				return true;
			}
			
      //generate all possible colors
			for(int i=1;true;i++)
			{
      //check if assigning color i to element is safe
				if(isSafe( map,i,element,colorassigned))
				{
					colorassigned[element-1]=i;
          //assign color to next element
					boolean nextcolor=color(map,n,element+1,colorassigned);
          
          //return statement to prevent infinte loop
					if(nextcolor)
						return true;
				}
			}
			
			//return false;
		}

		

}
