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


    
}