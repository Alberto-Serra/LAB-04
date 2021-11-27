import com.aor.numbers.DivisibleByFilter
import com.aor.numbers.GenericListFilter
import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterSpock extends Specification{

    def "True divisible accept method test"() {
        given:
        GenericListFilter filter = new PositiveFilter()
        when:
        def accept = filter.accept(12)
        then:
        accept == true
    }

    def "False divisible accept method test"() {
        given:
        GenericListFilter filter = new PositiveFilter()
        when:
        def accept = filter.accept(-15)
        then:
        accept == false
    }
}
