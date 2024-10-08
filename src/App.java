import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class TreeImplemention
{
    static class Node
    {
        private int data;
        private Node left;
        private Node right;

        public Node()
        {
           this.data=0;
           this.left=null;
           this.right=null;
        }

        public Node(int val)
        {
          this.data=val;
          this.left=null;
          this.right=null;
        }

        public String toString()
        {
           return  this.data+" ";
        }
    }
     private Node root;
     public TreeImplemention()
     {
        this.root=null;
     }

     public void add(int val)
     {
        Node newnNode=new Node(val);
        if(root==null)
        root=newnNode;
        else
        {
           Node trav=root;

           while (true)
           {
               if(val<trav.data)
               {
                  if(trav.left ==null)
                  {
                    trav.left=newnNode;
                    break;
                  }
                  else
                  trav=trav.left;
               }
               else
               {
                  if(trav.right==null)
                  {
                    trav.right=newnNode;
                    break;
                  }
                  else
                  trav=trav.right;
               }
           }

        }
     }
//---------------------------------------
     public void preOrderTraversal()
     {
         System.out.print("PreOrder Traversal :- ");
         bstPreOrderTraversal(root);
       
     }
     public void bstPreOrderTraversal(Node trav)
     {
         if(trav == null)
         return ;
         System.out.print(trav.data+" ");
         bstPreOrderTraversal(trav.left);
         bstPreOrderTraversal(trav.right);
     }

     //--------------------------------
     public void inOrderTraversal()
     {
         System.out.print("InOrder Traversal :- ");
         bstInOrderTraversal(root);
       
     }
     public void bstInOrderTraversal(Node trav)
     {
         if(trav == null)
         return ;
         
         bstInOrderTraversal(trav.left);
         System.out.print(trav.data+" ");
         bstInOrderTraversal(trav.right);
     }
    //-----------------------------------------
     public void postOrderTraversal()
     {
         System.out.print("PostOrdern Traversal :- ");
         bstPostOrderTraversal(root);
         
     }
     public void bstPostOrderTraversal(Node trav)
     {
         if(trav == null)
         return ;
         
         bstPostOrderTraversal(trav.left);
         bstPostOrderTraversal(trav.right);
         System.out.print(trav.data+" ");
     }
//---------------------------------------------------
     public int hightOfTree()
     {
        return bstHightOfTree(root);
     }
     private int bstHightOfTree(Node trav)
     {
          if(trav==null)
          return -1;
          int hl=bstHightOfTree(trav.left);
          int hr=bstHightOfTree(trav.right);
          return Math.max(hl, hr)+1;
     }
//---------------------------------------------------
     private void bstDelTree(Node trav)
     {
        if(trav==null)
        return;

        bstDelTree(trav.left);
        trav.left=null;
        bstDelTree(trav.right);
        trav.right=null;

        trav=null;
     }
     public void delTree()
     {
           bstDelTree(root);
           root=null;
     }

     public Node serch(int val)
     {
        Node trav=root; 
         while(trav !=null)
         {
          if(val == trav.data)
          {
              return trav;
          }
          if(val>trav.data)
          trav=trav.right;
          else
          trav=trav.left;
         }
         return null;
     }
//---------------------------------------------------------------
     private Node bstRecursiveSearch(Node trav,int val)
     {
       if(trav==null)
       return null;
        if(val==trav.data)
        return trav;
        if(val > trav.data)
        return bstRecursiveSearch(trav.right, val);
        else
        return bstRecursiveSearch(trav.left, val);
     }
     public Node recursiveSerach(int val)
     {
         return bstRecursiveSearch(root,val);
     }

//--------------------------------------------------
     public void BFS_LevelOrderTraversal()
     {
      // explore all adjecent vertex then go to next vertex
          System.out.println("Level Order Traversal :- ");
          Queue<Node>queue=new ArrayDeque<>();
          queue.offer(root);

          while (!queue.isEmpty()) 
          {
              Node trav=  queue.poll();
              System.out.print(trav.data+" ");

              if(trav.left !=null)
              queue.add(trav.left);
              if(trav.right !=null)
              queue.add(trav.right);

          }
     }
     //-------------------------------------------------
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
}

public class App {
    public static void main(String[] args) throws Exception {

        TreeImplemention bst=new TreeImplemention();
      bst.add(50);
      bst.add(60);
      bst.add(40);

      bst.preOrderTraversal();
      System.out.println();
      bst.inOrderTraversal();
      System.out.println();
      bst.postOrderTraversal();
      System.out.println();

      int check_hight=bst.hightOfTree();
      System.out.println(check_hight==-1?"Tree is not present it's empty tree why you finding hight of tree ":"Hight of Tree is :- "+check_hight);
      // bst.delTree();
      // bst.inOrderTraversal();
     
      TreeImplemention.Node searchCheck= bst.recursiveSerach(60);
      System.out.println(searchCheck == null ?"Element is not present in tree ":"Element is prsent in tree :- "+searchCheck);

      bst.BFS_LevelOrderTraversal();
      System.out.println();
      bst.DFS();
    
    
   
       
    }
}
