<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="fr.esgi.dto.Tache" %>
<%@ page import="fr.esgi.dto.Priorite" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Elèves</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="../css/compile/compile.css"/>
        <script src="../js/jquery/jquery.js"></script>
        <script>$j = jQuery.noConflict()</script>
        <script src="../js/include.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Accueil</a>
            <div class="nav-item dropdown">
                <a class="navbar-toggler nav-link dropdown-toggle show" href="#" data-toggle="dropdown" aria-haspopup="false" aria-expanded="true"><span class="navbar-toggler-icon"></span></a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </div>
        </nav>

        <div class="container">