package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node {
    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class Tree {
    public Node root;

    public void addNode(int value) {
        if (root == null) {
            Node node = new Node();
            node.setValue(value);
            root = node;
        } else {
            addNode(value, root);
        }
    }

    public void addNode(int value, Node root) {
        if (value <= root.getValue()) {
            if (root.getLeft() == null) {
                Node node = new Node();
                node.setValue(value);
                root.setLeft(node);
            } else {
                addNode(value, root.getLeft());
            }
        } else {
            if (root.getRight() == null) {
                Node node = new Node();
                node.setValue(value);
                root.setRight(node);
            } else {
                addNode(value, root.getRight());
            }
        }
    }

    public void printTree() {
        postorder(root);
    }

    public void postorder(Node root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.println(root.getValue());
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        Tree tree = new Tree();

//        int index = 0;

//        List<Integer> preorder_tree = new ArrayList<>();

        while (sc.hasNextLine() && !(str = sc.nextLine()).equals("")) {
            tree.addNode(Integer.parseInt(str));
//            preorder_tree.add(Integer.parseInt(str));
        }

        tree.printTree();
//        preorderTopostorder(preorder_tree);
    }
}
/** 트리 안만들고 전위-> 후위 나중에 다시 해보기 **/
//    public static void preorderTopostorder(List<Integer> list) {
//        int right_tree_index = partition(list);
//
//        postorder(list.subList(1, right_tree_index));
//        postorder(list.subList(1, list.size()));
//
//        System.out.println(list.get(0));
//    }
//
//    public static int partition(List<Integer> list) {
//        int index = 0;
//        while(list.get(0) > list.get(++index));
//
//        return index;
//    }
//
//    public static void postorder(List<Integer> list) {
//        int[] postorder = new int[list.size()];
//        int min_index = list.indexOf(Collections.min(list));
//        int postorder_index = list.size() - 1;
//
//        postorder[0] = list.get(min_index);
//
//        for(int i = 0; i <= min_index; i++) {
//            postorder[postorder_index--] = list.get(i);
//
//            postorder_index = getFirstBigNum(i, list, postorder_index, postorder);
//        }
//
//        for(int num: postorder) {
//            System.out.println(num);
//        }
//
//        list.clear();
//    }
//
//    public static int getFirstBigNum(int index, List<Integer> list, int postorder_index, int[] postorder) {
//        int result_index = index + 1;
//
//        while(result_index < list.size()) {
//            if(list.get(index) < list.get(result_index)) {
//                int input_num = list.get(result_index);
//                postorder[postorder_index--] = input_num;
//                postorder_index = getFirstBigNum(result_index, list, postorder_index, postorder);
//                list.remove(result_index);
//                postorder_index = getFirstBigNum(index, list, postorder_index, postorder);
//                break;
//            }
//            result_index++;
//        }
//
//        return postorder_index;
//    }

