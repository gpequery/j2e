$j(document).ready(function () {
    var parentElement = $j('#home');

    parentElement.find('#listTache #addTache').on('click', function () {
        $j(function () {
            $j("#dialog_tache").dialog(global.popin.options);
            $j("#dialog_tache").dialog({title: 'Créer une tâche'});
        });
    });
});