
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Graph {
     int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
     LinkedList<Integer> adj[];
     LinkedList<Integer> route[];
     int routeNo;

    // Constructor
    Graph(int v)
    {
        this.V = v;
        this.adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            this.adj[i] = new LinkedList();
        }


    }
    Graph(){

    }
    void SetRouteNumber(int routeNumber){
        this.route = new LinkedList[routeNumber];
        for (int i=0; i<routeNumber; ++i) {
            this.route[i] = new LinkedList();
        }
        this.routeNo = -1;
        return;

    }
    int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);

    }
    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);    // Add w to v's list.
    }
    boolean hasEdge(int v, int w){
        for ( int i=0; i<adj[v].size(); i++) {
            if(adj[v].get(i)==w) {
                return true;
            }
        }
        return false;
    }

    boolean DFS(int node, int preNode, int preRouteNo)
    {

        boolean flag = false;
        if( node == V ){
            System.out.print(preNode+" ");
            System.out.print(node+" ");
            if(preNode==0){
                routeNo++;
            }
            route[routeNo].add(preNode);
            route[routeNo].add(node);
            flag = true;
            return flag;
        }

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[node].listIterator();
        int indictor = -1;
        while (i.hasNext())
        {   indictor++;
            if ( preNode != -1 ) {

                if (indictor>=1)
                {
                    routeNo++;
                    for(int j = 0; j < route[preRouteNo].size(); j++){
                        if(route[preRouteNo].get(j)<preNode) {
                            route[routeNo].add(route[preRouteNo].get(j));
                            System.out.print(route[preRouteNo].get(j) + " ");
                        }
                }
                }

                System.out.print(preNode + " ");
                route[routeNo].add(preNode);
            }
            else{
                routeNo++;
        }
            int nextNode = i.next();
            if(DFS(nextNode,node, routeNo)){
                flag = true;
                }
        }
        return flag;
    }
}

public class WordBreak {
    List<String> dict;
    List<Integer> wordBorder;
    List<String> result = new ArrayList<>();
    String s;
    Integer[] state;
    Graph graph;
    public List<String> wordBreak(String s, List<String> wordDict) {

        this.dict = wordDict;
        this.wordBorder = new ArrayList<>();
        this.s = s;
        this.state = new Integer[s.length()+1];
        this.graph = new Graph(s.length());
        check(s, s.length());
        if (wordBorder.size() == 0) {
            wordBorder.add(0);
            return result;
        }
        int routeNumber=1000;

        graph.SetRouteNumber(routeNumber);

        graph.DFS(0,-1,-1);
        for(int i=0; i<=graph.routeNo; i++ ){
            String resultWord = "";
            for(int j=0; j<graph.route[i].size()-1; j++) {
                if(j!=graph.route[i].size()-2){
                    resultWord = resultWord + s.substring(graph.route[i].get(j), graph.route[i].get(j+1)) + " ";
                    }else{
                    resultWord = resultWord + s.substring(graph.route[i].get(j), graph.route[i].get(j+1));
                    result.add(resultWord);
                }
            }
        }
        return result;
    }

    private boolean check(String s, int nthCharOfS) {
        if (state[nthCharOfS] != null && state[nthCharOfS] == 1) {
            return true;
        }
        if (state[nthCharOfS] != null && state[nthCharOfS] == -1) {
            return false;
        }

        int dictLength = dict.size();

        if (nthCharOfS == 0) {
            state[0] = 1;
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < dictLength; i++) {
            int tempNthCharOfS = nthCharOfS;
            for (int j = dict.get(i).length() - 1; j >= 0; j--) {
                if (tempNthCharOfS >= 1 && s.charAt(tempNthCharOfS - 1) == dict.get(i).charAt(j)) {
                    tempNthCharOfS--;
                    if (j == 0) {
                        if (check(s, tempNthCharOfS) == true) {
                            state[nthCharOfS] = 1;
                            wordBorder.add(nthCharOfS);
                            graph.addEdge(tempNthCharOfS, nthCharOfS);
                            flag = true;
                        }
                        else{
                            state[tempNthCharOfS] = -1;
                        }
                    }

                } else {
                    break;
                }
            }
        }
        return flag;
    }

}