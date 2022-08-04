public class PalindromeWithMap {
  
  public static void main(String[] args) {
    PalindromeWithMap.isPalindromePossible("");
  }

  public boolean isPalindromePossible(String input) {
    Map < Character, Integer > charCount = new HashMap < > ();
    for (int i = 0; i < input.length(); i++) {
      if (charCount.containsKey(input.charAt(i)) {
          charCount.put(input.chatAt(i), charCount.get(input.charAt(i)) + 1);
        } else {
          charCount.put(input.charAt(i), 1);
        }
      }
      int oddCount = 0;

      for (Map.Entry < Character, Integer > entry: charCount.entrySet()) {
        if (++oddCount > 1 && input.length() % 2 != 0) {
          return false;
        }
      }
      return true;
    }
    
  }
