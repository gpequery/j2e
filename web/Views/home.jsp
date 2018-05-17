<%@ page pageEncoding="UTF-8" %>
<%@ include file="Templates/header.jsp" %>

<% List<Tache> taches = (List<Tache>) request.getAttribute("taches"); %>

<div class="container" id="home">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card text-white bg-dark" id="listTache">
                <div class="card-header">
                    <div><h2>List des tâches</h2></div>
                    <div><button class="btn btn-success" id="addTache"><img src="../images/add-button-white.png" /> </button></div>
                </div>

                <div class="card-body">
                    <table class="table table-dark table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOM</th>
                                <th>DESCRIPTION</th>
                                <th>PRIORITE</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${taches}" var="tache">
                                <tr data-id="${tache.id}">
                                    <td>${tache.id}</td>
                                    <td>${tache.nom}</td>
                                    <td>${tache.description}</td>
                                    <td>${tache.priorite.nom}</td>
                                    <td>
                                        <input type="submit" value="Modifier" class="btn btn-primary"/>
                                        <input type="submit" value="Supprimer" class="btn btn-danger"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="dialog" id="dialog_add_tache" title="Créer une tâche">
    <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
</div>

<%@ include file="Templates/footer.jsp" %>