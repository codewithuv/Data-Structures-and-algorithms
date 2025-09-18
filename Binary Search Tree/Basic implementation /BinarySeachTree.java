import java.util.*;

class Tree{
    Tree left,right;
    int data;
    Tree()
    {
        this.left=null;
        this.right=null;
    }
    Tree(int data)
    {
        this.data=data;
        this.left=this.right=null;
    }


} 
class BinarySearchTree{
     Tree root;
    BinarySearchTree()
    {
        root=null;
    }
    //insert int tree
    public Tree insert(Tree root,int data)
    {
        if(root==null)
        {   
            return new Tree(data);
        }
        if(data <root.data)
        root.left= insert(root.left, data);
        else 
        root.right= insert(root.right,data);

        return root;
    }


    //inorder 
    public void inorder(Tree root){
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.data +"->");
            inorder(root.right);
        }
    }

    //pre order traversal
    public void preorder(Tree root){
        if(root!=null)
        {
            System.out.print(root.data +"->");
            preorder(root.left);
            
            preorder(root.right);
        }
    }
    //post
    public void postorder(Tree root){
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data +"->");
        }
    }


    public boolean search(Tree root,int data)
    {
        if(root==null)
        return false;
        if(root.data ==data)
            {return true;}
        if(data <root.data)
        return search(root.left,data);
        return search(root.right,data);
         
    }

    private Tree findMin(Tree node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}

    public Tree deletenode(Tree root,int data)
    {
        if(root==null)
        return null;
        if(data<root.data)
        root.left=deletenode(root.left,data);
        else if(data>root.data)
        root.right=deletenode(root.right, data);
        else{
            //case 1 if root as no child
            if(root.left==null && root.right==null)
            return null;
             //case 2 : if one child   
            if(root.left==null) 
            return root.right;
            if(root.right==null)
            return root.left;

            //case3: more child and successor
            Tree successor = findMin(root.right);
            root.data = successor.data;

            // Delete the inorder successor
            root.right = deletenode(root.right, successor.data);
    

        }
        return root;
    }

    

    public boolean printAncestors(Tree root,int val)
    {
        if(root==null)
        return false;
        if(root.data==val)
        return true;
        if (printAncestors(root.left, val) || printAncestors(root.right, val)) {
            System.out.print(root.data + " ");
            return true;
        }

        return false;
    }

    //root to leaf
    public boolean isPathexist(Tree root,int key)
    {
        if(root==null && key==0)return true;
        if(root==null )return false;
        return isPathexist(root.left, key-root.data)||isPathexist(root.right, key-root.data);
    }
    
    public void mirrorImage(Tree root)
    {
        if(root==null )return ;
        mirrorImage(root.left);
        mirrorImage(root.right);
        Tree temp=root.left;
        root.left=root.right;
        root.right=temp;
    }



    //hieght of the binary tree
    int height(Tree root)
    {
        if(root==null)
        return  0;
        return  Math.max(height(root.left) ,height(root.right))+1;
    }


    //size of the binaryTreee
    int size (Tree root)
    {
        if(root==null)
        return  0;
        return size(root.left)+size(root.right)+1;
    }


    int maximunnode(Tree root)
    {
        if(root==null)
        return Integer.MIN_VALUE;

        return  Math.max(root.data,Math.max(maximunnode(root.left),maximunnode(root.right)));

    }


    //level order traversal using queue
    void levelorder(Tree root)
    {
        Queue<Tree> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Tree curr=q.poll();
            System.out.print(curr.data);

            if(curr.left !=null)
            q.add(curr.left);

            if(curr.right !=null)
            q.add(curr.right);
        }


    }


   void levelorderLinewise(Tree root) {
    if (root == null) return;

    Queue<Tree> q = new LinkedList<>();
    q.add(root);
    q.add(null); // null as marker for end of level

    while (!q.isEmpty()) {
        Tree curr = q.poll();

        if (curr == null) {
            System.out.println(); // move to new line
            if (!q.isEmpty()) {
                q.add(null); // add marker for next level
            }
        } else {
            System.out.print(curr.data + " "); // print data

            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }
    }


    //  left view using Hashmap
   

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        BinarySearchTree tree=new BinarySearchTree();
        System.out.println("Enter number in a tree Pess -1 to exit");
        while (true) { 
            int n=sc.nextInt();
            if(n==-1)
            break;
            tree.root=tree.insert(tree.root,n);    
        }
        
        // tree.root=tree.insert(tree.root,4);
        // tree.root=tree.insert(tree.root,6);
        // tree.root=tree.insert(tree.root,2);
        // tree.root=tree.insert(tree.root,1);
        // tree.root=tree.insert(tree.root,3);
        // tree.root=tree.insert(tree.root,8);
        // tree.root=tree.insert(tree.root,7);
 
        System.out.println("InOrder");
        tree.inorder(tree.root);
         System.out.println("null");
        // System.out.println("pre-Order");
        // tree.preorder(tree.root);
        // System.out.println("null");
        // System.out.println("postOrder");
        // tree.postorder(tree.root);
        // System.out.println("null");

        // System.out.println("Enter Number to be searched");
        // int n=sc.nextInt();
        // if(tree.search(tree.root, n))
        // {
        //     System.out.println("Number is found");
        // }else 
        //  System.out.println("Number is not found");
        
        // System.out.println("Enter Number to be deleted");
        // int n2=sc.nextInt();
        // tree.root=tree.deletenode(tree.root, n2);
        // tree.inorder(tree.root);
        // System.out.println("");
        // System.out.print("Enter the node to find its Ancestors");
        // int an=sc.nextInt();
        // if(!tree.printAncestors(tree.root,an))
        // System.out.println("Node not found");

        // System.out.println("Enter the sum to find paths exist");
        // int sm=sc.nextInt();
        // if(tree.isPathexist(tree.root,sm))
        // System.out.println("Yes path is there");
        // else 
        // System.out.println("No path");
       // System.out.println(tree.height(tree.root));
       // System.out.println(tree.size(tree.root));
       tree.levelorderLinewise(tree.root);
    }
}
