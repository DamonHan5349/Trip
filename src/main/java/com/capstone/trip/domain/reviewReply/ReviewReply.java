package com.capstone.trip.domain.reviewReply;

import com.capstone.trip.domain.BaseTimeEntity;
import com.capstone.trip.domain.review.Review;
import com.capstone.trip.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class ReviewReply extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 500)
	private String content;

	@ManyToOne
	@JoinColumn(name = "reviewId")
	private Review review;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;


	public void save(Review review, User user) {
		this.review = review;
		this.user = user;
	}
}