import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import spock.lang.Specification

class ListAggregatorSpock extends Specification {


    def "List sum test"() {
        given:
        def list = Arrays.asList(1, 2, 3, 4, 5)
        def aggregator = new ListAggregator()
        when:
        int result = aggregator.sum(list)
        then:
        result == 15
    }

    def "Max in list test"() {
        given:
        def list = Arrays.asList(1, 2, 4, 2, 5)
        def aggregator = new ListAggregator()
        when:
        int max = aggregator.max(list)
        then:
        max == 5

    }

    def "Max method bug test 7263"() {
        given:
        def list = Arrays.asList(-1, -2, -3, -4, -5)
        def aggregator = new ListAggregator()
        when:
        int max = aggregator.max(list)
        then:
        max == -1
    }

    def "Min in list test"() {
        given:
        def list = Arrays.asList(1, 2, 4, 2, 5)
        def aggregator = new ListAggregator()
        when:
        int min = aggregator.min(list)
        then:
        min == 1

    }

    def "Distinct method bug test 8726"() {
        given:
        GenericListDeduplicator deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)
        when:
        def result = deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2))
        then:
        result == Arrays.asList(1, 2, 4)
    }

    def "Distinct count test "() {
        given:
        def aggregator = new ListAggregator()
        GenericListDeduplicator deduplicator = Mock(GenericListDeduplicator)
        deduplicator.deduplicate(_) >> Arrays.asList(1, 0, 5, 3)
        when:
        def distinct = aggregator.distinct(Arrays.asList(1, 0, 5, 3, 7, 4), deduplicator)
        then:
        distinct == 4
    }
}
