# Weisfeiler-Lehman Test

This project implements the Weisfeiler-Lehman test, which is a simple graph isomorphism test.

### Instructions

Compile the code from the command line: `javac *.java`

Run the code: `java WeisfeilerLehman`

Upon running, enter `1`, `2`, or `3` to access the respective graph. Any other input causes the program to terminate without loading a file.

Feel free to edit the graph data files, which are `graphx.dat` for `x=1,2,3`. The structure of the input files is as follows.

Line 1: the number of vertices. This value should be at least as great as the largest vertex number (plus `1` because vertices are zero-indexed).

The blank line indicates the divide between the first and second graph.

All other lines are edges, formatted `u,v` where `u` and `v` are the first and second vertices respectively. Remember that the vertices are zero-indexed. Graphs are undirected, so `u,v` is equivalent to `v,u`.

### Graph Isomorphism

Given two graphs G and H with vertex sets U and V, a graph isomorphism is a function f such that there is an edge f(u1)f(u2) if and only if there is an edge u1u2. Given a candidate map f, it is easy to verify in quadratic time (relative to the number of vertices of U and V) whether f is an isomorphism. Determining if an isomorphism exists is generally much harder.

The fastest known algorithm full graph isomorphism problem [was published](https://arxiv.org/abs/1512.03547) in 2015 by László Babai and runs in [quasi-polynomial time](https://mathoverflow.net/questions/223420/what-are-the-implications-of-the-new-quasi-polynomial-time-solution-for-the-grap). It is not known whether the graph isomorphism problem can be solved in polynomial time, or if the problem is NP-complete, or if it exists in an intermediate complexity level.

### The Weisfeiler-Lehman Test

If two graphs pass the WL test, they may or may not be isomorphic. If two graphs fail the WL test, then they are definitely not isomorphic. Therefore, the WL test can rule out graph isomorphism but cannot establish it.

See [David Bieber's exposition](https://davidbieber.com/post/2019-05-10-weisfeiler-lehman-isomorphism-test/) for details on the WL test.

The time complexity of this implementation is `O(n^3)log(n)`. The most expensive operation is sorting hashed codes for the neighbors of a vertex. If each vertex has `O(n)` neighbors, the time complexity of sorting is `O(n log(n))`. This is called for each vertex per WL pass, and `n` passes are required in total.

### Hash Collisions

We use hashing of Java's ArrayList class as part of the algorithm. It is possible that a hash collision will cause two graphs to pass the WL test when they should fail. It is not possible that a hash collision will cause two graphs to fail the WL test when they should pass. Therefore, if our code reports that two graphs fail the WL test, then they are not isomorphic even if a hash collision occurs.