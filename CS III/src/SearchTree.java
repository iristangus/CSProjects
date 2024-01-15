// Ulee K, Iris T, Meira C, Anna F
// CS 3 Summer 2022-2023
// BST Implementation
// A class to store, print, and perform various operations on a binary tree of type E.
// SearchTree
// 7/20/22

/*
 * For BST Implementation:
 * Ulee -  Worked on the findSmallest, print, and printInOrder methods.
 * Anna - Worked on the two remove methods.
 * Iris - Worked on the two contain methods.
 * Meira - Worked on the two add methods and constructor.
 *
 * All group members also helped with commenting and debugging.
 */

/*
 * For Graph Theory Project:
 * Ulee - Worked on the iterative search method.
 * Anna - Worked on the recursive search method.
 * Iris - Worked on the LCA method.
 * Meira - Worked on the method that prints the tree level by level.

 * All group members also helped with commenting and debugging.
 */

import java.util.*;

public class SearchTree<E extends Comparable<E>> {
  private SearchTreeNode<E> overallRoot; // root of overall tree

  // Meira
  // post: constructs an empty search tree search tree
  /**
   * A constructor for a SearchTree object.
   */
  public SearchTree() {
    overallRoot = null;

  }

  // post: value added to tree so as to preserve binary search tree
  /**
   * Calls add method to add a value to the tree
   * 
   * @param value the value to be added to the tree
   */
  public void add(E value) {
    overallRoot = add(overallRoot, value);
  }

