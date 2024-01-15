// Ulee K, Iris T, Meira C, Anna F
// CS 3 Summer 2022-2023
// BST Implementation
// A class to create a SearchTree and test methods from the SearchTree class.
// SearchTreeClient
// 7/20/22

import java.util.*;

public class SearchTreeClient {

  /**
   * Tests the binary search tree methods from the SearchTree class.
   * 
   * @param args console input
   */
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    SearchTree<String> names = new SearchTree<>();
    System.out.print("Name (blank to quit)? ");
    String name = console.nextLine();
    while (name.length() > 0) {
      names.add(name);
      System.out.print("Name (blank to quit)? ");
      name = console.nextLine();
    }
    System.out.println();
    System.out.println("Alphabetized list:");
    names.print();
    System.out.println();

    System.out.print("Name to remove (blank to quit)? ");
    name = console.nextLine();
    while (name.length() > 0) {
      names.remove(name);
      System.out.print("Name to remove (blank to quit)? ");
      name = console.nextLine();
    }
    System.out.println();
    System.out.println("Alphabetized list (after removal):");
    names.print();

    // testing print by level
    System.out.println();
    System.out.println("Tree printed level by level (after removal): ");
    names.printByLevel();
    System.out.println();

    // testing recursive search
    System.out.print("Value to search for recursively (blank to quit)? ");
    String valueRecur = console.nextLine();
    if (valueRecur.length() > 0) {
      if (names.searchRecur(valueRecur) == null) {
        System.out.print("The value does not exist.");
        System.out.println();
      } else {
        System.out.println("The SearchTreeNode containing the value is " + names.searchRecur(valueRecur));
      }
    }

    // testing iterative search
    System.out.print("Value to search for iteratively (blank to quit)? ");
    String valueIter = console.nextLine();
    if (valueIter.length() > 0) {
      System.out.println("The SearchTreeNode containing the value is " + names.searchIter(valueIter));
    }
    System.out.println();

    // testing LCA method
    System.out.print(
        "Would you like to find the lowest common ancestor of two nodes? Enter yes or no: ");
    String answer = console.next();
    if (answer.contains("y")) {
      System.out.print("Enter value of node 1: ");
      String node1 = console.next();
      System.out.print("Enter value of node 2: ");
      String node2 = console.next();
      SearchTree.SearchTreeNode<String> lca = names.LCA(names.searchRecur(node1), names.searchRecur(node2));
      System.out.print("The lowest common ancestor is "
          + lca + ", which has a value of " + lca.data + ".");
    }
    System.out.println();

    SearchTree<Integer> numbers = new SearchTree<>();
    System.out.print("Next int (0 to quit)? ");
    int number = console.nextInt();
    while (number != 0) {
      numbers.add(number);
      System.out.print("Next int (0 to quit)? ");
      number = console.nextInt();
    }
    System.out.println();
    System.out.println("Sorted list:");
    numbers.print();
    System.out.println();

    System.out.print("Enter int to remove (0 to quit): ");
    number = console.nextInt();
    while (number != 0) {
      numbers.remove(number);
      System.out.print("Next int to remove (0 to quit)? ");
      number = console.nextInt();
    }
    System.out.println();
    System.out.println("Sorted list (after removal):");
    numbers.print();

    // testing print by level
    System.out.println();
    System.out.println("Tree printed level by level (after removal):");
    numbers.printByLevel();
    System.out.println();

    // testing recursive search
    System.out.print("Value to search for recursively (blank to quit)? ");

    if (console.hasNextInt()) {
      int valueRecur2 = console.nextInt();
      if (numbers.searchRecur(valueRecur2) == null) {
        System.out.print("The value does not exist.");
        System.out.println();
      } else {
        System.out.println("The SearchTreeNode containing the value is " + numbers.searchRecur(valueRecur2));
      }
    }

    // testing iterative search
    System.out.print("Value to search for iteratively (blank to quit)? ");
    if (console.hasNextInt()) {
      int valueIter2 = console.nextInt();
      System.out.println("The SearchTreeNode containing the value is " + numbers.searchIter(valueIter2));
    }

    // testing LCA method
    System.out.print(
        "Would you like to find the lowest common ancestor of two nodes? Enter yes or no: ");
    String answer2 = console.next();
    if (answer2.contains("y")) {
      System.out.print("Enter value of node 1: ");
      int node1 = console.nextInt();
      System.out.print("Enter value of node 2: ");
      int node2 = console.nextInt();
      SearchTree.SearchTreeNode<Integer> lca2 = numbers.LCA(numbers.searchRecur(node1), numbers.searchRecur(node2));
      System.out.print("The lowest common ancestor is "
          + lca2 + ", which has a value of " + lca2.data + ".");
      System.out.println();

    }

    console.close();
  }
}