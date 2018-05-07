package com.ds;

import com.ds.tree.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DSMainApp {

	public static void main(String[] args) {

        BSTTestStubForValidatingPreOrderPath();

	}

	public static void BSTTestStubForValidatingPreOrderPath(){
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		Scanner sc = new Scanner(System.in);

		//No of queries
		int q = sc.nextInt();

		List<String> inputList = new ArrayList<>();


		for (int i = 0; i < q; i++) {
			int noOfNode = sc.nextInt();
			StringBuilder st = new StringBuilder();
			for(int j=0; j<noOfNode; j++){
				int val = sc.nextInt();
				if(j == noOfNode-1) {
					st.append(val);
				}else{
					st.append(val + " ");
				}
			}

			inputList.add(st.toString());
		}

		for (String nodeList : inputList) {
			if(nodeList == null || nodeList.isEmpty()){
				continue;
			}
			BST tree = new BST();
			String[] str = nodeList.split(" ");
			int[] arr = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}

			for (int i = 0; i < arr.length; i++) {
				tree.insert(arr[i]);

			}

			List<String> preOrder = tree.preOrder();
			String nodeSpaceSeparated = String.join(" ", preOrder);
			if (nodeSpaceSeparated.contains(nodeList)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}
}
