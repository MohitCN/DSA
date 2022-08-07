class StockSpanner {

  class Span {
    int price;
    int count;

    Span(int price, int count) {
      this.price = price;
      this.count = count;
    }
  }
  ArrayDeque < Span > helperStack;

  public StockSpanner() {
    helperStack = new ArrayDeque < > ();
  }

  public int next(int price) {

    int span = 1;

    while (!helperStack.isEmpty() &&
      price >= helperStack.peek().price) {
      span = span + helperStack.peek().count;
      helperStack.pop();
    }

    if (helperStack.isEmpty()) {
      helperStack.push(new Span(price, span));
    } else if (price < helperStack.peek().price) {
      helperStack.push(new Span(price, span));
    }
    return span;

  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/*  If working with storing indexes and getting the spoan as diff between the indexes
    public static int[] stockSpan(int[] input) {
        int n = input.length;

        int[] result = new int[n];
        Stack<Integer> helperStack = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!helperStack.isEmpty()
                    && input[i] >= input[helperStack.peek()]) {
                helperStack.pop();
            }

            if(helperStack.isEmpty()) {
                helperStack.push(i);
            } else if(input[i] < input[helperStack.peek()]) {
                result[i] = i - helperStack.peek();
                helperStack.push(i);
            }
        }
    }*/
