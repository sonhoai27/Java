/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APathfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class Heuristic {

    private int end;
    private String filePath;
    private int size;
    private double[] arrayEstimatedCose;

    public Heuristic() {
    }

    public Heuristic(String filePath) {
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
            this.arrayEstimatedCose = new double[size];

            for (int i = 0; i < this.size; ++i) {
                this.arrayEstimatedCose[i] = scanner.nextDouble();
            }
        }
    }
    
    public double getEstimatedCost(int node) {
        return this.arrayEstimatedCose[node];
    }

}
