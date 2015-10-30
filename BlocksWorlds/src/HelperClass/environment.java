package HelperClass;
import java.util.ArrayList;
import java.util.HashMap;

public class environment {

	public ArrayList<Block> BlockList;
	public String FOLFile;
	public String LOGFile;
	public HashMap<String,Block> colorMap=new HashMap<String,Block>();
	public int id;
	public int time=0;
	public String action="initiated";
	public boolean reward=true;
	boolean initiate(ArrayList<Block> BlockList,String FOLFile,String LOGFile){
		/*
		 * Author : Aniket Gaikwad
		 * Date : 28th Oct 15
		 * 
		 * */
		// Read user file and create environment
		// Do validation before creating blocks.
		id = (int) Math.round(Math.random()*100000); //5 digit random number
		this.time=0;
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
		predicateLogic(); 
		return true;
	}
	
	boolean move(String color1,String color2){
		/*
		 * Author : Manoj Prabhakar
		 * Date : 28th Oct 15
		 * 
		 * */
		time+=1;
		this.action="move";
		Block block1;
		Block block2;
		
		block1 =colorMap.get(color1);
		block2 = colorMap.get(color2);
		if (block1 == block2){
			System.out.println("Both are same Blocks");
			this.reward=false;
			block2.isTakenAction=true;
			this.predicateLogic();
			return this.reward;
		}
		 
		int block1a5 =block1.getX5();
		int block1a6 =block1.getX6();
		int block1a7 =block1.getX7();
		int block1a8 =block1.getX8();
		 
		int block1b5 =block1.getY5();
		int block1b6 =block1.getY6();
		int block1b7 =block1.getY7();
		int block1b8 =block1.getY8();
		 
		int block1c5 =block1.getZ5();
		int block1c6 =block1.getZ6();
		int block1c7 =block1.getZ7();
		int block1c8 =block1.getZ8();
		int block2a1 =block2.getX1();
		int block2a2 =block2.getX2();
		int block2a3 =block2.getX3();
		int block2a4 =block2.getX4();
		 
		int block2b1 =block2.getY1();
		int block2b2 =block2.getY2();
		int block2b3 =block2.getY3();
		int block2b4 =block2.getY4();
		 
		int block2c1 =block2.getZ1();
		int block2c2 =block2.getZ2();
		int block2c3 =block2.getZ3();
		int block2c4 =block2.getZ4();
		 
		int block2Length=block2.getLength();
		int block2Width=block2.getWidth();
		int block2Height=block2.getHeight();
		if (block1.getLength() == block2.getLength())
			if (block1a5 == block2a1 && block1b5 == block2b1 && block1c5 == block2c1 && block1a6 == block2a2 && block1b6 == block2b2 && block1c6 == block2c2 && block1a7 == block2a3 && block1b7 == block2b3 && block1c7 == block2c3 && block1a8 == block2a4 && block1b8 == block2b4 && block1c8 == block2c4){
				System.out.println("The Block is Already Present there.Exiting !!!!!!!!!!!!");
				this.reward=false;
				block2.isTakenAction=true;
				this.predicateLogic();
				return this.reward;
			}
			else{
				block2.setX1(block1a5);
				block2.setY1(block1b5);
				block2.setZ1(block1c5);
				block2.setX2(block1a6);
				block2.setY2(block1b6);
				block2.setZ2(block1c6);
				block2.setX3(block1a7);
				block2.setY3(block1b7);
				block2.setZ3(block1c7);
				block2.setX4(block1a8);
				block2.setY4(block1b8);
				block2.setZ4(block1c8);
				block2.setX5(block1a5);
				block2.setY5(block1b5 + block2Height);
				block2.setZ5(block1c5);
				block2.setX6(block1a6);
				block2.setY6(block1b6 + block2Height);
				block2.setZ6(block1c6);
				block2.setX7(block1a7);
				block2.setY7(block1b7 + block2Height);
				block2.setZ7(block1c7);
				block2.setX8(block1a8);
				block2.setY8(block1b8 + block2Height);
				block2.setZ8(block1c8);
			}
		
		if (block1.getLength() < block2.getLength()){
			System.out.println("Block 2 is bigger than Block1, So It cannot be placed on smaller cube");
			System.out.println("Exiting !!!!!!!!!!!!");
			this.reward=false;
			block2.isTakenAction=true;
			this.predicateLogic();
			return this.reward;
		}
		if (block1.getLength() > block2.getLength())
			if (block1a5 == block2a1 && block1b5 == block2b1 && block1c5 == block2c1 && block1a8 == block2a4 && block1b8 == block2b4 && block1c8 == block2c4){
				System.out.println("The block 2 is already placed on top of block 1");
				System.out.println("Exiting !!!!!!!!!!!!");
				this.reward=false;
				block2.isTakenAction=true;
				this.predicateLogic();
				return this.reward;
		}
			else{
				block2.setX1(block1a5);
				block2.setY1(block1b5);
				block2.setZ1(block1c5);
				block2.setX2(block1a5 + block2Length);
				block2.setY2(block1b5);
				block2.setZ2(block1c5);
				block2.setX4(block1a8);
				block2.setY4(block1b8);
				block2.setZ4(block1c8);
				block2.setX3(block1a8 + block2Length);
				block2.setY3(block1b8);
				block2.setZ3(block1c8);
				block2.setX5(block1a5);
				block2.setY5(block1b5 + block2Height);
				block2.setZ5(block1c5);
				block2.setX6(block2.getX5() + block2Length);
				block2.setY6(block2.getY5());
				block2.setZ6(block2.getZ5());
				block2.setX8(block1a8);
				block2.setY8(block1b8 + block2Height);
				block2.setZ8(block1c8);
				block2.setX7(block2.getX8() + block2Length);
				block2.setY7(block2.getY8());
				block2.setZ7(block2.getZ8());
				
			}
		this.reward=true;
		block2.isTakenAction=true;
		this.predicateLogic();
		return this.reward;
		
		
		}
	
