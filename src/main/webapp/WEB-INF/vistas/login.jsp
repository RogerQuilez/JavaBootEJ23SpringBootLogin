<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale= 1.0">
<link href="style.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap"
	rel="stylesheet">
<title>Exercise 1 Option 2</title>

<style>
* {
	margin: 0;
	padding: 0;
	font-size: 14px;
	font-family: 'Montserrat', sans-serif;
}

body {
	background-color: #05141D;
}

#login-panel, #signup-panel {
	position: absolute;
	width: 400px;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	color: white;
}

#signup-panel {
	visibility: hidden;
}

#login-panel h3, #signup-panel h3 {
	font-size: 26px;
	margin-bottom: 15px;
}

form {
	margin: auto;
	display: flex;
	justify-content: space-around;
	flex-wrap: wrap;
}

input, button {
	width: 100%;
	height: 50px;
	margin: 3px;
	border-radius: 3px;
	border: 1px solid #aaa;
	text-align: center;
	background-color: white;
}

input:focus {
	border-color: #2980b9;
	box-shadow: 0 0 5px #2980b9;
}

.signup-button:focus {
	border-color: #06883B;
	box-shadow: none;
}

.signup-button, .login-button {
	cursor: pointer;
	border: none;
	background-color: #1297E0;
	color: white;
	width: 100%;
	margin-top: 5px;
	border-bottom: 2px solid #0267A0;
}

form .signup-button {
	background-color: #16A84B;
	border-bottom: 2px solid #06680B;
}

form .signup-button:active {
	background-color: #06883B;
	border-color: #04681B;
}

form .login-button:active {
	background-color: #1277B0;
	border-color: #024780;
}

#signup-panel .signup-button {
	width: 100%;
}

label {
	text-align: center;
	color: white;
	margin-top: 15px;
}

label a {
	color: #22A7F0;
	text-decoration: none;
}

h2 {
	color: red;
}

.correct {
	color: green;
}

@media screen and (max-width: 832px) {
	#login-panel, #signup-panel {
		width: 245px;
	}
	label {
		width: 80%;
	}
}
</style>
</head>

<body>

	<div id="login-panel">
		<h3>Iniciar sesión</h3>
		<h2>${empty message ? "" : message}</h2>
		<h2 class="correct">${param.message}</h2>
		<form action="login" method="POST">
			<input type="text" name="username" placeholder="Usuario"> <input
				type="password" name="password" placeholder="Contraseña">
			<button type="submit" class="signup-button">Entrar</button>
		</form>
		<a href="formLogin"><button class="signup-button">Registrarse</button></a>
	</div>

</body>
</html>