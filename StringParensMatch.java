import java.util.Stack;

public class StringParensMatch {

	public static void main(String[] args) {
		System.out.println(isWellFormed("sd(one{23[ser]}two)sds"));
		System.out.println(isWellFormed("sd(one{23[ser}two)sds"));

	}

	public static boolean isWellFormed(String input) {
		Stack<String> stack = new Stack<>();
		String str = "({[]})";
		boolean match = false;

		for(int i = 0; i< input.length(); i++) {
			String currentStr =  String.valueOf(input.charAt(i));
			//log("start scanning char at ", i);
			//check if character is one I'm interested in
			if(str.contains(currentStr)) {
				if(stack.empty()) {
					//Quit if parens is close type
					if("]})".contains(currentStr)) {
						match = false;
						break;
					}
					stack.push(currentStr);
					log("pushed first char", currentStr);
				} else {
					// Push current string if it is open type
					if("([{".contains(currentStr)) {
						stack.push(currentStr);
						log("pushed subsequent char", currentStr);
					} else {
						if((stack.peek().equals("(")) && (currentStr.equals(")"))) {
							match = true;
							log("found matching open", currentStr);
						} else if((stack.peek().equals("{")) && (currentStr.equals("}"))) {
							match = true;
							log("found matching open", currentStr);
						} else if((stack.peek().equals("[")) && (currentStr.equals("]"))) {
							match = true;
							log("found matching open", currentStr);
						} else {
							match = false;
							log("found non-matching open", currentStr);
							break;
						}
						stack.pop();
					}
				}
				
			}	
		}

		return match;
		
	}

	public static void log(String msg, String str) {
		System.out.println(msg + ":" + str);
	}
	
}