//pasta static com coisas estaticas
(function(){// função deixa a variavel em java scrpt closer(privada)
    $('#tabelaproduto').on('click','.js-delete',function(){
        let botaoClicado = $(this)
        $('#btnsim').attr('data-id', botaoClicado.attr('data-id'))
        $('#modalproduto').modal('show')
    })

    $(document).on('click', '#btnsim', function(){
        let botaoClicado = $(this)
        let id = botaoClicado.attr('data-id')
        $.ajax({
            url: '/produto/delete/' + id,
            method: 'GET',
            success: function(){
                window.location.href = '/produto'
            }
        })
    
    })

})()