package org.example.semc.service;

import org.example.semc.entity.Node;
import org.example.semc.repository.NodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {
    private final NodeRepository nodeRepository;

    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public List<Node> getNearestNodes(String currentPosition) {
        return nodeRepository.findNearestNodes(currentPosition);
    }
}

