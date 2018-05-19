/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APathfinder;

import java.util.logging.Logger;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class Connection {
    private double cost;
    private int fromNode;
    private int toNode;

    public Connection() {
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

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setFromNode(int fromNode) {
        this.fromNode = fromNode;
    }

    public void setToNode(int toNode) {
        this.toNode = toNode;
    }

    @Override
    public String toString() {
        return "Connection{" + "cost=" + cost + ", fromNode=" + fromNode + ", toNode=" + toNode + '}';
    }
   
    
    
}