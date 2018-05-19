/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathFinding;

import java.util.Objects;

/**
 *
 * @author macos
 */

//gần giống như 1 cái đỉnh
public class NodeRecord {
    private int node;
    private Connection connection;
    private double costSoFar;

    public NodeRecord(int node, Connection connection, double costSoFar) {
        this.node = node;
        this.connection = connection;
        this.costSoFar = costSoFar;
    }

    public NodeRecord() {
    }

    public int getNode() {
        return node;
    }

    public Connection getConnection() {
        return connection;
    }

    public double getCostSoFar() {
        return costSoFar;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setCostSoFar(double costSoFar) {
        this.costSoFar = costSoFar;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodeRecord other = (NodeRecord) obj;
        if (this.node != other.node) {
            return false;
        }
        if (Double.doubleToLongBits(this.costSoFar) != Double.doubleToLongBits(other.costSoFar)) {
            return false;
        }
        if (!Objects.equals(this.connection, other.connection)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "NodeRecord{" + "node=" + node + ", connection=" + connection + ", costSoFar=" + costSoFar + '}';
    }   
    
}
