from fabricator2 import Fabricator


def test_add_claim():
    fabric = Fabricator()
    fabric.add_claim('#1 @ 1,3: 4x4')
    assert len([1 for i in fabric.fabric[3] if i == 1]) == 4


def test_get_overlap_count():
    fabric = Fabricator()

    fabric.add_claim('#1 @ 1,3: 4x4')
    fabric.add_claim('#2 @ 3,1: 4x4')
    fabric.add_claim('#3 @ 5,5: 2x2')
    overlap_count = fabric.get_overlap_count()

    assert overlap_count == 4


def test_get_claim_number():
    fabric = Fabricator()

    fabric.add_claim('#1 @ 1,3: 4x4')
    fabric.add_claim('#2 @ 3,1: 4x4')
    fabric.add_claim('#3 @ 5,5: 2x2')

    claim_number = fabric.get_claim_number(5, 5)
    assert claim_number == '3'


def test_get_good_claim():
    fabric = Fabricator(8)

    fabric.add_claim('#11 @ 1,3: 4x4')
    fabric.add_claim('#22 @ 3,1: 4x4')
    fabric.add_claim('#33 @ 5,5: 2x2')

    good_claim = fabric.get_good_claim()
    assert list(good_claim)[0] == '33'
