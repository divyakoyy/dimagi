package dimagi;

public class DimagiProblem {

	/**
	 * Translates an integer to its spoken language representation
	 * @param input, a non-negative integer (includes 0)
	 * @return string that represents the spoken representation of the input
	 */

	public String intToSpoken(long input) {
		String[] firstTwenty = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] byTen = { "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		String[] byThreeDec = { "thousand", "million", "billion", "trillion","quadrillion","quintillion"};

		if (input < 20) return firstTwenty[(int) input];
		String sequence = Long.toString(input);
		StringBuilder sb = new StringBuilder();
		boolean threeConsecZeroes = false;					// used to keep track of zeroes such as the middle three in 6,000,000, so we don't add the word "thousand"

		for (int i = 0; i < sequence.length(); i++) {
			int decimalPos = sequence.length() - i - 1;
			char curr = sequence.charAt(i);
		
			if (curr != '0') {
				if (decimalPos == 0) {
					sb.append(firstTwenty[curr - 48]);
				}
				
				else {
					threeConsecZeroes = true;
					// thousand, million, billion,...
					if (decimalPos % 3 == 0) {
						sb.append(firstTwenty[curr - 48]);
					} 
					// ten thousand, ten million, ten billion,...
					else if (decimalPos % 3 == 1) {
						sb.append(byTen[curr - 49]);
					} 
					// hundred thousand, hundred million, hundred billion,...
					else if (decimalPos % 3 == 2) {
						sb.append(firstTwenty[curr - 48]);
						sb.append(" hundred");
					}	
				}
				
				sb.append(" ");	
			}
			if (decimalPos % 3 == 0 && decimalPos != 0 && threeConsecZeroes) {
				sb.append(byThreeDec[decimalPos / 3 - 1]);
				sb.append(" ");	
				threeConsecZeroes = false;
			}

		}
		return sb.toString().trim();
	}
	public static void main(String[] args){
		DimagiProblem d = new DimagiProblem();
		System.out.println(d.intToSpoken(Long.MAX_VALUE));
	}
	

	
}
