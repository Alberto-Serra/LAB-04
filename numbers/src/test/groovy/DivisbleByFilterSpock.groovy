import com.aor.numbers.DivisibleByFilter
import com.aor.numbers.GenericListFilter
import spock.lang.Specification

class DivisbleByFilterSpock extends Specification {

    def "True divisible accept method test"() {
        given:
        GenericListFilter filter = new DivisibleByFilter(8)
        when:
        def accept = filter.accept(4)
        then:
        accept == true
    }

    def "False divisible accept method test"() {
        given:
        GenericListFilter filter = new DivisibleByFilter(8)
        when:
        def accept = filter.accept(3)
        then:
        accept == false
    }
}
