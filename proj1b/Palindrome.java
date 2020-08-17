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
        Deque<Character> wordDeque = new LinkedListDeque<>();
        int l = word.length();
        Deque origin = wordToDeque(word);

        if (l == 0 || l == 1) {
            return true;
        }
        for (int i = 0; i <= l / 2; i++) {
            if (origin.get(i) == origin.get(l - 1 - i)) {
                return true;
            }
            return false;
        }
        return false;
    }
}