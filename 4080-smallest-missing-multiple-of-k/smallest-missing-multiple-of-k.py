class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        my_set = set(nums)
        

        multiple = 1
        while True:
            
            if k * multiple not in my_set:
                return k * multiple
            multiple+= 1
            
        
        return -1