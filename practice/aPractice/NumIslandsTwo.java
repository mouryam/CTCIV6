/**
A 2d grid map of m rows and n columns is initially filled with water. 
We may perform an addLand operation which turns the water at position (row, col) into a land. 
Given a list of positions to operate, count the number of islands after each addLand operation. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example:

Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:

Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
0 0 0
0 0 0
0 0 0

Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
1 0 0
0 0 0   Number of islands = 1
0 0 0

Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
1 1 0
0 0 0   Number of islands = 1
0 0 0

Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
1 1 0
0 0 1   Number of islands = 2
0 0 0

Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
1 1 0
0 0 1   Number of islands = 3
0 1 0

Follow up:
Can you do it in time complexity O(k log mn), where k is the length of the positions?

-----
 - So pretty much union find:

The idea is simple. To represent a list of islands, we use trees. i.e., a list of roots. 
This helps us find the identifier of an island faster. If roots[c] = p means the parent of node c is p, 
we can climb up the parent chain to find out the identifier of an island:

Do root[root[roots[c]]]... until root[c] == c;
To transform the two dimension problem into the classic UF, perform a linear mapping:
int id = n * x + y;

Initially assume every cell are in non-island set {-1}. 
When point A is added, we create a new root, i.e., a new island. 
Then, check if any of its 4 neighbors belong to the same island. 
If not, union the neighbor by setting the root to be the same. 
Remember to skip non-island cells.

UNION operation is only changing the root parent so the running time is O(1).

FIND operation is proportional to the depth of the tree. 
If N is the number of points added, the average running time is O(logN), 
and a sequence of 4N operations take O(NlogN). 
If there is no balancing, the worse case could be O(N^2).

Remember that one island could have different roots[node] value for each node. 
Because roots[node] is the parent of the node, not the highest root of the island. 
To find the actually root, we have to climb up the tree by calling findIsland function.

*/
package practice.aPractice;
import java.util.*;
import ctciutil.CTCIMethods;

public class NumIslandsTwo {
	public static void main (String[] args) {
		int m= 3;
		int n=3;
	    int[][] matrix = new int[m][n];
    	int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};

    	List<Integer> resultOrder = numIslands2(m, n, positions);
    	for(int i=0; i<positions.length; i++) {
    		System.out.println("Position: "+Arrays.toString(positions[i]));
    		matrix[positions[i][0]][positions[i][1]] = 1;
	    	CTCIMethods.printMatrix(matrix);
    		System.out.println("Num Islands: "+ resultOrder.get(i));
    	}


	}



	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
		int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    	List<Integer> result = new ArrayList<>();
    	if(m <= 0 || n <= 0 ) { return result; }

    	int count = 0;
    	int[] roots = new int[m*n];
    	Arrays.fill(roots, -1);


    	for(int[] p : positions) { 
    		int root = n*p[0]+p[1];
    		roots[root] = root;
    		count++;

    		for(int[] dir : dirs) {
    			int x = p[0] + dir[0];
    			int y = p[1] + dir[1];

    			int nb = n*x+y;

    			if(x<0 || x>=m || y<0 || y>=n || roots[nb] == -1) {
    				// if roots[nb] == -1 then there is no connecting island
    				continue;
    			}

    			int rootNb = findIslandRoot(roots, nb);
    			if(root != rootNb) {			// if the rootB is not root then it is a new island
    				roots[root] = rootNb;		// lets combine it - UNION
    				root = rootNb;				// now the current tree root is the full combined root	
    				count--;					// count lowers cause the position is part of the same tree - NOT NEW
    			}
    		}
    		result.add(count);					// add the count after each position iteration
    	}
		return result; 
    }

    private  static int findIslandRoot(int[] roots, int id) {
    	while(id != roots[id]) {
    		roots[id] = roots[roots[id]];
    		id = roots[id];
    	} 
    	return id;
	}
}













