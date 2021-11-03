<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Red Hat Display', sans-serif ;
}
body {
    background-image: url(https://i.postimg.cc/c1RYpKCV/pattern-background-desktop.png);
    background-repeat: no-repeat;
    background-size: 100vmax;
    width: 100vm;
    min-height: 100vh;
    background-color: hsla(225, 100%, 94%, 0.801);
    position: relative;
}

.card {
    display: flex;
    flex-flow: column wrap;
    background: #fff;    
    justify-content: flex-start;
    width: 400px;
    height: 600px;
    border-radius: 10px;
    position: absolute;
    left: 50%;
    top:50%;
    transform: translate(-50%,-50%);
    gap: 5px;
    box-shadow: 5px 5px 10px  rgba(221, 221, 221, 0.445)
}
img[alt="hero"] {
    border-radius: 10px 10px 0 0;
    max-width: 400px;
    max-height: 300px;
}

h2 {
    text-align: center;
    font-weight: 900;
    margin-top: 30px;
    color: #203150;
}
.card p {
    padding: 15px;
    margin: 0 30px 0 30px;
    text-align: center;
    color: #888B9E;
    font-size: 15px;
}
.card div {
    margin: 0 20px 20px 50px;
    width: 300px;
    background: #eef0fc9c;
    border-radius: 10px;
    display: flex;
    flex-flow: row nowrap;
    justify-content: space-evenly;
    align-items: center;
    padding: 10px;
}

.card div span {
    margin-left: 20px;
    color: #888B9E;
    font-size: smaller;
}
div span b {
    color: #203150;
    font-size: 12.5px;
    font-weight: 700;
}
.card div button {
    border: none;
    background: transparent;
    cursor: pointer;
    color: hsl(245, 75%, 52%);
    font-weight: bold;
    margin-top: 10px;
    margin-right: -5px;
    text-decoration: underline;
}
.card div button:hover {
    filter: opacity(0.6);
    color: hsl(245, 75%, 52%);
    text-decoration: none;
}
 button:nth-last-of-type(2) {
    margin: 0 20px 20px 50px;
    width: 300px;
    height: 40px;
    background: hsl(245, 75%, 52%);
    color: #fff;
    border: none;
    border-radius: 10px;
    font-weight: 700;
    cursor: pointer;
    box-shadow: 0 10px 10px hsl(225, 100%, 94%);

}
button:nth-last-of-type(2):hover {
    filter: opacity(0.8);
}
button:last-of-type {
    margin: 0 20px 20px 50px;
    width: 300px;
    height: 35px;
    background: transparent;
    color: hsl(224, 23%, 55%);
    border: none;
    border-radius: 10px;
    font-weight: 700;
    cursor: pointer;
}
button:last-of-type:hover {
    color: #203150;
    font-weight: 900;
}
	
</style>
</head>
<body>
	
	<div class="card">

    <img src="<spring:url value="/images/${videojuego.imagen}"/>" alt="hero">
    <h2>${videojuego.nombre }</h2>
      
      <div>
        <span><b>Author: </b> ${videojuego.author}</span>
        
        <span><b>Company: </b> ${videojuego.compania}</span>
        
        <span><b>Nota: </b> ${videojuego.nota}</span>
      </div>
         				
    </div>
      
</body>
</html>