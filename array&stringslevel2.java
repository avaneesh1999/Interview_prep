public class Solution {

    //Linctcode 912
    //https://www.lintcode.com/problem/912/
    
    public int minTotalDistance(int[][] grid) {
        //make xcord
        ArrayList<Integer> xcord=new ArrayList<>();

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    xcord.add(r);
                }
            }
        }

        //make ycord
         ArrayList<Integer> ycord=new ArrayList<>();

         for(int c=0;c<grid[0].length;c++){
            for(int r=0;r<grid.length;r++){
                if(grid[r][c]==1){
                    ycord.add(c);
                }
            }
        }

        //meeting point

        int x=xcord.get(xcord.size()/2);
        int y=ycord.get(ycord.size()/2);

        // calculate distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

        int dist=0;

        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    dist+=Math.abs((x-r)) +Math.abs((y-c));
                }
            }
        }

        return dist;



     }

     //leetcode 26. Remove Duplicates from Sorted Array
     //https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/


     public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    //leetcode 925 Long Pressed Name
    //https://leetcode.com/problems/long-pressed-name/
    public boolean isLongPressedName(String name, String typed) {

        if(name.length()>typed.length()){
            return false;
        }

        int i=0 ;//name
        int j=0 ;//typed

        while(i<name.length() && j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;

            }else if( 0<= i-1 && name.charAt(i-1)==typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }

        while(j<typed.length()){
            if(name.charAt(i-1)!=typed.charAt(j)){
                return false;
            }
            j++;
        }

        return i<name.length()?false:true;
        
    }

    //Leetcode 11. Container With Most Water
    //https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int ans=0;

        while(i<j){
            int length=Math.min(height[j],height[i]);
            int breadth=(j-i);

            int area=length*breadth;

            if(area>ans){
                ans=area;
            }

            if(height[j]<height[i]){
                j--;
            }else{
                i++;
            }



        }

        return ans;
        
    }

    //977. Squares of a Sorted Array
    //https://leetcode.com/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums) {

        int i=0;
        int j=nums.length-1;

        int[] ans =new int[nums.length];

        for(int k=ans.length-1;k>=0;k--){
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                ans[k]=nums[i]*nums[i];
                i++;
             
            }else {
                ans[k]=nums[j]*nums[j];
                j--;
                
            }
        }

        return  ans;
        
    }

    //leetcode169. Majority Element
    //https://leetcode.com/problems/majority-element/description/

    //USIG HASHMAP
    public int majorityElement(int[] nums) {
        //insert array elements into HashMap
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(h.containsKey(nums[i])){
                h.put(nums[i],h.get(nums[i])+1);
            }else{
                h.put(nums[i],1);
            }
        }

        for (Map.Entry<Integer, Integer> it : h.entrySet()) {
            if (it.getValue() > (nums.length / 2)) {
                return it.getKey();
            }
        }

        return -1;

        

        
        
    }

    //USING MOORE VOTING ALGO
    public int majorityElement(int[] nums) {
        
        int val=nums[0];
        int count=1;

        // check valid candidate

        for(int i=1;i<nums.length;i++){
            if(nums[i]==val){
                count++;
            }else{
                if(count>0){
                    count--;
                    

                }else{
                    val=nums[i];
                    count=1;
                    
                }
            }
        }

        // count of valid candidate;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                ans++;
            }
        }
        //check majority element
        if(ans>nums.length/2){
            return val;
        }

        return -1;

        
    }
    //229. Majority Element II
    //https://leetcode.com/problems/majority-element-ii/description/

    public boolean checkmajority(int n,int[]nums){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==n){
                count++;
            }
        }
        if(count>nums.length/3){
            return true;
        }
        return false;
    }

    public List<Integer> majorityElement(int[] nums) {
        
        //intialize 
        List<Integer> ans =new ArrayList<>();
    

        int val1=nums[0];
        int count1=1;

        int val2=nums[0];
        int count2=0; // make sure you make count 2 =0

        //mapping of triplets

        int i=1;
        while(i<nums.length){
            if(nums[i]==val1){
                count1++;
            }else if(nums[i]==val2){
                count2++;
            }else{
                if(count1==0){
                    val1=nums[i];
                    count1++;
                }else if(count2==0){
                    val2=nums[i];
                    count2++;
                }else{
                    count1--;
                    count2--;
                }
            }
            i++;
        }

        //check if they appears more than n/3 in array.

        if(checkmajority(val1,nums)){
            ans.add(val1);
        }
        if(val1==val2) return ans;

        if(checkmajority(val2,nums)){
            ans.add(val2);
        }

        return ans;



        
    }

    //628. Maximum Product of Three Numbers
    //https://leetcode.com/problems/maximum-product-of-three-numbers/description/
    public int maximumProduct(int[] nums) {
        //intialize three max and two min
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;

        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            // check for max
            if(max1<nums[i]){
                max3=max2;
                max2=max1;
                max1=nums[i];
            }else if(max2<nums[i]){
                max3=max2;
                max2=nums[i];
            }else if(max3<nums[i]){
                max3=nums[i];
            }

            //check for min
            if(min1>nums[i]){
                min2=min1;
                min1=nums[i];
            }else if(min2 >nums[i]){
                min2=nums[i];
            }
        }

        return Math.max(max1*max2*max3,min1*min2*max1);


        
    }
    //Leetcode 747. Largest Number At Least Twice of Others
    //https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/

    public int dominantIndex(int[] nums) {
        // make max1 and max2 
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int ans=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>max1){
                max2=max1;
                max1=nums[i];
                ans=i;
            }else if(nums[i]>max2){
                max2=nums[i];
            }
        }
        // check largest element in the array is at least twice as much as every other number in the array
        if(max1>=max2*2){
            return ans;
        }

        return -1;
        
    }

    //Leetcode 769. Max Chunks To Make Sorted
    //https://leetcode.com/problems/max-chunks-to-make-sorted/description/
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            //we will use chaining technique 
            //initialize chunk and maximpact of arr[i]
    
            int chunk=0;
            int maximpact=-1;
    
            for(int i=0;i<arr.length;i++){
                int val=arr[i];
                //check max impact of that val on array
                maximpact=Math.max(maximpact,val);
                if(maximpact==i){
                    chunk++;
                }
            }
    
            return chunk;
            
        }
    }


    
}