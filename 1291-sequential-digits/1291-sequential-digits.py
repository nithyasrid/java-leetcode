from typing import List

class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        ans = []
        digits = "123456789"

        # Generate numbers with lengths between low and high
        for length in range(len(str(low)), len(str(high)) + 1):

            # Starting index of each substring
            for i in range(10 - length):

                # Extract sequential digits
                num = int(digits[i:i + length])

                # Check if it lies in the given range
                if low <= num <= high:
                    ans.append(num)

        return ans