package csc402;
import stdlib.*;


public class BalancedPunctuation {
	
	public static boolean balanceCheck(String target) {
		Stack<String> checkStack  = new Stack<>();
		
		for (char x: target.toCharArray()) {
			String t = String.valueOf(x);
			if((t.equals("(")) || (t.equals("{")) || (t.equals("["))) {
				checkStack.push(t);

			} else if (t.equals(")")) {
				if (!checkStack.pop().equals("(")) {
					return false;
				}
			} else if (t.equals("}")) {
				if (!checkStack.pop().equals("{")) {
					return false;
				}
			} else if (t.equals("]")) {
				if (!checkStack.pop().equals("[")) {
					return false;
				}
			}
			
		}
		if(checkStack.isEmpty()) {
			return true;	
		} else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String target = StdIn.readString();
		boolean result = balanceCheck(target);
		StdOut.print(result);

	}

}
