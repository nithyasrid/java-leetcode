class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = [False] * n

        def dfs(node):
            visited[node] = True
            nodes = 1
            degree_sum = len(graph[node])

            for nei in graph[node]:
                if not visited[nei]:
                    cnt, deg = dfs(nei)
                    nodes += cnt
                    degree_sum += deg

            return nodes, degree_sum

        ans = 0

        for i in range(n):
            if not visited[i]:
                nodes, degree_sum = dfs(i)

                # Complete graph: degree_sum = nodes * (nodes - 1)
                if degree_sum == nodes * (nodes - 1):
                    ans += 1

        return ans