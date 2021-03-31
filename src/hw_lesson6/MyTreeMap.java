package hw_lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap <Key extends Comparable<Key>, Value>{
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
            height = 0;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key не должен быть null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        checkKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        if (value == null) {
            //remove(key)
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        updateHeight(node);

        return node;
    }

    public Key minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key maxKey() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        updateHeight(node);
        return node;
    }

    public void delete(Key key) {
        checkKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        updateHeight(node);
        return node;
    }

    public int getHeight (){
        return height(root);
    }

    private int height(Node node) {
        if (node == null){
            return 0;
        }
        return node.height;
    }

    private int updateHeight (Node node){
        if (node.left == null && node.right == null) {
            return node.height = 0;
        }
        if (node.left != null && node.right == null) {
           return node.height = node.left.height + 1;
        }
        if (node.left == null) {
           return node.height = node.right.height + 1;
        }
        if (node.left.height > node.right.height) {
           return node.height = node.left.height + 1;
        }
        if (node.left.height < node.right.height) {
           return node.height = node.right.height + 1;
        } else
           return node.height = node.left.height + 1;

    }

    boolean isBalanced() {
        if (root == null || root.size == 1) {
            return true;
        } else {
            int leftHeight;
            int rightHeight;

            if (root.left == null) {
                leftHeight = 0;
            } else {
                leftHeight = root.left.height;
            }

            if (root.right == null) {
                rightHeight = 0;
            } else {
                rightHeight = root.right.height;
            }
            return Math.abs(leftHeight - rightHeight) <= 1;
        }
    }


    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " +
                node.key + " = " + node.value + " " +
                toString(node.right);
    }
}


