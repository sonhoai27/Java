package PathFinding;

public class PathfindingList{
    private PathfindingNode first;

    public PathfindingList() {
        this.first = null;
    }

    public PathfindingList(PathfindingNode first) {
        this.first = first;
    }

    public PathfindingNode getFirst() {
        return first;
    }

    public void setFirst(PathfindingNode first) {
        this.first = first;
    }
    
    public void add(NodeRecord node) {
        PathfindingNode noderecord = new PathfindingNode(node, null);
        
        if (this.first == null) {
            this.first = noderecord; 
        } else {
            PathfindingNode temp = this.first;
            
            for (; temp.getNext() != null; temp = temp.getNext()) {
                temp.setNext(noderecord);
            }
        }
    }
    
    public int size() {
        int size = 0;
        PathfindingNode temp = this.first;
        
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }
        
        return size;
    }
    
    public boolean remove(NodeRecord nodeRecord) {
        if (this.first == null) {
            return false;
        }
        
        PathfindingNode temp = this.first;
        
        if (this.first.equals(nodeRecord)) {
            this.first = this.first.getNext();
            return true;
        }
        
        for (; temp.getNext() != null; temp = temp.getNext()) {
            if (temp.getNext().getNodeRecord().equals(nodeRecord)) {
                temp.setNext(temp.getNext().getNext());
                return true;
            }
        }  
        
        return false;
    }
    
    public NodeRecord smallestElement() {
        PathfindingNode temp = this.first;
        NodeRecord result = null;
        
        if (temp == null) {
            return result;
        }
        
        result = temp.getNodeRecord();
        
        for (; temp != null; temp = temp.getNext()) {
            if (temp.getNodeRecord().getCostSoFar() > result.getCostSoFar()) {
                result = temp.getNodeRecord();
            }
        }
        
        return result;
    }
    
    public boolean containtsNode(int node) {
        PathfindingNode temp = this.first;
        
        for (; temp != null; temp = temp.getNext()) {
            if (temp.getNodeRecord().getNode() == node) {
                return true;
            }
        }
        
        return false;
    }
    
    public NodeRecord find(int node) {
        PathfindingNode temp = this.first;
        
        for (; temp != null; temp = temp.getNext()) {
            if (temp.getNodeRecord().getNode() == node) {
                return temp.getNodeRecord();
            }
        }
        
        return null;
    }
    
}
