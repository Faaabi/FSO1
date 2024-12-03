//pasta static com coisas estaticas
(function(){// função deixa a variavel em java scrpt closer(privada)
    $('#tabelacomp').on('click','.js-delete',function(){
        let botaoClicado = $(this)
        $('#btnsim').attr('data-id', botaoClicado.attr('data-id'))
        $('#modalcomp').modal('show')
    })

    $(document).on('click', '#btnsim', function(){
        let botaoClicado = $(this)
        let id = botaoClicado.attr('data-id')
        $.ajax({
            url: '/componente/delete/' + id,
            method: 'GET',
            success: function(){
                window.location.href = '/componente'
            }
        })
    
    })

})()