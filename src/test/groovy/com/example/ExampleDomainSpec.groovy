package com.example

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ExampleDomainSpec extends Specification implements DomainUnitTest<ExampleDomain> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
