
$(function() {
	filtrarPorBotoes();
	filtrarPorBusca();
});

function filtrarPorBotoes(){
	
	$('.item-cardapio').click(function() {
	
	var tipo = $(this).data("tipo");
	
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
