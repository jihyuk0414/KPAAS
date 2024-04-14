package org.example.repository;

import org.example.controller.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {
    WishList findByEmail(String email);
    Optional<List<WishList>> findAllByEmail(String email);
    void deleteByEmailAndProductId(String email, Long productId);
    public void deleteByProductIdIn(List<Long> productIds);
}
