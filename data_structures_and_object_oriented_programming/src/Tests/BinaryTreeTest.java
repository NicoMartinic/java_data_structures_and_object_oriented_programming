package Tests;

import BinaryAndGeneralTree.Binary_tree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		
	Binary_tree<Integer> a = new Binary_tree<Integer>(4);
	a.AddLeftSon(new Binary_tree<Integer>(1));
	a.AddRightSon(new Binary_tree<Integer>(5));
	a.getRightSon().AddRightSon(new Binary_tree<Integer>(8));
	a.getRightSon().AddLeftSon(new Binary_tree<Integer>(1));
	a.getLeftSon().AddRightSon(new Binary_tree<Integer>(6));
	a.getLeftSon().AddLeftSon(new Binary_tree<Integer>(2));
	System.out.println("Amount of leafs " + a.amountOfLeafs());System.out.println();
	System.out.println("Is the tree empty? " + a.isEmpty());System.out.println();
	System.out.println("Is it a full tree " + a.isFullWithoutPrint());System.out.println();
	a.isFull();System.out.println();
	System.out.println("Printing the tree in preorder");System.out.println();
	a.printPreorder();
	
	}

}
