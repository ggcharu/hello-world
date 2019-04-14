//CodeChef April Challenge

/*
Shlok and Sachin are good friends. Shlok wanted to test Sachin, so he wrote down a string S with length N and one character X. 
He wants Sachin to find the number of different substrings of S which contain the character X at least once. 
Sachin is busy with his girlfriend, so he needs you to find the answer.

Two substrings of S are considered different if their positions in S are different.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N.
The second line contains a string S with length N, followed by a space and a character X.
Output
For each test case, print a single line containing one integer — the number of substrings of S that contain X.

Constraints
1≤T≤1,000
1≤N≤106
S contains only lowercase English letters
X is a lowercase English letter
the sum of N over all test cases does not exceed 106
Subtasks
Subtask #1 (30 points): the sum of N over all test cases does not exceed 103
Subtask #2 (70 points): original constraints

Example Input
2
3
abb b
6
abcabc c
*/



//Hint count 
//no of characters ahead of given character(including itself)=t + no of characters behind*t 


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	static ArrayList<Integer> pos;
	static Scanner sc=new Scanner(System.in);
	public static void main(String args[])
	{
		try {
		int t=sc.nextInt();
		long ans[]=new long[t];
		int index=0;
		while(t-->0)
		{
			int n=sc.nextInt();
			pos=new ArrayList<>(n);
			String s=sc.next();
			char b=sc.next().charAt(0);
			long count=0;
			for(int i=0;i<n;i++)
			{
				if(s.charAt(i)==b)
					pos.add(i);
			}
			count=substr(n);
			
			ans[index]=count;
			index+=1;
		}
		
		for(long i:ans)
			System.out.println(i);
	}
	catch(Exception e) {
		return;
	}
		
	}
	public static long substr(int n) {
		long count=0;
		int l=pos.size();
		for(int i=0;i<l;i++)
		{
			if(i==0) {
				int t=pos.get(i);
				count+=n-t+t*(n-t);
			}
			else {
				int t=pos.get(i);
				count+=n-t+(t-pos.get(i-1)-1)*(n-t);
			}
		}
		return count;
	}
}
