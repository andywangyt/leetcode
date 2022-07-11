/**
 * Time Complexity: O(3*L + N^2) = O(Split + Substring + Adding word to sb +
 * Adding suffix to sb)
 *
 * Space Complexity: O(L + N^2 + N) = O(Input string + Suffix for all words +
 * Suffix sb)
 *
 * L = Length of the input string. N = Number of words in the input string.
 */
class Solution {
    private static final HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder suffix = new StringBuilder("a");

        for (String w : S.split(" ")) {
            if (sb.length() != 0) {
                sb.append(" ");
            }

            char fChar = w.charAt(0);
            if (vowels.contains(fChar)) {
                sb.append(w);
            } else {
                sb.append(w.substring(1));
                sb.append(fChar);
            }

            sb.append("ma").append(suffix);

            suffix.append("a");
        }

        return sb.toString();
    }
}