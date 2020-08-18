import edu.princeton.cs.algs4.CC;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("C:/Users/Administrator/Shc/library-sp19/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByN(19);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word,cc)) {
                System.out.println(word);
            }
        }
    }
}
