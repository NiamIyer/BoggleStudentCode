public class TSTNode {
    private boolean isWord;
    // Hss a left middle and right because it doesn't need all 256 indices
    private TSTNode left;
    private TSTNode middle;
    private TSTNode right;
    private char letter;
    public TSTNode() {
        isWord = false;
        left = null;
        middle = null;
        right = null;
        letter = 0;
    }
    public boolean isWord() {
        return isWord;
    }
    public void setWord(boolean word) {
        isWord = word;
    }

    public TSTNode getLeft() {
        return left;
    }

    public void setLeft(TSTNode left) {
        this.left = left;
    }

    public TSTNode getMiddle() {
        return middle;
    }

    public void setMiddle(TSTNode middle) {
        this.middle = middle;
    }

    public TSTNode getRight() {
        return right;
    }

    public void setRight(TSTNode right) {
        this.right = right;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
