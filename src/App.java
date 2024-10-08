import java.util.*;
class BinarySearchTree{
    
    static class Node{
        private int data;
        private Node left;
        private Node right;
        
        public Node(){
            this.data=0;
            this.left=null;
            this.right=null;
        }
        public Node(int val){
            this.data=val;
            this.left=null;
            this.right=null;
        }
        
        public String toString(){
            return this.data+" ";
        }
    }
    
    private Node root;
    public BinarySearchTree(){
        this.root=null;
    }
    
    
    
 //------------------------------------
    
    
    public void add(int val){
        Node newnode=new Node(val);
        if(root==null)
        root=newnode;
        else{
            Node trav=root;
            
            while(true){
                if(val<trav.data){
                    if(trav.left==null){
                        trav.left=newnode;
                        break;
                    }else
                    trav=trav.left;
                }else{
                    if(trav.right==null){
                        trav.right=newnode;
                        break;
                    }else
                    trav=trav.right;
                }
            }
        }
    }
   //------------------------------------------------ 
    private void preeorder(Node trav){
        if(trav==null)
        return;
        System.out.print(trav.data+" ");
        preeorder(trav.left);
        preeorder(trav.right);
    }
    public void preo(){
        System.out.print("Preeorder:-");
        preeorder(root);
    }
 //--------------------------------------------------   
    private void inorder(Node trav){
        if(trav==null)
        return;
        inorder(trav.left);
        System.out.print(trav.data+" ");
        inorder(trav.right);
    }
    public void Ineo(){
        System.out.print("Inorder:-");
        inorder(root);
    }

    //--------------------------------------
    
    private void postorder(Node trav){
        if(trav==null)
        return;
        postorder(trav.left);
        postorder(trav.right);
        System.out.print(trav.data+" ");
    }
    public void Poso(){
        System.out.print("Postorder:-");
        postorder(root);
    }
    



//------------------------------------
    private int Hight(Node trav){
        if(trav==null)
        return -1;
       int hl=Hight(trav.left);
       int hr=Hight(trav.right);
       int max=Integer.max(hl,hr);
       return max+1;
       
     
    }
    public int hi(){
      
       int h= Hight(root);
       return h;
    }
    
  //----------------------------------------  


private void delt(Node trav){
    if(trav==null)
    return;
    
    delt(trav.left);
    trav.left=null;
    delt(trav.right);
    trav.right=null;
    
    trav=null;
    
}  
  
  public void deltree(){
      delt(root);
      root=null;
  }  
    
//------------------------------------------------- 

public Node Search(int val){
    Node trav=root;
    
    while(trav!=null)
    {
        if(val==trav.data)
        return trav;
        if(val<trav.data)
        trav=trav.left;
        else
        trav=trav.right;
    }
    return null;
}
//------------------------------------------------------

public Node recSerch(Node trav,int val){
    if(trav==null)
    return null;
    
    if(val==trav.data)
    return trav;
    if(val<trav.data)
    return recSerch(trav.left,val);
    else
    return recSerch(trav.right,val);
}

public Node RecSearch(int val){
    return recSerch(root,val);
}
//----------------------------------------
public  void BFS_leveOrderTraversal()
    { 
       // In BFS:- when need explore all vertex of adjacent of that vertex then go to next vertex
        System.out.print("Level Order Traversal :- ");
        Queue<Node>treeNodeQueue=new LinkedList<>();
        //Start With the first/root node
        treeNodeQueue.add(root);
         //Run a loop till this queue is not empty

         while(!treeNodeQueue.isEmpty())
         {
            Node treeNode=treeNodeQueue.poll();

            //print the value
            System.out.print(treeNode.data+" ");
            
            //Add left child to queue
            if(treeNode.left !=null)
            treeNodeQueue.add(treeNode.left);

            //Add right child to queue
            if(treeNode.right !=null)
            treeNodeQueue.add(treeNode.right);
         }
        
    }
//--------------------------------------------------------
 
     public void DFS()
     {
          System.out.println("DFS Traversal :- ");
          Stack<Node>stack=new Stack<>();
          stack.push(root);

          while (!stack.isEmpty()) 
          {
              Node trav=  stack.pop();
              System.out.print(trav.data+" ");
              
              if(trav.right !=null)
              stack.add(trav.right);

              if(trav.left !=null)
              stack.add(trav.left);
             

          }
     }
//--------------------------------------------------

}

public class App {
    public static void main(String[] args) throws Exception {

        BinarySearchTree bst=new BinarySearchTree();
        bst.add(10);
        bst.add(20);
         bst.add(5);
        bst.preo();
        
         System.out.println();
         bst.Ineo();
         
         System.out.println();
         bst.Poso();
         
     System.out.println();
     int h=bst.hi();
     if(h==-1)
     System.out.println("Tree is empty");
     else
     System.out.println("Hight of tree is "+h);
         
       System.out.println();
    //   bst.deltree();
        
    //  int h2=bst.hi();
    //  if(h2==-1)
    //  System.out.println("Tree is empty");
    //  else
    //  System.out.println("Hight of tree is "+h2);
    
    
  BinarySearchTree.Node temp=bst.Search(10);
  if(temp==null)
  System.out.println("element is not present in tree");
  else
  System.out.println("element is present in tree "+temp);
    
  BinarySearchTree.Node tem=bst.RecSearch(20);
  if(tem==null)
  System.out.println("element is not present in tree");
  else
  System.out.println("element is present in tree "+tem);
    
    
   
       
    }
}
