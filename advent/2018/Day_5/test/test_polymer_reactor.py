from polymer_reactor import PolymerReactor


def test_init():
    poly = PolymerReactor()
    assert poly.polymer == 'dabAcCaCBAcCcaDA'


def test_reactor():
    poly = PolymerReactor()
    poly.react_polymer()
    print(poly.polymerised_string)
    assert poly.polymerised_string == 'dabCBAcaDA'
