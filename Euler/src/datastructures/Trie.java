package datastructures;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Character c;
        TrieNode current = root;
        for(int i = 0; i < word.length();i++){
            c = word.charAt(i);
            if(!current.containsKey(c)){
                current.put(c,new TrieNode());
            }
            current = current.get(c);
        }
        current.setWord(true);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	Character c;
        TrieNode current = root;
        for(int i = 0; i < word.length();i++){
        	c = word.charAt(i);
            if(!current.containsKey(c)){
               return false;
            }
            current = current.get(c);
        }
        return current.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	Character c;
        TrieNode current = root;
        for(int i = 0; i < prefix.length();i++){
        	c = prefix.charAt(i);
            if(!current.containsKey(c)){
               return false;
            }
            current = current.get(c);
        }
        return true;
    }
}
