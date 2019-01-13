import java.util.LinkedList;
public class GraphAdjanceyList{
    private int V;
    private LinkedList <Integer> adjListArray[];

    @SuppressWarnings("unchecked")
    GraphAdjanceyList(int v){
        V = v;
        adjListArray = new LinkedList[V];
        for(int i = 0;i < V;i++)
            adjListArray[i] = new LinkedList();
    }

    void addEdge(int source,int destination){
        adjListArray[source].add(destination);
        adjListArray[destination].add(source);
    }

    void printGraph(){
        for(int i = 0;i < V;i++){
             System.out.println("Adjancey list of vertex " + i);
             System.out.print("head");
             for(Integer pCrawl: adjListArray[i]){
                 System.out.print("-> "+pCrawl);
             }
             System.out.println();
        }
    }

    public static void main(String []args){
        int V = 5;
        GraphAdjanceyList graph = new GraphAdjanceyList(V);
        graph.addEdge(0,1);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);

        graph.printGraph();
    }
}
~
