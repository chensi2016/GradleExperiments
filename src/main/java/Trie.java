import java.util.ArrayList;

class TrieNode {
    char value;
    ArrayList<TrieNode> next;
    boolean isEnd;
    TrieNode(char value , TrieNode preNode) {
        this.value = value;
        this.next = new ArrayList<>();
        preNode.next.add(this);
    }
    TrieNode(){
        this.next = new ArrayList<>();
    }
}
public class Trie {
    TrieNode startNode;

    /** Initialize your data structure here. */
    public Trie() {
        this.startNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int pointer = 0;
        TrieNode currentNode = startNode;
        while ( pointer != word.length() ) {
            char currentChar = word.charAt(pointer);
            boolean isUpdated = false;
            //while ( !currentNode.next.isEmpty() ) {
                for (TrieNode node : currentNode.next) {
                    if (node.value == currentChar) {
                        currentNode = node;
                        isUpdated = true;
                        break;
                    }
                }

            if ( ! isUpdated ) {
                TrieNode newNode = new TrieNode( currentChar, currentNode);
                currentNode = newNode;
            }
            pointer++;
        }
        currentNode.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int pointer = 0;
        TrieNode currentNode = startNode;
        while ( pointer != word.length() ) {
            char currentChar = word.charAt(pointer);
            boolean isUpdated = false;

                for (TrieNode node : currentNode.next) {
                    if (node.value == currentChar) {
                        currentNode = node;
                        isUpdated = true;
                        break;
                    }
                }

            if ( ! isUpdated ) {
                return false;
            }
            pointer++;
        }
        return currentNode.isEnd;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int pointer = 0;
        TrieNode currentNode = startNode;
        while ( pointer != prefix.length() ) {
            char currentChar = prefix.charAt(pointer);
            boolean isUpdated = false;

                for (TrieNode node : currentNode.next) {
                    if (node.value == currentChar) {
                        currentNode = node;
                        isUpdated = true;
                        break;
                    }
                }

            if ( ! isUpdated ) {
                return false;
            }
            pointer++;
        }
        return true;

    }
}

