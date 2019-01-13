private static int max(int x,int y){
        return (x > y) ? x : y;
    }
    private static int Height(Node root){
        if(root == null)
            return -1;
        else
            return root.ht;
    }
    private static int setHeight(Node root){
        if(root == null)
            return -1;
        else
            return 1 + max(Height(root.left),Height(root.right));
    }
    private static int getBalance(Node root){
        if(root == null)
            return -1;
        else
            return Height(root.left) - Height(root.right);
    }
    private static Node leftRotate(Node root){
        Node newRoot = root.right;
       root.right = newRoot.left;
       newRoot.left = root;

        root.ht = setHeight(root);
        newRoot.ht = setHeight(newRoot);

        return newRoot;
    }
    private static Node rightRotate(Node root){
        Node newRoot = root.left;
       root.left = newRoot.right;
       newRoot.right = root;

        root.ht = setHeight(root);
        newRoot.ht = setHeight(newRoot);

        return newRoot;
    }
        static Node insert(Node root,int val)
    {
        if(root == null){
            root = new Node();
            root.val = val;
            root.ht = Height(root);
            return root;
        }

        if(val <= root.val)
            root.left = insert(root.left,val);

        else if(val > root.val)
            root.right = insert(root.right,val);

        int balance = getBalance(root);
        if(balance > 1){
            if(getBalance(root.left) >= 0){
                root = rightRotate(root);
            }
            else{
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }
        else if(balance < -1){
            if(getBalance(root.right) <= 0){
                root = leftRotate(root);
            }
            else{
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }
        else{
            root.ht = setHeight(root);
        }
        return root;
    }
