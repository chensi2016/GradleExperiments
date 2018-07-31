import java.util.*;

class WordBreakSample
{
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();

        Set<String> words = new HashSet<>();

        //a pure dfs will have TLE, use cache to store the sentence we can build for a string
        Map<String, List<String>> cache = new HashMap<>();

        boolean dp []= new boolean[len];

        for(String w: wordDict) words.add(w);

        List<String> res = buildSentence(s, words, cache);

        return res;
    }

    public  List<String> buildSentence(String s, Set<String> words,
                                       Map<String, List<String>> cache){
        List<String> res = new ArrayList<>();

        if(s.length()==0){
            res.add("");
            return res;
        }

        if(cache.get(s) != null) return cache.get(s);

        for(String w: words){
            if(s.startsWith(w)){
                //String ns = (sentence.length()==0)? w: sentence + " " + w;
                List<String> tmp = buildSentence(s.substring(w.length()), words, cache);

                //if tmp is empty, cannot make a sentence from s. return empty
                if(tmp.size()!=0) {
                    for(String ss: tmp){
                        if (ss.length()==0) res.add(w);
                        else res.add(w + " " + ss);
                    }
                }
            }
        }

        cache.put(s, res);
        return res;

    }

}
