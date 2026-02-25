class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse from the last digit backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; 
                return digits; // No carry needed, return immediately
            }
            digits[i] = 0; // Set current digit to 0 and continue loop for carry
        }
        
        // If all digits were 9, we need an extra digit at the front
        int[] result = new int[n + 1];
        result[0] = 1; // e.g., 999 + 1 = 1000
        return result;
    }
}
