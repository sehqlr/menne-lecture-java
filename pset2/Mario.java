package com.sehqlr.launchcode.mario;

public class Mario
{
    // initializations
    private final String space = " ";
    private final String brick = "#";
    private final String nline = "\n";
    
    int num_rows;
    private StringBuilder pyramid = new StringBuilder();

    // constructor
    public Mario(int height) 
        num_rows = height;

    public void buildRow(int num_sp, int num_br)
    {
        // count down for spaces
        for (int s = num_sp; s > 0; s--)
            pyramid.append(space);
        // count up for bricks
        for (int b = 0; b < num_br; b++)
            pyramid.append(brick);
    }

    public void buildPyramid()
    {
        for (int i = 0; i < num_rows; i++)
        {
            int num_sp = num_rows - i;
            int num_br = 2 + i;
            buildRow(num_sp, num_br);
            pyramid.append(nline);
        }
        System.out.print(pyramid.toString());
    }

    public static void main(String[] args)
    {
        // validate user input
        if (args.length == 0)
        {
            System.out.println("Usage: java Mario height");
            return;
        }

        private int height = Integer.parseInt(args[0]);

        if (height < 0 || height > 23)
        {
            System.out.println("Sorry, height must be between 0 and 23");
            return;
        }

        Mario mario = new Mario(height);
        mario.buildPyramid();
    }
}
