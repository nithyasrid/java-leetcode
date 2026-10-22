class Solution:
    def intersection(self, nums: list[list[int]]) -> list[int]:
        return sorted(set.intersection(*map(set,nums)))