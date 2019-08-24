package com.mercadolibre.itacademy

import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        def marca1 = new Marca(name: "Adidas").save(flush: true)
        def marca2 = new Marca(name: "Nike").save(flush: true)

        marca1.addToArticulos(new Articulo(name: 'Remera', picture:'https://assets.adidas.com/images/w_840,h_840,f_auto,q_' +
                'auto:sensitive,fl_lossy/16fefe6dbb3e4b39a008a83500d507a5_9366/Remera_3_Tiras_Blanco_CW1203_21_model.jpg',total_items_in_this_category:'100'))

        marca1.addToArticulos(new Articulo(name: 'Buzo', picture:'https://http2.mlstatic.com/buzo-con-capucha-adidas-nova-hombre-originals-D_NQ_NP_962600-MLA27428925909_052018-F.jpg',total_items_in_this_category:'100'))


        marca2.addToArticulos(new Articulo(name: 'Remera', picture:'https://showsport.vteximg.com.br/arquivos/ids/589297-1000-1000/NIK-AA2303011-20-1-.jpg?v=636773126302330000',total_items_in_this_category:'100'))

        marca2.addToArticulos(new Articulo(name: 'Buzo', picture:'https://megasports.vteximg.com.br/arquivos/ids/178359-1000-1000/06991063001_0.jpg?v=637015145346500000',total_items_in_this_category:'100'))

        marshaller()
    }

    def destroy = {

    }

    private void marshaller() {

        JSON.registerObjectMarshaller(Marca){
            marca ->[
                    id: marca.id,
                    name: marca.name
            ]
        }

        JSON.registerObjectMarshaller(Articulo){
            articulo ->[
                    id: articulo.id,
                    name: articulo.name,
                    picture: articulo.picture,
                    total_items_in_this_category: articulo.total_items_in_this_category,
                    children_categories:[]
            ]
        }
    }
}
