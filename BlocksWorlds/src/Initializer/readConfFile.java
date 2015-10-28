package Initializer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import HelperClass.Block;

public class readConfFile {

	ArrayList<Block> BlockList = new ArrayList<Block>();
	FileReader reader;
	BufferedReader buf;
    public ArrayList<Block> readConfigFile(String fileName) {
        String line = null;
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader buf = new BufferedReader(reader);
            int count=0;	
            while ((line = buf.readLine()) != null) {
                if (line.contains("#")) {
                    continue;
                }
                
                String[] result = line.split(",");
                int x1=Integer.parseInt(result[0]);
                int y1=Integer.parseInt(result[1]);
                int z1=Integer.parseInt(result[2]);
                int x2=Integer.parseInt(result[3]);
                int y2=Integer.parseInt(result[4]);
                int z2=Integer.parseInt(result[5]);
                int x3=Integer.parseInt(result[6]);
                int y3=Integer.parseInt(result[7]);
                int z3=Integer.parseInt(result[8]);
                int x4=Integer.parseInt(result[9]);
                int y4=Integer.parseInt(result[10]);
                int z4=Integer.parseInt(result[11]);
                //int height=Integer.parseInt(result[12]);
                String color = result[12];
                
                // Check for incosistencies in Configuration files
                if(validator.isCoordiantesOK(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4)==false){
                	System.out.println("\nError : Invalid Configuration File given");
                	System.out.println("\nPlease refer to user guide for setting configuratio file");
                	return null;
                } 
                Block newBlock = new Block(count,x1,y1,z1,x2,y2,z2,x3,y3,z3,
            			x4,y4,z4,color);
                count+=1;
                BlockList.add(newBlock);
            }
            return BlockList;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found !!!");
        } catch (IOException e) {
            System.out.println("Error in reading file : ");
            e.printStackTrace();
        }
        

        return BlockList;
    }
}
