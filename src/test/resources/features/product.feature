#language: es
Característica: : Product - Store

  @test
  Esquema del escenario: : Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario "<username>" y clave "<password>"
    Cuando navego a la categoria "<category>" y subcategoria "<subcategory>"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito

    Ejemplos:
      | username                | password       | category     | subcategory |
      | rodrigo.haro@epn.edu.ec | rodrigo2003@   | Clothes      | Men         |