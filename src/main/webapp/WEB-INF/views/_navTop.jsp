<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <style>
    	*{
    		margin:0;
    		padding:0;
    	}
    	nav{
    		backgroud-color: #3578E55;
    	}
    	nav ul{
    		display: flex;
    		justify-connet: flex-start;
    		align-items: center;
    		list-style: none;
    	}
    	nav ul li a{
    		color: #fff;
    		display: block;
    		padding: 1rem;
    		text-decoration: none;
    	}
    	nav ul li:first-child a{
    		padding-left: 0 !importtant;
    	}
    	nav ul lo a:hover{
    		color: yellow;
    	}
    </style>
    <nav>
    	<ul class="container">
    		<li>
    			<a href="${pageContext.request.contextPath}/home">Home</a></li>
    		<li>
    			<a href="${pageContext.request.contextPath}/productList">Product List</a></li>
    		<li>
    		<a href="${pageContext.request.contextPath}/userList">User List</a></li>
    	</ul>
    </nav>