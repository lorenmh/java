package com.lorenhoward.binarytree;

public class Node {
  private int mKey;
  private Node mParent, mLeft, mRight;

  public Node() {
  }

  public Node( int key ) {
    mKey = key;
  }

  public Node( int key, Node parent ) {
    mKey = key;
    mParent = parent;
  }

  public Node( int key, Node parent, Node left, Node right ) {
    mKey = key;
    mParent = parent;
    mLeft = left;
    mRight = right;
  }

  public int getKey() {
    return mKey;
  }

  public void setKey( int key ) {
    mKey = key;
  }

  public Node getParent() {
    return mParent;
  }

  public void setParent( Node parent ) {
    mParent = parent;
  }

  public Node getLeft() {
    return mLeft;
  }

  public void setLeft( Node left ) {
    mLeft = left;
  }

  public Node getRight() {
    return mRight;
  }

  public void setRight( Node right ) {
    mRight = right;
  }
}
