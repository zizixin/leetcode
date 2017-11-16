package JavaPractice.leetcode.houseRob;

public class Solution {
	
	//static int[] houseMoney = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143};
	
	static int[] houseMoney = {7,1,42,3,8,66,71};
	
	//static int[] houseMoney = {1,2};
	
	public int rob(int[] nums) {
		
		if(nums==null){
			return 0;
		}else if(nums.length==0){
			return 0;
		}else if(nums.length==1){
			return nums[0];
		}
		
		
		return search(0, nums);
		
    }
	
	
	public int robOtherOne(int[] num) {
		
	    int[][] dp = new int[num.length + 1][2];
	    
	    for (int i = 1; i <= num.length; i++) {
	    	
	        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
	        
	        dp[i][1] = num[i - 1] + dp[i - 1][0];
	        
	    }
	    return Math.max(dp[num.length][0], dp[num.length][1]);
	}
	
	public int robOtherTwo(int[] num){
		
		 	int yes = 0;
		    int no = 0;
		    for (int n : num) {
		        int temp = no;
		        no =  Math.max(yes,no);
		        yes = n + temp;
		    }
		    return Math.max(yes, no);
		
	}
	
	 public int searchTurbo(int[] nums){
	        
	        int yes = 0;
	        
	        int no = 0;
	        
	        for(int newCome:nums){
	            
	            int temp = no;
	            
	            no = Math.max(yes,no);
	            
	            yes = newCome + temp;
	        }
	        
	        return Math.max(yes,no);
	    }
	
	
	public int search(int i,int[] nums){
		
		if(i>nums.length-1){
			return 0;
		}
		
		return Math.max(search(i+1, nums),nums[i]+search(i+2, nums));//状态转移方程
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().rob(houseMoney));
		
		System.out.println(new Solution().robOtherOne(houseMoney));
		
		System.out.println(new Solution().robOtherTwo(houseMoney));
		
	}
}
