class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        
        max_heap = [-x for x in stones]

        heapq.heapify(max_heap)

        while len(max_heap) > 1:
            x = -heapq.heappop(max_heap)
            y = -heapq.heappop(max_heap)

            z = x - y
            if z > 0:
                heapq.heappush(max_heap, -z)
        
        return -max_heap[0] if len(max_heap) == 1 else  0