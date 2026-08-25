class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        

        my_dict = {}

        
        
        for i in range(0, len(nums)):
            compli = target - nums[i]
            if compli in my_dict:
                return [i,my_dict[compli]]
            my_dict[nums[i]]= i
        
        return [-1,-1]