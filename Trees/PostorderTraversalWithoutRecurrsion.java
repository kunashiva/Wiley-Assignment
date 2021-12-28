/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.Stack;

/**
 *
 * @author pshastri
 */
public class Postorder {
        Node root;
	void postorder()
	{
            //L-R-root
            
           Stack<Node> st = new Stack<>();
           while(true){
              while(root!=null){
                  st.push(root);
                  st.push(root);
                  root=root.left;
              }
               if(st.empty())return;
               root = st.pop();
               if(!st.empty() && st.peek()==root){
                   root=root.right;
               }else{
                   System.out.println(" "+root.data );
                   root=null;
               }
           }
		
	}

	public static void main(String args[])
	{

		Postorder tree = new Postorder();
		tree.root = new Node(11);
		tree.root.left = new Node(122);
		tree.root.right = new Node(345);
		tree.root.left.left = new Node(9);
		tree.root.left.right = new Node(65);
                System.out.println("the Post order traversal is ");
		tree.postorder();
	}
}
