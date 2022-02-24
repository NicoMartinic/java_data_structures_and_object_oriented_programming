package Tests;

import BinaryAndGeneralTree.General_tree;
import Structures.*;

public class GeneralTreeTest {
		public static void main(String[] args) {				
			
			General_tree<String> a1 = new General_tree<String>("1");
			General_tree<String> a2 = new General_tree<String>("2");
			General_tree<String> a3 = new General_tree<String>("3");
			Generic_list<General_tree<String>> sons = new Generic_linked_list<General_tree<String>>();
			sons.AddToTheEnd(a1); sons.AddToTheEnd(a2); sons.AddToTheEnd(a3);
			General_tree<String> a = new General_tree<String>("0", sons);
			Generic_list<General_tree<String>> sons2 = new Generic_linked_list<General_tree<String>>();
			General_tree<String> a11 = new General_tree<String>("11");
			General_tree<String> a12 = new General_tree<String>("12");
			sons2.AddToTheEnd(a11); sons2.AddToTheEnd(a12);
			a1.setSons(sons2);
			System.out.println("Data in preorder: ");System.out.println();
			a.pre_Order();System.out.println();
			System.out.println("Data in postorder: ");System.out.println();
			a.post_Order();System.out.println();
			System.out.println("Data by level: ");System.out.println();
			a.by_level();System.out.println();
			System.out.println();
			System.out.println("Height: " + a.height());System.out.println();
			System.out.println("Wide: " + a.wide());System.out.println();
			System.out.println("Level of the node: " + a.level("0"));System.out.println();
			System.out.println();
		}
}