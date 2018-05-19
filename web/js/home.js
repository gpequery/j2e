$j(document).ready(function () {
    var parentElement = $j('#home');

    parentElement.find('#listTache #addTache, #listTache .update_tache').on('click', function () {
        var action = $j(this).attr('data-action');
        dialogTache.find("input[name='action']").val(action);
        dialogTache.dialog(global.popin.options);
        dialogTache.dialog({
            title:  $j(this).attr('data-title-dialog')
        });

        if (action === 'update') {
            var row = $j(this).closest('tr');

            dialogTache.find('#dialog_tache_nom').val(row.find('td:nth-child(2)').text());
            dialogTache.find('#dialog_tache_description').val(row.find('td:nth-child(3)').text());

            dialogTache.find('#dialog_tache_priorite option[value="' + row.find('td:nth-child(4)').attr('data-priorite-id') + '"]').prop('selected', true);
        }
    });

    dialogTache.find('form').on('submit', function (event) {
        event.preventDefault();

        if (window.confirm("Confirmer la tâche ?")) {
            var nom = $j(this).find('#dialog_tache_nom').val();
            var description = $j(this).find('#dialog_tache_description').val();
            var prioriteId = $j(this).find('#dialog_tache_priorite').val();

            $j.post("/tache/create", {
                nom: nom,
                description: description,
                prioriteId: prioriteId
            }, function (newTacheId) {
                var newElement = '<tr id="tache_' + newTacheId + '" data-id="\' + newTacheId + \'">' +
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

    parentElement.find('#listTache .delete_tache').on('click', function () {
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