class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        my_set = set()
        for i in nums:
            my_set.add(i)

        multiple = 1
        while True:
            
            if k * multiple not in my_set:
                return k * multiple
            multiple+= 1
            
        
        return -1