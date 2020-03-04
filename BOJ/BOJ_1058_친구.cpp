#include <iostream>
using namespace std;
#include <string>
#include <queue>

static int** graph;
static int N, result = 0;

void bfs(int start) {
	queue<int> q;
	q.push(start);
	q.push(-1);
	bool *visited = new bool[N];
	for (int i = 0; i < N; i++)
	{
		visited[i] = false;
	}
	visited[start] = true;
	int sum = 0;
	int count = 0;
	while (q.size() > 1) {
		int n = q.front();
		q.pop();
		if (count == 2) {
			break;
		}
		if (n == -1) {
			count++;
			q.push(-1);
			continue;
		}
		for (int i = 0; i < N; i++)
		{
			if (!visited[i] && graph[n][i]) {
				visited[i] = true;
				q.push(i);
				sum++;
			}
		}
	}
	result = max(result, sum);
}

int main() {
	scanf_s("%d", &N);
	graph = new int*[N];
	string str;
	for (int i = 0; i < N; i++)
	{
		graph[i] = new int[N];
		cin >> str;
		for (int j = 0; j < N; j++)
		{
			if (str[j] == 'Y')
				graph[i][j] = 1;
			else
				graph[i][j] = 0;
		}
	}
	for (int i = 0; i < N; i++)
	{
		bfs(i);
	}
	printf("%d", result);
	return 0;
}