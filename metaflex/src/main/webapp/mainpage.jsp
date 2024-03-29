<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Metaflex Details</title>
<link href="resources/css/mainpage.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</script>
<link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400"
	rel="stylesheet">
</head>
<body>
	<!-- Script has to be loaded in body to work-->
	<script src="http://cdn.jsdelivr.net/mojs/latest/mo.min.js"></script>
	<div id="logo_wrapper">
		<h1 id="logo_title">YOUR METADATA</h1>
		<c:choose>
			<c:when test="${error}">
				<div class="alert alert-danger" role="alert"
					style="margin: auto; margin-top: 300px; margin-bottom: 200px;; width: 50%;">an error occured please try again</div>
			</c:when>
			<c:otherwise>
				<div id="dataContent">
					<h4 class="attribute">compression type</h4>
					<h6 class="attributeValue">${imageData.compressionType != null ? imageData.compressionType : "-"}</h6>
					<h4 class="attribute">height</h4>
					<h6 class="attributeValue">${imageData.height != null ? imageData.height : "-"}</h6>
					<h4 class="attribute">width</h4>
					<h6 class="attributeValue">${imageData.width != null ? imageData.width : "-"}</h6>
					<h4 class="attribute">camera</h4>
					<h6 class="attributeValue">${imageData.camera != null ? imageData.camera : "-"}</h6>
					<h4 class="attribute">model</h4>
					<h6 class="attributeValue">${imageData.model != null ? "imageData.model" : "-"}</h6>
					<h4 class="attribute">datetime</h4>
					<h6 class="attributeValue">${imageData.dateTime != null ? imageData.dateTime : "-"}</h6>
					<h4 class="attribute">exposuretime</h4>
					<h6 class="attributeValue">${imageData.exposureTime != null ? imageData.exposureTime : "-"}</h6>
					<h4 class="attribute">aperture</h4>
					<h6 class="attributeValue">${imageData.aperture != null ? imageData.aperture : "-"}</h6>
					<h4 class="attribute">iso</h4>
					<h6 class="attributeValue">${imageData.iso != null ? imageData.iso : "-"}</h6>
					<h4 class="attribute">flash</h4>
					<h6 class="attributeValue">${imageData.flash != null ? imageData.flash : "-"}</h6>
					<h4 class="attribute">longitude</h4>
					<h6 class="attributeValue">${imageData.longitude != null ? imageData.longitude : "-"}</h6>
					<h4 class="attribute">latitude</h4>
					<h6 class="attributeValue">${imageData.latitude != null ? imageData.latitude : "-"}</h6>

					<br>
				</div>
			</c:otherwise>
		</c:choose>

		<h2 style="display: none;">No Data available</h2>
		<a href="/metaflex" class="anotherPic">Upload another Picture</a>
		<div id="pictureDetails"></div>
		<div class="seperator"></div>
		<div id="lowerSite">

			<a href="https://github.com/zenosaurusflex"> <img
				src="resources/images/git.png" height="35px" /></a> <a
				href="https://github.com/zenosaurusflex"> <img
				src="resources/images/octo.png" height="35px" width="35px" /></a> <a
				href="https://www.paypal.me/ZenoFritschi"> <img
				src="resources/images/pp1.png" height="35px" /></a>

		</div>
</body>
<footer> </footer>
</html>
