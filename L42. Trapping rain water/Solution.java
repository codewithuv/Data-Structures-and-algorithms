import java.util.*;
class Solution
{
    public int trap(int[] height) {
        int n=height.length;
        int left[]=new int[n];
        int right[]=new int[n];
       
        //for left limit
        left[0]=height[0];
        for(int i=1;i<n;i++)
        {
            left[i]=(int)Math.max(left[i-1],height[i]);
        }
        int max=0;
        for(int i=n-1;i>=0;i--)
        {
            max=(int)Math.max(max,height[i]);
            right[i]=max;
        }

        int waterlevel=0;
        for(int i=0;i<n;i++)
        {
            int min=Math.min(left[i],right[i]);
            waterlevel+=min-height[i];
        }

        return waterlevel;



    }
    public static void main(String args[])
    {
        Solution ob=new Solution();
        int arr[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(ob.trap(arr));
    }
}