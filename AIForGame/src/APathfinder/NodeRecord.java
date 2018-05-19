/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APathfinder;

public class NodeRecord {
    private int node;
    private double costSoFa;
    private Connection connection;
    private double estimatedTotalCost;

    public NodeRecord() {
    }

    public NodeRecord(int node, double costSoFa, Connection connection, double estimatedTotalCost) {
        this.node = node;
        this.costSoFa = costSoFa;
        this.connection = connection;
        this.estimatedTotalCost = estimatedTotalCost;
    }

    public int getNode() {
        return node;
    }

    public double getCostSoFa() {
        return costSoFa;
    }

    public Connection getConnection() {
        return connection;
    }

    public double getEstimatedTotalCost() {
        return estimatedTotalCost;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public void setCostSoFa(double costSoFa) {
        this.costSoFa = costSoFa;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setEstimatedTotalCost(double estimatedTotalCost) {
        this.estimatedTotalCost = estimatedTotalCost;
    }
    
}

