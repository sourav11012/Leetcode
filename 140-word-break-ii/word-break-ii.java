class Solution {

    void fn(int start,int end, String s,List<String> wordDict,List<String> curr,List<String> ds )
    {
        if(end == s.length() )
        {
            if(start == end )
            {
            ds.add(String.join(" ", curr));
            return;
            }
            else{
                return;
            }
        }

        if(wordDict.contains(s.substring(start, end + 1)))
        {
            curr.add(s.substring(start, end + 1));
            
            fn(end + 1, end + 1, s, wordDict, curr, ds);
            curr.remove(curr.size() - 1);
        }
        
        
        fn(start, end + 1, s, wordDict, curr, ds);
        
        return ;
    }




    public List<String> wordBreak(String s, List<String> wordDict) {
        // StringBuilder sb = new StringBuilder();
        List<String> curr = new ArrayList<>();
        List<String> ds = new ArrayList<>();

        fn(0,0,s,wordDict,curr,ds);
    
        return ds;
    }
}