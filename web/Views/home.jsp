<%@ page pageEncoding="UTF-8" %>
<%@ include file="Templates/header.jsp" %>

<% List<Tache> taches = (List<Tache>) request.getAttribute("taches"); %>

<div class="container" id="home">
    <div class="row justify-content-center">
        <div class="col-md-12">
            <div class="card text-white bg-dark" id="listTache">
                <div class="card-header">
                    <div><h2>List des tâches</h2></div>
                    <div>
                        <button class="btn btn-success" id="addTache" data-action="create" data-title-dialog="Créer une tâche">
                            <img src="../images/add-button-white.png"/>
                        </button>
                    </div>
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
                                <tr id="tache_${tache.id}" data-id="${tache.id}">
                                    <td>${tache.id}</td>
                                    <td>${tache.nom}</td>
                                    <td>${tache.description}</td>
                                    <td data-priorite-id="${tache.priorite.id}">${tache.priorite.nom}</td>
                                    <td>
                                        <input type="submit" value="Modifier" class="btn btn-primary update_tache" data-action="update" data-title-dialog="Modifier une tâche"/>
                                        <input type="submit" value="Supprimer" class="btn btn-danger delete_tache"/>
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

<div class="dialog" id="dialog_tache">
    <form>
        <label for="dialog_tache_nom">Nom</label>
        <input type="text" name="nom" placeholder="Nom" id="dialog_tache_nom" class="form-control" required/>

        <label for="dialog_tache_description">Description</label>
        <textarea class="form-control" placeholder="Description" id="dialog_tache_description" rows="5"></textarea>

        <label for="dialog_tache_priorite">Priorité</label>
        <select class="form-control" id="dialog_tache_priorite" required>
            <option disabled selected value="">Choisir une priorité</option>
            <c:forEach items="${priorites}" var="priorite">
                <option value="${priorite.id}">${priorite.nom}</option>
            </c:forEach>
        </select>

        <div id="form_input">
            <input type="reset" value="Annuler" class="btn btn-warning"/>
            <input type="submit" value="Valider" class="btn btn-success"/>
        </div>

        <input type="hidden" name="action"/>
    </form>
</div>

<%@ include file="Templates/footer.jsp" %>