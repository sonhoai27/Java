/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiforgame;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class Vector {

    private double x;
    private double y;

    public Vector() {
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //GET
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //SET
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    //MULTIPLIER
    public static Vector mulConst(Vector vector, double b) {
        return new Vector((vector.x * b), (vector.y * b));
    }
    
    public void mulConst(double b) {
        this.x *= b;
        this.y *= b;
    }
    
    //ADD
    public static Vector add(Vector vector1, Vector vector2) {
        return new Vector((vector1.x + vector2.x), (vector1.y + vector2.y));
    }
    
    public void add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }
    
    //SUBTRACT
    public void subtract(Vector vector) {
        this.x -= vector.x;
        this.y -= vector.y;
    }
    
    public static Vector subtract(Vector vector1, Vector vector2) {
        return new Vector(vector1.x - vector2.x, vector1.y - vector2.y);
    }

    //NORMALIZE
    public void nomalize() {
        if (this.x == 0 && this.y == 0) {
            return;
        } else if (this.x == 0) {
            this.y = 1;
            return;
        } else if (this.y == 0) {
            this.x = 1;
        }
        
        double sign = Math.abs(this.x / this.y) / (this.x / this.y);
        double a = this.x;
        double b = this.y;
        
        this.x = Math.abs(this.x / Math.sqrt(this.x * this.x + this.y * this.y)) * sign;
        this.y = this.x * b / a;
    }
    
    static Vector normalize(Vector vector) {
        Vector result = new Vector();
        
        if (vector.x == 0 && vector.y == 0) {
            return result;
        } else if (vector.x == 0) {
            result.y = 1;
            return result;
        } else if (vector.y == 0) {
            result.x = 1;
            return result;
        }
        
        double sign = Math.abs(vector.x / vector.y) / (vector.x / vector.y);
        result.x = Math.abs(vector.x / Math.sqrt(vector.x * vector.x + vector.y * vector.y)) * sign;
        result.y = result.x * vector.y / vector.x;
        
        return result;
    }
    
    double lenght() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + '}';
    }
  
}
