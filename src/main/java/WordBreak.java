
import java.util.*;

class Graph {
     int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
     ArrayList<Integer> adj[];
     ArrayList<ArrayList<Integer>> route;

    // Constructor
    Graph(int v)
    {
        this.V = v;
        this.adj = new ArrayList[v];
        for (int i=0; i<v; ++i) {
            this.adj[i] = new ArrayList();
        }
        this.route = new ArrayList<>();
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
            newPrePart.add(node);
            route.add(newPrePart);
            return true;
        }

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[node].listIterator();
        int indicator = -1;
        while (i.hasNext()) {
            indicator++;
            if (indicator>=1) {
                newPrePart.remove(newPrePart.size()-1);
            }
            newPrePart.add(node);
            int nextNode = i.next();
            if(DFS(nextNode,newPrePart)){
                flag = true;
            }
        }
        return flag;
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

        graph.DFS(0,new ArrayList<>());
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

    private boolean check(String s, int nthCharOfS) {
        if (state[nthCharOfS] != null && state[nthCharOfS] == 1) {
            return true;
        }
        if (state[nthCharOfS] != null && state[nthCharOfS] == -1) {
            return false;
        }
        if (nthCharOfS == 0) {
            state[0] = 1;
            return true;
        }
        boolean flag = false;
        for (String word: words) {
            int tempNthCharOfS;
            if (nthCharOfS >= word.length()) {
                tempNthCharOfS = nthCharOfS - word.length();
            } else {
                continue;
            }
            if (word.equals(s.substring(tempNthCharOfS, nthCharOfS))) {
                if (check(s, tempNthCharOfS)) {
                    state[nthCharOfS] = 1;
                    wordBorder.add(nthCharOfS);
                    graph.addEdge(tempNthCharOfS, nthCharOfS);
                    flag = true;

                } else {
                    state[tempNthCharOfS] = -1;
                }
            }
        }
        if (flag) {
            state[nthCharOfS] = 1;
        } else {
            state[nthCharOfS] = -1;
        }
        return flag;
    }

}

