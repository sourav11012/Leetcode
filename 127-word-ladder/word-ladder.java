class Solution {
    
    class Pair{
        String first;
        int second;
        Pair(String first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList)
        {
            set.add(s);
        }
        if(set.contains(beginWord))
        {
            set.remove(beginWord);
        }
        if(!set.contains(endWord))
        {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
 

        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            String currentWord = curr.first;
            if(currentWord.equals(endWord)) return curr.second;
            for(int i = 0 ;i <currentWord.length() ; i++)
            {
                char[] newWord = currentWord.toCharArray();
                for(int j= 0; j<26 ; j++)
                {

                    newWord[i] = (char)(j + 97);
                    String temp = new String(newWord); 
                    if(set.contains(temp))
                    {
                        q.add(new Pair(temp , curr.second + 1));
                        set.remove(temp);
                    }
                }

            }
      

        }
          return 0;
    }
}