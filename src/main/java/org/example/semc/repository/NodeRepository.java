package org.example.semc.repository;

import org.example.semc.entity.Edge;
import org.example.semc.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {
    @Query(value = """
        SELECT * FROM nodes
        WHERE SDO_NN(gps_coordinates, SDO_GEOMETRY(:currentPosition), 'sdo_num_res=3') = 'TRUE'
    """, nativeQuery = true)
    List<Node> findNearestNodes(@Param("currentPosition") String currentPosition);
}