  // post: value added to tree so as to preserve binary search tree
  /**
   * Recursively adds a value to a tree by searching the tree for the value
   * (ensuring it's not a duplicate). Compares node to existing values to
   * eventually add it into the tree
   *
   * @param root  the root of the tree containing the node to be added
   * @param value the value to be added
   * @return updated root node
   */
  private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
    if (root == null) {
      root = new SearchTreeNode<E>(value);
    }
    if (root.data.compareTo(value) > 0) {
      root.left = add(root.left, value);
    } else if (root.data.compareTo(value) < 0) {
      root.right = add(root.right, value);
    }
    return root;
  }

  // Iris
  // post: returns true if tree contains value, returns false otherwise
  /**
   * Calls the contains() method with the overallRoot Checks if a search tree
   * contains a value
   *
   * @param value value to be found in the search tree
   * 
   * @return whether the value exists or not
   */
  public boolean contains(E value) {
    return (contains(overallRoot, value));
  }

  // post: returns true if given tree contains value, returns false otherwise
  /**
   * Checks if the current node is equal to the value we want to find If so,
   * returns true If not, runs itself again with a child node If the node is null,
   * the search tree has been exhausted and the value doesn't exist
   *
   * @param root  the node being checked
   * 
   * @param value the value to be found
   * 
   * @return whether the value exists in the search tree
   */
  private boolean contains(SearchTreeNode<E> root, E value) {
    if (root == null) {
      // No such root exists, and the value doesn't exist in the tree
      return false;
    } else if (root.data.compareTo(value) > 0) {
      // The root is greater than the value we are trying to find
      // Runs contains() again with the node to the left, which is smaller
      return contains(root.left, value);
    } else if (root.data.compareTo(value) < 0) {
      // The root is less than the value we are trying to find
      // Runs contains() again with the node to the right, which is bigger
      return contains(root.right, value);
    } else {
      // If root.data equals the value
      return true;
    }

  }

  // Anna
  // post: value removed from tree so as to preserve binary search tree
  /**
   * Calls a remove method to remove a value from the tree and reassigns the tree
   * to the tree with the value deleted.
   *
   * @param value the value to be removed from the tree
   */
  public void remove(E value) {
    overallRoot = remove(overallRoot, value);
  }

  // post: value removed to tree so as to preserve binary search tree
  /**
   * Recursively deletes a value from a tree first by searching the tree for the
   * value. Replaces the node with its inorder successor or null if it has no
   * children
   *
   * @param root  the root of the tree containing the node to be deleted
   * @param value the value to be deleted
   * @return a null value to delete a node
   */
  private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {

    if (root == null) { // Base case
      return null;

      // Searching the tree for the value to be removed
    } else if (root.data.compareTo(value) > 0) {
      root.left = remove(root.left, value);
    } else if (root.data.compareTo(value) < 0) {
      root.right = remove(root.right, value);

    } else { // If (root.data == value), e.g. the value is found
      if (root.right == null) {
        return root.left; // Deleting node and replacing it with its left child
      } else if (root.left == null) {
        return root.right; // Deleting node and replacing it with its right child
      } else {
        root.data = findSmallest(root.right); // Find inorder successor
        root.right = remove(root.right, root.data); // Replace node with inorder successor
      }
    }
    return root;
  }

  // Ulee
  // post: return the smallest value in the binary search tree
  /**
   * Finds the smallest value within a binary search tree
   * 
   * @param root is a searchtree node that is used to scan the entire tree
   * 
   * @return E is the smallest value of a node in the tree
   */
  private E findSmallest(SearchTreeNode<E> root) {
    if (root.left == null) {
      return root.data; // Wait until we reach the end where the reference will be null
    } else { // We take the top root, and keep shifting it left
      root = root.left; // The further left we get, the smaller values we get
      return findSmallest(root); // Then we call findSmallest with the new root inside ->
                                 // recursion
    }
  }

  // post: prints the data of the tree, one per line
  /**
   * Prints out the results of a binary search tree
   */
  public void print() {
    // We use this method to call private methods such as printInorder and
    // findSmallest to get info about the binary search tree
    printInorder(overallRoot);
    System.out.println();
  }

  // post: prints the data of the tree using an inorder traversal
  /**
   * Uses a binary search tree and prints it within a sorted/inOrder form
   * (Scanning left most node to right)
   * 
   * @param root is the top root node
   */
  private void printInorder(SearchTreeNode<E> root) {
    // TO DO:
    if (root != null) { // We start from the top most node and keep going down until root is
                        // equal to
                        // null, if the node does not equal null then we can keep scanning for
                        // values
      printInorder(root.left); // for print inorder we need to format left node, node value,
                               // right node
      System.out.print(root.data + " ");
      printInorder(root.right);
    }
  }

  /**
   * Prints the binary search tree level by level.
   */
  public void printByLevel() {
    List<List<E>> resSet = new ArrayList<>();

    // checking that the root is not null
    if (overallRoot == null) {
      return;
    }

    Queue<SearchTreeNode<E>> queue = new ArrayDeque<>();
    queue.offer(overallRoot);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<E> res = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        SearchTreeNode<E> cur = queue.poll();
        res.add(cur.data);
        if (cur.left != null) { // if left subtree exists
          queue.offer(cur.left);
        }
        if (cur.right != null) { // if right subtree exists
          queue.offer(cur.right);
        }
      }
      resSet.add(res);
    }

    // printing the result
    for (List<E> list : resSet) {
      for (E i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }

  /**
   * Initiates the search for a value by calling the searchRecur method with the
   * overall root and the desired value.
   *
   * @param value the value to be searched for
   * @return the SearchNode containing the value or null
   */
  public SearchTreeNode<E> searchRecur(E value) {
    return searchRecur(overallRoot, value);

  }

  /**
   * Recursively searches for a value in a binary tree.
   *
   * @param root  the current root being compared to the value
   * @param value the value that is being searched for
   * @return the node in the tree containing the value or null if the value does
   *         not exist
   */
  private SearchTreeNode<E> searchRecur(SearchTreeNode<E> root, E value) {
    if (root == null) {
      return null;
    } else if (root.data.compareTo(value) == 0) { // value is found
      return root;
    } else if (root.data.compareTo(value) > 0) {
      return searchRecur(root.left, value); // search left subtree
    } else if (root.data.compareTo(value) < 0) {
      return searchRecur(root.right, value); // search right subtree
    }

    return root;
  }

  /**
   * Iteratively searches for a value in a binary tree.
   *
   * @param value is the value being searched for
   * @return the SearchTreeNode containing the value
   */
  public SearchTreeNode<E> searchIter(E value) {
    if (overallRoot == null) {
      return null;
    }
    Queue<SearchTreeNode<E>> q = new LinkedList<SearchTreeNode<E>>();
    q.offer(overallRoot);
    while (q.size() > 0) {
      SearchTreeNode<E> node = q.peek();
      if (node.data.compareTo(value) == 0)
        return node;
      q.poll();
      if (node.left != null) {
        q.offer(node.left);
      }
      if (node.right != null) {
        q.offer(node.right);
      }
    }
    return null;
  }

  /**
   * Returns the lowest common ancestor of two SearchTreeNodes.
   *
   * @param one any SearchTreeNode in the tree
   * @param two any SearchTreeNode in the tree
   * @return the LCA of the two SearchTreeNodes
   */
  public SearchTreeNode<E> LCA(SearchTreeNode<E> one, SearchTreeNode<E> two) {
    // Runs the recursive LCA method with the overallRoot
    return LCA(overallRoot, one, two);
  }

  /**
   * A private method to find the LCA of two SearchTreeNodes.
   *
   * @param root the root of the tree or a subtree
   * @param one  a SearchTreeNode in the tree 
   * @param two  a SearchTreeNode in the tree
   *
   * @return the LCA of the two SearchTreeNodes
   */
  private SearchTreeNode<E> LCA(SearchTreeNode<E> root, SearchTreeNode<E> one,
      SearchTreeNode<E> two) {
    // The node doesn't exist, returns null
    if (root == null) {
      return null;
    } else if (root == one || root == two) {
      // If the root is one of the nodes being searched for
      return root;
    }

    // The values when the children nodes are run
    SearchTreeNode<E> left = LCA(root.left, one, two);
    SearchTreeNode<E> right = LCA(root.right, one, two);

    // If neither of the children have anything, the node is null
    if (left == null && right == null) {
      return null;
    } else if (left == null) {
      // If right has something but left is null, return right
      return right;
    } else if (right == null) {
      // If left has something but right is null, return left
      return left;
    } else {
      // If both children have values, the node is the LCA and is returned
      return root;
    }
  }

  public static class SearchTreeNode<E> {
    /**
     * Data stored in this node.
     */
    public E data; // data stored in this node
    /**
     * The left subtree.
     */
    public SearchTreeNode<E> left; // left subtree
    /**
     * The right subtree.
     */
    public SearchTreeNode<E> right; // right subtree

    /**
     * Constructs a node with given data.
     * 
     * @param data the data to be stored in the node
     */
    public SearchTreeNode(E data) {
      this(data, null, null);
    }

    /**
     * Constructs a node with given data and links.
     * 
     * @param data  the data to be stored in the node
     * @param left  the link to the left node
     * @param right the link to the right node
     */
    public SearchTreeNode(E data, SearchTreeNode<E> left, SearchTreeNode<E> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
}