class DisjointSet{

    class edge{
         int src;
         int dest;

         edge(int s,int d){
              src = s;
              dest = d;
         }
    }

    class subset{
         int parent[];
         int rank[];
         int v;

         subset(int V){
              v = V;
              for(int i = 0;i < v; i++){
                   parent[i] = i;
                   rank[i] = 0;
              }
         }

    }

    int find(int n){
         if(parent[n]!=n){
              parent[n] = find(parent[n])
         }
         return parent[n];
    }

    void union(int source,int destination){
         int x = parent[source];
         int y = parent[destination];

         if(x!=y){
              if(rank[x] > rank[y]){
                   parent[y] = x;
              }

              else if(rank[x] < rank[y]){
                   parent[x] = y;
              }

              else{
                   parent[y] = x;
                   if(source == x){
                       rank[x]++;
                   }
              }
         }
    }

    public static void main(String args[]){

    }
}
