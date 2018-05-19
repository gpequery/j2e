var dialogBg = $j('#dialog_background');
var dialogTache = $j("#dialog_tache");

var global = {
    popin : {
        options : {
            modale: true,
            draggable: false,
            resizable: false,
            show: { effect: "blind", duration: 600 },
            hide: { effect: "blind", duration: 1000 },
            open: function() { dialogBg.show()},
            close: function() { dialogBg.hide()}
        }
    },
    home: {
        row: {
            id:1,
            nom:2,
            description:3,
            priorite:4
        }
    }
};

$j(document).ready(function () {
    dialogBg.on('click', function() {
        $j(".ui-dialog-content").dialog("close");
    })
});