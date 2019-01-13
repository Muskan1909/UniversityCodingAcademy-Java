import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Math;
enum color {
    white,grey,black;
}

@SuppressWarnings("unchecked")

class FupAndDep{
    int v;
    color id[];
    int fup[];
    int dep[];
    LinkedList <Integer> arr[];

    FupAndDep(int V){
          v = V;
          arr = new LinkedList[v];
          id =  new color[v];
          fup = new int[v];
          dep = new int[v];
          for(int i = 0; i < v; i++) {
              id[i] = color.white;
              arr[i] = new LinkedList();
          }
    }

    void addEdge(int src,int desc) {
         arr[src].add(desc);
         //arr[desc].add(src);
    }

    void dfsFunc(int src,int d) {
         fup[src] = d;
         dep[src] = d;
         id[src] = color.grey;
         System.out.print(src + " ");
         Iterator <Integer> i = arr[src].listIterator();
         while(i.hasNext()){
              int x = i.next();
              if(id[x] == color.white){
                   dfsFunc(x,d+1);
                   fup[src] = Math.min(fup[src],fup[x]);
              }
              else{
                   fup[src] = Math.min(fup[src],dep[x]);
              }
              id[src] = color.black;
         }
    }

    void printFUPDEP(){
        for(int i = 0; i < v;i++)
            System.out.println("fup : "+fup[i]+" dep : "+dep[i]);
    }

    public static void main(String args[]){
         FupAndDep d = new FupAndDep(4);
         d.addEdge(0,1);
         d.addEdge(1,2);
         d.addEdge(2,3);
         d.addEdge(2,0);
         d.dfsFunc(0,0);
         System.out.println();
         d.printFUPDEP();
    }
}

