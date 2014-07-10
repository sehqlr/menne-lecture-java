/**
 * Mario, a half-pyramid builder
 * by sehqlr
 * for Menne's CS50 LaunchCode Java class
 */

package pyramid;

public class Mario {

	private final String SP = " ";
	private final String BR = "#";
	private final String NL = "\n";
	
	private int num_rows;
	private StringBuilder pyramid = new StringBuilder();
	
	public Mario(int height) {
		num_rows = height;
	}
	
    public void buildRow(int num_sp, int num_br) {
        // count down for spaces
        for (int s = num_sp; s > 0; s--)
            pyramid.append(SP);
        // count up for bricks
        for (int b = 0; b < num_br; b++)
            pyramid.append(BR);
    }

    public void buildPyramid() {
        for (int i = 0; i < num_rows; i++) {
            int num_sp = num_rows - i;
            int num_br = 2 + i;
            buildRow(num_sp, num_br);
            pyramid.append(NL);
        }
        System.out.print(pyramid.toString());
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // validate user input
        int height;

        if (args.length == 0) {
            System.out.println("Usage: java Mario height");
            return;
        }

        try {
            height = Integer.parseInt(args[0]); 
        } catch (NumberFormatException nFE) {
            System.out.println("Height must be an integer.");
            return;
        }

        if (height < 0 || height > 23) {
            System.out.println("Sorry, height must be between 0 and 23");
            return;
        }

        // construct objects, and print pyramid
        Mario mario = new Mario(height);
        mario.buildPyramid();
    }
}

