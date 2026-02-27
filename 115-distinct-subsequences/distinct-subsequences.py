class Solution:
    def fn( self, s: str, i : int, t:str , j : int, dp: List[List[int]]) -> int:
        if j < 0: return 1
        if i < 0: return 0

        if dp[i][j] != -1: return dp[i][j]
        if s[i] == t[j]:
            dp[i][j] = self.fn(s, i - 1, t, j - 1 ,dp) + self.fn(s, i - 1, t, j,dp)
            return dp[i][j]

        dp[i][j] = self.fn(s, i -1, t, j,dp) 
        return dp[i][j]


    def numDistinct(self, s: str, t: str) -> int:
        dp = []
        for _ in range(len(s) + 1):
            row = [0] * (len(t) + 1)
            dp.append(row)

        for i in range(len(s) + 1):
            dp[i][0] = 1


        for i in range(1,  len(s) + 1):
            for j in range(1 , len(t) + 1):
               
                if s[i - 1] == t[j - 1]:
                    dp[i][j] = dp [i - 1][j - 1] + dp[i - 1][j]
                else:
                    dp[i][j] = dp[i -1][j] 
                


        return dp[len(s)][len(t)]
        # return self.fn(s, len(s) - 1,t,len(t) - 1, dp )


#     class Solution {
#     private int fn(String s, int i , String t, int j)
#     {
#         if(j < 0) return 1;
#         if(i < 0) return 0;

#         if(s.charAt(i) == t.charAt(j))
#         {
#             return fn(s, i - 1, t, j - 1) + fn(s, i - 1, t , j);
#         }

#         return fn(s, i - 1, t, j);
#     }

#     public int numDistinct(String s, String t) {
#         return fn(s,s.length() - 1, t,t.length()-1);
#     }
# }    