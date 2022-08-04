import java.util.Stack;

public class SortStackUsingOtherStack {
	public static void main (String[] args) {
		Stack<Integer> input = new Stack<Integer>();
		input.push(5);
		input.push(3);
		input.push(2);
		input.push(1);
		input.push(7);
		Stack<Integer> result = SortStackUsingOtherStack.sortStack(input);
		for(int i : result) {
			System.out.println(i);
        }
  }
    
  //Sort an stack using another stack
  public static Stack<Integer> sortStack(Stack<Integer> inputStack) {
      int n = inputStack.size();
      if(n == 0) {
          return inputStack;
      }
      Stack<Integer> auxStack = new Stack<Integer>();

      while(!inputStack.isEmpty()){
        if(auxStack.isEmpty()) {
          auxStack.push(inputStack.pop());
          } 
          int ele = inputStack.pop();
          while(!auxStack.isEmpty() && auxStack.peek() <= ele) {
            inputStack.push(auxStack.pop());
          }
          if (auxStack.isEmpty() || auxStack.peek() > ele) {
            auxStack.push(ele);
          }
      }
      return auxStack;
  }
}
