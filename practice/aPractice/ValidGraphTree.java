/**
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
----
An undirected graph is tree if it has following properties.
1) There is no cycle.  (Can do Union Find - lets use path compression too)
2) The graph is connected.

--- 
Can to BFS and DFS: 
 - Node and its neighbors are the edges' relationships, 
 	have another set of visited to keep track to check for connectedness
*/

package practice.aPractice;
import java.util.*;

public class ValidGraphTree {

	public static void main (String[] args) {
		int[][] array1 = { {0,1}, {0,2}, {0,3}, {1,4} };
		int[][] array2 = { {0,1}, {1,2}, {2,3}, {1,3}, {1,4} };
		int[][] array3 = { {0,1}, {1,2}, {2,3}, {4,5} };

		System.out.println(Arrays.deepToString(array1) + " : "+validTree(5, array1));
		System.out.println(Arrays.deepToString(array2)+ " : "+validTree(5, array2));
		System.out.println(Arrays.deepToString(array3)+ " : "+validTree(6, array3));

		System.out.println(" --- DFS METHOD ---");
		
		System.out.println(Arrays.deepToString(array1) + " : "+validTreeDFS(5, array1));
		System.out.println(Arrays.deepToString(array2)+ " : "+validTreeDFS(5, array2));
		System.out.println(Arrays.deepToString(array3)+ " : "+validTreeDFS(6, array3));
	}

    static boolean validTree(int n, int[][] edges) {
    	int[] nums = new int[n];
    	Arrays.fill(nums, -1);

    	for(int i=0; i < edges.length; i++){
    		int x = findRoot(nums, edges[i][0]);
    		int y = findRoot(nums, edges[i][1]);

			// if two vertices are in the same set then it is a cycle
    		if(x == y){
    			return false;
    		}
    		// create union
    		nums[x] = y;
    	}
		// If edges.length > n - 1, it becomes cyclic.
		// If edges.length < n - 1, it's a forest with multiple trees.
    	return edges.length == n-1;
    }

    static int findRoot(int[] nums, int i) {
    	if(nums[i] == -1) { 
    		return i;
    	}
    	// Path compression (assign grandparent)
    	if(nums[nums[i]] != -1) {
    		nums[i] = nums[nums[i]];
    	}
    	return findRoot(nums, nums[i]);
    }


    static boolean validTreeDFS(int n, int[][] edges){
    	List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
    	for(int i=0; i<n; i++){
    		graph.add(new HashSet<Integer>());
    	}

    	for (int[] edge : edges){
    		graph.get(edge[0]).add(edge[1]);
    		graph.get(edge[1]).add(edge[0]);
    	}

    	Deque<Integer> stack = new ArrayDeque<Integer>();
    	boolean[] visited = new boolean[n];
    	stack.push(0);

    	while(!stack.isEmpty()){
    		int node = stack.pop();
    		// if already visited then cycle exists!
    		if(visited[node]){
    			return false;
    		}
    		visited[node] = true;
    		for(int neighbor : graph.get(node)){
    			stack.push(neighbor);
    			graph.get(neighbor).remove(node);
    		}
    	}

    	for(boolean connect : visited){
    		if (!connect) { 
    			return false;
    		}
    	}
    	return true;
    }

}