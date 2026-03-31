class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        int cash = 0;  //not holding stock
        int hold = -arr[0];  //holding stock
        for (int i = 1; i < n; i++) {
            int price = arr[i];
            cash = Math.max(cash, hold + price - k); //sell
            hold = Math.max(hold, cash - price);  //buy
        }
        return cash;
    }
}
