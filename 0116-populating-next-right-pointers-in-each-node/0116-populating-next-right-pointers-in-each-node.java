
class Solution {
    public Node connect(Node root) {
     
    Node levelHead=root;
    Node itr=levelHead;
        
    while(levelHead!=null)
    {
        itr=levelHead;
        while(itr!=null)
        {
//         left 
            if(itr.left!=null) itr.left.next=itr.right;
//         right
            if(itr.right!=null && itr.next!=null) itr.right.next=itr.next.left;
            
            itr=itr.next;
        }
        levelHead=levelHead.left;
        
    }
        
    return root;
  }
}