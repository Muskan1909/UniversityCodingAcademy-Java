class TopologicalSort{
     int v;
     LinkedList <Integer> arr[];
     int inDegree[];
     int visited[];
     int T[];

     TopologicalSort(int V){
         v = V;
         arr = new LinkedList[v];
         for(int i = 0; i < v; i++){
              arr[i] = new LinkedList();
              inDegree[i] = visited[i] = 0;
         }
     }

     void addEdge(int src,int dest){
          arr[src].add(dest);
     }

     void findInDeg(LinkedList <Integer> arr[]){
           for(int i = 0; i < v; i++){
                 for(int j = 0; j < arr[i].size(); j++){
                       int x = arr[i].get(j);
                       inDegree[x] = inDegree[x] + 1;
                 }
           }
     }

     void Sort(){
          Queue <Integer> q = new <Integer> Queue();
          for(int i = 0; i < v; i++){
                if(inDegree[i] == 0){
                    q.push(i);
                }
          }


     }
