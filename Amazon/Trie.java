package Amazon;

//prefix-tree quetion leetcode
public class Trie {

    // node structure of trie
    static class TrieNode {
        // contain all characters which is links of child node
        TrieNode[] links = new TrieNode[26];
        // marks the end of the word to check if it is end or not
        boolean flag = false;

        // check if a specific char present in node
        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        // insert a new node which contains letter in node
        void put(char ch, TrieNode newNode) {
            links[ch - 'a'] = newNode;
        }

        // get the node with specific key(letter) from the trie
        TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        // set the end of word
        void setEnd() {
            flag = true;
        }

        // check if the curr node is end
        boolean isEnd() {
            return flag;
        }

    }

    // Trie class
    private TrieNode root;

    // constructor to intialize trie with an empty node
    public Trie() {
        root = new TrieNode();
    }

    // insert word in trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            // Check if ith character of word is present in the trie
            if (!node.containsKey(word.charAt(i))) {
                // if char in not present than create a new node for that char
                node.put(word.charAt(i), new TrieNode());
            }
            // move to the next node
            node = node.get(word.charAt(i));
        }
        // mark the end of the word
        node.setEnd();
    }

    // search the word
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            // check if ith char present in trie
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            // move to the next node
            node = node.get(word.charAt(i));
        }
        // check if the node ends
        return node.isEnd();
    }

    // return if there is any word who has the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            // check if the char node is present
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            // move to the next node
            node = node.get(prefix.charAt(i));
        }
        // prefix is found in the trie
        return true;
    }

}