class Trie {
    
    Trie[] nodes;
    boolean endOfWord;
    public Trie() {
        this.nodes = new Trie[26];
        this.endOfWord = false;
    }
    
    public void insert(String word) {
        Trie temp = this;

        for(int i = 0;i<word.length();i++)
        {
            int idx = word.charAt(i) - 'a';
            if(temp.nodes[idx] == null)
                temp.nodes[idx] = new Trie();
            
        
            temp = temp.nodes[idx];
            
        }
        temp.endOfWord = true;
    }

    
    public boolean search(String word) {
        Trie temp = this;
        for(int i = 0; i<word.length();i++)
        {
            if(temp.nodes[word.charAt(i) - 'a'] == null)
            {
                return false;
            }
            temp = temp.nodes[word.charAt(i) - 'a'];
        }
        return temp.endOfWord;
        
    }
    
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for(int i = 0; i<prefix.length();i++)
        {
            if(temp.nodes[prefix.charAt(i) - 'a'] == null)
            {
                return false;
            }
            temp = temp.nodes[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */