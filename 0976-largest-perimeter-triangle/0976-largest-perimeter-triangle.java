class Solution {
    public int largestPerimeter(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < nums.length - 1 - i; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        // check largest possbl triangle;
        for(int i = nums.length - 1; i >= 2; i--){
            if(nums[i - 2] + nums[i - 1] > nums[i]){
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}