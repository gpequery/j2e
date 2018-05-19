$j(document).ready(function () {
    var parentElement = $j('#home');

    parentElement.find('#listTache #addTache').on('click', function () {
        $j(function () {
            dialogTache.dialog(global.popin.options);
            dialogTache.dialog({
                title: 'Créer une tâche'
            });
        });
    });

    dialogTache.find('form').on('submit', function (event) {
        event.preventDefault();

        if (window.confirm("Confirmer la création de cette tâche ?")) {
            var nom = $j(this).find('#dialog_tache_nom').val();
            var description = $j(this).find('#dialog_tache_description').val();
            var prioriteId = $j(this).find('#dialog_tache_priorite').val();

            $j.post("/tache/create", {
                nom: nom,
                description: description,
                prioriteId: prioriteId
            }, function (newTacheId) {
                var newElement =    '<tr id="tache_' + newTacheId + '" data-id="\' + newTacheId + \'">' +
                                    '    <td>' + newTacheId + '</td>' +
                                    '    <td>' + nom + '</td>' +
                                    '    <td>' + description + '</td>' +
                                    '    <td>Greg</td>' +
                                    '    <td>' +
                                    '        <input type="submit" value="Modifier" class="btn btn-primary"/>' +
                                    '        <input type="submit" value="Supprimer" class="btn btn-danger delete_tache"/>' +
                                    '    </td>' +
                                    '</tr>';

                parentElement.find('table tbody').append(newElement);
            })
        }
    });

    parentElement.find('.delete_tache').on('click', function () {
        var tacheId = $j(this).closest('tr').attr('data-id');

        if (window.confirm("Confirmer la suppréssion de la tache " + tacheId + " ?")) {
            $j.post("/tache/delete", {
                id: tacheId
            }, function () {
                parentElement.find('#tache_' + tacheId).remove();
            })
        }
    });
});