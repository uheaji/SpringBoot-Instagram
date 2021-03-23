package com.cos.costagram.domain.likes;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.costagram.domain.image.Image;
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
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@ManyToOne
	@JoinColumn(name="imageId")
	private Image image;
	
	@ManyToOne
	@JoinColumn(name= "userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;

}
