
$(function() {
	$('.home-page').fadeIn('slow');
	filtrarPorBotoes();
	filtrarPorBusca();
});

function filtrarPorBotoes(){
	
	$('.item-cardapio').click(function(event) {
	var tipo = $(this).data("tipo");
	event.preventDefault();
	console.log(tipo);
	if(tipo !== "TODOS") {
				
		$(".container-item-cardapio").fadeIn(800).hide();
		$(".container-item-cardapio[data-tipo='" + tipo +"']").fadeIn(800).show();	
		
	} else {
		
		$(".container-item-cardapio").fadeIn(800).show();
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
