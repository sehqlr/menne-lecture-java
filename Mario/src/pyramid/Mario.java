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
    
	public int getNum_rows() {
		return num_rows;
	}

	public void setNum_rows(int num_rows) {
		this.num_rows = num_rows;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // validate user input
        int height;
        TestIO validator = new HeightValidator("");
        boolean is_valid = validator.validate(args);
        
        if (is_valid) {
        	height = Integer.parseInt(args[0]);
        } else {
        	return;
        }
        
        // construct objects, and print pyramid
        Mario mario = new Mario(height);
        mario.buildPyramid();
    }
}