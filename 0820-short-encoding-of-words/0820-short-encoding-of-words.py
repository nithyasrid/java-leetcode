class Solution:
    def minimumLengthEncoding(self, W: List[str]) -> int:
        trie, ans = defaultdict(), 1
        for word in W:
            curr, newWord = trie, False
            for i in range(len(word)-1,-1,-1):
                char = word[i]
                if not curr and not newWord: ans -= len(word) - i
                if char not in curr:
                    newWord = True
                    curr[char] = defaultdict()
                curr = curr[char]
            if newWord: ans += len(word) + 1
        return ans