package csc402;

import stdlib.In;
import stdlib.StdIn;
import stdlib.StdOut;

public class ParseXML {
	
	public static String[] checkChars(String target) {
		String[] result = new String[4];
		
		result[0] = String.valueOf(target.charAt(0));
		result[1] = String.valueOf(target.charAt(1));
		result[2] = String.valueOf(target.charAt(target.length()-2));
		result[3] = String.valueOf(target.charAt(target.length()-1));
		
		return result;
	}
	
	public static String tagName(String token) {
		if(!isTag(token)) {
			return null;
		}
		if( isClosingTag(token) ) {
			return token.substring(2, token.length()-1);
		} else if ( isSelfClosingTag(token) ) {
			return token.substring(1, token.length()-2);
		} else if ( isOpeningTag(token) ) {
			return token.substring(1, token.length()-1);
		} else {
			return null;
		}
	}
	
	public static boolean isTag(String token) {
		//This returns true if and only if the token passed as a parameter is a tag, 
		//as opposed to being a word;
		String[] target = checkChars(token);
		if( (target[0].equals("<")) && (target[3].equals(">")) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isWord(String token) {
		//This returns true if and only if the token is a word.
		return !isTag(token);
	}
	
	public static boolean isClosingTag(String token) {
		//This returns true if and only if the token is a closing tag;
		String[] target = checkChars(token);
		if( (target[1].equals("/")) && (target[0].equals("<")) && (target[3].equals(">")) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isSelfClosingTag(String token) {
		//This returns true if and only if the token is a self-closing tag.
		String[] target = checkChars(token);
		if( (target[2].equals("/")) && (target[0].equals("<")) && (target[3].equals(">")) ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isOpeningTag(String token) {
		if( (isTag(token)) && (!isClosingTag(token))  && (!isSelfClosingTag(token)) ) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
		String dataSource = StdIn.readString();
        final In in = new In(dataSource);
        if (!in.exists ()) {
        	StdOut.println("Unable to open the text source " + dataSource);
            System.exit (1);
        }
        
		String[]inpt = in.readAllStrings();	
		
		Stack<String> tagNames = new Stack<>();		
		
		for (int i = 0; i < inpt.length; i++) {
			String c = inpt[i];
			
			if(isOpeningTag(c)) {
				System.out.println(c);
				tagNames.push(c);
			} else if (isClosingTag(c)) {
				System.out.println(c);
				if (tagNames.isEmpty()) {
					System.out.println("a closing tag has no matching opening tag and print that closing tag");
					return;
				}
				String target = tagName(tagNames.pop());
				if(!target.equals(tagName(c))) {
					System.out.println("a closing tag does not match its opening tag and print that closing tag");
					System.exit (1);
					return;
				}
			} else {
				System.out.println(c);
			}
		}
		
		if(!tagNames.isEmpty()) {
			System.out.println("there are opening tags with no matching closing tags and print all of those opening tags");
		}
	}
}
