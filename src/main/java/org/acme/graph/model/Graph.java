package org.acme.graph.model;

import java.util.ArrayList;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;

/**
 * 
 * Un graphe matérialisé par une liste de sommets et d'arcs
 * 
 * @author MBorne
 *
 */
public class Graph {
	/**
	 * Liste des sommets
	 */
	private List<Vertex> vertices = new ArrayList<>();

	/**
	 * Liste des arcs
	 */
	private List<Edge> edges = new ArrayList<>();

	/**
	 * Récupération de la liste sommets
	 * 
	 * @return
	 */
	public List<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * Recherche d'un sommet par identifiant
	 * 
	 * @param id
	 * @return
	 */
	public Vertex findVertex(String id) {
		for (Vertex vertex : vertices) {
			if (vertex.getId().equals(id)) {
				return vertex;
			}
		}
		return null;
	}

	/**
	 * Recherche d'un sommet par coordonnées
	 * 
	 * @param coordinate
	 * @return
	 */
	public Vertex findVertex(Coordinate coordinate) {
		for (Vertex vertex : vertices) {
			Coordinate candidate = vertex.getCoordinate();
			if (candidate != null && candidate.equals(coordinate)) {
				return vertex;
			}
		}
		return new Vertex();
	}

	/**
	 * Récupération de la liste des arcs
	 * 
	 * @return
	 */
	public List<Edge> getEdges() {
		return edges;
	}

	/**	
	 * Fabrique de création de Vertex et d'ajout au graphe
	 * @param coordinate
	 * @param id
	 * @return
	 */
	public Vertex createVertex(Coordinate coordinate, String id) {
		Vertex v = new Vertex();
		v.setCoordinate(coordinate);
		v.setId(id);
		this.getVertices().add(v);
		return v;
	}
	
	/**
	 * Fabrique de création de Edge et d'ajout au graphe
	 * @param source
	 * @param target
	 * @param id
	 * @return
	 */
	public Edge createEdge(Vertex source, Vertex target, String id) {
		Edge e = new Edge(source, target);
		e.setId(id);
		this.getEdges().add(e);
		return e;
	}

}
