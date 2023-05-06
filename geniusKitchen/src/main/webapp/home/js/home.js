
$(function() {
	filtrarPorBotoes();
	filtrarPorBusca();
});

function filtrarPorBotoes(){
	
	$('.item-cardapio').click(function(event) {
	var tipo = $(this).data("tipo");
	event.preventDefault();
	console.log(tipo);
	if(tipo !== "TODOS") {
				
		$(".container-item-cardapio").hide();
		$(".container-item-cardapio[data-tipo='" + tipo +"']").show();	
		
	} else {
		
		$(".container-item-cardapio").show();
	}
 });
	
}

function filtrarPorBusca()	{
	
  $("#campoBuscaHomePage").on("keyup", function() {
	
    var texto = $(this).val().toLowerCase();
    
    $(".container-item-cardapio").filter(function() {
	
      $(this).toggle($(this).text().toLowerCase().indexOf(texto) > -1)
      
    });
  });
}
