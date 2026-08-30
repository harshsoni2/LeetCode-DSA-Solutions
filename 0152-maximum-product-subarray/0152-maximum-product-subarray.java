class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = currentMax;
            currentMax = Math.max(num,
                    Math.max(tempMax * num, currentMin * num));

            currentMin = Math.min(num,
                    Math.min(tempMax * num, currentMin * num));

            maxProduct = Math.max(maxProduct, currentMax);
        }
        return maxProduct;
    }
}