#Implement Tries (Prefic Tree)

#Implement a trie with insert, search, and startsWith methods.

#Example:
#Trie trie = new Trie();
#trie.insert("apple");
#trie.search("apple");   // returns true
#trie.search("app");     // returns false
#trie.startsWith("app"); // returns true
#trie.insert("app");   
#trie.search("app");     // returns true

#Note:
#You may assume that all inputs are consist of lowercase letters a-z.
#All inputs are guaranteed to be non-empty strings.

class Trie {
    
    int size = 26;
    
    class Node
    {
        Node[] children = new Node[size];
        boolean lastNode;
        Node()
        {
            for(int i=0; i<size; i++)
                children[i]=null;
            lastNode = false;
        }
        
    }
    
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();   
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i) - 'a';
            if(temp.children[index]==null)
            {
                temp.children[index] = new Node();
            }
            temp = temp.children[index];
        }
        temp.lastNode = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++)
        {
            int index = word.charAt(i)-'a';
            if(temp.children[index]==null)
                return false;
            temp=temp.children[index];
        }
        return temp!=null && temp.lastNode;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0; i<prefix.length(); i++)
        {
            int index = prefix.charAt(i)-'a';
            if(temp.children[index]==null)
                return false;
            temp=temp.children[index];
        }
        return temp!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
