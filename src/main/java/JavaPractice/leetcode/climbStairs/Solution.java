package JavaPractice.leetcode.climbStairs;

public class Solution {

	
	public int climbStairs(int n) {
    

		if(n==2){
			
			return 2;
		}
		else if(n==1){
			return 1;
		}else if(n==0){
			return 0;
		}
		else{
			return (climbStairs(n-1)+climbStairs(n-2));
		}
		
		
    }
	
	public int climbStairsTurbo(int n){
		
		if(n==2){
			
			return 2;
		}
		else if(n==1){
			return 1;
		}else if(n==0){
			return 0;
		}
		
		int two = 2;
		
		int one = 1;
		
		int sum;
		
		for(int i=2;i<n;i++){
			
			sum = two + one;
			
			one = two;
			
			two = sum;
			
		}
		return sum;
		
	}
	
	public static void main(String[] args) {
		
		for(int i=0;i<20;i++){
			System.out.print(new Solution().climbStairs(i)+" ");
		}
		
		
		
	}
	
}
