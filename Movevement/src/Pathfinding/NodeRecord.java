/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pathfinding;

/**
 *
 * @author sonho
 */
//chỉ chứa dữ liệu
//1 cost sofar, va node truoc do
public class NodeRecord {
    private int node; //node này là hiện đang nói node nào
    private Connection connection;
    private double costSofar;

    public NodeRecord() {
    }

    public NodeRecord(int node, Connection connection, double costSofar) {
        this.node = node;
        this.connection = connection;
        this.costSofar = costSofar;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public double getCostSofar() {
        return costSofar;
    }

    public void setCostSofar(double costSofar) {
        this.costSofar = costSofar;
    }

    @Override
    public String toString() {
        return "NodeRecord{" + "node=" + node + ", connection=" + connection + ", costSofar=" + costSofar + '}';
    }
    
    
}
