/**
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

package practice.aPractice;
import ctciutil.TreeNode;
import ctciutil.CTCIMethods;
import java.util.*;

//	(a) Inorder (Left, Root, Right)
// 	(b) Preorder (Root, Left, Right) 
// 	(c) Postorder (Left, Right, Root)

// The whole goal is to make the encoded string AS SMALL AS POSSIBLE otherwise we could have treated this the same as a Binary Tree
// Must make use of the BST property to make the encoded string smaller (need to get rid of "NULL")

public class SerializeDeserializeBST{
	static class Codec{

		private static final String SPLITTER = ","; 

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	if (root == null){return null;}
	    	StringBuilder sb = new StringBuilder();
	    	preOrder(root,sb);
	    	return sb.toString();
	    }

	    private void preOrder(TreeNode root, StringBuilder sb){
	    	if(root==null){return;}
	    	sb.append(root.data).append(SPLITTER);
	    	preOrder(root.left, sb);
	    	preOrder(root.right, sb);
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	if(data == null || data.length() == 0 ){return null;}

        	Queue<String> queue = new LinkedList<>();
        	queue.addAll(Arrays.asList(data.split(SPLITTER)));

        	return getTree(queue, Integer.MAX_VALUE);
	    }

	    private TreeNode getTree(Queue<String> queue, int max){
	    	if(queue.isEmpty() || Integer.parseInt(queue.peek()) > max) {return null;}

	    	TreeNode node = new TreeNode(Integer.parseInt(queue.poll()));
	    	node.left = getTree(queue, node.data);
	    	node.right = getTree(queue, max);
	    	return node;
	    }

	}

	public static void main(String[] args) {
		int[] array = {5,3,2,6,7};
		Arrays.sort(array);
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("ORIGINAL: ");
		root.print();
		System.out.println("is BST : "+root.isBST());


		Codec codec = new Codec();
		String serializedTree = codec.serialize(root);
		System.out.println("SERIALIZED: "+serializedTree);

		TreeNode deSerializedtree = codec.deserialize(serializedTree);
		System.out.println("DESERIALIZED: ");
		deSerializedtree.print();

	}


}