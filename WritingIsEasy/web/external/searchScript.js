/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function createElement(single_el)
{
    //Crea un h1 e ci appende l'username restituito dalla ricerca
    var nome = $("<h1>").html(single_el.username);
    return $("<div>").append(nome); //crea un nuovo div a cui appende l'h1 appena creato e lo restituisce
}

function showRes(res){
    //Vado a prendere il div con id-content
    var div_content = $("#content");

    // svuoto il div
    $(div_content).empty();

    //Popolo il div con il nuovo contenuto (creo un nuovo elemento per ogni username restituito dalla query (res))
    for(var instance in res){
        $(div_content).append(createElement(res[instance]));
    }
}

function error(){
    alert('Errore!!');
}

$(document).ready(function(){
    //collego l'input con id 'search' all'evento 'keyup'
    $("#search").keyup(function(){
        $.ajax({
            url: "searchAutore",
            data: {
                cmd: "search",
                query: $("#search").val() //prendo il valore contenuto nell'input e lo salvo in query
            },
            dataType: 'json',
            success: function(data,state){
                showRes(data); //Gestisce l'inserimento del risultato della ricerca nella pagina (appendendolo al DOM)
            },
            error: function(data,state){
                error();
            }
        }); 
        
    });
     
});