/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathFinding;

/**
 *
 * @author macos
 */
public class Connection {
    private double cost;
    private int fromNode;
    private int toNode;

    public Connection() {
        this.cost = 0.0;
        this.fromNode = 0;
        this.toNode = 0;
    }

    public Connection(double cost, int fromNode, int toNode) {
        this.cost = cost;
        this.fromNode = fromNode;
        this.toNode = toNode;
    }

    public double getCost() {
        return cost;
    }

    public int getFromNode() {
        return fromNode;
    }

    public int getToNode() {
        return toNode;
    }
    
    
    
}
