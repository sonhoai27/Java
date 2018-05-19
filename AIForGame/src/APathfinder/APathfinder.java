/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APathfinder;

import PathFinding.DijkstraPathfinder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class APathfinder {
 
       public List<Connection> pathfindingA(Graph graph, int start, int end, Heuristic heuristic) {
        PathfindingList open = new PathfindingList();
        PathfindingList close = new PathfindingList();

        NodeRecord startNodeRecord = new NodeRecord(start, 0, null, heuristic.getEstimatedCost(start));
        open.add(startNodeRecord);

        NodeRecord current = null;
        NodeRecord endNodeRecord = null;
        List<Connection> connections = null;
        int endNode;
        double endNodeCostSoFa;
        double endNodeHeuristic;

        while (open.size() > 0) {
            current = open.smallestElement();
            
            if (current.getNode() == end) {
                break;
            }
            
            connections = graph.getConnections(current.getNode());

            for (Connection connection : connections) {
                endNode = connection.getToNode();
                endNodeCostSoFa = current.getCostSoFa() + connection.getCost();
                
                if (close.contains(endNode)) {
                    endNodeRecord = close.find(endNode);
                    
                    if (endNodeRecord.getCostSoFa() <= endNodeCostSoFa) {
                        continue;
                    }
                    
                    endNodeHeuristic = endNodeRecord.getEstimatedTotalCost() - endNodeRecord.getCostSoFa();
                    close.remove(endNodeRecord);
                } else if (open.contains(endNode)) {
                    endNodeRecord = open.find(endNode);

                    if (endNodeRecord.getCostSoFa() <= endNodeCostSoFa) {
                        continue;
                    }
                    
                    endNodeHeuristic = endNodeRecord.getEstimatedTotalCost() - endNodeRecord.getCostSoFa();
                } else {
                    endNodeRecord = new NodeRecord();
                    endNodeRecord.setNode(endNode);
                    endNodeHeuristic = heuristic.getEstimatedCost(endNode);
                }
                
                endNodeRecord.setConnection(connection);
                endNodeRecord.setCostSoFa(endNodeCostSoFa);
                endNodeRecord.setEstimatedTotalCost(endNodeCostSoFa + endNodeHeuristic);
                
                if (!open.contains(endNodeRecord)) {
                    open.add(endNodeRecord);
                }
            }
            
            open.remove(current);
            close.add(current);
        }
        
        if (current.getNode() != end) {
            return null;
        }
        
        List<Connection> result = new ArrayList<>();
        
        while (current.getNode() != start) {
            result.add(current.getConnection());
            current = close.find(current.getConnection().getFromNode());
        }

        this.reverse(result);
        return result;
    }

    void reverse(List<Connection> listConnection) {
        int size = listConnection.size();
        int i = 0;
        int j = size - 1;
        
        while (i <= size / 2 && j >= size / 2) {
            Connection conn = listConnection.get(i);
            listConnection.set(i, listConnection.get(j));
            listConnection.set(j, conn);
            ++i;
            --j;
        }
    }
    
    public static void main(String[] args) {
        Graph path = new Graph("C:/AGraph.txt");
        APathfinder pathfindingA = new APathfinder();
        List<Connection> connections = pathfindingA.pathfindingA(path, 0, 6, new Heuristic("C:/Heuristic.txt"));
        
        for (Connection connection: connections) {
            System.out.println(connection.toString());
        }
        
    }
    
}
