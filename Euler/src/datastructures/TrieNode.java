package datastructures;

import java.util.HashMap;

class TrieNode {
    boolean hasWord;
    HashMap<Character,TrieNode> nextCharMap;
    // Initialize your data structure here.
    public TrieNode() {
        hasWord = false;
        nextCharMap = new HashMap<>();
    }
    public void put(Character c, TrieNode n){
        nextCharMap.put(c,n);
    }
    public void setWord(boolean hasWord){
        this.hasWord = hasWord;
    }
	public boolean containsKey(Character c) {
		return nextCharMap.containsKey(c);
	}
	public TrieNode get(Character c) {
		return nextCharMap.get(c);
	}
	public boolean hasWord(){
		return hasWord;
	}
	
}
