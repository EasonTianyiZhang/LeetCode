public class LRUCache {
    
    private class BiListNode{
        int val;
        int key;
        BiListNode pre;
        BiListNode next;
        public BiListNode(int key, int val){
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
    
    int cap;
    BiListNode anchor;
    Map<Integer, BiListNode> map;
    public LRUCache(int capacity) {
        cap = capacity;
        anchor = new BiListNode(Integer.MIN_VALUE, 0);
        anchor.pre = anchor;
        anchor.next = anchor;
        map = new HashMap<Integer, BiListNode>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else{
            BiListNode node = map.get(key);
            int value = node.val;
            moveForward(node);
            return value;
        }
    }
    
    private void moveForward(BiListNode node){
        if (map.size() != 1){ // do nothing if the cache just have one element
            node.pre.next = node.next;//node.pre -> node.next
            node.next.pre = node.pre;//node.pre <- node.next
            addFirst(node);
        }
    }
    
    private void addFirst(BiListNode node){
        node.next = anchor.next;// node -> e0
        node.pre = anchor;//a <- node
        node.next.pre = node;// node <- e0
        anchor.next = node;//  a -> node
    }
    
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            BiListNode node = map.get(key);
            node.val = value;
            moveForward(node);
        }
        else{
            if (map.size() == cap){
                //remove LRU
                map.remove(anchor.pre.key);
                anchor.pre = anchor.pre.pre;
                anchor.pre.next = anchor;
            }
            
            BiListNode node = new BiListNode(key, value);
            map.put(key, node);
            addFirst(node);
        }

    }
}