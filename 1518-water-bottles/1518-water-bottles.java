class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        int empty = 0;

        while (numBottles > 0) {
            total += numBottles;  // drink full bottle
            empty += numBottles; // collect empty bottle
            
            numBottles = empty / numExchange; // exchange empty
            empty = empty % numExchange; // remaining empty
        }

        return total;
    }
}