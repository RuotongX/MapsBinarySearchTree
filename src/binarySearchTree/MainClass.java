package binarySearchTree;

import java.util.Scanner;

public class MainClass {
	public static void main(String args[]) {
		int key;
		String value;
		BinarySearchTree bst = null;
		boolean conti = false;
		Scanner sc = new Scanner(System.in);
		String input;
		System.out.println("Type 1 if you want to get key set");
		System.out.println("Type 2 if you want to get the values");
		System.out.println("Type 3 if you want to get the entry set");
		System.out.println("Type 4 if you want to get the value set");
		System.out.println("Type 5 if you want to exit this program");
		System.out.println("Type 6 if you want to get the height of tree");
		do {
			System.out.println(
					"Please input your key and value of any order(format must be like 'key value' if you want to add elements):");
			input = sc.nextLine();
			if (!input.contains(" ")) {
				if (input.equals("1") || input.equals("2") || input.equals("3")||input.equals("4")||input.equals("5")) {
					switch (input) {
					case "1":
						System.out.println(bst.keyset(bst.root));
						break;
					case "2":
						System.out.println("Please input your key");
						input = sc.nextLine();
						int temp = Integer.valueOf(input);
						try {
							System.out.println("Value: "+bst.getValue(temp).toString());
						} catch(NullPointerException e) {
							continue;
						}
						break;
					case "3":
						System.out.println(bst.entryset(bst.root));
						break;
					case "4":
						System.out.println(bst.valueset(bst.root));
						break;
					case "5":
						conti = false;
						break;
					case "6":
						System.out.println("Tree height is "+bst.treeHeight());
						break;
					}
				} else {
					System.out.println("Input invalid");
					conti = true;
				}
			} else {
				String[] temp = input.split(" ");
				if (temp[1].contains(" ")) {
					System.out.println("Input invalid");
					conti = true;
				}
				key = Integer.valueOf(temp[0]);
				value = temp[1];
				conti = true;
				if (bst == null) {
					bst = new BinarySearchTree(key, value);
				} else {
					bst.add(key, value);
				}
			}
		} while (conti);
	}
}
