# modeling road network of indian cities
import networkx as nx
import matplotlib.pyplot as plt
import random as rand

G = nx.Graph() #undirected
# G = nx.DiGraph() #directed

city_set = ['mumbai', 'delhi','banglore','chennai']

for city in city_set:
	G.add_node(city)

costs = [x ** 2 for x in range(10)]
print G.number_of_edges()
while(G.number_of_edges() < 5):
	c1 = rand.choice(G.nodes())
	c2 = rand.choice(G.nodes())
	if c1 != c2 and G.has_edge(c1, c2) == 0:
		w = rand.choice(costs)
		print w
		G.add_edge(c1, c2, weight = w)		
#pos=nx.spectral_layout(G)
#pos=nx.spring_layout(G)
pos = nx.circular_layout(G)
nx.draw(G,pos, with_labels=True)
plt.show()
