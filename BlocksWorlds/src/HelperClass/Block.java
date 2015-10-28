package HelperClass;

public class Block {

	private int x1,y1,z1,x2,y2,z2,x3,y3,z3,x4,y4,z4,x5,y5,z5,x6,y6,z6,x7,y7,z7,x8,y8,z8;
	private String color;
	private int height=1;
	private int length;
	private int width=1;
	private int id;
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getZ1() {
		return z1;
	}
	public void setZ1(int z1) {
		this.z1 = z1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getZ2() {
		return z2;
	}
	public void setZ2(int z2) {
		this.z2 = z2;
	}
	public int getX3() {
		return x3;
	}
	public void setX3(int x3) {
		this.x3 = x3;
	}
	public int getY3() {
		return y3;
	}
	public void setY3(int y3) {
		this.y3 = y3;
	}
	public int getZ3() {
		return z3;
	}
	public void setZ3(int z3) {
		this.z3 = z3;
	}
	public int getX4() {
		return x4;
	}
	public void setX4(int x4) {
		this.x4 = x4;
	}
	public int getY4() {
		return y4;
	}
	public void setY4(int y4) {
		this.y4 = y4;
	}
	public int getZ4() {
		return z4;
	}
	public void setZ4(int z4) {
		this.z4 = z4;
	}
	public int getX5() {
		return x5;
	}
	public void setX5(int x5) {
		this.x5 = x5;
	}
	public int getY5() {
		return y5;
	}
	public void setY5(int y5) {
		this.y5 = y5;
	}
	public int getZ5() {
		return z5;
	}
	public void setZ5(int z5) {
		this.z5 = z5;
	}
	public int getX6() {
		return x6;
	}
	public void setX6(int x6) {
		this.x6 = x6;
	}
	public int getY6() {
		return y6;
	}
	public void setY6(int y6) {
		this.y6 = y6;
	}
	public int getZ6() {
		return z6;
	}
	public void setZ6(int z6) {
		this.z6 = z6;
	}
	public int getX7() {
		return x7;
	}
	public void setX7(int x7) {
		this.x7 = x7;
	}
	public int getY7() {
		return y7;
	}
	public void setY7(int y7) {
		this.y7 = y7;
	}
	public int getZ7() {
		return z7;
	}
	public void setZ7(int z7) {
		this.z7 = z7;
	}
	public int getX8() {
		return x8;
	}
	public void setX8(int x8) {
		this.x8 = x8;
	}
	public int getY8() {
		return y8;
	}
	public void setY8(int y8) {
		this.y8 = y8;
	}
	public int getZ8() {
		return z8;
	}
	public void setZ8(int z8) {
		this.z8 = z8;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Block(int count,int x1,int y1,int z1,int x2,int y2,int z2,int x3,int y3,int z3,
			int x4,int y4,int z4,String color){
		// Assign values passed 
		this.setId(count);
		this.setColor(color);
		//this.setHeight(height);
		this.setX1(x1);this.setY1(y1);this.setZ1(z1);this.setX2(x2);this.setY2(y2);this.setZ2(z2);
		this.setX3(x3);this.setY3(y3);this.setZ3(z3);this.setX4(x4);this.setY4(y4);this.setZ4(z4);
		
		// based on passed values calculate new values
		this.width=1;
		this.height=1;
		this.length=Math.abs(this.getX1()-this.getX2());
		this.setX5(this.getX1());
		this.setX6(this.getX2());
		this.setX7(this.getX3());
		this.setX8(this.getX4());
		
		this.setY5((this.getY1())+(this.getHeight()));
		this.setY6((this.getY2())+(this.getHeight()));
		this.setY7((this.getY3())+(this.getHeight()));
		this.setY8((this.getY4())+(this.getHeight()));
		
		this.setZ5(this.getZ1());
		this.setZ6(this.getZ2());
		this.setZ7(this.getZ3());
		this.setZ8(this.getZ4());
	
	}
	
}
