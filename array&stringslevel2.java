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


    
}