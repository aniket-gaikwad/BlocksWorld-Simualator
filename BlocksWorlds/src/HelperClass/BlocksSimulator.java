package HelperClass;

import java.util.ArrayList;

import Initializer.readConfFile;

public class BlocksSimulator {
	/*
	 * Author : Aniket Gaikwad
	 * Date : 28th Oct 15
	 * 
	 * */
	static ArrayList<Block> BlockList;
	static environment e;
	static String configFile="D:\\Fall 2015\\Lab\\BlocksWorlds\\BlocksWorld-Simulator\\BlocksWorlds\\src\\InitialFiles\\Config.txt";
	static String FOLFile="D:\\Fall 2015\\Lab\\BlocksWorlds\\BlocksWorld-Simulator\\BlocksWorlds\\src\\Output\\FOL.txt";
	static String LOGFile="D:\\Fall 2015\\Lab\\BlocksWorlds\\BlocksWorld-Simulator\\BlocksWorlds\\src\\Output\\LOG.txt";
	public static void main(String args[]){
		System.out.println("\n ****** BLOCK SIMULATION STARTS ******");
		readConfFile rcf=new readConfFile();
		BlockList=rcf.readConfigFile(configFile);
		
		if(BlockList==null || BlockList.isEmpty()){
			System.out.println("\n No blocks added for simulations...Exiting \n");
			return;
		}
		e=new environment();
		if(e.initiate(BlockList,FOLFile,LOGFile)){
			// Initiation Success
			/*
			 * Please code your policy here.
			 * */
			System.out.println("\n BLOCK worlds initiation Success !!!!");
			//display();
			e.move("BLUE","YELLOW");
			System.out.println("Action taken : ");
			//display();
		}
		else{
			return;
		}
		System.out.println("\n ****** BLOCK SIMULATION ENDS ******");
	}
	
	public static void display(){
		for(Block entry : BlockList){
			System.out.println("\n : Next Block Properties :");
			printBlock(entry);
		}
	}
	
	public static void printBlock(Block entry){
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
