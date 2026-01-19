public class TST {
    private TSTNode root;
    public TST() {
        root = new TSTNode();
        root.setLetter('m');
        // Near the middle of the alphabet so less average depth
    }
    public void insert (String s) {
        // Calls helper method
        insertHelper(s,root,0);
    }

    public TSTNode insertHelper(String s, TSTNode node, int index) {
        char letter = s.charAt(index);
        // The node is part of the TST structure because I start from the root,
        // Meaning that it is some child or distant child of the root
        if (node == null) {
            node = new TSTNode();
            node.setLetter(letter);
        }
        // Checks to know whether to go right or left based off of letter value (assumes all lower case)
        if (letter > node.getLetter()) {
            // Sets the right to insertHelper because it returns the node, so if the right is originally null then it will
            // Become the right letter and not null, and if it is already a letter nothing will change
            node.setRight(insertHelper(s,node.getRight(),index));
        }
        else if (letter < node.getLetter()) {
            node.setLeft(insertHelper(s,node.getLeft(),index));
        }
        else {
            // Checks if it got to end of the word
            // Which would happen if the word was already inserted or if the path was already there
            if (index == s.length() - 1) {
                node.setWord(true);
            }
            else {
                // This happens when it finds the right letter, meaning that it can go further down the path,
                // So it can check the next letter
                node.setMiddle(insertHelper(s,node.getMiddle(),index+1));
            }
        }
        return node;
    }

    public boolean lookup (String s) {
        return lookupHelper(s,root,0);
    }

    public boolean lookupHelper(String s, TSTNode node, int index) {
        char letter = s.charAt(index);
        if (node == null) {
            return false;
        }

        if (letter > node.getLetter()) {
            return lookupHelper(s,node.getRight(),index);
        }

        else if (letter < node.getLetter()) {
            return lookupHelper(s,node.getLeft(),index);
        }

        else {
            if (index == s.length() - 1) {
                return node.isWord();
            }
            return lookupHelper(s,node.getMiddle(),index + 1);
        }
    }

    public boolean isPrefix(String s) {
        return prefixHelper(s,root,0);
    }

    public boolean prefixHelper(String s, TSTNode node, int index) {
        char letter = s.charAt(index);
        if (node == null) {
            return false;
        }
        if (letter > node.getLetter()) {
            return prefixHelper(s,node.getRight(),index);
        }
        else if (letter < node.getLetter()) {
            return prefixHelper(s,node.getLeft(),index);
        }
        else {
            if (index == s.length() - 1) {
                return true;
            }
            return prefixHelper(s, node.getMiddle(),index + 1);
        }
    }


}
