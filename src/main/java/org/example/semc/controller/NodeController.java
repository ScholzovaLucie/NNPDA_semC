package org.example.semc.controller;

import org.example.semc.entity.Node;
import org.example.semc.service.NodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nodes")
public class NodeController {
    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping("/nearest")
    public ResponseEntity<List<Node>> findNearestNodes(@RequestParam String currentPosition) {
        List<Node> nodes = nodeService.getNearestNodes(currentPosition);
        return ResponseEntity.ok(nodes);
    }
}

