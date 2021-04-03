package hw_lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1,3);
        graph.addEdge(1,6);
        graph.addEdge(1,9);
        graph.addEdge(3,7);
        graph.addEdge(7,8);
        graph.addEdge(3,8);
        graph.addEdge(3,5);
        graph.addEdge(9,5);
        graph.addEdge(5,2);
        graph.addEdge(5,4);
        graph.addEdge(8,2);

       // System.out.println(graph.getAdjList(1));

        BreadthFirstPath bfp  = new BreadthFirstPath(graph, 1);
        System.out.println("Кратчайщий путь из вершины 1 в вершину 8 = " + bfp.pathTo(8));
        System.out.println("Кратчайщий путь из вершины 1 в вершину 4 = " + bfp.pathTo(4));

    }
}
