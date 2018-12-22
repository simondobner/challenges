from polymer_reactor import PolymerReactor


def test_init():
    poly = PolymerReactor()
    assert poly.polymer == 'dabAcCaCBAcCcaDA'


def test_reactor():
    poly = PolymerReactor()
    polymerised_string = poly.primary_reactor(poly.polymer)
    assert polymerised_string == 'dabCBAcaDA'


def test_improve_polymer():
    poly = PolymerReactor()
    poly.bad_unit_stripper()
    print(poly.get_shortest_polymer())
    assert poly.get_shortest_polymer() == 4