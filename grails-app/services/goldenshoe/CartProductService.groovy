package goldenshoe

import grails.gorm.services.Service

@Service(CartProduct)
interface CartProductService {

    CartProduct get(Serializable id)

    List<CartProduct> list(Map args)

    Long count()

    void delete(Serializable id)

    CartProduct save(CartProduct cartProduct)

}
