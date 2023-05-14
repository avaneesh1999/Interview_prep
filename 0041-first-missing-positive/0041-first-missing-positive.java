class Solution {
    public int firstMissingPositive(int[] nums) {

        // mark 1 and also check presence of 1

    
        int n=nums.length;
        boolean one=false;

        for(int i=0;i<n;i++){
            if(nums[i] ==1){
               one=true;
            }  

            if(nums[i]<1 || nums[i]>n){
                nums[i]=1;
            }
        }

        if(one==false) return 1;

        //make index -ve value

        for(int i=0;i<n;i++){
            int val=Math.abs(nums[i]);
            nums[val-1]=-Math.abs(nums[val-1]);
        }

        //travel and check absent no

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }

        return n+1;



        
    }
}