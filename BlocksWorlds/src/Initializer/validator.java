package Initializer;

public class validator {
	
	public static boolean isCoordiantesOK(int x1,int y1,int z1,int x2,int y2,int z2,
			int x3,int y3,int z3,int x4,int y4,int z4){
		/*
		 * Before looking into code look into the block diagram considered for the simulator
		 * */
		if(x1!=x4 || x2!=x3){
			// The X-coordinates of the points in same line should be same.
			System.out.println("\n The X1 and X4 must be same. Or The X2 and X3 must be same.");
			return false;
		}
		
		if(z1!=z2 || z3!=z4){
			// The Z-coordinates of the points in same line should be same.
			System.out.println("\n The Z1 and Z2 must be same. Or The Z3 and Z4 must be same.");
			return false;
		}
		
		if(y1!=y2 || y1!=y3 || y1!=y4 || y2!=y3 || y2!=y4 || y3!=y4){
			// In the Y-plane the coordiantes has to be same.
			System.out.println("\n The Y1 and Y2 must be same. Or The Y1 and Y3 must be same.");
			System.out.println("\n The Y2 and Y3 must be same. Or The Y3 and Y4 must be same.");
			return false;
		}
		
		/*
		 * Remove this code when we have width greater than 1.
		 * For initial build we have assumed width to be 1
		 * */
		if(Math.abs(z1-z4)!=1 ||Math.abs(z2-z3)!=1 ){
			// Restricting width to be of size 1
			
			System.out.println("\n **** Please enter the width of size 1 *******");
			return false;
		}
		return true;
	}

}
