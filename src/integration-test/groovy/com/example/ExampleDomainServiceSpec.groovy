package com.example

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ExampleDomainServiceSpec extends Specification {

    ExampleDomainService exampleDomainService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ExampleDomain(...).save(flush: true, failOnError: true)
        //new ExampleDomain(...).save(flush: true, failOnError: true)
        //ExampleDomain exampleDomain = new ExampleDomain(...).save(flush: true, failOnError: true)
        //new ExampleDomain(...).save(flush: true, failOnError: true)
        //new ExampleDomain(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //exampleDomain.id
    }

    void "test get"() {
        setupData()

        expect:
        exampleDomainService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ExampleDomain> exampleDomainList = exampleDomainService.list(max: 2, offset: 2)

        then:
        exampleDomainList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        exampleDomainService.count() == 5
    }

    void "test delete"() {
        Long exampleDomainId = setupData()

        expect:
        exampleDomainService.count() == 5

        when:
        exampleDomainService.delete(exampleDomainId)
        sessionFactory.currentSession.flush()

        then:
        exampleDomainService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ExampleDomain exampleDomain = new ExampleDomain()
        exampleDomainService.save(exampleDomain)

        then:
        exampleDomain.id != null
    }
}
