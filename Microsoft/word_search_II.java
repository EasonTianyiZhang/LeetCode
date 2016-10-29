public class Solution {
    private class TrieNode{
        TrieNode[] next;
        String word;
        public TrieNode(){
            next = new TrieNode[26];
            word = null;
        }
    }
    
    private class Trie{
        TrieNode root;
        public Trie(){
            this.root = new TrieNode();
        }
        
        public void insert(String word){
            TrieNode t = root;
            for(int i = 0; i < word.length() +1; i++){
                if (i == word.length()){
                    t.word = word;
                    break;
                }
                char c = word.charAt(i);
                int idx = (int)(c - 'a');
                if (t.next[idx] == null)
                    t.next[idx] = new TrieNode();
                t = t.next[idx];
            }
        }
    }
    
    private boolean[][] visited;
    private List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        res = new LinkedList<String>();
        if (board.length == 0) return res;
        
        Trie trie = new Trie();
        for (String word : words){
            trie.insert(word);
        }
        
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                visit(board, i, j, trie.root);
            }
        }
      
        return res;
    }
    
    private void visit(char[][] board, int i, int j, TrieNode t){
        char c = board[i][j];
        int idx = (int)(c - 'a');
        TrieNode nextT = t.next[idx];
        
        if (visited[i][j] || nextT == null) 
            return;    
        else{
            
            if (nextT.word != null){
                res.add(nextT.word);
                nextT.word = null;// DE-DUPLICATE!!!!
            }
            
            visited[i][j] = true;
            if (i > 0) visit(board, i-1, j, nextT);
            if (i < board.length-1) visit(board, i+1, j, nextT);
            if (j > 0) visit(board, i, j-1, nextT);
            if (j < board[0].length-1) visit(board, i, j+1, nextT);
            visited[i][j] = false;
        }
    }
}