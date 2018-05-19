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
            var description =  $j(this).find('#dialog_tache_description').val();
            var prioriteId = $j(this).find('#dialog_tache_priorite').val();

            $j.post("/tache/create", {
                nom: nom,
                description:description,
                prioriteId: prioriteId
            }, function (data) {
                //TODO fix le if avec le return du servlet pour fermer la dialog + inserer la ligne de la tache dans le tableau
                if (data) {
                    console.log('TRUE');
                } else {
                    console.log('FALSE');
                }
            })
        }
    });
});