public class BST<K extends Comparable<K>,V> {

    private Node root;

    public void insert(K key,V val) {
        root = insert(root,key,val);
    }

    public int height(){
         return height(root);
    }

    private int height(Node r){
         if(r == null) return 0;
         return 1+Math.max(height(r.left),height(r.right));
    }

    private Node insert(Node n,K key,V val){
        if(n == null) return new Node(key,val);
        int cmp = key.compareTo(n.key);
        if(cmp>0) n.right = insert(n.right,key,val);
        if(cmp<0) n.left = insert(n.left,key,val);
        return n;
    }

    private class Node{
        private K key;
        private V val;
        private Node left;
        private Node right;
    }

}
