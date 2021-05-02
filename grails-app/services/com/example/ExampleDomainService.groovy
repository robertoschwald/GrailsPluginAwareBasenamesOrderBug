package com.example

import grails.gorm.services.Service

@Service(ExampleDomain)
interface ExampleDomainService {

    ExampleDomain get(Serializable id)

    List<ExampleDomain> list(Map args)

    Long count()

    void delete(Serializable id)

    ExampleDomain save(ExampleDomain exampleDomain)

}