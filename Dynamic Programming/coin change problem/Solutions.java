import java.util.*;
class Solution
{
    public static void main(String args[]   )
    {
        int coins[]={1,2,5}; // can take your input
        int amount=11;  // take your input
        Solution obj = new Solution();
        System.out.print(obj.coinChange(coins,amount)); 
    }
   public int coinChange(int[] coins, int amount) {
        if(amount <1)return 0;
        int dp[]=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            dp[i]=Integer.MAX_VALUE;

            for(int c:coins)
            {
                if(c<=i && dp[i-c]!=Integer.MAX_VALUE)
                dp[i]=Math.min(dp[i],1+dp[i-c]);
            }
        }
        if(dp[amount]==Integer.MAX_VALUE)
        return -1;
        return dp[amount];
    }

}