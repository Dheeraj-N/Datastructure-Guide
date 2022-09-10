package Tree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Tree tree = new Tree();
       tree.insert(7);
       tree.insert(9);
       tree.insert(4);
       tree.insert(10);
       tree.insert(1);
       tree.insert(6);
       tree.insert(8);
       Tree tree1 = new Tree();
       tree1.insert(7);
       tree1.insert(9);
       tree1.insert(4);
       tree1.insert(10);
       tree1.insert(1);
       tree1.insert(6);
       tree1.insert(8);
       System.out.println(tree.find(12));
       System.out.println("Inorder Traversal");
       tree.inOrderTraversal();
       System.out.println("Preorder Traversal");
       tree.preOrderTraversal();
       System.out.println("Postorder Traversal");
       tree.postOrderTraversal();
       System.out.println("LevelOrder Traversal");
       tree.levelOrderTraversal();
       tree1.swap();
       System.out.println(tree1.isBinarySearchTree());       
       tree.printNodesAtDistance(2);
       
	}

}
