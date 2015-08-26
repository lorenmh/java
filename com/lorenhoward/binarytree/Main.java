package com.lorenhoward.binarytree;

public class Main {
  public static void main( String[] args ) {
    System.out.println( "Worked" );

    BinaryTree bt = new BinaryTree();
    bt.insert(5);
    bt.insert(2);
    bt.insert(7);
    bt.insert(3);
    bt.insert(3);
    bt.insert(0);
    bt.insert(1);

    bt.inOrderPrint();
    System.out.println();

    bt.deleteNode( bt.search( 7 ) );
    bt.deleteNode( bt.search( 5 ) );
    bt.deleteNode( bt.search( 3 ) );

    bt.inOrderPrint();
  }
}
