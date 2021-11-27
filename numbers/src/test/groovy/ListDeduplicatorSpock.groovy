import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDeduplicatorSpock extends Specification {

    def "Deduplicate list test"() {
        given:
        def temp = Arrays.asList(1, 2, 4, 2)
        def deduplicator = new ListDeduplicator()
        GenericListSorter sorter = Mock(GenericListSorter)
        sorter.sort(_) >> Arrays.asList(1, 2, 2, 4)
        when:
        def list = deduplicator.deduplicate(temp)
        then:
        list == Arrays.asList(1, 2, 4)
    }

}
