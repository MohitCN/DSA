public class LetterConstructionWithMap {
  public static void main(String[] args) {
    LetterConstructionWithMap.isletterConstructible("", "");
  }

  public static boolean isletterConstructible(String Letter, String magzine) {
    Map < Character, Integer > countFrequency = new HashMap < > ();
    for (int i = 0; i < letter.length(); i++) {
      char c = letter.charAt(i);
      if (countFrequency.containsKey(c)) {
        countFrequency.put(c, ++countFrequency.get(c));
      } else {
        countFrequency.put(c, 1);
      }
    }

    for (int i = 0; i < magzine.length(); i++) {
      char c = magzine.charAt(i);
      if (countFrequency.containsKey(c)) {
        countFrequency.get(c, --countFr equency.get(c));
        if (countFrequency.get(c) == 0) {
          countFrequency.remove(c);
          if (countFrequency.isEmpty()) {
            break;
          }
        }
      }
    }

    return countFrequency.isEmpty();
  }

}
