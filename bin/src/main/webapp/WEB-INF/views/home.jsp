<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div style="width:100%; height: 20rem;">
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel"
		style="width: 100%; height: 25rem;">
	  <ol class="carousel-indicators">
	    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	  </ol>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="/springframework-mini-project/resources/images/puppy1.jpeg"
	      	class="homeCarouselImg d-block" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/springframework-mini-project/resources/images/puppy2.jpeg"
	      	class="homeCarouselImg d-block" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="/springframework-mini-project/resources/images/puppy3.jpeg"
	      	class="homeCarouselImg d-block" alt="...">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-target="#carouselExampleIndicators" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button"
	  	data-target="#carouselExampleIndicators" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </button>
	</div>
	
	<div>
		<span class="d-flex justify-content-center" style="font-size: 100px;">
			메인카피!
		</span>
	</div>
	<div>
		<span class="d-flex justify-content-center" style="font-size: 40px;">
			서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피
			 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피
			 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피
			  서브 카피 서브 카피 서브 카피 서브 카피 서브 카피 서브 카피
		</span>
	</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>