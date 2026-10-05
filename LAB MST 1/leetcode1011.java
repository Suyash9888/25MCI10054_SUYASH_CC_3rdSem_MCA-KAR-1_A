class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low < high) {

            int capacity = low + (high - low) / 2;

            if (canShip(weights, days, capacity)) {
                high = capacity;
            } else {
                low = capacity + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights, int days, int capacity) {

        int daysUsed = 1;
        int currentWeight = 0;

        for (int weight : weights) {

            if (currentWeight + weight > capacity) {
                daysUsed++;
                currentWeight = weight;

                if (daysUsed > days) {
                    return false;
                }
            } else {
                currentWeight += weight;
            }
        }

        return true;
    }
}