package tree.traversal;

import tree.BaseBinaryTree;
import tree.TreeLinkNode;

public class PopulatingNextRightPointersII {
    public void connect(TreeLinkNode root) {
        if(root == null) return;

        TreeLinkNode lastHead = root;
        TreeLinkNode lastCurrent ;
        TreeLinkNode currentHead = null;
        TreeLinkNode current = null;

        while(lastHead != null) {
            lastCurrent = lastHead;

            while(lastCurrent != null) {
                if(current == null) {
                    if (lastCurrent.left != null) {
                        current = lastCurrent.left;
                        currentHead = current;
                    }
                    if (lastCurrent.right != null && current == null) {
                        current = lastCurrent.right;
                        currentHead = current;
                    }
                }

                if (lastCurrent.left != null && lastCurrent.left != current) {
                    current.next = lastCurrent.left;
                    current = current.next;
                }
                if (lastCurrent.right != null && lastCurrent.right != current) {
                    current.next = lastCurrent.right;
                    current = current.next;
                }

                lastCurrent = lastCurrent.next;
            }

            lastHead = currentHead;
            currentHead = current = null;
        }
    }



    public static void main(String[] args) {
        Integer[] tokens = {1,2, 3, 4, 5, 6, 7, 8};

        TreeLinkNode root = new BaseBinaryTree().createTreeWithNext(tokens);
        new PopulatingNextRightPointersII().connect(root);
    }
}
