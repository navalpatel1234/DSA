class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        const int MOD = 1e9 + 7;
        int n = arr.size();
        
        vector<int> left(n), right(n);
        stack<int> st;
        
        // Step 1: Previous Less Element (PLE)
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.top()] > arr[i]) {
                st.pop();
            }
            left[i] = st.empty() ? i + 1 : i - st.top();
            st.push(i);
        }
        
        // Clear stack for next use
        while (!st.empty()) st.pop();
        
        // Step 2: Next Less Element (NLE)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.top()] >= arr[i]) {
                st.pop();
            }
            right[i] = st.empty() ? n - i : st.top() - i;
            st.push(i);
        }
        
        // Step 3: Contribution
        long long result = 0;
        for (int i = 0; i < n; i++) {
            long long contrib = (long long)arr[i] * left[i] * right[i];
            result = (result + contrib) % MOD;
        }
        
        return (int)result;
    }
};
