package hw_lesson7;

import java.util.LinkedList;

public class TraversalGraph {
     boolean[] marked;
     int[] edgeTo;
     int source;


    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public LinkedList<Integer> pathTo(int w) {
        if (!hasPathTo(w)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = w;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
