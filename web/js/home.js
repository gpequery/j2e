$j(document).ready(function () {
    var parentElement = $j('#home');

    parentElement.find('#listTache #addTache, #listTache .update_tache').on('click', function () {
        var tacheId = $j(this).closest('tr').attr('data-id');

        dialogTache.find('form')[0].reset();

        var action = $j(this).attr('data-action');
        dialogTache.find("input[name='action']").val(action);
        dialogTache.dialog(global.popin.options);
        dialogTache.dialog({
            title: $j(this).attr('data-title-dialog')
        });

        if (action === 'update') {
            var row = $j(this).closest('tr');

            dialogTache.find('#dialog_tache_nom').val(row.find('td:nth-child(' + global.home.row.nom + ')').text());
            dialogTache.find('#dialog_tache_description').val(row.find('td:nth-child(' + global.home.row.description + ')').text());
            dialogTache.find('#dialog_tache_priorite option[value="' + row.find('td:nth-child(' + global.home.row.priorite + ')').attr('data-priorite-id') + '"]').prop('selected', true);
            dialogTache.find('input[name="tacheId"]').val(tacheId);
        }
    });

    dialogTache.find('form').on('submit', function (event) {
        event.preventDefault();

        if (window.confirm("Confirmer la tâche ?")) {
            var action = $j(this).find('input[name="action"]').val();
            var prioriteId = $j(this).find('#dialog_tache_priorite').val();
            var data = {
                nom: $j(this).find('#dialog_tache_nom').val(),
                description: $j(this).find('#dialog_tache_description').val(),
                prioriteId: prioriteId,
                id: $j(this).find('input[name="tacheId"]').val()
            };

            $j.post("/tache/" + $j(this).find('input[name="action"]').val(),
                data, function (json) {
                json = JSON.parse(json);
                    if (action === 'create') {
                        var newElement = '<tr id="tache_' + json.tacheId + '" data-id="' + json.tacheId + '">' +
                            '    <td>' + json.tacheId + '</td>' +
                            '    <td>' + data.nom + '</td>' +
                            '    <td>' + data.description + '</td>' +
                            '    <td data-priorite-id="' + data.prioriteId + '">' + json.prioriteNom + '</td>' +
                            '    <td>' +
                            '        <input type="submit" value="Modifier" class="btn btn-primary"/>' +
                            '        <input type="submit" value="Supprimer" class="btn btn-danger delete_tache"/>' +
                            '    </td>' +
                            '</tr>';

                        parentElement.find('table tbody').append(newElement);
                    } else if (action === 'update') {
                        var row = parentElement.find('table tbody #tache_' + json.tacheId);

                        row.find('td:nth-child(' + global.home.row.nom + ')').text(json.nom);
                        row.find('td:nth-child(' + global.home.row.description + ')').text(json.description);
                        row.find('td:nth-child(' + global.home.row.priorite + ')').text(json.prioriteNom);
                        row.find('td:nth-child(' + global.home.row.priorite + ')').attr('data-priorite-id', prioriteId);
                    }
                });

            dialogTache.dialog("close");
        }
    });

    parentElement.find('#listTache .delete_tache').on('click', function () {
        var tacheId = $j(this).closest('tr').attr('data-id');

        if (window.confirm("Confirmer la suppréssion de la tache " + tacheId + " ?")) {
            $j.post("/tache/delete", {
                id: tacheId
            }, function () {
                parentElement.find('#tache_' + tacheId).fadeToggle('slow', function () {
                    $j(this).remove()
                });
            })
        }
    });
});