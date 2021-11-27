import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListSorterSpock extends Specification {

    def "Sort list test"() {
        given:
        def list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
        def expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        GenericListSorter sorter = new ListSorter()
        when:
        def sorted = sorter.sort(list)
        then:
        sorted == expected
    }

    def "Sort list bug test"() {
        given:
        def list = Arrays.asList(1, 2, 4, 2)
        def expected = Arrays.asList(1, 2, 2, 4)
        GenericListSorter sorter = new ListSorter()
        when:
        def sorted = sorter.sort(list)
        then:
        sorted == expected
    }
}
