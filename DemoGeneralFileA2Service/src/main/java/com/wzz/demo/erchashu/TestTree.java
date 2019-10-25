package com.wzz.demo.erchashu;

import javax.transaction.xa.Xid;

public class TestTree {

	public static void main(String[] args) {

		BinaryTree t1 = new BinaryTree();
		BinaryTree t2 = new BinaryTree();
		BinaryTree t22 = new BinaryTree();
		BinaryTree t3 = new BinaryTree();
		BinaryTree t32 = new BinaryTree();
		BinaryTree t33 = new BinaryTree();
		BinaryTree t34 = new BinaryTree();
		BinaryTree t4 = new BinaryTree();
		BinaryTree t42 = new BinaryTree();
		BinaryTree t43 = new BinaryTree();
		BinaryTree t44 = new BinaryTree();
		BinaryTree t45 = new BinaryTree();
		BinaryTree t46 = new BinaryTree();
		BinaryTree t47 = new BinaryTree();
		BinaryTree t48 = new BinaryTree();

		t1.setValue(1);
		t2.setValue(2);
		t22.setValue(3);
		t3.setValue(4);
		t32.setValue(5);
		t33.setValue(6);
		t34.setValue(7);
		t4.setValue(8);
		t42.setValue(9);
		t43.setValue(10);
		t44.setValue(11);
		t45.setValue(12);
		t46.setValue(12);
		t47.setValue(14);
		t48.setValue(15);
		t1.setLeft(t2);
		t1.setRight(t22);
		t2.setLeft(t3);
		t2.setRight(t32);
		t22.setLeft(t33);
		t22.setRight(t34);
		t3.setLeft(t4);
		t3.setRight(t42);
		t32.setLeft(t43);
		t32.setRight(t44);
		t33.setLeft(t45);
		t33.setRight(t46);
		t34.setLeft(t47);
		t34.setRight(t48);

		TestTree testTree = new TestTree();
		System.out.println("-----------先序遍历--------------");

		testTree.xiAn(t1);
		System.out.println("-----------后序遍历--------------");

		testTree.Hou(t1);
		System.out.println("-----------中序遍历--------------");

		testTree.zhong(t1);

	}

	// 先序遍历
	public void xiAn(BinaryTree argss) {

		if (argss != null) {
			System.out.println(argss.getValue());
			xiAn(argss.getLeft());
			xiAn(argss.getRight());
		}

	}

	// 后序遍历
	public void Hou(BinaryTree argss1) {
		if (argss1 != null) {
			Hou(argss1.getLeft());
			Hou(argss1.getRight());
			System.out.println(argss1.getValue());
		}
	}

	// 中序遍历
	public void zhong(BinaryTree argss2) {
		if (argss2 != null) {
			zhong(argss2.getLeft());
			System.out.println(argss2.getValue());
			zhong(argss2.getRight());
		}
	}
}
