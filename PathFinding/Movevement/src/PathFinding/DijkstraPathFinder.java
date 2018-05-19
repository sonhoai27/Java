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
 * @author macos
 */
/*
 Open chứa danh sách có thể xét
 Close chứa danh sách không xét: Đã xet rồi
 */
//tìm đường, tìm trên đồ thị
public class DijkstraPathFinder {

    public List<Connection> pathfindDijkstra(Graph graph, int start, int end) {
        PathfindingList openList = new PathfindingList();
        PathfindingList closeList = new PathfindingList();

        NodeRecord startRecord = new NodeRecord();
        startRecord.setNode(start);
        startRecord.setConnection(null);
        startRecord.setCostSoFar(0);

        openList.add(startRecord);
        NodeRecord current = null;
        List<Connection> connections;
        int endNode;
        double endNodeCost;

        while (openList.size() > 0) {
            current = openList.smallestElement();

            if (current.getNode() == end) {
                break;
            }

            connections = graph.getConnections(current.getNode());

            for (int i = 0; i < connections.size(); ++i) {
                endNode = connections.get(i).getToNode();
                endNodeCost = current.getCostSoFar() + connections.get(i).getCost();

                if (closeList.containtsNode(endNode)) {
                    continue;
                } else if (openList.containtsNode(endNode)) {
                    NodeRecord endNodeRecord = openList.find(endNode);

                    if (endNodeRecord.getCostSoFar() <= endNodeCost) {
                        continue;
                    }
                } else {
                    NodeRecord endNodeRecord = new NodeRecord();
                    endNodeRecord.setNode(endNode);
                }

                NodeRecord endNodeRecord = new NodeRecord();
                endNodeRecord.setCostSoFar(endNodeCost);
                endNodeRecord.setConnection(connections.get(i));
                endNodeRecord.setNode(endNode);

                if (!openList.containtsNode(endNode)) {
                    openList.add(endNodeRecord);
                }
            }

            openList.remove(current);
            closeList.add(current);
        }

        if (current.getNode() != end) {
            return null;
        }

        List<Connection> path = new ArrayList<>();

        while (current.getNode() != start) {
            path.add(current.getConnection());
            int fromNode = current.getConnection().getFromNode();
            current = closeList.find(fromNode);
        }

        this.reverse(path);
        return path;
    }

    public NodeRecord smallestElement(List<NodeRecord> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        NodeRecord result = list.get(0);

        for (int i = 1; i < list.size(); ++i) {
            if (result.getCostSoFar() > list.get(i).getCostSoFar()) {
                result = list.get(i);
            }
        }

        return result;
    }

    public boolean containts(List<NodeRecord> list, int node) {
        for (int i = 0; i < list.size(); ++i) {
            if (node == list.get(i).getNode()) {
                return true;
            }
        }

        return false;
    }

    public NodeRecord find(List<NodeRecord> list, int node) {
        for (int i = 0; i < list.size(); ++i) {
            if (node == list.get(i).getNode()) {
                return list.get(i);
            }
        }

        return null;
    }

    public void reverse(List<Connection> listConnection) {
        int size = listConnection.size();
        Connection temp;
        int i = 0;
        int j = size - 1;
        
        for (; i < size / 2 && j > size / 2; ++i, --j) {
            temp = listConnection.get(i);
            listConnection.set(i, listConnection.get(j));
            listConnection.set(j, temp);
        }
    }
    
    public static void main(String[] args) {
        
    }

}
