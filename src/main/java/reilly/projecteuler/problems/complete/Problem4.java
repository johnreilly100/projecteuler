package reilly.projecteular.problems.complete;

class Problem4 {
	public static void main(String[] args) {
		int result = 0;

		for (int x = 999; x >= 100; x--) {
			for (int y = 999; y >= 100; y--) {
				int temp = x * y;
					if ( checkIfpalindromic(temp) ) {
						if ( temp > result ) {
							result = temp;
						}
					}
			}
		}
		System.out.println("result = " +result);
	}

	public static boolean checkIfpalindromic( int number ) {
		String str = String.valueOf(number);
		char[] ch = str.toCharArray();;
		if (ch.length % 2 == 0) {
			if ( evenNumber(ch) ) {
				return true;
			}
		} else {
			if ( oddNumber(ch) ) {
			return true;
			}
		}
		return false;
	}

	public static boolean evenNumber(char[] ch) {
		for (int i = 0; i < (ch.length / 2); i++) {
			if (ch[i] != ch[ch.length -(i+1)]) {
				return false;
			}
		}
		return true;
	}

	public static boolean oddNumber(char[] ch) {
		for (int i = 0; i < (ch.length / 2); i++) {
			if (ch[i] != ch[ch.length -(i+1)]) {
				return false;
			}
		}
		return true;
	}
}
