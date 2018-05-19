/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathFinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class Graph {
    private int size;
    private double[][] maxtrix;
    private String filePath;

    public Graph() {
    }

    public Graph(String filePath) {
        this.filePath = filePath;
        this.init();
    }
    
    public void init() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (scanner != null) {
            this.size = scanner.nextInt();
            this.maxtrix = new double[size][size];
            
            for (int i = 0; i < this.size; ++i) {
                for (int j = 0; j < this.size; ++j) {
                    this.maxtrix[i][j] = scanner.nextDouble();
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public double[][] getMaxtrix() {
        return maxtrix;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMaxtrix(double[][] maxtrix) {
        this.maxtrix = maxtrix;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public List<Connection> getConnections(int fromNode) {
        List<Connection> result = new ArrayList<>();
        
        for (int i = 0; i < this.size; ++i) {
            if (this.maxtrix[fromNode][i] != Double.MIN_VALUE) {
                result.add(new Connection(this.maxtrix[fromNode][i], fromNode, i));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Graph grapth = new Graph("C:/input.txt");
        List<Connection> connections = grapth.getConnections(0);
        
        for (Connection connection: connections) {
            System.out.print(connection.toString());
        }
    }
}
