#include <iostream>
#include <stdlib.h>

using namespace std;

int main(){
	int V, E;
	int u, v;
	V = 6; //no. of vertices;
	E = 8;
	//each row contains src, dest, weight
	int edge[][3] = {{1, 2, 10}, {1, 6, 8}, {6, 5, 1}, {5,4,-1}, {4, 3, -2}, {3, 2, 1}, {5, 2, -4}, {2, 4, 2}};
	//dist from source node 1. 10000 is infinite dist.
	int dist[] = {0, 10000, 10000, 10000, 10000, 10000};
	for(int i=0; i<V-1; i++){
		for(int j=0; j<E; j++){
			u = edge[j][0] - 1;//setting src index
			v = edge[j][1] - 1;//setting dest index
			if(dist[v]>dist[u] + edge[j][2]){
				dist[v] = dist[u] + edge[j][2];
			}
		}
	}
	cout<<"SHORTEST DISTANCES ARE :"<<endl;
	for(int k=0; k<V; k++){
		cout<<dist[k]<<"\t";
	}
	return 0;
}