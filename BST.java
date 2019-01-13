class BinarySearchTree{
        class Node{
                int key;
                Node left,right;
        public Node(int item){
                key = item;
                left = right = null;
            }
        }

        static Node root;

        BinarySearchTree(){
                root = null;
        }

        public  void insert(int key){
                root = insertREC(root,key);
        }

        public Node insertREC(Node root,int key){
                if(root == null){
                        root = new Node(key);
                        return root;
                }
                if(key < root.key)
                        root.left = insertREC(root.left,key);
                if(key > root.key)
                        root.right = insertREC(root.right,key);
                return root;
        }

        public void inorder(Node root){
                if(root!=null){
                inorder(root.left);
                System.out.print(root.key + " ");
                inorder(root.right);
                }
        }

        public static void main(String []args){
                BinarySearchTree b = new BinarySearchTree();
                b.insert(10);
                b.insert(3);
                b.insert(7);
                b.insert(19);
                b.insert(4);
                b.inorder(root);
        }
}
