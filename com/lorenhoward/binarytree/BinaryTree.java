package com.lorenhoward.binarytree;

public class BinaryTree {
  private Node mRoot;

  public BinaryTree() {
  }

  public Node getRoot() {
    return mRoot;
  }

  public void setRoot( Node root ) {
    mRoot = root;
  }

  private Node minNode( Node node ) {
    if ( node.getLeft() == null ) {
      return node;
    }
    return minNode( node.getLeft() );
  }

  private Node maxNode( Node node ) {
    if ( node.getRight() == null ) {
      return node;
    }
    return maxNode( node.getRight() );
  }

  public int min() {
    return maxNode( mRoot ).getKey();
  }

  public int max() {
    return maxNode( mRoot ).getKey();
  }

  private Node searchNode( Node node, int key ) {
    if ( node == null || node.getKey() == key ) {
      return node;
    }

    if ( key > node.getKey() ) {
      return searchNode( node.getRight(), key );
    } else {
      return searchNode( node.getLeft(), key );
    }
  }

  public Node search( int key ) {
    return searchNode( mRoot, key );
  }

  private void insertNode( Node node, int key ) {
    if ( key > node.getKey() ) {
      if ( node.getRight() == null ) {
        Node newNode = new Node( key, node );
        node.setRight( newNode );
      } else {
        insertNode( node.getRight(), key );
      }
    } else {
      if ( node.getLeft() == null ) {
        Node newNode = new Node( key, node );
        node.setLeft( newNode );
      } else {
        insertNode( node.getLeft(), key );
      }
    }
  }

  public void insert( int key ) {
    if ( mRoot == null ) {
      mRoot = new Node( key );
    } else {
      insertNode( mRoot, key );
    }
  }

  private void inOrderPrintNode( Node node ) {
    if ( node != null ) {
      inOrderPrintNode( node.getLeft() );
      System.out.println( node.getKey() );
      inOrderPrintNode( node.getRight() );
    }
  }

  public void inOrderPrint() {
    inOrderPrintNode( mRoot );
  }

  private void transplant( Node node, Node replacement ) {
    if ( node.getParent() != null ) {
      if ( node == node.getParent().getLeft() ) {
        node.getParent().setLeft( replacement );
      } else {
        node.getParent().setRight( replacement );
      }
    }

    if ( replacement != null ) {
      replacement.setParent( node.getParent() );
    }
  }

  public void deleteNode( Node node ) {
    if ( node.getLeft() == null ) {
      transplant( node, node.getRight() );
    } else if ( node.getRight() == null ) {
      transplant( node, node.getLeft() );
    } else {
      Node replacement = minNode( node.getRight() );
      if ( replacement != node.getRight() ) {
        transplant( replacement, replacement.getRight() );
        replacement.setRight( node.getRight() );
        node.getRight().setParent( replacement );
      }
      transplant( node, replacement );
      replacement.setLeft( node.getLeft() );
      node.getLeft().setParent( replacement );
    }
  }
}