	void predicateLogic(){
		/*
		 * Author : Aniket Gaikwad
		 * Date : 28th Oct 15
		 * 
		 * */
		String predList=new String();
		for(Block b : this.BlockList){
			predList+="BLOCK("+this.id+","+this.time+","+b.getId()+")\n";
			predList+="COORDINATE_1("+this.id+","+this.time+","+b.getX1()+","+b.getY1()+","+b.getZ1()+")\n";
			predList+="COORDINATE_2("+this.id+","+this.time+","+b.getX2()+","+b.getY2()+","+b.getZ2()+")\n";
			predList+="COORDINATE_3("+this.id+","+this.time+","+b.getX3()+","+b.getY3()+","+b.getZ3()+")\n";
			predList+="COORDINATE_4("+this.id+","+this.time+","+b.getX4()+","+b.getY4()+","+b.getZ4()+")\n";
			predList+="COORDINATE_5("+this.id+","+this.time+","+b.getX5()+","+b.getY5()+","+b.getZ5()+")\n";
			predList+="COORDINATE_6("+this.id+","+this.time+","+b.getX6()+","+b.getY6()+","+b.getZ6()+")\n";
			predList+="COORDINATE_7("+this.id+","+this.time+","+b.getX7()+","+b.getY7()+","+b.getZ7()+")\n";
			predList+="COORDINATE_8("+this.id+","+this.time+","+b.getX8()+","+b.getY8()+","+b.getZ8()+")\n";
			predList+="COLOR("+this.id+","+this.time+","+b.getColor()+")\n";
			if(b.isTakenAction){
				predList+="TOOK_ACTION("+this.id+","+this.time+","+this.action+")\n";
				b.isTakenAction=false;
			}
			
			
			
		}
		predList+="GOT_REWARD("+this.id+","+this.time+","+this.reward+")\n";
		FileUtilities.write2File(predList,this.FOLFile, true);
	}
	
	
}
