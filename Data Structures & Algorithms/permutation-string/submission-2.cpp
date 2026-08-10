class Solution {
public:
   bool checkInclusion(string s1, string s2) 
{
    if (s1.length() > s2.length()) return false;

    unordered_map<char, int> m1, m2;
    int differentChar = 0, charFound = 0;
    int windowSize = s1.length();

    // Initialize m1 and count unique characters
    for (char c : s1) {
        if (m1[c] == 0) differentChar++;
        m1[c]++;
    }

    int left = 0, right = 0;

    // Initialize the first window
    while (right < windowSize) {
        char c = s2[right];
        m2[c]++;
        if (m1.find(c) != m1.end() && m2[c] == m1[c]) {
            charFound++;
        }
        right++;
    }

    if (charFound == differentChar) return true;

    // Slide the window
    while (right < s2.length()) {
        char outChar = s2[left];
        if (m1.find(outChar) != m1.end()) {
            if (m2[outChar] == m1[outChar]) charFound--;
        }
        m2[outChar]--;
        left++;

        char inChar = s2[right];
        m2[inChar]++;
        if (m1.find(inChar) != m1.end()) {
            if (m2[inChar] == m1[inChar]) charFound++;
        }

        if (charFound == differentChar) return true;
        right++;
    }

    return false;
}

};
