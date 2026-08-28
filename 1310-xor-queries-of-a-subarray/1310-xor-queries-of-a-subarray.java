class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i - 1] ^ arr[i];
        }
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int L = queries[i][0];
            int R = queries[i][1];

            if(L == 0){
                answer[i] = prefix[R];
            }
            else{
                answer[i] = prefix[R] ^ prefix[L - 1];
            }
        }
        return answer;
    }
}