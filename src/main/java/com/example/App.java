package com.example;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   
        int [] nums = {3,4,5,2};
        int target = 6;

    int [] result  = twosum(nums,target);

    System.out.println("Result==>>"+ Arrays.toString(result));

    }

    public static int[] twosum(int[] nums, int targets){
     
         int [][] arr =new int [nums.length][2];

        for(int i=0;i<nums.length;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            
            int current = arr[left][0] + arr[right][0];
         
            if(current == targets){
                return new int[]{arr[left][1],arr[right][1]};
            }
            else if(current > targets){
                right--;
            }else{
                left++;
            }   

        }
         return  new int[]{-1,-1};
    }

      //  int [][] arr = []
        //System.out.println( "Hello World!"+ Arrays.toString(arr) );
    
}
