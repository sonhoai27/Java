/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APathfinder;

import java.awt.List;
import java.util.LinkedList;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class PathfindingList extends LinkedList<NodeRecord>{

    public PathfindingList() {
        super();
    }
    
    public NodeRecord smallestElement() {
        if (this.size() == 0) {
            return null;
        }
        
        NodeRecord temp = this.get(0);
        
        for (int i = 1; i < this.size(); ++i) {
            if (temp.getEstimatedTotalCost() > this.get(i).getEstimatedTotalCost()) {
                temp = this.get(i);
            }
        }
        
        return temp;
    }
    
    public NodeRecord find(int node) {
        if (this.size() == 0) {
            return null;
        }
       
        for (int i = 0; i < this.size(); ++i) {
            if (this.get(i).getNode() == node) {
                return this.get(i);
            }
        }
        
        return null;
    }
}

