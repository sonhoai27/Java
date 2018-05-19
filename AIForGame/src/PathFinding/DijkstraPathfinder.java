/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathFinding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGUYEN DINH TRIEU
 */
public class DijkstraPathfinder {

    public List<Connection> pathfindingDijkstra(Graph graph, int start, int end) {
        PathfindingList open = new PathfindingList();
        PathfindingList close = new PathfindingList();

        NodeRecord startNodeRecord = new NodeRecord(start, 0, null);
        open.add(startNodeRecord);

        NodeRecord current = null;
        NodeRecord endNodeRecord = null;
        List<Connection> connections = null;
        int endNode;
        double endNodeCostSoFa;

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
                    continue;
                } else if (open.contains(endNode)) {
                    endNodeRecord = open.find(endNode);

                    if (endNodeRecord.getCostSoFa() <= endNodeCostSoFa) {
                        continue;
                    }
                } else {
                    endNodeRecord = new NodeRecord();
                    endNodeRecord.setNode(endNode);
                }
                
                endNodeRecord.setConnection(connection);
                endNodeRecord.setCostSoFa(endNodeCostSoFa);
                
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
        Graph path = new Graph("C:/input.txt");
        DijkstraPathfinder dijkstra = new DijkstraPathfinder();
        List<Connection> connections = dijkstra.pathfindingDijkstra(path, 0, 2);
        
        for (Connection connection: connections) {
            System.out.println(connection.toString());
        }
        
    }
}
