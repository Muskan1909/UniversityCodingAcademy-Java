import java.util.LinkedList;
import java.util.Iterator;
class DFSGraph{
     private int V;
     private LinkedList <Integer> adj[];

     @SuppressWarnings("unchecked")
     DFSGraph(int v){
         V = v;
         adj = new LinkedList[v];

         for(int i=0;i < v;i++)
             adj[i] = new LinkedList();
     }

     void addEdge(int s,int e){
         adj[s].add(e);
     }

     void DFS(int v,boolean visited[]){
         visited[v] = true;
         System.out.println(v + " ");

         Iterator<Integer> i = adj[v].listIterator();
         while(i.hasNext()){
                int n = i.next();
                if(!visited[n])
                     DFS(n,visited);
         }
     }

     void DFSUtil(int v){
         boolean visited[] = new boolean[V];
         DFS(v,visited);
     }

     public static void main(String []args){
         DFSGraph g = new DFSGraph(4);
         g.addEdge(0,1);
         g.addEdge(0,2);
         g.addEdge(1,2);
         g.addEdge(2,0);
         g.addEdge(2,3);
         g.addEdge(3,3);

         g.DFSUtil(2);
     }
}
