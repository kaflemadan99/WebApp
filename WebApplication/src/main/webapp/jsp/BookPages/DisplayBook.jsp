<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/ninja.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displaying all books</title>
</head>
<body>
<jsp:include page="../partials/menu.jsp" />
      
      <table class="alternate">
      <thead>
      <tr>
      <th>Book Name</th>
      <th>Author</th>
      <th>Book Condition</th>
      <th>Book Genre</th>
      <th>Comments</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="book" items="${books}">
               <tr>
                  <td>
                        <c:out value = "${book.name}"/>
                    </td>
                    <td>
                        <c:out value = "${book.author}"/>
                    </td>
                    <td>
                        <c:out value = "${book.condition}"/>
                    </td>
                    <td>
                        <c:out value = "${book.genre}"/>
                    </td>
                    <td>
                        <c:out value = "${book.comments}"/>
                    </td>
                    
                    
                    <td class="noBorder">
                      <!--  /Book calls a servlet to fetch book by ID and populate EditBook.jsp -->
                        
                        <a class="greenButton button" href="${pageContext.request.contextPath}/Book/List?id=${book.id}">edit</a>
                        <a class="greenButton button" href="${pageContext.request.contextPath}/Book/List?deleteid=${book.id}">delete</a>
                    </td>
               </tr>
              
      </c:forEach>
      </tbody>
      </table>
      
</body>
</html>