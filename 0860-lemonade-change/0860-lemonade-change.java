class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;  // count of $5 bills in hand
        int ten = 0;   // count of $10 bills in hand
                       // $20 bills never useful for change, no need to track

        for (int bill : bills) {

            if (bill == 5) {
                // No change needed, just collect
                five++;

            } else if (bill == 10) {
                // Need to give $5 change
                if (five == 0) return false;
                five--;
                ten++;

            } else { // bill == 20
                // Need to give $15 change
                // Greedy: prefer $10 + $5 over three $5s
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false; // can't make change
                }
            }
        }

        return true; // all customers served
    }
}