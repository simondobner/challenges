from fabricator import Fabricator


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
