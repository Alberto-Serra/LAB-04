import com.aor.numbers.DivisibleByFilter
import com.aor.numbers.GenericListFilter
import com.aor.numbers.ListFilterer
import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class ListFiltererSpock extends Specification {

    def "Filter list test"() {
        given:
        def list = Arrays.asList(1, -5, 3, -4, 6, -8)
        GenericListFilter filter = Mock(GenericListFilter)
        def filterer = new ListFilterer(filter)
        when:
        def filtered = filterer.filter(list)
        then:
        list != filterer
    }

    def "Positive filter list test"() {
        given:
        def list = Arrays.asList(1, -5, 3, -4, 6, -8)
        GenericListFilter filter = new PositiveFilter()
        def filterer = new ListFilterer(filter)
        when:
        def filtered = filterer.filter(list)
        then:
        filtered == Arrays.asList(1, 3, 6)
    }

    def "Divisble filter list test"() {
        given:
        def list = Arrays.asList(1, -5, 3, -4, 6, 8)
        GenericListFilter filter = new DivisibleByFilter(8)
        def filterer = new ListFilterer(filter)
        when:
        def filtered = filterer.filter(list)
        then:
        filtered == Arrays.asList(1, -4, 8)
    }

}
