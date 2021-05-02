package com.example

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ExampleDomainController {

    ExampleDomainService exampleDomainService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond exampleDomainService.list(params), model:[exampleDomainCount: exampleDomainService.count()]
    }

    def show(Long id) {
        respond exampleDomainService.get(id)
    }

    def create() {
        respond new ExampleDomain(params)
    }

    def save(ExampleDomain exampleDomain) {
        if (exampleDomain == null) {
            notFound()
            return
        }

        try {
            exampleDomainService.save(exampleDomain)
        } catch (ValidationException e) {
            respond exampleDomain.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'exampleDomain.label', default: 'ExampleDomain'), exampleDomain.id])
                redirect exampleDomain
            }
            '*' { respond exampleDomain, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond exampleDomainService.get(id)
    }

    def update(ExampleDomain exampleDomain) {
        if (exampleDomain == null) {
            notFound()
            return
        }

        try {
            exampleDomainService.save(exampleDomain)
        } catch (ValidationException e) {
            respond exampleDomain.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'exampleDomain.label', default: 'ExampleDomain'), exampleDomain.id])
                redirect exampleDomain
            }
            '*'{ respond exampleDomain, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        exampleDomainService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'exampleDomain.label', default: 'ExampleDomain'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'exampleDomain.label', default: 'ExampleDomain'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
