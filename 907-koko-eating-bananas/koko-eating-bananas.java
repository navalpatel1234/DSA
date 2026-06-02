class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile); // max pile size
        }
        
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                result = mid;      // possible answer
                right = mid - 1;   // try smaller speed
            } else {
                left = mid + 1;    // need faster speed
            }
        }
        
        return result;
    }
    
    private boolean canEatAll(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil(pile/k)
        }
        return hours <= h;
    }
}
