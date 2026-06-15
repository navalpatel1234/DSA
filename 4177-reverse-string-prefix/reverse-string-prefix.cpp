class Solution {
public:
    string reversePrefix(string s, int k) {
       int l = 0;
       int h = k-1;

       while(l<h){
        swap(s[l],s[h]);
        l++;
        h--;
       }
       return s;
    }
};