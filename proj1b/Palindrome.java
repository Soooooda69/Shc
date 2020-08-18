public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        int l = word.length();
        for (int i = 0; i < l; i++) {
            char c = word.charAt(i);
            wordDeque.addLast(c);
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        Deque origin = wordToDeque(word);
        return isPalindromeHelper(origin);
    }

    public boolean isPalindromeHelper(Deque origin) {

        if (origin.size() <= 1) {
            return true;
        }

        if (origin.removeFirst() != origin.removeLast()) {
            return false;
        }
        return isPalindromeHelper(origin);
    }
    /**the word is a palindrome according to the
     * character comparison test provided by the CharacterComparator.*/
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque origin = wordToDeque(word);
        return isPalindromeHelper(origin,cc);

    }

    private boolean isPalindromeHelper (Deque<Character> origin, CharacterComparator cc) {
        if (origin.size()<=1) {
            return true;
        }
        if (!cc.equalChars(origin.removeFirst(),origin.removeLast())) {
            return false;
        }
        return isPalindromeHelper(origin,cc);
    }
}