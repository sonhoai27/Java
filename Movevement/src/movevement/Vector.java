/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movevement;

/**
 *
 * @author macos
 */
public class Vector {
    private double x;
    private double y;
    
    public Vector() {
       this.x = 0;
       this.y = 0;
    }
    
    public Vector(double x_Config, double y_Config) {
       this.x = x_Config;
       this.y = y_Config;
    }
    
    public void setX(double x) {
        this.x = x;  
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void add(Vector v) {        
        this.x = this.x + v.x;
        this.y = this.y + v.y;  
    }
    
    public void subtract(Vector v) {
        this.x = this.x - v.x;
        this.y = this.y - v.y;
    }

    public static Vector add(Vector a, Vector b) {
        Vector result = new Vector();
        
        result.x = a.x + b.x;
        result.y = a.y + b.y;
        
        return result;
    }
    
    public Vector subtract(Vector a, Vector b) {
        Vector result = new Vector();
        
        result.x = a.x - b.x;
        result.y = a.y - b.y;
        
        return result;
    }
    
    public static Vector mulConst(Vector vector, double b) {
        Vector result = new Vector();
        
        result.x = vector.x * b;
        result.y = vector.y * b;
        
        return result;
    }
    
    public void mulConst(double b) {
                
        this.x = this.x * b;
        this.y = this.y * b;
        
    }

    
    public static Vector normalize(Vector vector) {
        Vector result = new Vector();
        
        if (vector.x == 0) {
            result.y = 1;
            return result;
        } else if (vector.y == 0) {
            result.x = 1;
            return result;
        } else if (vector.x == 0 && vector.y == 0) {
            return result;
        } 

        double sign = (Math.abs(vector.y) / (vector.y));
        result.y = Math.abs(vector.y) / Math.sqrt(vector.x * vector.x + vector.y * vector.y) * sign;
        result.x = (vector.x / vector.y) * result.y; 
        
        return result;
    }
    
    public void normalize() {
        if (this.x == 0) {
            this.y = 1;
            return;
        } else if (this.y == 0) {
            this.x = 1;
            return;
        } else if (this.x == 0 && this.y == 0) {
            return;
        } 

        double sign = (Math.abs(this.y) / (this.y));
        this.y = Math.abs(this.y) / Math.sqrt(x * x + y * y) * sign;
        this.x = (this.x / this.y) * this.y; 
        
    }


    @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + '}';
    }
    
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

}
