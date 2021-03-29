package com.cos.costagram.domain.follow;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
	
	// write (@Modifying)
	@Modifying
	@Query(value = "INSERT INTO follow(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId, now())", nativeQuery = true)
	int mFollow(int fromUserId, int toUserId); // prepareStatement updateQuery() => -1 0 1
	
	@Modifying
	@Query(value = "DELETE FROM follow WHERE fromUserId = :fromUserId AND toUserId = :toUserId", nativeQuery = true)
	int mUnFollow(int fromUserId, int toUserId); // prepareStatement updateQuery() => -1 0 1
	
	@Query(value = "select count(*) from follow where fromUserId = :principalId AND toUserId = :userId", nativeQuery = true)
	int mFollowState(int principalId, int userId);
	
	@Query(value = "select count(*) from follow where fromUserId = :userId", nativeQuery = true)
	int mFollowCount(int userId);
}
