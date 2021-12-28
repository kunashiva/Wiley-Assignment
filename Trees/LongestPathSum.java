/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author pshastri
 */
public class LongestPathSum {

	static int totalLen;
	static int mainSum;
	
	
	static void calculatesum(Node root, int sum,int len)
	{
		
		if (root == null) {
			if (totalLen <= len) {
				if(totalLen!=len){
                                    totalLen = len;
                                }
                               mainSum = sum;
			} else  if(sum>mainSum) mainSum=sum;
                        return;
		}
		
		calculatesum(root.left, sum + root.data,len + 1);
		calculatesum(root.right, sum + root.data,len + 1);
		
	}
	
	// utility function to find the sum of nodes on
	// the longest path from root to leaf node
	static int sumofLongestpath(Node root)
	{
		// if tree is NULL, then sum is 0
		if (root == null)
			return 0;
	
		mainSum = Integer.MIN_VALUE;
		totalLen= 0;
		calculatesum(root, 0, 0);
                return mainSum;
	}
	
	// Driver program to test above
	public static void main(String args[])
	{
		Node root = new Node(5);
                root.left = new Node(7);
		root.right = new Node(3);
		root.left.left = new Node(3);
		root.left.right = new Node(2);
		root.right.right = new Node(5);
                root.right.right.left = new Node(15);
		root.left.right.left = new Node(3);
                root.left.right.right=new Node(10);
                root.left.right.right.left= new Node(8);
                 root.left.right.right.left.right = new Node(7);
                root.left.right.left.left = new Node(6);
                root.left.right.left.left.left = new Node(20);
                
	
		System.out.println( "Sum = "+ sumofLongestpath(root));
	}
}
