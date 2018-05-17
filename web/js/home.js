$j(document).ready(function () {
    var parentElement = $j('#home');

    parentElement.find('#listTache #addTache').on('click', function () {
        $j(function () {
            $j("#dialog_add_tache").dialog();
        });
    });
});