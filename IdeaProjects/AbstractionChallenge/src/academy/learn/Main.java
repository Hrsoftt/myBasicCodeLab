package academy.learn;

public class Main {

    public static void main(String[] args) {

        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String stringData = "7 8 2 5 6 3 4 9 1 0";
        String[] data = stringData.split(" ");
        for (String s : data){
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.traverse((tree.getRoot()));

        tree.removeItem(new Node("6"));
        tree.traverse((tree.getRoot()));

        tree.removeItem(new Node("7"));
        tree.removeItem(new Node("2"));
        tree.removeItem(new Node("9"));
        tree.traverse((tree.getRoot()));

    }
}
