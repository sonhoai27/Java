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
 * @author macos
 */
public class Graph {
    private int size;
    private double[][] matrix;
    private String filePath;

    public Graph(String filePath) {
        this.filePath = filePath;
        this.init();
    }
    
    private void init() {
        Scanner scanner = null;
        
        try {          
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (scanner != null) {
            this.size = scanner.nextInt();
            this.matrix = new double[this.size][this.size];
            
            for (int i = 0; i < this.size; ++i) {
                for (int j = 0; j < this.size; ++j) {
                    this.matrix[i][j] = scanner.nextDouble();
                }
            }
            
            scanner.close();
        }
    }
    
    public List<Connection> getConnections(int fromNode) {
        List<Connection> connections = new ArrayList<>();
        
        for (int i = 0; i < this.size; ++i) {
            if (matrix[fromNode][i] != Double.MIN_VALUE) {
                connections.add(new Connection(matrix[fromNode][i], fromNode, i));
            }
        }
        
        return connections;
    }
    
    public static void main(String[] args) {
        Graph grapth = new Graph("/Desktop/PathFinding.txt");
        List<Connection> connections = grapth.getConnections(0);
        
        for (Connection connection: connections) {
            System.out.print(connection);
        }
    }
}
