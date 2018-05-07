package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BST {

    class Node {

        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;

    public BST(){
        root = null;
    }

    public void insert(int data){
        root = insertEntry(root, data);
    }

    public Node insertEntry(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insertEntry(root.left, data);
        }else if(data > root.data){
            root.right = insertEntry(root.right, data);
        }

        return root;
    }

    public List<String> preOrder = new ArrayList<>();

    public List<String> preOrder(){
        preOrderRecords(root);
        return preOrder;
    }

    public void preOrderRecords(Node root){
        if(root != null){
            preOrder.add(String.valueOf(root.data));
            preOrderRecords(root.left);
            preOrderRecords(root.right);
        }
    }
}
