/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pathfinding;
//datamodel chứa dữ liệu
/**
 *
 * @author sonho
 */
//de chua du lieu
public class Connection {
    //cac dinh là int, fromnode và tonode
    private int fromNode; //node dinh, cost là chi phí
    private int toNode;
    private double cost;

    public Connection() {
    }

    public Connection(int fromNode, int toNode, double cost) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.cost = cost;
    }

    public int getFromNode() {
        return fromNode;
    }

    public void setFromNode(int fromNode) {
        this.fromNode = fromNode;
    }

    public int getToNode() {
        return toNode;
    }

    public void setToNode(int toNode) {
        this.toNode = toNode;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Connection{" + "fromNode=" + fromNode + ", toNode=" + toNode + ", cost=" + cost + '}';
    }
}
