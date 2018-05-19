/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pathfinding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonho
 */
//danh sach
public class PathfindingDijkstra {
    public List<Connection> pathFindDijkstra(Graph graph, int start, int end){
        
        NodeRecord startNode = new NodeRecord();
        
        startNode.setNode(start);
        startNode.setCostSofar(0);
        startNode.setConnection(null);
        
        //con gán cha thì dc, chứ cha ko gán cho con
        List<NodeRecord> open = new ArrayList<>();
        List<NodeRecord> close = new ArrayList<>();
        open.add(startNode);
        
        NodeRecord current = null;
        
        List<Connection> connections;
        
        int endNode;//là đỉnh cuối
        double endNodeCost;
        NodeRecord endNodeRecord;
        
        
        while(open.size() > 0){
            current = smallestElement(open);
            //lấy cái đỉnh ra, chạy tới bằng đỉnh cuối cùng
            if(current.getNode() == end){
                break;
            }
            
            //chọn 1 đỉnh, xem xem đỉnh đã chọn nó kề những đỉnh nào. thông qua đồ thị, truyền vào 1 đỉnh hiện tại
            connections = graph.getConnections(current.getNode());
            
            //duyệt qua lần lượt từ connections
            for(int i = 0; i < connections.size(); i++){
                 endNode = connections.get(i).getToNode(); //lấy ra ở vị trí thứ i
                 endNodeCost = connections.get(i).getCost() + current.getCostSofar(); //lấy ra cost
                 if(contains(close, endNode)){
                     continue;
                 }else if(contains(open, endNode)){
                     endNodeRecord = find(open, endNode);
                     if(endNodeRecord.getCostSofar() <= endNodeCost){
                         continue;
                     }
                 }else {
                     endNodeRecord = new NodeRecord();
                     endNodeRecord.setNode(endNode);
                     
                 }
                 
                 endNodeRecord.setCostSofar(endNodeCost);
                 endNodeRecord.setConnection(connections.get(i));///lấy connection thứ i
                 if(!contains(open, endNode)){
                     open.add(endNodeRecord);
                 }
            }
            
            //current là node recode đang xét
            open.remove(current);
            close.add(current);
        }
        
        //ko đi dc tới đích đến
        if(current.getNode() != end){
            return null; //khong có đường đi
        }else {
            //chứa các đường đi connection
            List<Connection> path = new ArrayList<>();
            while(current.getNode() != start){
                //lấy ra những cái đã đi thì là trong ds close;
                path.add(current.getConnection());
                current = find(close, current.getConnection().getFromNode());
            }
                return reverse(path);   
        }
    }
    
    //tìm ra thành phần nhỏ nhất
    public NodeRecord smallestElement(List<NodeRecord> list){
        //list mà chưa dc khởi tạo thì bằng null
        if( list == null || list.size()== 0){
            return null;
        }else{
            NodeRecord smallestNode = list.get(0);
            for(int i = 1; i< list.size(); i++){
                if(list.get(i).getCostSofar() < smallestNode.getCostSofar()){
                    smallestNode = list.get(i);
                }
            }
            return smallestNode;
        }
    }
    
    //kiem tra co hoặc ko có node này trong danh sách
    public boolean contains(List<NodeRecord> list, int node){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getNode() == node){
                return true;
            }
        }
        return false;
    }
    //tìm thằng node xem trong list có nó không, nếu có thì trả về vị trí
    public NodeRecord find(List<NodeRecord> list, int node){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getNode() == node){
                return list.get(i);
                //nếu co thì return recode vị trí node đó
            }
        }
        return null;
    }
    
    //cấp độ truy cập
    public List<Connection> reverse(List<Connection> path ){
        //hoa doi giua i và n-1-i
        //i thuoc 0->n-1/2
        Connection temp;
        for(int i = 0; i < (path.size() - 1)/2; i++){
            temp = path.get(i);
            path.set(i, path.get(path.size() -1 -i));
            path.set(path.size() - 1 - i, temp);
            
        }
        return path;
    }
    
    
    public static void main(String[] args) {
        Graph graph = new Graph("C:\\input.txt");
        PathfindingDijkstra dijkstra = new PathfindingDijkstra();
        List<Connection> connections = dijkstra.pathFindDijkstra(graph, 0, 2);
        for(Connection connection:connections){
            System.out.println(connection);
        }
    }
}
