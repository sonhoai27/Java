package PathFinding;

public class PathfindingNode {
    private NodeRecord nodeRecord; 
    private PathfindingNode next;

    public PathfindingNode() {
    }

    public PathfindingNode(NodeRecord node, PathfindingNode next) {
        this.nodeRecord = node;
        this.next = next;
    }

    public NodeRecord getNodeRecord() {
        return nodeRecord;
    }

    public PathfindingNode getNext() {
        return next;
    }

    public void setNode(NodeRecord node) {
        this.nodeRecord = node;
    }

    public void setNext(PathfindingNode next) {
        this.next = next;
    }
    
}
