package org.paukov.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by dpaukov on 4/7/18.
 */
public class GraphTest {
    @Test
    public void bfs() throws Exception {
        Graph graph = new Graph(6);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        List<Integer> bsfTraversalNodes = graph.bfs(0);
        assertThat(bsfTraversalNodes).containsExactly(0, 1, 4, 5, 2, 3);

    }

    @Test
    public void dfs() throws Exception {
        Graph graph = new Graph(6);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        List<Integer> dsfTraversalNodes = graph.dfs(0);
        assertThat(dsfTraversalNodes).containsExactly(0, 1, 2, 3, 4, 5);
    }

    @Test
    public void connectedComponents() throws Exception {
        Graph graph = new Graph(9);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        graph.addBiDirectedEdge(6, 7);
        List<List<Integer>> connectedComponents = graph.connectedComponents();
        assertThat(connectedComponents).containsExactly(
                Arrays.asList(0, 1, 4, 5, 2, 3),
                Arrays.asList(6, 7),
                Arrays.asList(8));
    }

    @Test
    public void findPath() throws Exception {
        Graph graph = new Graph(9);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        graph.addBiDirectedEdge(6, 7);

        assertThat(graph.findPath(0, 3)).containsExactly(0, 4, 3);
        assertThat(graph.findPath(3, 0)).containsExactly(3, 4, 0);
        assertThat(graph.findPath(7, 6)).containsExactly(7, 6);
        assertThat(graph.findPath(6, 7)).containsExactly(6, 7);
    }

    @Test
    public void findPath_noPath() throws Exception {
        Graph graph = new Graph(9);
        graph.addBiDirectedEdge(0, 1);
        graph.addBiDirectedEdge(0, 4);
        graph.addBiDirectedEdge(0, 5);
        graph.addBiDirectedEdge(1, 2);
        graph.addBiDirectedEdge(1, 4);
        graph.addBiDirectedEdge(2, 3);
        graph.addBiDirectedEdge(3, 4);
        graph.addBiDirectedEdge(6, 7);

        assertThat(graph.findPath(2, 7)).isEmpty();
        assertThat(graph.findPath(7, 2)).isEmpty();
    }
}