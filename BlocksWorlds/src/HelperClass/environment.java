package HelperClass;
import java.util.ArrayList;
import java.util.HashMap;

public class environment {

	public ArrayList<Block> BlockList;
	public String FOLFile;
	public String LOGFile;
	public HashMap<String,Block> colorMap=new HashMap<String,Block>();
	
	boolean initiate(ArrayList<Block> BlockList,String FOLFile,String LOGFile){
		// Read user file and create environment
		// Do validation before creating blocks.
		this.BlockList=BlockList;
		this.FOLFile=FOLFile;
		this.LOGFile=LOGFile;
		
		for(Block entry : BlockList){
			if(this.colorMap.containsKey(entry.getColor())){
				System.out.println("\n *** ERROR : Two or more blocks has same color.");
				System.out.println("\n Please give different color to each block in config file");
				System.out.println("\n Exiting the program");
				return false;
			}
			else{
				this.colorMap.put(entry.getColor(),entry);
			}
		}
		display();
		return true;
	}
	
	public void move(String color1,String color2){
		// Get Block of color1 and color2
		// Validate before moving Blocks
		
	}
	
	public void display(){
		for(Block entry : BlockList){
			System.out.println("\n : Next Block Properties :");
			printBlock(entry);
		}
	}
	
	public void printBlock(Block entry){
		System.out.println("\n ID : "+entry.getId());
		System.out.println("\n Color : "+entry.getColor());
		System.out.println("\n Height : "+entry.getHeight());
		System.out.println("\n Width : "+entry.getWidth());
		System.out.println("\n Length : "+entry.getLength());
		System.out.printf("\n x_1 : %d , y_1 : %d , z_1 : %d",entry.getX1(),entry.getY1(),entry.getZ1());
		System.out.printf("\n x_2 : %d , y_2 : %d , z_2 : %d",entry.getX2(),entry.getY2(),entry.getZ2());
		System.out.printf("\n x_3 : %d , y_3 : %d , z_3 : %d",entry.getX3(),entry.getY3(),entry.getZ3());
		System.out.printf("\n x_4 : %d , y_4 : %d , z_4 : %d",entry.getX4(),entry.getY4(),entry.getZ4());
		System.out.printf("\n x_5 : %d , y_5 : %d , z_5 : %d",entry.getX5(),entry.getY5(),entry.getZ5());
		System.out.printf("\n x_6 : %d , y_6 : %d , z_6 : %d",entry.getX6(),entry.getY6(),entry.getZ6());
		System.out.printf("\n x_7 : %d , y_7 : %d , z_7 : %d",entry.getX7(),entry.getY7(),entry.getZ7());
		System.out.printf("\n x_8 : %d , y_8 : %d , z_8 : %d",entry.getX8(),entry.getY8(),entry.getZ8());
	}
}
