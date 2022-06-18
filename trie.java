/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise. 
*/


/*
	Every Node has a Array of 26 size to mark which chars are its children , also it has
	a boolean variable isEnd to mark end of any word.

	insert(): Point to root using curr pointer, now start a loop and extract each char from the
	word to be inserted in TRIE,  for every char check if it is present as child of
	curr node(for first char curr node will be root node).if no , then insert the char as the 
	child of curr and move the cur pointer to that child, so that next time we can insert
	the char as its child. Do this till the end char of word and outside the for loop
	mark the isEnd property of curr node (i.e the last char of our word) as true;

	search() &  startsWith() : keep checking char by char and if you don't found your char
	at any point return false, else at the end check for isEnd variable (in search() fun only)
	and return true(in startsWith () only).

	Because search function means that word should be completely present as a whole
	word and not as a part(substring ) of any other word thats why we are checking the
	isEnd flag , while startsWith() only want us to check that prefix is present in the trie or 
	not, it doesn't bother wheter we have it as a complete word or as a substring of any 
	other word.
*/
class Trie {
    
    class Node {
        Node [] childs;
        boolean isEnd;
        
        Node(){
            childs = new Node[26];
            isEnd = false;
        }
    }
    
    final private Node root;
    
    public Trie() {
        root = new Node();
    }
    
 
    public void insert(String word) {
        Node curr = root;
        
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.childs[ch - 'a'] == null){
                curr.childs[ch - 'a'] = new Node();
            }
            curr = curr.childs[ch - 'a'];
        }
        
        curr.isEnd = true;
    }
    
 
    public boolean search(String word) {
        Node curr = root;
        
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.childs[ch - 'a'] == null) return false;
            curr = curr.childs[ch - 'a'];
        }
        return curr.isEnd;
    }
    
  
    public boolean startsWith(String prefix) {
          Node curr = root;
        
        for(int i = 0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            
            if(curr.childs[ch - 'a'] == null) return false;
            curr = curr.childs[ch - 'a'];
        }
        
        return true;
    }
}
