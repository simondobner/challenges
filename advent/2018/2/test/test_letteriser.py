import os

from letteriser import Letteriser


def test_get_letter_counts_dups():
    letteriser = Letteriser()
    letteriser.get_letter_counts('bababcffgghh')
    print(letteriser.letter_count_list)

    assert letteriser.letter_count_list == [{2, 3}]


def test_get_letter_counts_none():
    letteriser = Letteriser()
    letteriser.get_letter_counts('abcdef')
    print(letteriser.letter_count_list)

    assert letteriser.letter_count_list == [set()]


def test_get_letter_counts_two_no_three():
    letteriser = Letteriser()
    letteriser.get_letter_counts('abbcde')
    print(letteriser.letter_count_list)

    assert letteriser.letter_count_list == [{2}]


def test_get_letter_counts_three_no_two():
    letteriser = Letteriser()
    letteriser.get_letter_counts('abcccd')
    print(letteriser.letter_count_list)

    assert letteriser.letter_count_list == [{3}]


def test_get_letter_counts_dup_two_no_three():
    letteriser = Letteriser()
    letteriser.get_letter_counts('aabcdd')
    print(letteriser.letter_count_list)

    assert letteriser.letter_count_list == [{2}]


def test_get_letter_counts_dup_three():
    letteriser = Letteriser()
    letteriser.get_letter_counts('ababab')
    print(letteriser.letter_count_list)

    assert letteriser.letter_count_list == [{3}]


def test_get_checksum():
    letteriser = Letteriser()
    letteriser.get_letter_counts('abcdef')
    letteriser.get_letter_counts('bababc')
    letteriser.get_letter_counts('abbcde')
    letteriser.get_letter_counts('abcccd')
    letteriser.get_letter_counts('aabcdd')
    letteriser.get_letter_counts('abcdee')
    letteriser.get_letter_counts('ababab')

    result = letteriser.get_checksum()
    assert result == 12


def test_end_to_end():
    letteriser = Letteriser(str(os.path.dirname(__file__)) + '/resources/test_input.txt')
    letteriser.process_input_records()
    result = letteriser.get_checksum()
    assert result == 12
