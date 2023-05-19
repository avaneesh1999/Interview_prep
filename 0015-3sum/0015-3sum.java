class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = 0 - nums[i];
            List<List<Integer>> subans = twosum(nums, i + 1, nums.length - 1, target);

            for (List<Integer> list : subans) {
                list.add(nums[i]);
                ans.add(list);
            }
        }

        return ans;
    }

    public List<List<Integer>> twosum(int[] nums, int i, int j, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum == target) {
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                ans.add(l);

                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }
                i++;
                j--;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }
}
