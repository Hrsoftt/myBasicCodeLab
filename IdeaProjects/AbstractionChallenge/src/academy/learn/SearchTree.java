package academy.learn;

import java.util.List;

public class SearchTree implements NodeList{
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            // the tree was empty, so our item becomes the head of the tree
            this.root = newItem;
            return true;
        }

        //otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0){
                if (currentItem.next()!=null){
                    currentItem = currentItem.next();
                }else{
                    currentItem.setNext(newItem);
                    return true;
                }

            }else if (comparison > 0){
                // newItem is less,move left if possible
                if (currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }else {
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }
        }return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item!= null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if (comparison <0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            }else if (comparison>0){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }else{
                performRemoval(currentItem, parentItem);
                return true;
            }
        }return false;
    }

    private void performRemoval(ListItem item, ListItem parent){
        //remove item from the tree
        if (item.next() ==null){
            //no right tree, so make parent point t left tree(which may be null)
            if (parent.next() == item){
                //item is right
                parent.setNext(item.previous());
            }else if (parent.previous() == item){
                //item is left
                parent.setPrevious(item.next());
            }else {
                // Again, we are deleting the root
                this.root = item.next();
            }
        }else{
            // not left nor right are null
            ListItem current = item.next();
            ListItem leftmostPatent = item;
            while(current.previous() != null){
                leftmostPatent = current;
                current = current.previous();
            }
            // Now put the smallest value int our node to be deleted
            item.setValue(current.getValue());
            // and delete the smallest
            if (leftmostPatent == item) {
                //there was no leftmost node, so "current" points to the smallest
                //node (the one that must now be deleted).
                item.setNext(current.next());
            }else {
                // set the smallest node's parent to point to
                //the smallest node's right child (which may be null)
                leftmostPatent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        // recursive method
        if (root != null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }
}
