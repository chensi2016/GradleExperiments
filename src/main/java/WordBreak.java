
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Graph {
     int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
     ArrayList<Integer> adj[];
     ArrayList<ArrayList<Integer>> route;
     int routeNo;

    // Constructor
    Graph(int v)
    {
        this.V = v;
        this.adj = new ArrayList[v];
        for (int i=0; i<v; ++i) {
            this.adj[i] = new ArrayList();
        }
        this.route = new ArrayList<>();
        this.routeNo = -1;
    }
    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);    // Add w to v's list.
    }
    boolean DFS(int node, ArrayList<Integer> prePart)
    {
        ArrayList newPrePart = new ArrayList(prePart);
        boolean flag = false;
        if( node == V ){
            if(prePart.isEmpty()){
                routeNo++;
                route.add(new ArrayList<>());
            }
            route.get(routeNo).add(node);
            return true;
        }


        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[node].listIterator();
        int indicator = -1;
        while (i.hasNext())
        {   indicator++;
            if ( node != 0 ) {

                if (indicator>=1) {
                    routeNo++;
                    route.add(new ArrayList<>(prePart));
                }else{
                    newPrePart.add(node);
                }
                route.get(routeNo).add(node);

            }
            else{
                if (indicator>=1) {
                    routeNo++;
                    route.add(new ArrayList<>(prePart));
                }else{
                    routeNo++;
                    route.add(new ArrayList<>());
                }
                route.get(routeNo).add(node);
                newPrePart.clear();
                newPrePart.add(node);

            }
            int nextNode = i.next();
            if(DFS(nextNode,newPrePart)){
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
            return result;
        }

        graph.DFS(0,new ArrayList<>());
        for(int i=0; i<=graph.routeNo; i++ ){
            String resultWord = "";
            for(int j=0; j<graph.route.get(i).size()-1; j++) {
                if(j!=graph.route.get(i).size()-2){
                    resultWord = resultWord + s.substring(graph.route.get(i).get(j), graph.route.get(i).get(j+1)) + " ";
                }
                else{
                    resultWord = resultWord + s.substring(graph.route.get(i).get(j), graph.route.get(i).get(j+1));
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

