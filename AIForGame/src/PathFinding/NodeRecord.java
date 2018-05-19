/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathFinding;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class NodeRecord {
    private int node;
    private double costSoFa;
    private Connection connection;

    public NodeRecord() {
    }

    public NodeRecord(int node, double costSoFa, Connection connection) {
        this.node = node;
        this.costSoFa = costSoFa;
        this.connection = connection;
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

    public void setNode(int node) {
        this.node = node;
    }

    public void setCostSoFa(double costSoFa) {
        this.costSoFa = costSoFa;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
