class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int windowSum = 0;
        // first window
        for(int i=0; i<k; i++){
            windowSum += arr[i];
        }
        // sliding window
        for(int i=k; i<arr.length; i++){
            if(windowSum >= k * threshold){
                count++;
            }
            windowSum = windowSum - arr[i - k] + arr[i];
        }
        // check the last window
        if(windowSum >= k * threshold){
            count++;
        }
        return count;
    }
}