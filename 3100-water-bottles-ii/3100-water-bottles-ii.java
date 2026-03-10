class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            empty -= numExchange; // exchange empty bottles
            numExchange++; // exchange requirement increases
            total++;  // drink the new bottle
            empty++;  // empty bottle after drinking
        }

        return total;
    }
}