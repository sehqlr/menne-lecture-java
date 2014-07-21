package pyramid;

public class HeightValidator implements TestIO {

	public HeightValidator(String s) {}

	/* (non-Javadoc)
	 * @see pyramid.TestIO#validate(java.lang.String[])
	 */
	@Override
	public boolean validate(String[] args) {
	    	
		int input;

		if (args.length == 0) {
			System.out.println("Usage: java Mario height");
			return false;
		}

		try {
			input = Integer.parseInt(args[0]); 
		} catch (NumberFormatException nFE) {
			System.out.println("Height must be an integer.");
			return false;
		}

		if (input < 0 || input > 23) {
			System.out.println("Sorry, height must be between 0 and 23");
			return false;
		}
		
		/* if all tests are passed, input must be valid */
		return true;
	}

}