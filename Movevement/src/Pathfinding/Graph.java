package Pathfinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonho
 */
public class Graph {
    private double[][] matrix; //mott65 cái ma trận trong đó có các đỉnh.
    private int size;//quy định số lượng đỉnh
    private String filePath;


    public Graph(String filePath) {
        this.filePath = filePath;    //cho biet lấy dữ liệu từ đâu, file nào
        //nạp dữ liệu từ tập tin vào, tạo mới đồ thị, tạo mới đồ thị thì có matrix kề.
        //khởi tạo đồ thị thì phải có ma trận kề vào, sẽ dc gọi khi khởi tạo.
        init();
    }

    
    public void init(){
       Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath)); //mở rồi
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(scanner != null){
       
            size = scanner.nextInt();
            matrix = new double[size][size];
            for (int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++){
                    matrix[i][j] = scanner.nextDouble();
                }
            }
        }
        scanner.close();
        
    }
    
    //mang mang tinh chat co dunh ve vung nho
    //danh sach thì link hoat, tự nền tảng quản lý.
    //nap du lieu, tạo mới đồ thị
    //trả nhiều các connection, là các đỉnh, từ đỉnh này tìm các connection như như là A, AB, AC
    //lấy ra các connection từ node
    public List<Connection> getConnections(int fromNode){ //từ đỉnh from nod này tìm các node có thề tới
        List<Connection> connections =  new ArrayList<>(); //dang list
        for (int i = 0; i < size; i++) {
            if(matrix[fromNode][i] != Double.MIN_VALUE){
                connections.add(new Connection(fromNode, i, matrix[fromNode][i]));
            }
        }
        return connections;
    }
    
     public static void main(String[] args) {
        Graph graph = new Graph("C:\\input.txt");
//         System.out.println(Double.MAX_VALUE);
        List<Connection> connections = graph.getConnections(0);
        for(Connection connection:connections){
            System.out.println(connection);
        }
    }
}

//muốn đuổi theo phải xác định dc vận tốc, phải biết phương chiều vtoc.
//tìm đường...
//thuat toán đi chuyển là đi giữa 2 điềm, tìm đường định ra tất cả các điểm trên đường đi.
//tìm đường đi ngắn nhất từ đỉnh này đến đỉnh kia là thuật toán dijkstra
//tìm điểm gần kề