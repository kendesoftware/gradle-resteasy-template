

import spock.lang.Specification

class ExampleTest extends Specification {

    def "should run the process"() {
        given:
        def a = 1
        def b = 4

        when:
        def result = a + b;

        then:
        result == 5
    }
}
