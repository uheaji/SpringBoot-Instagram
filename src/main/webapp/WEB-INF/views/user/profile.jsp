<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<input type="hidden" id="userId" value="${dto.user.id}" /> 

<!--프로필 섹션-->
<section class="profile">
	<!--유저정보 컨테이너-->
	<div class="profileContainer">

		<!--유저이미지-->
		<div class="profile-left">
			<div class="profile-img-wrap story-border" onclick="popup('.modal-image')">
				<img src="/upload/${dto.user.profileImageUrl}" alt=""  onerror="this.src='/images/person.jpeg'"/>
				<svg viewbox="0 0 110 110">
                        <circle cx="55" cy="55" r="53" />
                    </svg>
			</div>
		</div>
		<!--유저이미지end-->

		<!--유저정보 및 사진등록 구독하기-->
		<div class="profile-right">
			<div class="name-group">
				<h2>${dto.user.username}</h2>

				<c:choose>
					<c:when test="${principal.user.id == dto.user.id}">
						<button class="cta" onclick="location.href='/image/upload'">사진등록</button>
						<button class="modi" onclick="popup('.modal-info')">
							<i class="fas fa-cog"></i>
						</button>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${dto.followState}">
								<button class="cta blue" onclick="followOrUnFollowProfile(${dto.user.id})"  id="follow_profile_btn">구독취소</button>
							</c:when>
							<c:otherwise>
								<button class="cta" onclick="followOrUnFollowProfile(${dto.user.id})" id="follow_profile_btn">구독하기</button>
							</c:otherwise>
						</c:choose>

					</c:otherwise>
				</c:choose>

			</div>
			<div class="follow">
				<ul>
					<li><a href="">
							게시물<span>${dto.imageCount}</span>
						</a></li>
					<li><a href="" id="subscribeBtn">
							구독정보<span>${dto.followCount}</span>
						</a></li>
				</ul>
			</div>
			<div class="state">
				<h4>${dto.user.bio}</h4>
				<h4>${dto.user.website}</h4>
			</div>
		</div>
		<!--유저정보 및 사진등록 구독하기-->

	</div>
</section>

<!--게시물컨섹션-->
<section id="tab-content">
	<!--게시물컨컨테이너-->
	<div class="profileContainer">
		<!--그냥 감싸는 div (지우면이미지커짐)-->
		<div id="tab-1-content" class="tab-content-item show">
			<!--게시물컨 그리드배열-->
			<div class="tab-1-content-inner">

				<!--아이템들-->

				<c:forEach var="image" items="${dto.user.images}">
				
					<div class="img-box">
						<a href="">
							<img src="/upload/${image.postImageUrl}" alt="">
						</a>
						<div class="comment">
							<a href="#a" class="">
								<i class="fas fa-heart"></i><span>${image.likeCount}</span>
							</a>
						</div>
					</div>
					
				</c:forEach>



				<!--아이템들end-->
			</div>
		</div>
	</div>
</section>

<!--로그아웃, 회원정보변경 모달-->
<div class="modal-info">
	<div class="modal">
		<button onclick="location.href='/user/1/profileSetting'">회원정보 변경</button>
		<button onclick="location.href='/logout'">로그아웃</button>
		<button onclick="closePopup('.modal-info')">취소</button>
	</div>
</div>
<!--로그아웃, 회원정보변경 모달 end-->

<!--프로필사진 바꾸기 모달-->
<div class="modal-image">
	<div class="modal">
		<p>프로필 사진 바꾸기</p>
		<button>사진 업로드</button>
		<button onclick="closePopup('.modal-image')">취소</button>
	</div>
</div>
<!--프로필사진 바꾸기 모달end-->

<!--팔로워 모달-->
<div class="modal-follow">
	<!--팔로워 박스-->
	<div class="follower">
		<!--팔로워 헤더-->
		<div class="follower-header">
			<span>구독정보</span>
			<button onclick="closeFollow()">
				<i class="fas fa-times"></i>
			</button>
		</div>
		<!--팔로워 헤더end-->

		<!--팔로워 리스트-->
		<div class="follower-list" id="follow_list">
			
			
		</div>
		
		<!--팔로워 리스트end-->
	</div>
	<!--팔로워 박스end-->
</div>
<!--팔로워 모달end-->

<script src="/js/profile.js"></script>

<%@ include file="../layout/footer.jsp"%>