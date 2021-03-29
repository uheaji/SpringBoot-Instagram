package com.cos.costagram.domain.image;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.costagram.domain.comment.Comment;
import com.cos.costagram.domain.likes.Likes;
import com.cos.costagram.domain.tag.Tag;
import com.cos.costagram.domain.user.RoleType;
import com.cos.costagram.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String caption;
	private String postImageUrl;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy = "image")
	private List<Tag> tags;
	
	@OneToMany(mappedBy = "image")
	private List<Likes> likes;
	
	// comment (댓글)
	@OneToMany(mappedBy = "image")
	private List<Comment> comments;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@Transient // 컬럼이 만들어지지 않는다.
	private int likeCount;
}
