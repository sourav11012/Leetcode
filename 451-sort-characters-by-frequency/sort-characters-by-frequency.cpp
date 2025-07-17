class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> freqMap;
        for (char ch : s) {
            freqMap[ch]++;
        }

        // max-heap based on frequency
        priority_queue<pair<int, char>> pq;
        for (const auto& [ch, freq] : freqMap) {
            pq.push({freq, ch});
        }

        string ans;
        while (!pq.empty()) {
            auto [freq, ch] = pq.top();
            pq.pop();
            ans += string(freq, ch); // append 'ch' freq times
        }

        return ans;
    }
};
