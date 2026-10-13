from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n = len(s1)
        if len(s2) < n:
            return False
        
        seen = Counter(s1)
        matched = Counter(s2[:n])

        if seen == matched:
            return True
       
        for r in range(n , len(s2)):
            matched[s2[r]] +=1
            left = r - n
            matched[s2[left]] -=1

            if matched[s2[left] == 0]:
                del matched[s2[left]]
            
            if matched == seen:
                return True
        
        return False


           
