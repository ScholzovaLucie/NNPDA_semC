package org.example.semc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "edges")
@Getter
@Setter
public class Edge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double length;

    @ManyToOne
    @JoinColumn(name = "start_node", nullable = false)
    private Node startNode;

    @ManyToOne
    @JoinColumn(name = "end_node", nullable = false)
    private Node endNode;
}

