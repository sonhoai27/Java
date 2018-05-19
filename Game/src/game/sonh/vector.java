package game.sonh;

import java.util.Vector;

public class vector {
	private double x;
	private double y;
	
	public vector() {
		
	}
	
	public vector(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
	//phuong thuc la mot ham
	//cong 2 vector cung lop va cung doi tuong
	
	//phuong thuc thuoc lop co tu khoa la static, goi phuong thuc này thông qua tên lớp
	//
	
	//khoi tao co tham so va khong tham so
	
	
	public static vector add(vector a, vector b){
		vector vectors = new vector();
		
		vectors.setX(a.getX() + b.getX());
		vectors.setY(a.getY() + b.getY());
		
		return vectors;
	}
	
	//khai bao phuong thuc thuoc doi tuong
	
	public vector add(vector b){
		this.x = this.x + b.getX();
		this.y = this.y + b.getY();
		return this;
	}
	
	
	public static vector sub(vector a, vector b){
		vector vectors = new vector();
		
		vectors.setX(a.getX() - b.getX());
		vectors.setY(a.getY() - b.getY());
		
		return vectors;
	}

	
	//khai bao phuong thuc thuoc doi tuong
	
	public vector sub(vector b){
		this.x = this.x - b.getX();
		this.y = this.y - b.getY();
		
		return this;
	}
	
	//phuong thuc thuoc lop
	public static vector mulConst(vector a, double b){
		vector vectors = new vector();
		
		vectors.setX(a.getX()*b);
		vectors.setY(a.getY()*b);
		
		return vectors;
	}
	
	//khai bao phuong thuc thuoc doi tuong
	
	public vector mulConst(double b){
		this.x = this.x*b;
		this.y = this.y*b;
		return this;
	}
	
	
	
	//chuan hoa x,y vector
	//kiem tra điều kiện có 3 cấu trúc([if,elseif, else], [switch-case], )
	
	//chuẩn hóa vector
	public static vector normalize(vector a){
		vector vectors = new vector();
		double x, y;
		if(a.getX() == 0){
			x = 0; y = 1;
		}else if (a.getY() == 0) {
			x=1; y= 0;
		}else {
			if(a.getY() > 0){
				y = Math.sqrt(a.getY()*a.getY() / (a.getX()*a.getX() + a.getY() + a.getY()));
			}else {
				//be hon
				y = -Math.sqrt(a.getY()*a.getY() / (a.getX()*a.getX() + a.getY() + a.getY()));
			}
			
			x = y*a.getX()/a.getY();
		}
		
		vectors.setX(x);
		vectors.setY(y);
		
		return vectors;
	}
	
	public double lenght(){
		return Math.sqrt(x*x + y*y);
	}

	@Override
	public String toString() {
		return "vector [x=" + x + ", y=" + y + "]";
	}
	
	public static void main(String[] args) {
		vector vectors = new vector(2,3);
		
		System.out.println(vectors.normalize(vectors));
	}
	
}
