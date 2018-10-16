
import java.util.*;
class Graph {
     int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
     ArrayList<Integer> adj[];
     ArrayList<ArrayList<Integer>> route;
    public Graph(int v)
    {
        this.V = v;
        this.adj = new ArrayList[v];
        for (int i=0; i<v; ++i) {
            this.adj[i] = new ArrayList();
        }
        this.route = new ArrayList<>();
    }
    //Function to add an edge into the graph
    public void addEdge(int v, int w)
    {

        adj[v].add(w);    // Add w to v's list.
    }
    public void DFS(int node, ArrayList<Integer> prePart)
    {
        ArrayList newPrePart = new ArrayList(prePart);
        if( node == V ){
            route.add(new ArrayList<>(prePart));
            return;
        }
        for (int nextNode : adj[node]){
            newPrePart.add(nextNode);
            DFS(nextNode,newPrePart);
            newPrePart.remove(newPrePart.size()-1);
        }
    }
}

public class WordBreak {
    List<Integer> wordBorder;
    List<String> result = new ArrayList<>();
    String s;
    Integer[] state;
    Graph graph;
    Set<String> words;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordBorder = new ArrayList<>();
        this.s = s;
        this.state = new Integer[s.length()+1];
        this.graph = new Graph(s.length());
        this.words = new HashSet<>(wordDict);
        check(s, s.length());
        if (wordBorder.size() == 0) {
            return result;
        }
        ArrayList<Integer> prePart = new ArrayList<>();
        prePart.add(0);
        graph.DFS(0,prePart);
        for(int i=0; i<graph.route.size(); i++ ){
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

    private void check(String s, int nthCharOfS) {
        if (state[nthCharOfS] != null && state[nthCharOfS] == 1) {
            return;
        }
        if (state[nthCharOfS] != null && state[nthCharOfS] == -1) {
            return;
        }
        if (nthCharOfS == 0) {
            state[0] = 1;
            return;
        }
        state[nthCharOfS] = -1;
        for (String word: words) {
            int tempNthCharOfS;
            if (nthCharOfS >= word.length()) {
                tempNthCharOfS = nthCharOfS - word.length();
            } else {
                continue;
            }
            if (word.equals(s.substring(tempNthCharOfS, nthCharOfS))) {
                check(s, tempNthCharOfS);
                wordBorder.add(nthCharOfS);
                graph.addEdge(tempNthCharOfS, nthCharOfS);
                state[nthCharOfS] = 1;
            }
        }
        return;
    }

}

