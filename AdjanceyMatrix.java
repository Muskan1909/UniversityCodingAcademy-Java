class GraphAdjacencyMatrix{
     int v;
     int arr[][];

     GraphAdjacencyMatrix(int V){
          v = V;
          arr = new int[v][v];
          for(int i = 0; i < v; i++){
                for(int j = 0; j < v; j++){
                     arr[i][j] = 0;
                }
          }
     }

     static void addEdge(GraphAdjacencyMatrix graph,int from,int to){
           graph.arr[from][to] = 1;
           graph.arr[to][from] = 1;
     }

     static void PrintGraph(GraphAdjacencyMatrix graph){
           for(int i = 0; i < graph.v; i++){
                for(int j = 0; j < graph.v; j++){
                     System.out.print(graph.arr[i][j] + " ");
                }
                System.out.println();
           }
     }

     public static void main(String args[]){
           GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(5);
           addEdge(g,0,1);
           addEdge(g,0,4);
           addEdge(g,1,2);
           addEdge(g,1,3);
           addEdge(g,1,4);
           addEdge(g,2,3);
           addEdge(g,2,4);
           PrintGraph(g);
     }
}
