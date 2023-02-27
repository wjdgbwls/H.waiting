<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
<button onclick="test()" type="button">Ajax</button>

<script>
var obj = {"name": "kim", "age": 30};

function test() {
    $.ajax({
        url: "<c:url value="/test" />",
        method: "POST",
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json",
        success: function(data) {
            alert("성공");
        },
        error: function(errorThrown) {
            alert(errorThrown.statusText);
        }
    });
}
</script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>
</html>