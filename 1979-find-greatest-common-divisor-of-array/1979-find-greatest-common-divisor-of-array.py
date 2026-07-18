class Solution:
    def findGCD(self, nums: List[int]) -> int:
        small = min(nums)
        large = max(nums)
        while(large!=0):
            remainder = small%large 
            small = large 
            large = remainder 
        return small