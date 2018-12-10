from polymer_reactor import PolymerReactor


def test_init():
    poly = PolymerReactor()
    assert poly.polymer == ['d', 'a', 'b', 'A', 'c', 'C', 'a', 'C', 'B', 'A', 'c', 'C', 'c', 'a', 'D', 'A']


def test_reactor():
    poly = PolymerReactor()
    poly.reactor()
    assert poly.polymer == ['d', 'a', 'b', 'A', 'a', 'C', 'B', 'A', 'c', 'C', 'c', 'a', 'D', 'A']


def test_process_polymer():
    poly = PolymerReactor()
    poly.process_polymer()
    assert poly.polymer == ['d', 'a', 'b', 'C', 'B', 'A', 'c', 'a', 'D', 'A']
