package movevement;

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
       double x, y;
       if(vector.getX() == 0){
           x = 0;
           y = 1;
       }else if(vector.getY() == 0){
           x = 1; y = 0;
       }else {
           if(vector.getY() > 0){
               y = Math.sqrt(
                       vector.getY()*vector.getY()/(vector.getX()*vector.getX() 
                               + (vector.getY() * vector.getY()))
                  );
           }else {
               y = -Math.sqrt(
                       vector.getY()*vector.getY()/(vector.getX()*vector.getX() 
                               + (vector.getY() * vector.getY()))
                  );
           }
           x = y*vector.getX()/vector.getY();
       }
       
       result.setX(x);
       result.setY(y);
       
       return result;
    }
    
    public Vector normalize() {
        if (this.x == 0) {
            this.y = 1;
        } else if (this.y == 0) {
            this.x = 1;
        }else {
            if(this.y>0){
              y=Math.sqrt((this.y*this.y)/((this.x*this.x)+(this.y*this.y)));
            }else{
                y=-Math.sqrt((this.y*this.y)/((this.x*this.x)+(this.y*this.y)));
            }
            x=y*this.x/this.y;
        }
         
        return this;
        
    }


    @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + '}';
    }
    
    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public static void main(String[] args) {
        Vector v = new Vector(2, 3);
        System.out.println(Vector.normalize(v));
    }
}
