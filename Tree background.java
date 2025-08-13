package TreeD;

import TreeD.backgroundTree.Node;

public class backgroundTree {

	class Node{
		String key;
		int freq;
		Node left,right;
		public Node(String item) {
			key = item;
			freq = 1;
			left = right = null;
		}
	}
	
	
	Node root;
	
	public backgroundTree() {
		root = null;
	}
	
	void insert(String key) {
		root = insertRec(root,key);
	}
	
	Node insertRec(Node root,String key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if(key.compareTo(root.key) == 0) {
			root.freq++;
		}
		if(key.compareTo(root.key) < 0) {
			root.left = insertRec(root.left,key);
		}
		else if(key.compareTo(root.key) > 0) {
			root.right = insertRec(root.right,key);
		}
		return root;
	}
	
	void inorder() {
		printInorder(root);
	}
	
	void preorder() {
		printPreorder(root);
	}
	
	void postorder() {
		printPostorder(root);
	}
	
	void printInorder(Node root) {
		if(root != null) {
			printInorder(root.left);
			System.out.println(root.key + "(" + root.freq + ")");
			printInorder(root.right);
		}
	}
	
	void printPreorder(Node root) {
		if(root != null) {
			System.out.println(root.key + "(" + root.freq + ")");
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
	
	void printPostorder(Node root) {
		if(root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.println(root.key + "(" + root.freq + ")");
		}
	}
	
	public void search(String word) {
		root = searchRec(root, word);
		}
	
	public Node searchRec(Node root, String word) {
		if (root == null) {
		System.out.println("The word " + word+ " is not in the passage.\n");

		} else if (word.equals(root.key)) {
			System.out.println("The word " + word + " is used " + root.freq + " times.\n");
		} else if (word.compareTo(root.key) < 0) {
		return searchRec(root.left, word);
		} else {
		return searchRec(root.right, word);
		}
		return this.root;
		}
	
	public String minValue(Node root) {
		String min = root.key;
		
		while (root.left != null) {
			min = root.left.key;
			root = root.left;
		}
		return min;
	}
	
	public void delete(String word) {
		root = deleteRec(root, word);
		}
	
	public Node deleteRec(Node root, String word) {
		if (root == null) {
			System.out.println("The word "+word+" is not in the passage.\n");

		} else if (word.compareTo(root.key) < 0) {
		root.left = deleteRec(root.left, word);
		} else if (word.compareTo(root.key) > 0) {
		root.right = deleteRec(root.right, word);
		} else {
			if (root.left == null) {
				if (root.freq == 1) {
					System.out.println("One of the words " + word  + " was successfully deleted.\n");
					return root.right;
		} 
			else {
		root.freq -= 1;
		System.out.println("One of the words " + word  + " was successfully deleted.\n");
		}
		} else if (root.right == null) {
		if (root.freq == 1) {
			System.out.println("The word " + word + " was successfully deleted.\n");
		return root.left;
		} else {
		root.freq -= 1;
		System.out.println("One of the words " + word  + " was successfully deleted.\n");
		}
		} else {
		if (root.freq == 1) {
		root.key = minValue(root.right);
		root.right = deleteRec(root.right, root.key);
		System.out.println("The word " + word + " was successfully deleted.\n");

		} else {
		root.freq -= 1;
		System.out.println("One of the words " + word  + " was successfully deleted.\n");
		}
		}
		}
		return root;
		}
}