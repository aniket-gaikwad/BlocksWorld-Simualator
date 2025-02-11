package Initializer;

import java.util.ArrayList;

import HelperClass.Block;

public class validator {
	/*
	 * Author : Aniket Gaikwad
	 * Date : 28th Oct 15
	 * 
	 * */
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
	
	public static boolean isTwoBlocksSame(ArrayList<Block> BlockList,Block block){
		for(Block entry : BlockList){
			if(block.getX1()==entry.getX1() && block.getY1()==entry.getY1() && block.getZ1()==entry.getZ1()){
				if(block.getX3()==entry.getX3() && block.getY3()==entry.getY3() && block.getZ3()==entry.getZ3()){
					System.out.println("\n Error while adding block : "+block.getId());
					System.out.println("\n 1st and 3rd same");
					return false;
				}
			}
			if(block.getX2()==entry.getX2() && block.getY2()==entry.getY2() && block.getZ2()==entry.getZ2()){
				if(block.getX4()==entry.getX4() && block.getY4()==entry.getY4() && block.getZ4()==entry.getZ4()){
					System.out.println("\n Error while adding block : "+block.getId());
					System.out.println("\n 2nd and 4th same");
					return false;
				}
			}
			
		}
		return true;
	}

}
